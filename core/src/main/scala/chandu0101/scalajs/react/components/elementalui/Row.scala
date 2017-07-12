package chandu0101.scalajs.react.components
package elementalui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.React
import japgolly.scalajs.react.vdom.VdomNode

import scala.scalajs.js
import scala.scalajs.js.`|`

case class Row(key: js.UndefOr[String] = js.undefined,
               className: js.UndefOr[String] = js.undefined,
               gutter: js.UndefOr[Int] = js.undefined,
               style: js.UndefOr[String] = js.undefined) {

  def apply(children: VdomNode*) = {
    val props     = JSMacro[Row](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Eui.Row)
    component(props)(children: _*)
  }

}
