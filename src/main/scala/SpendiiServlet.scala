/*
 * Copyright 2010 Sanjiv Sahayam
 * Licensed under the Apache License, Version 2.0
 */

package spendii

import org.scalatra._
import scalate.ScalateSupport

class SpendiiServlet
        extends ScalatraServlet with
                ScalateSupport with
                WebConstants with
                Welcome with
                Ping with
                Login with
                NotFound