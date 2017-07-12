package demo
package components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

import scala.scalajs.js

case class Github(login: String = "",
                  html_url: String = "",
                  avatar_url: String = "",
                  time: Double = 0) {
  override def equals(obj: Any): Boolean = obj match {
    case that: Github => that.login.equalsIgnoreCase(this.login)
    case _            => false
  }
}

object GithubUser {

  object Styles {
    val userGroup = Seq(^.display := "inline-block",
                        ^.textAlign := "center",
                        ^.textDecoration := "none",
                        ^.color := "black").toTagMod

    val userIcon = Seq(^.margin := "10px",
                       ^.display := "block",
                       ^.width := "100px",
                       ^.height := "100px",
                       ^.borderRadius := "50%").toTagMod

    val userName = Seq(^.fontSize := "18px", ^.fontWeight := "500").toTagMod
  }
  case class Backend($ : BackendScope[Props, _]) {
    def render(P: Props) = {
      <.a(Styles.userGroup, ^.href := P.user.html_url)(
        <.img(Styles.userIcon, ^.src := P.user.avatar_url),
        <.span(Styles.userName)(P.user.login)
      )
    }
  }

  val component = ScalaComponent
    .builder[Props]("GithubUser")
    .renderBackend[Backend]
    .build

  case class Props(user: Github)

  def apply(user: Github) = component(Props(user))()
}
