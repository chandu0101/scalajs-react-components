package chandu0101.scalajs.react.components
package elementalui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.React

import scala.scalajs.js
import scala.scalajs.js.`|`

case class CheckBox(
    className: js.UndefOr[String] = js.undefined,
    disabled: js.UndefOr[Boolean] = js.undefined,
    autofocus: js.UndefOr[Boolean] = js.undefined,
    indeterminate: js.UndefOr[Boolean] = js.undefined,
    inline: js.UndefOr[Boolean] = js.undefined,
    label: js.UndefOr[String] = js.undefined,
    style: js.UndefOr[String] = js.undefined,
    title: js.UndefOr[String] = js.undefined,
    onclick: js.UndefOr[ReactEventFromHtml => Callback] = js.undefined,
    ondblclick: js.UndefOr[ReactEventFromHtml => Callback] = js.undefined) {

  def apply() = {
    val props = JSMacro[CheckBox](this)
    val component = JsComponent[js.Object, Children.None, Null](Eui.Checkbox)
    component(props)
  }

}
