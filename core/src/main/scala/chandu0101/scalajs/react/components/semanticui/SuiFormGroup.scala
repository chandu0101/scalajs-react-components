

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
     

case class SuiFormGroup(
     widths: js.UndefOr[SemanticFormGroupWIDTHS|SemanticWIDTHSSTRING|SemanticWIDTHSNUMBER|Double] = js.undefined,
ref: js.UndefOr[String] = js.undefined,
grouped: js.UndefOr[Boolean] = js.undefined,
inline: js.UndefOr[Boolean] = js.undefined,
key: js.UndefOr[String] = js.undefined,
className: js.UndefOr[String] = js.undefined,
as: js.UndefOr[String | js.Function] = js.undefined
){
  def apply(children: ReactNode*) = {
     val props = JSMacro[SuiFormGroup](this)
     ReactJS.createElement(Sui.FormGroup,props,children: _*)
   }
}
     