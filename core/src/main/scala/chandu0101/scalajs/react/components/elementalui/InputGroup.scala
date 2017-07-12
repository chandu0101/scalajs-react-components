package chandu0101.scalajs.react.components
package elementalui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.React
import japgolly.scalajs.react.vdom.VdomNode

import scala.scalajs.js
import scala.scalajs.js.`|`

object InputGroup {
  case class Section(className: js.UndefOr[String] = js.undefined,
                     `type`: js.UndefOr[String] = js.undefined,
                     grow: js.UndefOr[Boolean] = js.undefined) {
    def apply(children: VdomNode*) = {
      val props     = JSMacro[Section](this)
      val component = JsComponent[js.Object, Children.Varargs, Null](Eui.InputGroupSection)
      component(props)(children: _*)
    }
  }
}

case class InputGroup(className: js.UndefOr[String] = js.undefined,
                      contiguous: js.UndefOr[Boolean] = js.undefined) {
  def apply(children: VdomNode*) = {
    val props     = JSMacro[InputGroup](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Eui.InputGroup)
    component(props)(children: _*)
  }

}
