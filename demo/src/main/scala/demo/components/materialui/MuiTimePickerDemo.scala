package demo
package components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react.ScalaComponent
import japgolly.scalajs.react.vdom.html_<^._

import scala.scalajs.js

object MuiTimePickerDemo {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START
  val component = ScalaComponent
    .builder[Unit]("MuiTimePickerDemo")
    .render(P => {
      <.div(
        CodeExample(code, "MuiTimePicker")(
          MuiTimePicker(format = Ampm_24hr.ampm, hintText = js.defined("12 hr format"))(),
          MuiTimePicker(format = Ampm_24hr._24hr, hintText = js.defined("24 hr format"))()
        )
      )
    })
    .build

  // EXAMPLE:END

  def apply() = component()
}
