package demo.components.elementalui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.elementalui.{EuiGlyph, Octicons, _}
import demo.components.CodeExample
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.TagOf
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom.html.Div

object EuiGlyphsDemo {
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  case class Backend($ : BackendScope[Unit, Unit]) {
    val renderButtons: TagOf[Div] =
      <.div(
        EuiButton(`type` = ButtonType.primary)(EuiGlyph(icon = Octicons.beaker)()),
        EuiButton(`type` = ButtonType.danger)(EuiGlyph(icon = Octicons.flame)()),
        EuiButton(`type` = ButtonType.success)(EuiGlyph(icon = Octicons.squirrel)()),
        EuiButton(`type` = ButtonType.warning)(EuiGlyph(icon = Octicons.bug)())
      )

    val renderLinkButtons: TagOf[Div] =
      <.div(
        EuiButton(`type` = ButtonType.link)(EuiGlyph(icon = Octicons.beaker)()),
        EuiButton(`type` = ButtonType.link_cancel)(EuiGlyph(icon = Octicons.flame)()),
        EuiButton(`type` = ButtonType.link_delete)(EuiGlyph(icon = Octicons.squirrel)()),
        EuiButton(`type` = ButtonType.link_text)(EuiGlyph(icon = Octicons.bug)())
      )

    val renderGlyphGrid: VdomNode =
      Octicons.values
        .grouped(10)
        .zipWithIndex
        .map {
          case (list, index) =>
            EuiRow(key = s"row_$index") {
              list.map { icon =>
                EuiCol(key = s"col_${icon.value}", sm = "1/10")(
                  EuiCard(className = "code-example--glyph__icon")(
                    EuiGlyph(key = icon.value, icon = icon)(),
                    <.div(
                      ^.className := "code-example--glyph__icon-name",
                      icon.value
                    )
                  )
                )
              }.toVdomArray
            }
        }
        .toVdomArray

    def renderGlyphColors(icon: Octicons): VdomNode =
      GlyphType.values
        .map(
          glyphType =>
            <.div(
              ^.key := s"${glyphType.value}-${icon.value}",
              ^.className := "code-example__example-element--inline",
              EuiGlyph(icon = icon, `type` = glyphType)(),
              glyphType.value
          ))
        .toVdomArray

    def render =
      CodeExample(code, "EuiGlyphs")(
        <.div(
          <.h1("Glyphs"),
          <.h2("Basic Example"),
          EuiGlyph(icon = Octicons.thumbsup)(),
          <.h2("Icons"),
          renderGlyphGrid,
          <.h2("Colors"),
          renderGlyphColors(Octicons.heart),
          <.h2("Buttons"),
          renderButtons,
          <.h2("Link Buttons"),
          renderLinkButtons
        )
      )
  }

  val component = ScalaComponent
    .builder[Unit]("EuiGlyphsDemo")
    .renderBackend[Backend]
    .build

  // EXAMPLE:END

  def apply() = component()
}
