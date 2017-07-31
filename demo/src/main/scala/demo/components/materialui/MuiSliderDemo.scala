package demo
package components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui.MuiSlider
import japgolly.scalajs.react.{Callback, ReactComponentB, ReactMouseEvent}
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js

object MuiSliderDemo {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  val component = ReactComponentB[Unit]("MuiSliderDemo")
    .render(P => {

      val onChange: (ReactMouseEvent, Double) => Callback =
        (e, v) => Callback.info(s"chose value: $v")

      <.div(
        CodeExample(code, "MuiSlider")(
          MuiSlider(name = "slider1", onChange = onChange)(),
          MuiSlider(name = "slider2", onChange = onChange, defaultValue = 0.5)(),
          MuiSlider(name = "slider1", onChange = onChange, value = 0.3, disabled = true)()
        )
      )
    })
    .build

  // EXAMPLE:END

  def apply() = component()
}
