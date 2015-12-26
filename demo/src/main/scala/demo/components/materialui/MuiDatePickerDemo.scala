package demo
package components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react.{ReactNode, ReactComponentB}
import japgolly.scalajs.react.vdom.prefix_<^._

object MuiDatePickerDemo {
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  val component = ReactComponentB[Unit]("MuiDatePickerDemo")
    .render(P => {
      <.div(
        CodeExample(code, "MuiDatePicker")(
          MuiDatePicker(hintText = "Portrait Dialog",
            onChange   = DummyEvents.f2_("onChange"),
            onDismiss  = DummyEvents.f0("onDismiss"),
            onFocus    = DummyEvents.f1("onFocus"),
            onShow     = DummyEvents.f0("onShow"),
            onTouchTap = DummyEvents.f1("onTouchTap"))(),
          MuiDatePicker(
            hintText = "Landscape Dialog",
            mode = PortraitLandscape.landscape
          )()
        )
      )
    }).buildU

  // EXAMPLE:END

  def apply() = component()
}
