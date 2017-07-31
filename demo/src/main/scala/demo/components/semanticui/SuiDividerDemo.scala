package demo.components.semanticui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.semanticui.{SuiContainer, SuiDivider}
import demo.components.CodeExample
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

object SuiDividerDemo {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  case class Backend($ : BackendScope[Unit, Unit]) {

    def render() =
      <.div(
        CodeExample(code, "SuiDivider")(
          <.b("A standard divider"),
          SuiDivider()(),
          <.br(),
          <.b("Horizontal Divider"),
          SuiDivider(horizontal = true)("OR")
        )
      )
  }

  val component = ReactComponentB[Unit]("SuiDividerDemo")
    .renderBackend[Backend]
    .build

  // EXAMPLE:END

  def apply() = component()
}
