package chandu0101.scalajs.react.components
package elementalui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.React

import scala.scalajs.js
import scala.scalajs.js.`|`

case class ResponsiveText(
    className: js.UndefOr[String] = js.undefined,
    hiddenLG: js.UndefOr[String] = js.undefined,
    hiddenMD: js.UndefOr[String] = js.undefined,
    hiddenSM: js.UndefOr[String] = js.undefined,
    hiddenXS: js.UndefOr[String] = js.undefined,
    visibleLG: js.UndefOr[String] = js.undefined,
    visibleMD: js.UndefOr[String] = js.undefined,
    visibleSM: js.UndefOr[String] = js.undefined,
    visibleXS: js.UndefOr[String] = js.undefined) {

  def apply() = {
    val props = JSMacro[ResponsiveText](this)
    val component = JsComponent[js.Object, Children.None, Null](Eui.ResponsiveText)
    component(props)
  }
}
