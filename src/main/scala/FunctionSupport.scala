/*
 * Copyright 2009 Sanjiv Sahayam
 * Licensed under the Apache License, Version 2.0
 */

package spendii

import org.scalatra.scalate.ScalateSupport

trait FunctionSupport { this:ScalateSupport =>

  def goto(uri:String, attributes:Map[String, Any] = Map.empty[String, Any]): Any = {
    contentType = "text/html"
    templateEngine.layout(uri, attributes)
  }
}