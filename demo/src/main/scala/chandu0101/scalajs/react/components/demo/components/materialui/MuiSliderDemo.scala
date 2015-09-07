package chandu0101.scalajs.react.components.demo.components.materialui

import chandu0101.scalajs.react.components.demo.components.CodeExample
import chandu0101.scalajs.react.components.materialui.{MuiSlider, MuiAppBar}
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.prefix_<^._

object MuiSliderDemo {

  val code =
    """
      |  MuiSlider(name = "slider1"),
      |  MuiSlider(name = "slider2",defaultValue = 0.5 ),
      |  MuiSlider(name = "slider1",value = 0.3, disabled = true)
      |
    """.stripMargin
  val component = ReactComponentB[Unit]("MuiSliderDemo")
    .render(P => {
    <.div(
      CodeExample(code, "MuiSlider")(
        MuiSlider(name = "slider1")(),
        MuiSlider(name = "slider2",defaultValue = 0.5 )(),
        MuiSlider(name = "slider1",value = 0.3, disabled = true)()
      )
    )
  }).buildU


  def apply() = component()
}
