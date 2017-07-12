package demo.components.semanticui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.semanticui._
import demo.components.CodeExample
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object SuiGridDemo {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  case class Backend($ : BackendScope[Unit, Unit]) {

    val columns: Seq[VdomElement] = (1 to 16) map { i =>
      SuiGridColumn(key = i.toString)(
        SuiImage(src = "http://semantic-ui.com/images/wireframe/image.png")()
      ): VdomElement
    }
    def render() =
      <.div(
        CodeExample(code, "SuiGrid")(
          SuiGrid()(columns: _*)
        )
      )
  }

  val component = ScalaComponent
    .builder[Unit]("SuiGridDemo")
    .renderBackend[Backend]
    .build

  // EXAMPLE:END

  def apply() = component()
}
