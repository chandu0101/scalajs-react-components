

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
     

case class SuiIcon(
     onDrag: js.UndefOr[ReactDragEventFromHtml => Callback] = js.undefined,
corner: js.UndefOr[Boolean] = js.undefined,
onDragExit: js.UndefOr[ReactDragEventFromHtml => Callback] = js.undefined,
onContextMenu: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
onDragOver: js.UndefOr[ReactDragEventFromHtml => Callback] = js.undefined,
onMouseUp: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
onMouseDown: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
ref: js.UndefOr[String] = js.undefined,
onDragEnter: js.UndefOr[ReactDragEventFromHtml => Callback] = js.undefined,
onClick: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
disabled: js.UndefOr[Boolean] = js.undefined,
onMouseMove: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
onDragEnd: js.UndefOr[ReactDragEventFromHtml => Callback] = js.undefined,
name: js.UndefOr[String] = js.undefined,
onDragLeave: js.UndefOr[ReactDragEventFromHtml => Callback] = js.undefined,
key: js.UndefOr[String] = js.undefined,
fitted: js.UndefOr[Boolean] = js.undefined,
onDrop: js.UndefOr[ReactDragEventFromHtml => Callback] = js.undefined,
rotated: js.UndefOr[SemanticROTATION] = js.undefined,
onDragStart: js.UndefOr[ReactDragEventFromHtml => Callback] = js.undefined,
className: js.UndefOr[String] = js.undefined,
onMouseLeave: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
size: js.UndefOr[SemanticSIZES] = js.undefined,
flipped: js.UndefOr[SemanticIconFLIPPED] = js.undefined,
loading: js.UndefOr[Boolean] = js.undefined,
inverted: js.UndefOr[Boolean] = js.undefined,
bordered: js.UndefOr[Boolean] = js.undefined,
circular: js.UndefOr[Boolean] = js.undefined,
onDoubleClick: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
onMouseOut: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
onMouseEnter: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
color: js.UndefOr[SemanticCOLORS] = js.undefined,
onMouseOver: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
as: js.UndefOr[String | js.Function] = js.undefined,
link: js.UndefOr[Boolean] = js.undefined
){
  def apply() = {
    val props = JSMacro[SuiIcon](this)
    val component = JsComponent[js.Object, Children.None, Null](Sui.Icon)
    component(props)
  }
}
     