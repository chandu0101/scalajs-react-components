package demo.components.semanticui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.semanticui._
import demo.components.CodeExample
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object SuiIconDemo {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  case class Backend($ : BackendScope[Unit, Unit]) {

    def render() =
      <.div(
        CodeExample(code, "SuiIcon")(
          <.div(
            SuiIcon(name = SuiIconType("home"), size = SuiSize.mini)(),
            SuiIcon(name = SuiIconType("home"), size = SuiSize.tiny)(),
            SuiIcon(name = SuiIconType("home"), size = SuiSize.small)(),
            <.br(),
            SuiIcon(name = SuiIconType("home"))(),
            <.br(),
            SuiIcon(name = SuiIconType("home"), size = SuiSize.large)(),
            SuiIcon(name = SuiIconType("home"), size = SuiSize.big)(),
            SuiIcon(name = SuiIconType("home"), size = SuiSize.huge)()
          ),
          <.br(),
          <.br(),
          <.div(
            SuiIconGroup(size = SuiSize.huge)(
              SuiIcon(size = SuiSize.big, name = SuiIconType("thin circle"))(),
              SuiIcon(name = SuiIconType("user"))()
            )
          )
        )
      )
  }

  val component = ScalaComponent
    .builder[Unit]("SuiIconDemo")
    .renderBackend[Backend]
    .build

  // EXAMPLE:END

  def apply() = component()
}
