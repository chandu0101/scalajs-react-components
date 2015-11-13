package chandu0101.scalajs.react.components
package elementalui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

case class Button(
    block: js.UndefOr[Boolean] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    href: js.UndefOr[String] = js.undefined,
    component: js.UndefOr[String] = js.undefined,
    isActive: js.UndefOr[Boolean] = js.undefined,
    size: js.UndefOr[ButtonSize] = js.undefined,
    submit: js.UndefOr[Boolean] = js.undefined,
    `type`: js.UndefOr[ButtonType] = js.undefined,
    onclick: js.UndefOr[ReactEventH ⇒ Callback] = js.undefined,
    ondblclick: js.UndefOr[ReactEventH ⇒ Callback] = js.undefined) {

  def apply(children: ReactNode*) = {
    val props = JSMacro[Button](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Eui.Button)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }

}

case class ButtonSize private (value: String) extends AnyVal

object ButtonSize {
  val LG = ButtonSize("lg")
  val SM = ButtonSize("sm")
  val XS = ButtonSize("xs")

  val values = List(LG, SM, XS)
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
  val values = List(
    DEFAULT,
    DEFAULT_PRIMARY,
    DEFAULT_SUCCESS,
    DEFAULT_WARNING,
    DEFAULT_DANGER,
    HOLLOW_PRIMARY,
    HOLLOW_SUCCESS,
    HOLLOW_WARNING,
    HOLLOW_DANGER,
    PRIMARY,
    SUCCESS,
    WARNING,
    DANGER,
    LINK,
    LINK_TEXT,
    LINK_CANCEL,
    LINK_DELETE)
}
