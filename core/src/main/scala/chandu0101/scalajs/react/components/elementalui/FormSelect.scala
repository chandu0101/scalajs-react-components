package chandu0101.scalajs.react.components
package elementalui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.React
import japgolly.scalajs.react.vdom.VdomNode

import scala.scalajs.js
import scala.scalajs.js.`|`

case class SelectOption(label: String, value: String) {
  val toJS = JSMacro[SelectOption](this)
}
object SelectOption {
  def fromJson(obj: js.Dynamic) = SelectOption(label = obj.text.toString, value = obj.payload.toString)
}

case class FormSelect(
    className: js.UndefOr[String] = js.undefined,
    alwaysValidate: js.UndefOr[Boolean] = js.undefined,
    disabled: js.UndefOr[Boolean] = js.undefined,
    firstOption: js.UndefOr[String] = js.undefined,
    htmFor: js.UndefOr[String] = js.undefined,
    id: js.UndefOr[String] = js.undefined,
    label: js.UndefOr[String] = js.undefined,
    options: js.Array[SelectOption] = js.Array(),
    prependEmptyOption: js.UndefOr[Boolean] = js.undefined,
    onChange: js.UndefOr[String => Callback] = js.undefined,
    required: js.UndefOr[Boolean] = js.undefined,
    requiredMessage: js.UndefOr[String] = js.undefined,
    value: js.UndefOr[String] = js.undefined) {
  def apply(children: VdomNode*) = {
    val props = JSMacro[FormSelect](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Eui.FormSelect)
    component(props)(children: _*)
  }
}
