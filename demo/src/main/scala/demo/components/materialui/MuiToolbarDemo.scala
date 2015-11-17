package demo
package components
package materialui

import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.prefix_<^._

object MuiToolbarDemo {

  val code =
    """
      | MuiToolbar()(
      |         MuiToolbarGroup(key = "1",float = "left")(
      |           MuiRaisedButton(label = "Tool Left",secondary = true)()
      |         ),
      |          MuiToolbarGroup(key = "2",float = "right")(
      |            MuiToolbarTitle(text = "options"),
      |            MuiToolbarSeparator(),
      |            MuiRaisedButton(label = "Create Broadcast",primary = true)()
      |         )
      |        )
      |      )
      |
    """.stripMargin

  val component = ReactComponentB[Unit]("MuiToolbarDemo")
    .render(P => {
      <.div(
        CodeExample(code, "MuiToolbar")(
          MuiToolbar()(
            MuiToolbarGroup(key = "1", float = "left")(
              MuiRaisedButton(label = "Tool Left", secondary = true)()
            ),
            MuiToolbarGroup(key = "2", float = "right")(
              MuiToolbarTitle(text = "options")(),
              MuiToolbarSeparator()(),
              MuiRaisedButton(label = "Create Broadcast", primary = true)()
            )
          )
        )
      )
    }).buildU

  def apply() = component()
}
