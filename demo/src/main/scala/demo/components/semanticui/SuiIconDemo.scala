package demo.components.semanticui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.ReactMouseEventB
import chandu0101.scalajs.react.components.semanticui.{
  SemanticSIZES,
  SuiButton,
  SuiIcon,
  SuiIconGroup
}
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
            SuiIcon(name = "home", size = SemanticSIZES.MINI)(),
            SuiIcon(name = "home", size = SemanticSIZES.TINY)(),
            SuiIcon(name = "home", size = SemanticSIZES.SMALL)(),
            <.br(),
            SuiIcon(name = "home")(),
            <.br(),
            SuiIcon(name = "home", size = SemanticSIZES.LARGE)(),
            SuiIcon(name = "home", size = SemanticSIZES.BIG)(),
            SuiIcon(name = "home", size = SemanticSIZES.HUGE)()
          ),
          <.br(),
          <.br(),
          <.div(
            SuiIconGroup(size = SemanticSIZES.HUGE)(
              SuiIcon(size = SemanticSIZES.BIG, name = "thin circle")(),
              SuiIcon(name = "user")()
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
