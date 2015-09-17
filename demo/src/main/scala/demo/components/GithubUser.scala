package demo
package components

import chandu0101.scalajs.react.components.models.Github
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import scala.scalajs.js

object GithubUser {

  object Styles {
    val userGroup = Seq(^.display := "inline-block", ^.textAlign := "center", ^.textDecoration := "none", ^.color := "black")

    val userIcon = Seq(^.margin := "10px", ^.display := "block", ^.width := "100px", ^.height := "100px", ^.borderRadius := "50%")

    val userName = Seq(^.fontSize := "18px", ^.fontWeight := 500)
  }

  val component = ReactComponentB[Props]("GithubUser")
    .render((P) => {
     <.a( Styles.userGroup, ^.href := P.user.html_url)(
        <.img(Styles.userIcon, ^.src := P.user.avatar_url),
        <.span(Styles.userName)(P.user.login)
      )
    })
    .build

  case class Props(user: Github)

  def apply(user: Github,ref: js.UndefOr[String] = "", key: js.Any = {}) = component.set(key, ref)(Props(user))
}
