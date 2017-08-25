package demo.components.reactsplitpane

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.reactsplitpane.ReactSplitPane
import demo.components.CodeExample
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object ReactSplitPaneSimpleVertical {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  class Backend(t: BackendScope[_, _]) {

    def render() = {

      <.div(
        CodeExample(code, "Simple Vertical Split")(
          <.div(
            ^.width := "95%",
            ^.height := "200px",
            ^.border := "1px solid",
            ^.margin := "auto",
            ^.position := "relative",
            ReactSplitPane()(<.div("first"), <.div("second"))
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
