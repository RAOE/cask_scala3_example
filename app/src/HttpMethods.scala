package app


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
    var a = 1L
    a
  }

  initialize()
}
