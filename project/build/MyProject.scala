import sbt._

class MyProject(info: ProjectInfo) extends DefaultWebProject(info) {
  lazy val scalatraVersion = "2.0.0.M3"
  lazy val scalatra = "org.scalatra" %% "scalatra" % scalatraVersion withSources()
  lazy val scalate = "org.scalatra" %% "scalatra-scalate" % scalatraVersion withSources()
  lazy val servletApi = "org.mortbay.jetty" % "servlet-api" % "2.5-20081211" % "provided"
  lazy val scalate_sources = "org.fusesource.scalate" % "scalate-core" % "1.4.1" withSources()

  // Alternatively, you could use scalatra-specs
  lazy val scalatest = "org.scalatra" %% "scalatra-test" % scalatraVersion % "test" withSources()
  lazy val scalattatest = "org.scalatra" %% "scalatra-scalatest" % scalatraVersion % "test" withSources()

  // Pick your favorite slf4j binding
  lazy val slf4jBinding = "ch.qos.logback" % "logback-classic" % "0.9.25" % "runtime"

  // http://groups.google.com/group/simple-build-tool/msg/1f17b43807d06cda
  override def testClasspath = super.testClasspath +++ buildCompilerJar

  lazy val hyperion = "Hyperion" at "http://hyperion:9080/artifactory/remote-repos"

}
