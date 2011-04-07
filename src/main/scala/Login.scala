/*
 * Copyright 2010 Sanjiv Sahayam
 * Licensed under the Apache License, Version 2.0
 */

package spendii

import org.scalatra.scalate.ScalateSupport
import org.scalatra.ScalatraServlet
import akuru._

trait Login { this:ScalatraServlet with ScalateSupport with WebConstants with AkuruSupport with FunctionSupport =>

  lazy val onError = gotoLogin("The supplied username and password were incorrect.")

  post("/") {
    import User._
    val validation = for {
     u <- params.get("username")
     p <- params.get("password")
    } yield User(usernameField === u, passwordField === p)

    validateLogin(validation)(onError)
  }

  private def validateLogin(validation:Option[User])(onError: => Any): Any = {
    validation fold (onError, user => if (user.username.value == "admin" && user.password.value == "admin2010") successfulLogin else onError)
  }

  private def successfulLogin: Any =  goto(Paths.homeTemplate, Map("username" -> "admin"))

  private def gotoLogin(message:String): Any = goto(Paths.loginTemplate, Map("errors" -> message))
}