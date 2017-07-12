package chandu0101.scalajs.react.components
package elementalui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.React
import japgolly.scalajs.react.vdom.VdomNode

import scala.scalajs.js
import scala.scalajs.js.`|`

case class Table(
    className: js.UndefOr[String] = js.undefined) {

  def apply(children: VdomNode*) = {
    val props = JSMacro[Table](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Eui.Table)
    component(props)(children: _*)
  }
}
