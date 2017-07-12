package chandu0101.scalajs.react.components
package elementalui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.React
import japgolly.scalajs.react.vdom.html_<^._

import scala.scalajs.js
import scala.scalajs.js.`|`

case class Button(
    onClick: js.UndefOr[ReactEventFromHtml => Callback] = js.undefined,
    `type`: js.UndefOr[ButtonType] = js.undefined,
    block: js.UndefOr[Boolean] = js.undefined,
    disabled: js.UndefOr[Boolean] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    href: js.UndefOr[String] = js.undefined,
    component: js.UndefOr[String] = js.undefined,
    isActive: js.UndefOr[Boolean] = js.undefined,
    size: js.UndefOr[ButtonSize] = js.undefined,
    submit: js.UndefOr[Boolean] = js.undefined,
    ondblclick: js.UndefOr[ReactEventFromHtml => Callback] = js.undefined) {

  def apply(children: VdomNode*) = {
    val props = JSMacro[Button](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Eui.Button)
    component(props)(children: _*)
  }

}

case class ButtonSize private (value: String) extends AnyVal

object ButtonSize {
  val LG = ButtonSize("lg")
  val SM = ButtonSize("sm")
  val XS = ButtonSize("xs")

  val values = List(LG, SM, XS)
}

case class ButtonType private (value: String) extends AnyVal

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
