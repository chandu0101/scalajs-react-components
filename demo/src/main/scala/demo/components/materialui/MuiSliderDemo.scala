package demo
package components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui.MuiSlider
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.prefix_<^._

object MuiSliderDemo {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START
  val component = ReactComponentB[Unit]("MuiSliderDemo")
    .render(P => {
      <.div(
        CodeExample(code, "MuiSlider")(
          MuiSlider(name = "slider1")(),
          MuiSlider(name = "slider2", defaultValue = 0.5)(),
          MuiSlider(name = "slider1", value = 0.3, disabled = true)()
        )
      )
    }).buildU

  // EXAMPLE:END

  def apply() = component()
}
