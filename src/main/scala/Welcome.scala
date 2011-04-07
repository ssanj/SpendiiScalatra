/*
 * Copyright 2010 Sanjiv Sahayam
 * Licensed under the Apache License, Version 2.0
 */

package spendii

import org.scalatra.scalate.ScalateSupport
import org.scalatra.ScalatraServlet
import akuru._

trait Welcome { this:ScalatraServlet with ScalateSupport with WebConstants with AkuruSupport with FunctionSupport =>

  import User._
  get("/") {
    var result:String = Paths.genericErrorTemplate //standard error page to be defined?
    (onDb ~~> ( find * User where (usernameField === ("*"/)) constrainedBy (Limit(1)) withResults { users =>
      result = Paths.loginTemplate
      None
    } withoutResults {
      result = Paths.firstLoginTemplate
      None
    }) ~~>()) fold (goto(result), error => goto(result, Map("errors" -> ("There was an error executing your request: " + error))))
  }
}