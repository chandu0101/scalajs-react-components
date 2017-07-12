package chandu0101.scalajs.react.components
package elementalui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.React
import japgolly.scalajs.react.vdom.VdomNode

import scala.scalajs.js

case class ModalHeader(
    className: js.UndefOr[String] = js.undefined,
    showCloseButton: js.UndefOr[Boolean] = js.undefined,
    text: js.UndefOr[String] = js.undefined,
    onClose: js.UndefOr[ReactEventFromHtml => Callback] = js.undefined) {

  def apply(children: VdomNode*) = {
    val props = JSMacro[ModalHeader](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Eui.ModalHeader)
    component(props)(children: _*)
  }
}
