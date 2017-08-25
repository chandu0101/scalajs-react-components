package demo.components.reactsplitpane

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.reactsplitpane.ReactSplitPane
import demo.components.CodeExample
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object ReactSplitPaneSimpleNested {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  class Backend(t: BackendScope[_, _]) {

    def render() = {

      val vert = ReactSplitPane()(<.div("second"), <.div("third"))

      <.div(
        CodeExample(code, "Simple Nested")(
          <.div(
            ^.width := "95%",
            ^.height := "400px",
            ^.border := "1px solid",
            ^.margin := "auto",
            ^.position := "relative",
            ReactSplitPane(
              split = "horizontal"
            )(<.div("first"), vert)
          )
        )
      )
    }
  }

  val component = ScalaComponent.builder[Unit]("ReactSplitPaneDemo")
    .renderBackend[Backend]
    .build

  // EXAMPLE:END

  def apply() = component()
}
