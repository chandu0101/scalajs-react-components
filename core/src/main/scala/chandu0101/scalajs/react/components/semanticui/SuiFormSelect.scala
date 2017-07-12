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
case class SuiFormSelect(
    onChange: js.UndefOr[(ReactEventS, js.Dynamic) => Callback] = js.undefined,
    ref: js.UndefOr[String] = js.undefined,
    control: js.UndefOr[String | VdomElement] = js.undefined,
    onFocus: js.UndefOr[ReactFocusEventS => Callback] = js.undefined,
    onSubmit: js.UndefOr[(ReactEventS, js.Dynamic) => Callback] = js.undefined,
    compact: js.UndefOr[Boolean] = js.undefined,
    onInput: js.UndefOr[(ReactEventS, js.Dynamic) => Callback] = js.undefined,
    onBlur: js.UndefOr[ReactFocusEventS => Callback] = js.undefined,
    name: js.UndefOr[String] = js.undefined,
    options: js.UndefOr[js.Any] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    width: js.UndefOr[Double] = js.undefined,
    multiple: js.UndefOr[Boolean] = js.undefined,
    search: js.UndefOr[Boolean] = js.undefined,
    placeholder: js.UndefOr[String] = js.undefined,
    label: js.UndefOr[String | js.Object | VdomElement] = js.undefined,
    as: js.UndefOr[String | js.Function] = js.undefined
) {
  def apply() = {
    val props     = JSMacro[SuiFormSelect](this)
    val component = JsComponent[js.Object, Children.None, Null](Sui.FormSelect)
    component(props)
  }
}
