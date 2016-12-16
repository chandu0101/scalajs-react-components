

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
     

case class SuiFormCheckbox(
     ref: js.UndefOr[String] = js.undefined,
control: js.UndefOr[String | ReactElement] = js.undefined,
value: js.UndefOr[String|Double|js.Array[String]|js.Array[Double]] = js.undefined,
name: js.UndefOr[String] = js.undefined,
key: js.UndefOr[String] = js.undefined,
placeholder: js.UndefOr[String] = js.undefined,
label: js.UndefOr[String | js.Object | ReactElement] = js.undefined,
as: js.UndefOr[String | js.Function] = js.undefined
){
  def apply() = {
     val props = JSMacro[SuiFormCheckbox](this)
     ReactJS.createElement(Sui.FormCheckbox,props)
   }
}
     