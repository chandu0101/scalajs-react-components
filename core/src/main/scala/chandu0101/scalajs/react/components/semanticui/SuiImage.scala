package chandu0101.scalajs.react.components
package semanticui
import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.VdomElement

import scala.scalajs.js
import scala.scalajs.js.`|`

/**
  * This file is generated - submit issues instead of PR against it
  */
case class SuiImage(
    onDrag: js.UndefOr[ReactDragEventFromHtml => Callback] = js.undefined,
    onDragExit: js.UndefOr[ReactDragEventFromHtml => Callback] = js.undefined,
    fluid: js.UndefOr[Boolean] = js.undefined,
    onContextMenu: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
    avatar: js.UndefOr[Boolean] = js.undefined,
    onDragOver: js.UndefOr[ReactDragEventFromHtml => Callback] = js.undefined,
    onMouseUp: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
    onMouseDown: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
    ref: js.UndefOr[String] = js.undefined,
    width: js.UndefOr[Double | SemanticWIDTHSSTRING | SemanticWIDTHSNUMBER] = js.undefined,
    onDragEnter: js.UndefOr[ReactDragEventFromHtml => Callback] = js.undefined,
    onClick: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
    src: js.UndefOr[String] = js.undefined,
    disabled: js.UndefOr[Boolean] = js.undefined,
    centered: js.UndefOr[Boolean] = js.undefined,
    shape: js.UndefOr[SemanticImageSHAPE | Boolean] = js.undefined,
    spaced: js.UndefOr[SemanticImageSPACED | Boolean] = js.undefined,
    onMouseMove: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
    onDragEnd: js.UndefOr[ReactDragEventFromHtml => Callback] = js.undefined,
    floated: js.UndefOr[SemanticFLOATS] = js.undefined,
    height: js.UndefOr[String | Double] = js.undefined,
    `inline`: js.UndefOr[Boolean] = js.undefined,
    wrapped: js.UndefOr[Boolean | js.Object] = js.undefined,
    href: js.UndefOr[String] = js.undefined,
    onDragLeave: js.UndefOr[ReactDragEventFromHtml => Callback] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    onDrop: js.UndefOr[ReactDragEventFromHtml => Callback] = js.undefined,
    onDragStart: js.UndefOr[ReactDragEventFromHtml => Callback] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    onMouseLeave: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
    size: js.UndefOr[SemanticSIZES] = js.undefined,
    ui: js.UndefOr[Boolean] = js.undefined,
    bordered: js.UndefOr[Boolean] = js.undefined,
    onDoubleClick: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
    verticalAlign: js.UndefOr[SemanticVERTICALALIGNMENTS] = js.undefined,
    onMouseOut: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
    label: js.UndefOr[String | js.Object | VdomElement] = js.undefined,
    alt: js.UndefOr[String] = js.undefined,
    onMouseEnter: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
    onMouseOver: js.UndefOr[ReactMouseEventFromHtml => Callback] = js.undefined,
    as: js.UndefOr[String | js.Function] = js.undefined
) {
  def apply() = {
    val props     = JSMacro[SuiImage](this)
    val component = JsComponent[js.Object, Children.None, Null](Sui.Image)
    component(props)
  }
}
