

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
     

case class SuiLabel(
     detail: js.UndefOr[ReactNode] = js.undefined,
onClick: js.UndefOr[(ReactMouseEventH,js.Dynamic) => Callback] = js.undefined,
horizontal: js.UndefOr[Boolean] = js.undefined,
ref: js.UndefOr[String] = js.undefined,
removable: js.UndefOr[Boolean] = js.undefined,
basic: js.UndefOr[Boolean] = js.undefined,
onRemove: js.UndefOr[(ReactEventH,js.Dynamic) => Callback] = js.undefined,
ribbon: js.UndefOr[SemanticLabelRIBBON|Boolean] = js.undefined,
content: js.UndefOr[ReactNode] = js.undefined,
empty: js.UndefOr[Boolean | ReactNode] = js.undefined,
key: js.UndefOr[String] = js.undefined,
className: js.UndefOr[String] = js.undefined,
size: js.UndefOr[SemanticSIZES] = js.undefined,
floating: js.UndefOr[Boolean] = js.undefined,
tag: js.UndefOr[Boolean] = js.undefined,
image: js.UndefOr[Boolean | ReactNode] = js.undefined,
circular: js.UndefOr[Boolean] = js.undefined,
icon: js.UndefOr[String | js.Object | ReactElement] = js.undefined,
corner: js.UndefOr[Boolean|LabelPropCorner] = js.undefined,
pointing: js.UndefOr[Boolean|LabelPropPointing] = js.undefined,
color: js.UndefOr[SemanticCOLORS] = js.undefined,
as: js.UndefOr[String | js.Function] = js.undefined,
attached: js.UndefOr[LabelPropAttached] = js.undefined
){
  def apply(children: ReactNode*) = {
     val props = JSMacro[SuiLabel](this)
     ReactJS.createElement(Sui.Label,props,children: _*)
   }
}
     