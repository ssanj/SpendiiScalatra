package com.example

import org.scalatra.test.scalatest._
import org.scalatest.matchers._

class MyScalatraFilterSuite extends ScalatraFunSuite with ShouldMatchers {

  import _root_.spendii.SpendiiServlet

  addFilter(classOf[SpendiiServlet], "/*")

  test("GET / returns status 200") {
    get("/") {
      status should equal (200)
    }
  }
}
