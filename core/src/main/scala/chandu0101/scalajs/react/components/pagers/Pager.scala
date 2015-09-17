package chandu0101.scalajs.react.components
package pagers

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import scalacss.Defaults._
import scalacss.ScalaCssReact._

object Pager {

  class Style extends StyleSheet.Inline {

    import dsl._

    val pager = style(margin :=! "15px 0",
      unsafeChild("a")(
        display.inlineBlock,
        padding :=! "5px 14px",
        backgroundColor :=! "#EF5350",
        border :=! "1px solid transparent",
        borderRadius :=! "2px",
        cursor.pointer,
        color :=! "#ffffff",
        fontWeight.bold,
        boxShadow := "0 1px 3px 0 rgba(0, 0, 0, 0.12), 0 1px 2px 0 rgba(0, 0, 0, 0.24)",
        &.hover(
          textDecoration := "none",
          backgroundColor :=! "#ff1034"
        ),
        &.focus(
          textDecoration := "none",
          backgroundColor :=! "#ff1034"
        )
      )
    )
  }

  object DefaultStyle extends Style

  val component = ReactComponentB[Props]("Pager")
    .render((P) => {
    <.div(P.style.pager)(
      P.offset > 0 ?= <.a(^.onClick --> P.previousClick(), ^.float := "left")("← Previous"),
      P.offset + P.itemsPerPage < P.totalItems ?= <.a(^.onClick --> P.nextClick(), ^.float := "right")("Next →")
    )
  }).build

  case class Props(itemsPerPage: Int, totalItems: Int, offset: Int, nextClick: () => Unit, previousClick: () => Unit, style: Style)

  def apply(itemsPerPage: Int, totalItems: Int, offset: Int, nextClick: () => Unit, previousClick: () => Unit, style: Style = DefaultStyle) = {
    component(Props(itemsPerPage, totalItems, offset, nextClick, previousClick, style))
  }

}
