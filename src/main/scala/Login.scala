/*
 * Copyright 2010 Sanjiv Sahayam
 * Licensed under the Apache License, Version 2.0
 */

package spendii

import org.scalatra.scalate.ScalateSupport
import org.scalatra.ScalatraServlet

trait Login { this:ScalatraServlet with ScalateSupport with WebConstants =>

  post("/") {
    case class User(username:String, password:String)
    val validation = for {
     u <- params.get("username")
     p <- params.get("password")
    } yield User(u, p)

    lazy val onError = gotoLogin("The supplied username and password were incorrect.")

    fold(validation)(onError) { user =>
      if (user.username == "admin" && user.password == "admin2010") successfulLogin
      else onError
    }
  }

  private def successfulLogin: Any = {
    contentType = "text/html"
    templateEngine.layout(Paths.homeTemplate, Map("username" -> "admin"))
  }
  private def fold[T, R](op:Option[T])(none: => R)(some: T => R): R = op match {
    case Some(value) => some(value)
    case None => none
  }

  private def gotoLogin(message:String): Any = {
    contentType = "text/html"
    templateEngine.layout(Paths.loginTemplate, Map("errors" -> message))
  }
}