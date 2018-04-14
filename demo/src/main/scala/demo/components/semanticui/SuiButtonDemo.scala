package demo.components.semanticui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.semanticui.SuiButton
import demo.components.CodeExample
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object SuiButtonDemo {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  case class Backend($ : BackendScope[Unit, Unit]) {

    val handleOnClick = (e: ReactMouseEventFromInput) => Callback.info("You clicked me!")

    def render() =
      <.div(
        CodeExample(code, "SuiButton")(
          SuiButton(onClick = handleOnClick)("Click Here"),
          SuiButton(primary = true)("Primary"),
          SuiButton(secondary = true)("Secondary")
        )
      )
  }

  val component = ScalaComponent
    .builder[Unit]("SuiButtonDemo")
    .renderBackend[Backend]
    .build

  // EXAMPLE:END

  def apply() = component()
}
