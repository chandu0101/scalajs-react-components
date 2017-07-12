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
case class SuiList(
    onDrag: js.UndefOr[ReactDragEventFromHtml => Callback] = js.undefined,
    onDragExit: js.UndefOr[ReactDragEventFromHtml => Callback] = js.undefined,
    celled: js.UndefOr[Boolean] = js.undefined,
    onContextMenu: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
    ordered: js.UndefOr[Boolean] = js.undefined,
    onDragOver: js.UndefOr[ReactDragEventFromHtml => Callback] = js.undefined,
    horizontal: js.UndefOr[Boolean] = js.undefined,
    onMouseUp: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
    onMouseDown: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
    ref: js.UndefOr[String] = js.undefined,
    bulleted: js.UndefOr[Boolean] = js.undefined,
    onDragEnter: js.UndefOr[ReactDragEventFromHtml => Callback] = js.undefined,
    onClick: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
    relaxed: js.UndefOr[SemanticListRELAXED | Boolean] = js.undefined,
    onMouseMove: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
    onDragEnd: js.UndefOr[ReactDragEventFromHtml => Callback] = js.undefined,
    floated: js.UndefOr[SemanticFLOATS] = js.undefined,
    divided: js.UndefOr[Boolean] = js.undefined,
    onDragLeave: js.UndefOr[ReactDragEventFromHtml => Callback] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    onDrop: js.UndefOr[ReactDragEventFromHtml => Callback] = js.undefined,
    onDragStart: js.UndefOr[ReactDragEventFromHtml => Callback] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    onMouseLeave: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
    size: js.UndefOr[SemanticSIZES] = js.undefined,
    selection: js.UndefOr[Boolean] = js.undefined,
    inverted: js.UndefOr[Boolean] = js.undefined,
    animated: js.UndefOr[Boolean] = js.undefined,
    onDoubleClick: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
    verticalAlign: js.UndefOr[SemanticVERTICALALIGNMENTS] = js.undefined,
    onMouseOut: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
    onMouseEnter: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
    items: js.UndefOr[js.Array[js.Object]] = js.undefined,
    onMouseOver: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
    as: js.UndefOr[String | js.Function] = js.undefined,
    link: js.UndefOr[Boolean] = js.undefined
) {
  def apply(children: VdomNode*) = {
    val props     = JSMacro[SuiList](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Sui.List)
    component(props)(children: _*)
  }
}
