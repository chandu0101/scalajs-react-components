package demo
package components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui.{MuiDatePicker, MuiDatePickerMode}
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.prefix_<^._

object MuiDatePickerDemo {
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  val component = ReactComponentB[Unit]("MuiDatePickerDemo")
    .render(P => {
      <.div(
        CodeExample(code, "MuiDatePicker")(
          MuiDatePicker(hintText = "Protrait Dialog",
            onChange   = DemoEvents.f2_("onChange"),
            onDismiss  = DemoEvents.f0("onDismiss"),
            onFocus    = DemoEvents.f1("onFocus"),
            onShow     = DemoEvents.f0("onShow"),
            onTouchTap = DemoEvents.f1("onTouchTap"))(),
          MuiDatePicker(hintText = "Landscape Dialog", mode = MuiDatePickerMode.LANDSCAPE)()
        )
      )
    }).buildU

  // EXAMPLE:END

  def apply() = component()
}
