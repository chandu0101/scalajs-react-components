package demo
package components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react.ScalaComponent
import japgolly.scalajs.react.vdom.html_<^._

object MuiToolbarDemo {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  val component = ScalaComponent
    .builder[Unit]("MuiToolbarDemo")
    .render(P => {
      <.div(
        CodeExample(code, "MuiToolbar")(
          MuiToolbar()(
            MuiToolbarGroup(key = "1")(
              MuiRaisedButton(label = "Tool Left", secondary = true)()
            ),
            MuiToolbarGroup(key = "2")(
              MuiToolbarTitle(text = "options")(),
              MuiToolbarSeparator()(),
              MuiRaisedButton(label = "Create Broadcast", primary = true)()
            )
          )
        )
      )
    })
    .build

  // EXAMPLE:END

  def apply() = component()
}
