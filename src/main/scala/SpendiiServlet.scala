package spendii

import org.scalatra._
import scalate.ScalateSupport

class SpendiiServlet extends ScalatraServlet with ScalateSupport {

  import scala.xml.NodeSeq

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

  post("/") {
    case class User(username:String, password:String)
    val validation = for {
     u <- params.get("username")
     p <- params.get("password")
    } yield User(u, p)

    fold(validation)(gotoLogin("The supplied username and password were incorrect.")) { user =>
      if (user.username == "admin" && user.password == "admin2010") successfulLogin
      else gotoLogin("There was problem retrieving your user credentials")
    }
  }

  private def successfulLogin: Any = {
    <html>
      <body>
        <h1>You logged in Successfuly</h1>
      </body>
    </html>
  }
  private def fold[T, R](op:Option[T])(none: => R)(some: T => R): R = op match {
    case Some(value) => some(value)
    case None => none
  }

  private def gotoLogin(message:String): Any = {
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
