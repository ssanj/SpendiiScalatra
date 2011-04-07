/*
 * Copyright 2009 Sanjiv Sahayam
 * Licensed under the Apache License, Version 2.0
 */

package spendii

import org.scalatra.scalate.ScalateSupport
import org.scalatra.ScalatraServlet

trait CreateFirstUser { this:ScalatraServlet with ScalateSupport with WebConstants with AkuruSupport with FunctionSupport =>

  post("/createFirstUser") {
    import User._
    val defaultUser = User(usernameField === "unknown", passwordField === "")
    val defaultPath = Paths.firstLoginTemplate
    //parameter validation here?
    val requestUser = for {
     u <- params.get("username")
     p <- params.get("password")
     v <- params.get("verification")
    } yield User(usernameField === u, passwordField === p)

    val validation = requestUser flatMap (u => if (u.username.value.trim.isEmpty || u.password.value.trim.isEmpty) None else Some(u))

    validation fold (gotoWithError(defaultPath, "Some user data was missing. Please try again."), user => {
      ( onDb ~~> ( modify a User where (usernameField === user.username.value and passwordField === user.password.value)
                    upsertWith user withUpserted (newUser => None) onError (Some("Could not create Administrative user.")) )
      ) ~~>() fold(goto(Paths.homeTemplate,
        Map[String, Any]("username" -> validation.getOrElse(defaultUser).username.value)), error => gotoWithError(defaultPath, error))
    })

  }
}