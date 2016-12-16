

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
     

case class SuiGridColumn(
     computer: js.UndefOr[SemanticWIDTHSNUMBER|SemanticWIDTHSSTRING|Double] = js.undefined,
largeScreen: js.UndefOr[SemanticWIDTHSNUMBER|SemanticWIDTHSSTRING|Double] = js.undefined,
textAlign: js.UndefOr[SemanticTEXTALIGNMENTS] = js.undefined,
ref: js.UndefOr[String] = js.undefined,
widescreen: js.UndefOr[Double|SemanticWIDTHSSTRING|Double] = js.undefined,
width: js.UndefOr[SemanticWIDTHSNUMBER|SemanticWIDTHSSTRING|Double] = js.undefined,
tablet: js.UndefOr[SemanticWIDTHSNUMBER|SemanticWIDTHSSTRING|Double] = js.undefined,
floated: js.UndefOr[SemanticFLOATS] = js.undefined,
key: js.UndefOr[String] = js.undefined,
className: js.UndefOr[String] = js.undefined,
mobile: js.UndefOr[SemanticWIDTHSNUMBER|SemanticWIDTHSSTRING|Double] = js.undefined,
only: js.UndefOr[GridPropOnly] = js.undefined,
verticalAlign: js.UndefOr[SemanticVERTICALALIGNMENTS] = js.undefined,
color: js.UndefOr[SemanticCOLORS] = js.undefined,
as: js.UndefOr[String | js.Function] = js.undefined,
stretched: js.UndefOr[Boolean] = js.undefined
){
  def apply(children: ReactNode*) = {
     val props = JSMacro[SuiGridColumn](this)
     ReactJS.createElement(Sui.GridColumn,props,children: _*)
   }
}
     