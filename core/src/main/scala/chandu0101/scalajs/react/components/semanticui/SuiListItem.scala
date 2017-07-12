

package chandu0101.scalajs.react.components
package semanticui
import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.{VdomElement, VdomNode}

import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
     

case class SuiListItem(
     onDrag: js.UndefOr[ReactDragEventFromHtml => Callback] = js.undefined,
image: js.UndefOr[js.Any] = js.undefined,
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
description: js.UndefOr[VdomNode] = js.undefined,
active: js.UndefOr[Boolean] = js.undefined,
onDragEnd: js.UndefOr[ReactDragEventFromHtml => Callback] = js.undefined,
content: js.UndefOr[VdomNode] = js.undefined,
header: js.UndefOr[VdomNode] = js.undefined,
onDragLeave: js.UndefOr[ReactDragEventFromHtml => Callback] = js.undefined,
key: js.UndefOr[String] = js.undefined,
onDrop: js.UndefOr[ReactDragEventFromHtml => Callback] = js.undefined,
onDragStart: js.UndefOr[ReactDragEventFromHtml => Callback] = js.undefined,
className: js.UndefOr[String] = js.undefined,
onMouseLeave: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
icon: js.UndefOr[String | js.Object | VdomElement] = js.undefined,
onDoubleClick: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
value: js.UndefOr[String] = js.undefined,
onMouseOut: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
onMouseEnter: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
onMouseOver: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
as: js.UndefOr[String | js.Function] = js.undefined
){
  def apply(children: VdomNode*) = {
    val props = JSMacro[SuiListItem](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Sui.ListItem)
    component(props)(children: _*)
  }
}
     