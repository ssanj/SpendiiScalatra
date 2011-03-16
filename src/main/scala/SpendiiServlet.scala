package spendii

import org.scalatra._
import scalate.ScalateSupport

class SpendiiServlet extends ScalatraServlet with ScalateSupport {

  object Paths {
    val loginTemplate = "/WEB-INF/scalate/templates/login.scaml"
  }

  get("/ping") {
    <html>
      <body>
        <h1>You Pinged Me!</h1>
      </body>
    </html>
  }
  get("/") {
    contentType = "text/html"
    templateEngine.layout(Paths.loginTemplate)
  }

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
