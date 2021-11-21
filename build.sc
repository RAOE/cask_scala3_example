import mill._, scalalib._


object app extends ScalaModule {
  def scalaVersion = "3.0.0"

  def ivyDeps = Agg(
    ivy"com.lihaoyi::cask:0.8.0",
  )
  object test extends Tests{
    def testFramework = "utest.runner.Framework"

    def ivyDeps = Agg(
      ivy"com.lihaoyi::utest::0.7.10",
      ivy"com.lihaoyi::requests::0.6.9",
      ivy"com.lihaoyi::fansi:0.2.4",
      ivy"com.lihaoyi::sourcecode:0.2.7",
      ivy"com.lihaoyi::pprint:0.6.6",
      ivy"com.lihaoyi::geny:0.6.10",
      ivy"com.auth0::java-jwt:3.18.2"
    )
  }
}
