package demo.components.elementalui

import chandu0101.scalajs.react.components.elementalui._
import demo.components.materialui.svgicons.ActionGrade
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import scalacss.Defaults._
import scalacss.ScalaCssReact._
import scalacss.mutable.StyleSheet.Inline
import chandu0101.scalajs.react.components.elementalui.Glyph
import chandu0101.scalajs.react.components.elementalui.Octicons
import org.scalajs.dom
import org.scalajs.dom.html

object EuiGlyphsDemo {
  val renderButtons = {
    <.div(
      Button(`type` = ButtonType.PRIMARY)(Glyph(icon = Octicons.beaker)()),
      Button(`type` = ButtonType.DANGER)(Glyph(icon = Octicons.flame)()),
      Button(`type` = ButtonType.SUCCESS)(Glyph(icon = Octicons.squirrel)()),
      Button(`type` = ButtonType.WARNING)(Glyph(icon = Octicons.bug)()))
  }
  val renderLinkButtons = {
    <.div(
      Button(`type` = ButtonType.LINK)(Glyph(icon = Octicons.beaker)()),
      Button(`type` = ButtonType.LINK_CANCEL)(Glyph(icon = Octicons.flame)()),
      Button(`type` = ButtonType.LINK_DELETE)(Glyph(icon = Octicons.squirrel)()),
      Button(`type` = ButtonType.LINK_TEXT)(Glyph(icon = Octicons.bug)()))
  }
  val component = ReactComponentB[Unit]("EuiGlyphsDemo")
    .render(P ⇒ {
      def renderGlyphGrid = {
        Octicons.values.grouped(10).zipWithIndex.map {
          case (list, index) ⇒
            Row(key = s"row_${index}")(list.map { icon ⇒
              Col(key = s"col_${icon.value}", sm = "1/10")(Card(className = "code-example--glyph__icon")(
                Glyph(key = icon.value, icon = icon)(),
                <.div(^.className := "code-example--glyph__icon-name")(icon.value)))
            })
        }
      }
      def renderGlyphColors(icon: Octicons) = {
        GlyphType.values.map(glyphType ⇒
          <.div(^.key := s"${glyphType.value}-${icon.value}", ^.className := "code-example__example-element--inline", Glyph(icon = icon, `type` = glyphType)(), glyphType.value))
      }

      <.div(
        <.h1("Glyphs"),
        <.h2("Basic Example"),
        Glyph(icon = Octicons.thumbsup)(),
        <.h2("Icons"),
        renderGlyphGrid,
        <.h2("Colors"),
        renderGlyphColors(Octicons.heart),
        <.h2("Buttons"),
        renderButtons,
        <.h2("Link Buttons"),
        renderLinkButtons)
    }).buildU
  def apply() = component()
}
