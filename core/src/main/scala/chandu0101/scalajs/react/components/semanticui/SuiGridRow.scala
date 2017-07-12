

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
     

case class SuiGridRow(
     textAlign: js.UndefOr[SemanticTEXTALIGNMENTS] = js.undefined,
columns: js.UndefOr[SemanticGridRowCOLUMNS|SemanticWIDTHSNUMBER|SemanticWIDTHSSTRING|Double] = js.undefined,
ref: js.UndefOr[String] = js.undefined,
reversed: js.UndefOr[GridPropReversed] = js.undefined,
centered: js.UndefOr[Boolean] = js.undefined,
divided: js.UndefOr[Boolean] = js.undefined,
key: js.UndefOr[String] = js.undefined,
className: js.UndefOr[String] = js.undefined,
only: js.UndefOr[GridPropOnly] = js.undefined,
verticalAlign: js.UndefOr[SemanticVERTICALALIGNMENTS] = js.undefined,
color: js.UndefOr[SemanticCOLORS] = js.undefined,
as: js.UndefOr[String | js.Function] = js.undefined,
stretched: js.UndefOr[Boolean] = js.undefined
){
  def apply(children: VdomNode*) = {
    val props = JSMacro[SuiGridRow](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Sui.GridRow)
    component(props)(children: _*)
   }
}
     