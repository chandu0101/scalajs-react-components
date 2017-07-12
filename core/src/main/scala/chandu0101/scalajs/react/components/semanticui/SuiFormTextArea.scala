

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
     

case class SuiFormTextArea(
     ref: js.UndefOr[String] = js.undefined,
onSubmit: js.UndefOr[(ReactEventFromTextArea,js.Dynamic) => Callback] = js.undefined,
control: js.UndefOr[String | VdomElement] = js.undefined,
onInput: js.UndefOr[(ReactEventFromTextArea,js.Dynamic) => Callback] = js.undefined,
onBlur: js.UndefOr[ReactFocusEventFromTextArea => Callback] = js.undefined,
onFocus: js.UndefOr[ReactFocusEventFromTextArea => Callback] = js.undefined,
name: js.UndefOr[String] = js.undefined,
options: js.UndefOr[js.Any] = js.undefined,
key: js.UndefOr[String] = js.undefined,
width: js.UndefOr[Double] = js.undefined,
placeholder: js.UndefOr[String] = js.undefined,
label: js.UndefOr[String | js.Object | VdomElement] = js.undefined,
onChange: js.UndefOr[(ReactEventFromTextArea,js.Dynamic) => Callback] = js.undefined,
rows: js.UndefOr[String|Double] = js.undefined,
as: js.UndefOr[String | js.Function] = js.undefined
){
  def apply() = {
    val props = JSMacro[SuiFormTextArea](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Sui.FormTextArea)
    component(props)()
   }
}
     