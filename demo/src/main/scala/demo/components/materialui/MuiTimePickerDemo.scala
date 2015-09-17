package demo
package components
package materialui

import chandu0101.scalajs.react.components.materialui.{MuiTimePicker, MuiTimePickerFormat}
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.prefix_<^._

object MuiTimePickerDemo {

  val code =
    """
      |  MuiTimePicker(format = MuiTimePickerFormat.AM_PM,
      |         hintText = "12 hr format"),
      |
      |  MuiTimePicker(format = MuiTimePickerFormat.TWENTY_FOUR_HOUR,
      |         hintText = "24 hr format")
      |
    """.stripMargin
  val component = ReactComponentB[Unit]("MuiTimePickerDemo")
    .render(P => {
    <.div(
      CodeExample(code, "MuiTimePicker")(
        MuiTimePicker(format = MuiTimePickerFormat.AM_PM, hintText = "12 hr format")(),
        MuiTimePicker(format = MuiTimePickerFormat.TWENTY_FOUR_HOUR, hintText = "24 hr format")()
      )
    )
  }).buildU

  def apply() = component()
}
