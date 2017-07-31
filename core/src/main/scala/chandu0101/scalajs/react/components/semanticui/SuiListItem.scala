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
case class SuiListItem(
    onDrag: js.UndefOr[ReactDragEventH => Callback] = js.undefined,
    image: js.UndefOr[js.Any] = js.undefined,
    onDragExit: js.UndefOr[ReactDragEventH => Callback] = js.undefined,
    onContextMenu: js.UndefOr[ReactMouseEventH => Callback] = js.undefined,
    onDragOver: js.UndefOr[ReactDragEventH => Callback] = js.undefined,
    onMouseUp: js.UndefOr[ReactMouseEventH => Callback] = js.undefined,
    onMouseDown: js.UndefOr[ReactMouseEventH => Callback] = js.undefined,
    ref: js.UndefOr[String] = js.undefined,
    onDragEnter: js.UndefOr[ReactDragEventH => Callback] = js.undefined,
    onClick: js.UndefOr[ReactMouseEventH => Callback] = js.undefined,
    disabled: js.UndefOr[Boolean] = js.undefined,
    onMouseMove: js.UndefOr[ReactMouseEventH => Callback] = js.undefined,
    description: js.UndefOr[ReactNode] = js.undefined,
    active: js.UndefOr[Boolean] = js.undefined,
    onDragEnd: js.UndefOr[ReactDragEventH => Callback] = js.undefined,
    content: js.UndefOr[ReactNode] = js.undefined,
    header: js.UndefOr[ReactNode] = js.undefined,
    onDragLeave: js.UndefOr[ReactDragEventH => Callback] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    onDrop: js.UndefOr[ReactDragEventH => Callback] = js.undefined,
    onDragStart: js.UndefOr[ReactDragEventH => Callback] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    onMouseLeave: js.UndefOr[ReactMouseEventH => Callback] = js.undefined,
    icon: js.UndefOr[String | js.Object | ReactElement] = js.undefined,
    onDoubleClick: js.UndefOr[ReactMouseEventH => Callback] = js.undefined,
    value: js.UndefOr[String] = js.undefined,
    onMouseOut: js.UndefOr[ReactMouseEventH => Callback] = js.undefined,
    onMouseEnter: js.UndefOr[ReactMouseEventH => Callback] = js.undefined,
    onMouseOver: js.UndefOr[ReactMouseEventH => Callback] = js.undefined,
    as: js.UndefOr[String | js.Function] = js.undefined
) {
  def apply(children: ReactNode*) = {
    val props = JSMacro[SuiListItem](this)
    ReactJS.createElement(Sui.ListItem, props, children: _*)
  }
}
