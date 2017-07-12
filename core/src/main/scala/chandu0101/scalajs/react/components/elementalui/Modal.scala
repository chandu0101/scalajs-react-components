package chandu0101.scalajs.react.components
package elementalui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.React
import japgolly.scalajs.react.vdom.VdomNode

import scala.scalajs.js
import scala.scalajs.js.`|`

case class Modal(
    className: js.UndefOr[String] = js.undefined,
    backdropClosesModal: js.UndefOr[Boolean] = js.undefined,
    isOpen: js.UndefOr[Boolean] = js.undefined,
    onCancel: js.UndefOr[ReactEventFromHtml => Callback] = js.undefined,
    width: js.UndefOr[String | Int] = js.undefined) {

  def apply(children: VdomNode*) = {
    val props = JSMacro[Modal](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Eui.Modal)
    component(props)(children: _*)
  }
}

case class ModalWidth private (value: String) extends AnyVal

object ModalWidth {
  val SMALL = ModalWidth("small")
  val MEDIUM = ModalWidth("medium")
  val LARGE = ModalWidth("large")
}
