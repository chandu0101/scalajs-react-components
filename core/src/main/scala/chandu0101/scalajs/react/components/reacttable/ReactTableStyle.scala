package chandu0101.scalajs.react.components.reacttable

import scalacss.ProdDefaults._
import scalacss.ScalaCssReact._

class ReactTableStyle extends StyleSheet.Inline {

  import dsl._

  val reactTableContainer = style(display.flex, flexDirection.column)

  val table = style(
    display.flex,
    flexDirection.column,
    width(100.%%),
    boxShadow := "0 1px 3px 0 rgba(0, 0, 0, 0.12), 0 1px 2px 0 rgba(0, 0, 0, 0.24)",
    media.maxWidth(740 px)(boxShadow := "none"))

  val tableRow = style(
    display.flex,
    flexDirection.row,
    verticalAlign.middle,
    padding :=! "0.8rem",
    &.hover(backgroundColor :=! "rgba(244, 244, 244, 0.77)"),
    media.maxWidth(740 px)(boxShadow := "0 1px 3px grey", margin(5 px))
  )

  val tableRowSelected = style(
    backgroundColor.lightgreen,
    tableRow
  )

  val tableHeader = style(
    fontWeight.bold,
    borderBottom :=! "1px solid #e0e0e0",
    tableRow
  )

  val settingsBar = style(
    display.flex,
    margin :=! "15px 0",
    justifyContent.spaceBetween
  )

  val selectColumn = style(
    width(2.rem)
  )

  val sortIcon = styleF.bool(
    ascending =>
      styleS(
        &.after(fontSize(9 px), marginLeft(5 px),
          if (ascending) {
            content := "'\\25B2'"
          } else {
            content := "'\\25BC'"
          }
        )
      )
  )
}
