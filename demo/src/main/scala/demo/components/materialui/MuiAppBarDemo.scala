package demo
package components
package materialui

import chandu0101.scalajs.react.components.materialui.MuiAppBar
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.prefix_<^._

object MuiAppBarDemo {

  val code =
    """
      | MuiAppBar(title = "Title")()
      |
    """.stripMargin
  val component = ReactComponentB[Unit]("MuiAppBarDemo")
    .render(P => {
    <.div(
      CodeExample(code, "MuiAppBar")(
        MuiAppBar(title = "Title")()
      )
    )
  }).buildU

  def apply() = component()
}
