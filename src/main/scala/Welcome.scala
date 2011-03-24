/*
 * Copyright 2010 Sanjiv Sahayam
 * Licensed under the Apache License, Version 2.0
 */

package spendii

import org.scalatra.scalate.ScalateSupport
import org.scalatra.ScalatraServlet

trait Welcome { this:ScalatraServlet with ScalateSupport with WebConstants =>

  get("/") {
    contentType = "text/html"
    templateEngine.layout(Paths.loginTemplate)
  }

}