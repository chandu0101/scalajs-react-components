

package chandu0101.scalajs.react.components
package semanticui
import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.{VdomElement, VdomNode}

import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
     

case class SuiFormInput(
     onSubmit: js.UndefOr[(ReactEventFromInput,js.Dynamic) => Callback] = js.undefined,
onBlur: js.UndefOr[ReactFocusEventFromInput => Callback] = js.undefined,
fluid: js.UndefOr[Boolean] = js.undefined,
autocomplete: js.UndefOr[String] = js.undefined,
ref: js.UndefOr[String] = js.undefined,
actionPosition: js.UndefOr[SemanticInputACTIONPOSITION] = js.undefined,
labelPosition: js.UndefOr[SemanticButtonLABELPOSITIONS] = js.undefined,
disabled: js.UndefOr[Boolean] = js.undefined,
transparent: js.UndefOr[Boolean] = js.undefined,
iconPosition: js.UndefOr[SemanticInputICONPOSITION] = js.undefined,
onInput: js.UndefOr[(ReactEventFromInput,js.Dynamic) => Callback] = js.undefined,
name: js.UndefOr[String] = js.undefined,
key: js.UndefOr[String] = js.undefined,
focus: js.UndefOr[Boolean] = js.undefined,
`type`: js.UndefOr[String] = js.undefined,
className: js.UndefOr[String] = js.undefined,
action: js.UndefOr[Boolean | String | VdomNode ] = js.undefined,
width: js.UndefOr[Double] = js.undefined,
size: js.UndefOr[SemanticSIZES] = js.undefined,
step: js.UndefOr[Double] = js.undefined,
error: js.UndefOr[Boolean] = js.undefined,
defaultValue: js.UndefOr[String] = js.undefined,
input: js.UndefOr[js.Any] = js.undefined,
loading: js.UndefOr[Boolean] = js.undefined,
inverted: js.UndefOr[Boolean] = js.undefined,
readOnly: js.UndefOr[Boolean] = js.undefined,
icon: js.UndefOr[String | js.Object | VdomElement] = js.undefined,
onFocus: js.UndefOr[ReactFocusEventFromInput => Callback] = js.undefined,
onChange: js.UndefOr[(ReactEventFromInput,js.Dynamic) => Callback] = js.undefined,
placeholder: js.UndefOr[String] = js.undefined,
label: js.UndefOr[String | js.Object | VdomElement] = js.undefined,
value: js.UndefOr[String|Double] = js.undefined,
as: js.UndefOr[String | js.Function] = js.undefined
){
  def apply(children: VdomNode*) = {
    val props = JSMacro[SuiFormInput](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Sui.FormInput)
    component(props)(children: _*)
   }
}
     