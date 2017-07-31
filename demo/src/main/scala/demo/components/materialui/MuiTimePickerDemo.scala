package demo
package components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.prefix_<^._

object MuiTimePickerDemo {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START
  val component = ReactComponentB[Unit]("MuiTimePickerDemo")
    .render(P => {
      <.div(
        CodeExample(code, "MuiTimePicker")(
          MuiTimePicker(format = Ampm_24hr.ampm, hintText = "12 hr format")(),
          MuiTimePicker(format = Ampm_24hr._24hr, hintText = "24 hr format")()
        )
      )
    })
    .build

  // EXAMPLE:END

  def apply() = component()
}
