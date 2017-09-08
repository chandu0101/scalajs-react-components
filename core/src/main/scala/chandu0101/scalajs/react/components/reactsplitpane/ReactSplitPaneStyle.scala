package chandu0101.scalajs.react.components.reactsplitpane

import scalacss.DevDefaults._
import scalacss.internal.mutable.StyleSheet

class ReactSplitPaneStyle extends StyleSheet.Inline {

  import dsl._

  val Resizer = style("Resizer") (

    backgroundColor(black),
    opacity(0.2),
    zIndex(1),
    boxSizing.borderBox,
    backgroundClip.paddingBox,

    &.hover(
      transition := "all 2s ease"
    )

  )

  val ResizerVertical = style("Resizer.vertical") (
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

  val ResizerHorizontal = style("Resizer.horizontal") (
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

  val ResizerDisabled = style("Resizer.disabled") (
    cursor.notAllowed,

    &.hover(
      border.transparent
    )
  )

  val SplitPaneContent = style("splitPaneContent") (
    width(100.%%),
    height(100.%%),
    position.absolute,
    left(0.px),
    top(0.px)
  )
}