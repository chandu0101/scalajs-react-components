

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
     

case class SuiListIcon(
     onDrag: js.UndefOr[ReactDragEventFromHtml => Callback] = js.undefined,
onDragExit: js.UndefOr[ReactDragEventFromHtml => Callback] = js.undefined,
onContextMenu: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
onDragOver: js.UndefOr[ReactDragEventFromHtml => Callback] = js.undefined,
onMouseUp: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
onMouseDown: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
ref: js.UndefOr[String] = js.undefined,
onDragEnter: js.UndefOr[ReactDragEventFromHtml => Callback] = js.undefined,
onClick: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
onMouseMove: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
onDragEnd: js.UndefOr[ReactDragEventFromHtml => Callback] = js.undefined,
name: js.UndefOr[String] = js.undefined,
onDragLeave: js.UndefOr[ReactDragEventFromHtml => Callback] = js.undefined,
key: js.UndefOr[String] = js.undefined,
onDrop: js.UndefOr[ReactDragEventFromHtml => Callback] = js.undefined,
onDragStart: js.UndefOr[ReactDragEventFromHtml => Callback] = js.undefined,
className: js.UndefOr[String] = js.undefined,
onMouseLeave: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
onDoubleClick: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
verticalAlign: js.UndefOr[SemanticVERTICALALIGNMENTS] = js.undefined,
onMouseOut: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
onMouseEnter: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
onMouseOver: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined
){
  def apply() = {
    val props = JSMacro[SuiListIcon](this)
    val component = JsComponent[js.Object, Children.None, Null](Sui.ListIcon)
    component(props)
  }
}
     