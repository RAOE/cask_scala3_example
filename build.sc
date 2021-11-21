import mill._, scalalib._

object app extends ScalaModule {
  def scalaVersion = "3.0.0"

  def ivyDeps = Agg(
    ivy"com.lihaoyi::cask:0.8.0",
    ivy"com.github.jwt-scala::jwt-upickle:9.0.2",

  )

  object test extends Tests {
    def testFramework = "utest.runner.Framework"

    def ivyDeps = Agg(
      ivy"com.lihaoyi::upickle:0.5.1",
      ivy"com.lihaoyi::pprint:0.5.2",
      ivy"com.lihaoyi::fansi:0.2.4",
      ivy"com.lihaoyi::utest_3:0.7.10",
      ivy"com.github.jwt-scala::jwt-upickle:9.0.2"
    )
  }
}
