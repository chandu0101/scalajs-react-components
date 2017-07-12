

package chandu0101.scalajs.react.components
package semanticui
import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.VdomNode

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.JSName

/**
 * This file is generated - submit issues instead of PR against it
 */
     

case class SuiGrid(
     textAlign: js.UndefOr[SemanticTEXTALIGNMENTS] = js.undefined,
ref: js.UndefOr[String] = js.undefined,
celled: js.UndefOr[SemanticGridCELLED|Boolean] = js.undefined,
padded: js.UndefOr[SemanticGridPADDED|Boolean] = js.undefined,
reversed: js.UndefOr[GridPropReversed] = js.undefined,
centered: js.UndefOr[Boolean] = js.undefined,
doubling: js.UndefOr[Boolean] = js.undefined,
columns: js.UndefOr[SemanticGridCOLUMNS|Double|SemanticWIDTHSNUMBER|SemanticWIDTHSSTRING|Double] = js.undefined,
key: js.UndefOr[String] = js.undefined,
className: js.UndefOr[String] = js.undefined,
divided: js.UndefOr[SemanticGridDIVIDED|Boolean] = js.undefined,
verticalAlign: js.UndefOr[SemanticVERTICALALIGNMENTS] = js.undefined,
relaxed: js.UndefOr[SemanticGridRELAXED|Boolean] = js.undefined,
stackable: js.UndefOr[Boolean] = js.undefined,
as: js.UndefOr[String | js.Function] = js.undefined,
stretched: js.UndefOr[Boolean] = js.undefined
){
  def apply(children: VdomNode*) = {
    val props = JSMacro[SuiGrid](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Sui.Grid)
    component(props)(children: _*)
  }
}
     