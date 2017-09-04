package demo.components.reactsplitpane

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object ReactSplitPaneInfo {

  val component = ScalaComponent.builder[Unit]("ReactSplitPaneInfo")
    .render( P => {
      <.div(^.cls := "full-width-section")(
        <.h3("React Split Pane :"),
        <.p("Wrapper for the react-split-pane component (0.1.66)"),
        <.a(
          ^.href := "https://github.com/tomkp/react-split-pane",
          "react-split-pane on GitHub"
        )
      )
    })
    .build

  def apply() = component()
}
