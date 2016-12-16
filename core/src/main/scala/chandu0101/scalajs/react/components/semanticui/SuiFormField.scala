

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
     

case class SuiFormField(
     ref: js.UndefOr[String] = js.undefined,
control: js.UndefOr[String | ReactElement] = js.undefined,
disabled: js.UndefOr[Boolean] = js.undefined,
inline: js.UndefOr[Boolean] = js.undefined,
key: js.UndefOr[String] = js.undefined,
`type`: js.UndefOr[String] = js.undefined,
className: js.UndefOr[String] = js.undefined,
width: js.UndefOr[SemanticWIDTHSSTRING|SemanticWIDTHSNUMBER|Double] = js.undefined,
error: js.UndefOr[Boolean] = js.undefined,
label: js.UndefOr[String | js.Object | ReactElement] = js.undefined,
required: js.UndefOr[Boolean | js.Array[String]] = js.undefined,
as: js.UndefOr[String | js.Function] = js.undefined
){
  def apply(children: ReactNode*) = {
     val props = JSMacro[SuiFormField](this)
     ReactJS.createElement(Sui.FormField,props,children: _*)
   }
}
     