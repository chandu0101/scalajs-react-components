package demo
package components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.prefix_<^._

object MuiDatePickerDemo {
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  val component = ReactComponentB[Unit]("MuiDatePickerDemo")
    .render(P => {
      <.div(
        CodeExample(code, "MuiDatePicker")(
          MuiDatePicker(
            hintText = "Portrait Dialog",
            onChange = CallbackDebug.f2("onChange"),
            onDismiss = CallbackDebug.f0("onDismiss"),
            onFocus = CallbackDebug.f1("onFocus"),
            onShow = CallbackDebug.f0("onShow"),
            onTouchTap = CallbackDebug.f1("onTouchTap")
          )(),
          MuiDatePicker(
            hintText = "Landscape Dialog",
            mode = PortraitLandscape.landscape
          )()
        )
      )
    })
    .build

  // EXAMPLE:END

  def apply() = component()
}
