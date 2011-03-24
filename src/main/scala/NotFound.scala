/*
 * Copyright 2010 Sanjiv Sahayam
 * Licensed under the Apache License, Version 2.0
 */

package spendii

import org.scalatra.scalate.ScalateSupport
import org.scalatra.ScalatraServlet

trait NotFound { this:ScalatraServlet with ScalateSupport  =>

  notFound {
    <html>
      <head>
        <link type="text/css" rel="stylesheet" href="css/404.css" media="screen" />
      </head>
      <body>
        <h1>The page you requested could not be found</h1>
        <div class="errorLogo">
          <img src="images/404.jpg"/>
        </div>
        <h3>You might be a little lost.</h3>
      </body>
    </html>
  }
}