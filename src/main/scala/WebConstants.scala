/*
 * Copyright 2010 Sanjiv Sahayam
 * Licensed under the Apache License, Version 2.0
 */

package spendii

trait WebConstants {
  object Paths {
    val loginTemplate = "/WEB-INF/scalate/templates/login.scaml"
    val homeTemplate = "/WEB-INF/scalate/templates/home.scaml"
    val firstLoginTemplate = "/WEB-INF/scalate/templates/firstLogin.scaml"
    val genericErrorTemplate = "/WEB-INF/scalate/templates/genericError.scaml"
  }
}