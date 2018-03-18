package chandu0101.scalajs.react.components.reactsplitpane

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.VdomElement
import japgolly.scalajs.react.vdom.html_<^._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scalacss.internal.mutable.StyleSheet
import scalacss.DevDefaults._

object ReactSplitPane {
  @js.native
  @JSImport("react-split-pane", JSImport.Default)
  object Component extends js.Any

  class Style extends StyleSheet.Inline {

    import dsl._

    val Resizer = style("Resizer")(
      backgroundColor(black),
      opacity(0.2),
      zIndex(1),
      boxSizing.borderBox,
      backgroundClip.paddingBox,
      &.hover(
        transition := "all 2s ease"
      )
    )

    val ResizerVertical = style("Resizer.vertical")(
      width(11.px),
      marginTop(0.px),
      marginBottom(0.px),
      marginLeft(-5.px),
      marginRight(-5.px),
      borderLeft(5.px, solid, c"rgba(0,0,0,0)"),
      borderRight(5.px, solid, transparent),
      cursor.colResize,
      &.hover(
        borderLeft(5.px, solid, c"rgba(0, 0, 0, 0.5)"),
        borderRight(5.px, solid, c"rgba(0, 0, 0, 0.5)")
      )
    )

    val ResizerHorizontal = style("Resizer.horizontal")(
      height(11.px),
      marginTop(-5.px),
      marginBottom(-5.px),
      marginLeft(0.px),
      marginRight(0.px),
      borderTop(5.px, solid, c"rgba(0,0,0,0)"),
      borderBottom(5.px, solid, transparent),
      cursor.rowResize,
      &.hover(
        borderTop(5.px, solid, c"rgba(0, 0, 0, 0.5)"),
        borderBottom(5.px, solid, c"rgba(0, 0, 0, 0.5)")
      )
    )

    val ResizerDisabled = style("Resizer.disabled")(
      cursor.notAllowed,
      &.hover(
        border.transparent
      )
    )

    val SplitPaneContent = style("splitPaneContent")(
      width(100.%%),
      height(100.%%),
      position.absolute,
      left(0.px),
      top(0.px)
    )
  }

  object DefaultStyle extends Style
}

case class ReactSplitPane(
    // Specify whether resizing is allowed
    allowResize: js.UndefOr[Boolean] = true,
    className: js.UndefOr[String] = js.undefined,
    primary: js.UndefOr[String] = js.undefined,
    minSize: js.UndefOr[Double] = js.undefined,
    maxSize: js.UndefOr[Double] = js.undefined,
    defaultSize: js.UndefOr[Double] = js.undefined,
    size: js.UndefOr[Double] = js.undefined,
    split: js.UndefOr[String] = js.undefined,
    onDragStarted: js.UndefOr[Callback] = js.undefined,
    onDragFinished: js.UndefOr[Callback] = js.undefined,
    onChange: js.UndefOr[Double => Callback] = js.undefined,
    onResizerClick: js.UndefOr[Callback] = js.undefined,
    onResizerDoubleClick: js.UndefOr[Callback] = js.undefined,
    style: js.UndefOr[js.Object] = js.undefined,
    resizerStyle: js.UndefOr[js.Object] = js.undefined,
    paneStyle: js.UndefOr[js.Object] = js.undefined,
    pane1Style: js.UndefOr[js.Object] = js.undefined,
    pane2Style: js.UndefOr[js.Object] = js.undefined,
    resizerClassName: js.UndefOr[String] = ReactSplitPane.DefaultStyle.Resizer.htmlClass,
    step: js.UndefOr[Double] = js.undefined
) {
  def apply(first: VdomElement, second: VdomElement): JsComponent.Unmounted[_, _] = {

    val props     = JSMacro[ReactSplitPane](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](ReactSplitPane.Component)

    component(props)(
      <.div(
        ^.cls := "splitPaneContent",
        first
      ),
      <.div(
        ^.cls := "splitPaneContent",
        second
      )
    )
  }
}
