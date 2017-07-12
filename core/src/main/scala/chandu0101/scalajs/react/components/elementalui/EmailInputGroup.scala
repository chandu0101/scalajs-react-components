package chandu0101.scalajs.react.components
package elementalui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.React

import scala.scalajs.js
import scala.scalajs.js.`|`

case class EmailInputGroup(className: js.UndefOr[String] = js.undefined,
    alwaysValidate: js.UndefOr[Boolean] = js.undefined,
    invalidMessage: js.UndefOr[String] = js.undefined,
    label: js.UndefOr[String] = js.undefined,
    onChange: js.UndefOr[ReactEventFromInput => Callback] = js.undefined,
    required: js.UndefOr[Boolean] = js.undefined,
    requiredMessage: js.UndefOr[String] = js.undefined,
    value: js.UndefOr[String] = js.undefined) {

  def apply() = {
    val props = JSMacro[EmailInputGroup](this)
    val component = JsComponent[js.Object, Children.None, Null](Eui.EmailInputGroup)
    component(props)
  }
}
