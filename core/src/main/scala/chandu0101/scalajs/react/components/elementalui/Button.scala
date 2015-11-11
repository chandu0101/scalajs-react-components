package chandu0101.scalajs.react.components
package elementalui

import japgolly.scalajs.react._
import scala.scalajs.js

case class Button(
    block: U[Boolean] = uNone,
    className: U[String] = uNone,
    href: U[String] = uNone,
    component: U[String] = uNone,
    isActive: U[Boolean] = uNone,
    size: U[ButtonSize] = uNone,
    submit: U[Boolean] = uNone,
    `type`: U[ButtonType] = uNone) {

  def apply(children: ReactNode*) = {
    val props = JSMacro[Button](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Eui.Button)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }

}

case class ButtonSize private (val value: String) extends AnyVal

object ButtonSize {
  val LG = ButtonSize("lg")
  val SM = ButtonSize("sm")
  val XS = ButtonSize("xs")
}

case class ButtonType private (val value: String) extends AnyVal

object ButtonType {
  val DEFAULT = ButtonType("default")
  val DEFAULT_PRIMARY = ButtonType("default-primary")
  val DEFAULT_SUCCESS = ButtonType("default-success")
  val DEFAULT_WARNING = ButtonType("default-warning")
  val DEFAULT_DANGER = ButtonType("default-danger")
  val HOLLOW_PRIMARY = ButtonType("hollow-primary")
  val HOLLOW_SUCCESS = ButtonType("hollow-success")
  val HOLLOW_WARNING = ButtonType("hollow-warning")
  val HOLLOW_DANGER = ButtonType("hollow-danger")
  val PRIMARY = ButtonType("primary")
  val SUCCESS = ButtonType("success")
  val WARNING = ButtonType("warning")
  val DANGER = ButtonType("danger")
  val LINK = ButtonType("link")
  val LINK_TEXT = ButtonType("link-text")
  val LINK_CANCEL = ButtonType("link-cancel")
  val LINK_DELETE = ButtonType("link-delete")
}
