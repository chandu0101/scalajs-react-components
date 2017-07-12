package chandu0101.scalajs.react.components
package semanticui
import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.VdomElement

import scala.scalajs.js
import scala.scalajs.js.`|`

/**
  * This file is generated - submit issues instead of PR against it
  */
case class SuiFormRadio(
    ref: js.UndefOr[String] = js.undefined,
    control: js.UndefOr[String | VdomElement] = js.undefined,
    value: js.UndefOr[String | Double | js.Array[String] | js.Array[Double]] = js.undefined,
    checked: js.UndefOr[Boolean] = js.undefined,
    name: js.UndefOr[String] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    onChange: js.UndefOr[(ReactEventFromHtml, js.Dynamic) => Callback] = js.undefined,
    placeholder: js.UndefOr[String] = js.undefined,
    label: js.UndefOr[String | js.Object | VdomElement] = js.undefined,
    as: js.UndefOr[String | js.Function] = js.undefined
) {
  def apply() = {
    val props     = JSMacro[SuiFormRadio](this)
    val component = JsComponent[js.Object, Children.None, Null](Sui.FormRadio)
    component(props)
  }
}
