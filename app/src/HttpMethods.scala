package app
import scala.util.Try
import java.time.Instant

import pdi.jwt.{JwtUpickle, JwtAlgorithm, JwtClaim}
object HttpMethods extends cask.MainRoutes {
  @cask.route("/login", methods = Seq("get", "post"))
  def login(request: cask.Request) = {
    if (request.exchange.getRequestMethod.equalToString("post")) "do_the_login"
    else "show_the_login_form"
  }

  @cask.route("/session", methods = Seq("delete"))
  def session(request: cask.Request) = {
    "delete_the_session"
  }

  @cask.route("/session", methods = Seq("secretmethod"))
  def admin(request: cask.Request) = {
    "security_by_obscurity"
  }

  @cask.route("/api", methods = Seq("options"))
  def cors(request: cask.Request) = {
//    String token = JWT.create()
//      .withExpiresAt(newDate(System.currentTimeMillis()))  //设置过期时间
//      .withAudience("user1") //设置接受方信息，一般时登录用户
//      .sign(Algorithm.HMAC256("111111"));  //使用HMAC算法，111111作为密钥加密
    var a = 1L
    a
  }

  @cask.route("/token", methods = Seq("get", "post"))
  def token(request: cask.Request) = {
    val claim = JwtClaim(
      expiration = Some(Instant.now.plusSeconds(157784760).getEpochSecond),
      issuedAt = Some(Instant.now.getEpochSecond)
    )
    // claim: JwtClaim = JwtClaim({}, None, None, None, Some(1791123265), None, Some(1633338505), None)
    val key = "secretKey"
    // key: String = "secretKey"
    val algo = JwtAlgorithm.HS256
    // algo: JwtAlgorithm.HS256.type = HS256

    val token = JwtUpickle.encode(claim, key, algo)
    // token: String = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE3OTExMjMyNjUsImlhdCI6MTYzMzMzODUwNX0.isV-bVHyCiM0_IVAUQUUx-yByXXRWJFGN1T9RCKYcL4"

    JwtUpickle.decodeJson(token, key, Seq(JwtAlgorithm.HS256))
    // res1: util.Try[ujson.Value] = Success(
    //   value = Obj(
    //     value = LinkedHashMap(
    //       "exp" -> Num(value = 1.791123265E9),
    //       "iat" -> Num(value = 1.633338505E9)
    //     )
    //   )
    // )
    JwtUpickle.decode(token, key, Seq(JwtAlgorithm.HS256))
    // res1: util.Try[(String, String, String)] = Success(
    //   value = (
    //     "{\"typ\":\"JWT\",\"alg\":\"HS256\"}",
    //     "{\"user\":1}",
    //     "oG3iKnAvj_OKCv0tchT90sv2IFVeaREgvJmwgRcXfkI"
    token
  }

  initialize()
}
