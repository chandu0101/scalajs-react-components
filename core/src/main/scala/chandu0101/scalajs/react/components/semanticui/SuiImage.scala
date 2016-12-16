

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
     

case class SuiImage(
     onDrag: js.UndefOr[ReactDragEventH => Callback] = js.undefined,
onDragExit: js.UndefOr[ReactDragEventH => Callback] = js.undefined,
fluid: js.UndefOr[Boolean] = js.undefined,
onContextMenu: js.UndefOr[ReactMouseEventH => Callback] = js.undefined,
avatar: js.UndefOr[Boolean] = js.undefined,
onDragOver: js.UndefOr[ReactDragEventH => Callback] = js.undefined,
onMouseUp: js.UndefOr[ReactMouseEventH => Callback] = js.undefined,
onMouseDown: js.UndefOr[ReactMouseEventH => Callback] = js.undefined,
ref: js.UndefOr[String] = js.undefined,
width: js.UndefOr[Double|SemanticWIDTHSSTRING|SemanticWIDTHSNUMBER] = js.undefined,
onDragEnter: js.UndefOr[ReactDragEventH => Callback] = js.undefined,
onClick: js.UndefOr[ReactMouseEventH => Callback] = js.undefined,
src: js.UndefOr[String] = js.undefined,
disabled: js.UndefOr[Boolean] = js.undefined,
centered: js.UndefOr[Boolean] = js.undefined,
shape: js.UndefOr[SemanticImageSHAPE|Boolean] = js.undefined,
spaced: js.UndefOr[SemanticImageSPACED|Boolean] = js.undefined,
onMouseMove: js.UndefOr[ReactMouseEventH => Callback] = js.undefined,
onDragEnd: js.UndefOr[ReactDragEventH => Callback] = js.undefined,
floated: js.UndefOr[SemanticFLOATS] = js.undefined,
height: js.UndefOr[String|Double] = js.undefined,
inline: js.UndefOr[Boolean] = js.undefined,
wrapped: js.UndefOr[Boolean | js.Object] = js.undefined,
href: js.UndefOr[String] = js.undefined,
onDragLeave: js.UndefOr[ReactDragEventH => Callback] = js.undefined,
key: js.UndefOr[String] = js.undefined,
onDrop: js.UndefOr[ReactDragEventH => Callback] = js.undefined,
onDragStart: js.UndefOr[ReactDragEventH => Callback] = js.undefined,
className: js.UndefOr[String] = js.undefined,
onMouseLeave: js.UndefOr[ReactMouseEventH => Callback] = js.undefined,
size: js.UndefOr[SemanticSIZES] = js.undefined,
ui: js.UndefOr[Boolean] = js.undefined,
bordered: js.UndefOr[Boolean] = js.undefined,
onDoubleClick: js.UndefOr[ReactMouseEventH => Callback] = js.undefined,
verticalAlign: js.UndefOr[SemanticVERTICALALIGNMENTS] = js.undefined,
onMouseOut: js.UndefOr[ReactMouseEventH => Callback] = js.undefined,
label: js.UndefOr[String | js.Object | ReactElement] = js.undefined,
alt: js.UndefOr[String] = js.undefined,
onMouseEnter: js.UndefOr[ReactMouseEventH => Callback] = js.undefined,
onMouseOver: js.UndefOr[ReactMouseEventH => Callback] = js.undefined,
as: js.UndefOr[String | js.Function] = js.undefined
){
  def apply() = {
     val props = JSMacro[SuiImage](this)
     ReactJS.createElement(Sui.Image,props)
   }
}
     