package chandu0101.scalajs.react.components
package semanticui
import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.JSName

/**
  * This file is generated - submit issues instead of PR against it
  */
case class SuiFormTextArea(
    ref: js.UndefOr[String] = js.undefined,
    onSubmit: js.UndefOr[(ReactEventTA, js.Dynamic) => Callback] = js.undefined,
    control: js.UndefOr[String | ReactElement] = js.undefined,
    onInput: js.UndefOr[(ReactEventTA, js.Dynamic) => Callback] = js.undefined,
    onBlur: js.UndefOr[ReactFocusEventTA => Callback] = js.undefined,
    onFocus: js.UndefOr[ReactFocusEventTA => Callback] = js.undefined,
    name: js.UndefOr[String] = js.undefined,
    options: js.UndefOr[js.Any] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    width: js.UndefOr[Double] = js.undefined,
    placeholder: js.UndefOr[String] = js.undefined,
    label: js.UndefOr[String | js.Object | ReactElement] = js.undefined,
    onChange: js.UndefOr[(ReactEventTA, js.Dynamic) => Callback] = js.undefined,
    rows: js.UndefOr[String | Double] = js.undefined,
    as: js.UndefOr[String | js.Function] = js.undefined
) {
  def apply() = {
    val props = JSMacro[SuiFormTextArea](this)
    ReactJS.createElement(Sui.FormTextArea, props)
  }
}
