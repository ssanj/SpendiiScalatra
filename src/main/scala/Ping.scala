/*
 * Copyright 2010 Sanjiv Sahayam
 * Licensed under the Apache License, Version 2.0
 */

package spendii

import org.scalatra.scalate.ScalateSupport
import org.scalatra.ScalatraServlet

trait Ping { this:ScalatraServlet with ScalateSupport =>

  get("/ping") {
    <html>
      <body>
        <h1>You Pinged Me!</h1>
      </body>
    </html>
  }
}