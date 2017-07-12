package demo.components.elementalui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.elementalui.{Glyph, Octicons, _}
import demo.components.CodeExample
import demo.components.CodeExample.Props
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object EuiGlyphsDemo {
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  case class Backend($ : BackendScope[_, _]) {
    val renderButtons =
      <.div(
        Button(`type` = ButtonType.PRIMARY)(Glyph(icon = Octicons.beaker)()),
        Button(`type` = ButtonType.DANGER)(Glyph(icon = Octicons.flame)()),
        Button(`type` = ButtonType.SUCCESS)(Glyph(icon = Octicons.squirrel)()),
        Button(`type` = ButtonType.WARNING)(Glyph(icon = Octicons.bug)())
      )

    val renderLinkButtons =
      <.div(
        Button(`type` = ButtonType.LINK)(Glyph(icon = Octicons.beaker)()),
        Button(`type` = ButtonType.LINK_CANCEL)(Glyph(icon = Octicons.flame)()),
        Button(`type` = ButtonType.LINK_DELETE)(Glyph(icon = Octicons.squirrel)()),
        Button(`type` = ButtonType.LINK_TEXT)(Glyph(icon = Octicons.bug)())
      )

    val renderGlyphGrid =
      Octicons.values.grouped(10).zipWithIndex.map {
        case (list, index) =>
          Row(key = s"row_$index")(list.map { icon =>
            Col(key = s"col_${icon.value}", sm = "1/10")(
              Card(className = "code-example--glyph__icon")(
                Glyph(key = icon.value, icon = icon)(),
                <.div(
                  ^.className := "code-example--glyph__icon-name",
                  icon.value
                )
              )
            )
          }.toVdomArray)
      }

    def renderGlyphColors(icon: Octicons) =
      GlyphType.values.map(
        glyphType =>
          <.div(^.key := s"${glyphType.value}-${icon.value}",
                ^.className := "code-example__example-element--inline",
                Glyph(icon = icon, `type` = glyphType)(),
                glyphType.value))

    def render: ScalaComponent.Unmounted[Props, Unit, CodeExample.Backend] =
      CodeExample(code, "EuiGlyphs")(
        <.div(
          <.h1("Glyphs"),
          <.h2("Basic Example"),
          Glyph(icon = Octicons.thumbsup)().vdomElement,
          <.h2("Icons"),
          renderGlyphGrid.toVdomArray,
          <.h2("Colors"),
          renderGlyphColors(Octicons.heart).toVdomArray,
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
