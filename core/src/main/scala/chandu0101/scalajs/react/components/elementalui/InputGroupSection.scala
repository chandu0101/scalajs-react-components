package chandu0101.scalajs.react.components
package elementalui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.React
import japgolly.scalajs.react.vdom.VdomNode

import scala.scalajs.js

case class InputGroupSection(
    className: js.UndefOr[String] = js.undefined,
    grow: js.UndefOr[Boolean] = js.undefined) {

  def apply(children: VdomNode*) = {
    val props = JSMacro[InputGroupSection](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Eui.InputGroupSection)
    component(props)(children: _*)
  }
}
