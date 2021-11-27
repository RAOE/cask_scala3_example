package app

import scala.util.Try
import java.time.Instant
import pdi.jwt.{JwtUpickle, JwtAlgorithm, JwtClaim}
import app.{JwtUtils => Jwt }

object UserTokenController extends cask.MainRoutes {
  @cask.route("/token", methods = Seq("get", "post"))
  def token(request: cask.Request) = {
    //newJwtClaim(content: String, issuer: Option[String], subject: Option[String], audience: Option[Set[String]], expiration: Option[Long], notBefore: Option[Long], issuedAt: Option[Long], jwtId: Option[String])
    Jwt.getRes(1,2)
    val token = Jwt.encodeToken();
    // var result = JwtUpickle.decode(token, key, Seq(JwtAlgorithm.HS256))
    // println("result is %s .\n", result)
    token
  }
  override
  def port: Int = 8081
  initialize()
}





