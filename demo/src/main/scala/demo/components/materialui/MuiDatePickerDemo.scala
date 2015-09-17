package demo
package components
package materialui

import chandu0101.scalajs.react.components.fascades.LatLng
import chandu0101.scalajs.react.components.materialui.{MuiDatePicker, MuiDatePickerMode}
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.prefix_<^._

object MuiDatePickerDemo {

  val code =
    """
      | MuiDatePicker(hintText = "Protrait Dialog"),
      | MuiDatePicker(hintText = "Landscape Dialog",mode = MuiDatePickerMode.LANDSCAPE)
      |
    """.stripMargin
  val component = ReactComponentB[Unit]("MuiDatePickerDemo")
    .render(P => {
    <.div(
      CodeExample(code,"MuiDatePicker")(
       MuiDatePicker(hintText = "Protrait Dialog")(),
       MuiDatePicker(hintText = "Landscape Dialog",mode = MuiDatePickerMode.LANDSCAPE)()
      )
    )
  }).buildU

  lazy val latlng = LatLng(16.3008,80.4428)

  def apply() = component()
}
