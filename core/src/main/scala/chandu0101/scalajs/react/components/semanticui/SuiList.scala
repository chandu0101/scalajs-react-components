

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
     

case class SuiList(
     onDrag: js.UndefOr[ReactDragEventH => Callback] = js.undefined,
onDragExit: js.UndefOr[ReactDragEventH => Callback] = js.undefined,
celled: js.UndefOr[Boolean] = js.undefined,
onContextMenu: js.UndefOr[ReactMouseEventH => Callback] = js.undefined,
ordered: js.UndefOr[Boolean] = js.undefined,
onDragOver: js.UndefOr[ReactDragEventH => Callback] = js.undefined,
horizontal: js.UndefOr[Boolean] = js.undefined,
onMouseUp: js.UndefOr[ReactMouseEventH => Callback] = js.undefined,
onMouseDown: js.UndefOr[ReactMouseEventH => Callback] = js.undefined,
ref: js.UndefOr[String] = js.undefined,
bulleted: js.UndefOr[Boolean] = js.undefined,
onDragEnter: js.UndefOr[ReactDragEventH => Callback] = js.undefined,
onClick: js.UndefOr[ReactMouseEventH => Callback] = js.undefined,
relaxed: js.UndefOr[SemanticListRELAXED|Boolean] = js.undefined,
onMouseMove: js.UndefOr[ReactMouseEventH => Callback] = js.undefined,
onDragEnd: js.UndefOr[ReactDragEventH => Callback] = js.undefined,
floated: js.UndefOr[SemanticFLOATS] = js.undefined,
divided: js.UndefOr[Boolean] = js.undefined,
onDragLeave: js.UndefOr[ReactDragEventH => Callback] = js.undefined,
key: js.UndefOr[String] = js.undefined,
onDrop: js.UndefOr[ReactDragEventH => Callback] = js.undefined,
onDragStart: js.UndefOr[ReactDragEventH => Callback] = js.undefined,
className: js.UndefOr[String] = js.undefined,
onMouseLeave: js.UndefOr[ReactMouseEventH => Callback] = js.undefined,
size: js.UndefOr[SemanticSIZES] = js.undefined,
selection: js.UndefOr[Boolean] = js.undefined,
inverted: js.UndefOr[Boolean] = js.undefined,
animated: js.UndefOr[Boolean] = js.undefined,
onDoubleClick: js.UndefOr[ReactMouseEventH => Callback] = js.undefined,
verticalAlign: js.UndefOr[SemanticVERTICALALIGNMENTS] = js.undefined,
onMouseOut: js.UndefOr[ReactMouseEventH => Callback] = js.undefined,
onMouseEnter: js.UndefOr[ReactMouseEventH => Callback] = js.undefined,
items: js.UndefOr[js.Array[js.Object]] = js.undefined,
onMouseOver: js.UndefOr[ReactMouseEventH => Callback] = js.undefined,
as: js.UndefOr[String | js.Function] = js.undefined,
link: js.UndefOr[Boolean] = js.undefined
){
  def apply(children: ReactNode*) = {
     val props = JSMacro[SuiList](this)
     ReactJS.createElement(Sui.List,props,children: _*)
   }
}
     