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
case class SuiFlag(
    onDrag: js.UndefOr[ReactDragEventFromHtml => Callback] = js.undefined,
    onDragExit: js.UndefOr[ReactDragEventFromHtml => Callback] = js.undefined,
    name: SemanticCOUNTRY,
    onContextMenu: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
    onDragOver: js.UndefOr[ReactDragEventFromHtml => Callback] = js.undefined,
    onMouseUp: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
    onMouseDown: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
    ref: js.UndefOr[String] = js.undefined,
    onDragEnter: js.UndefOr[ReactDragEventFromHtml => Callback] = js.undefined,
    onClick: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
    onMouseMove: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
    onDragEnd: js.UndefOr[ReactDragEventFromHtml => Callback] = js.undefined,
    onDragLeave: js.UndefOr[ReactDragEventFromHtml => Callback] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    onDrop: js.UndefOr[ReactDragEventFromHtml => Callback] = js.undefined,
    onDragStart: js.UndefOr[ReactDragEventFromHtml => Callback] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    onMouseLeave: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
    onDoubleClick: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
    onMouseOut: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
    onMouseEnter: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
    onMouseOver: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
    as: js.UndefOr[String | js.Function] = js.undefined
) {
  def apply() = {
    val props     = JSMacro[SuiFlag](this)
    val component = JsComponent[js.Object, Children.None, Null](Sui.Flag)
    component(props)
  }
}
