package demo.components.semanticui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.semanticui.{
  SemanticCOUNTRY,
  SuiFlag,
  SuiHeader,
  SuiSegment
}
import demo.components.CodeExample
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object SuiHeaderDemo {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  case class Backend($ : BackendScope[Unit, Unit]) {

    def render() =
      <.div(
        CodeExample(code, "SuiHeader")(
          SuiHeader(as = "h1")("First Header"),
          SuiHeader(as = "h2")("Second Header"),
          SuiHeader(as = "h3")("Third Header"),
          SuiHeader(as = "h4")("Fourth Header"),
          SuiHeader(as = "h5")("Fifth Header"),
          SuiHeader(as = "h6")("Sixth Header")
        )
      )
  }

  val component = ScalaComponent
    .builder[Unit]("SuiHeaderDemo")
    .renderBackend[Backend]
    .build

  // EXAMPLE:END

  def apply() = component()
}
