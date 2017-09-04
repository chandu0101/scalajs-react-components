package demo
package components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react.ScalaComponent
import japgolly.scalajs.react.vdom.html_<^._

import scala.scalajs.js

object MuiTextFieldDemo {
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START
  //TODO for some reason the vdomNodeFromString implicit is not working

  val component = ScalaComponent
    .builder[Unit]("MuiTextFieldDemo")
    .render(P => {
      <.div(
        CodeExample(code, "MuiTextField")(
          <.div(
            ^.display.flex,
            ^.flexDirection.column,
            MuiTextField(
              hintText = js.defined("Hint Text"),
              onBlur = CallbackDebug.f1("onBlur"),
              onChange = CallbackDebug.f2("onChange"),
              onFocus = CallbackDebug.f1("onFocus")
            )(),
            MuiTextField(hintText = js.defined("Hint Text"),
                         floatingLabelText = js.defined("Floating Label Text"))(),
            MuiTextField(hintText = js.defined("Multi Line Text"), multiLine = true)(),
            MuiTextField(hintText = js.defined("Multi Line Text"),
                         multiLine = true,
                         floatingLabelText = js.defined("Multi Line Floating Label Text"))(),
            MuiTextField(hintText = js.defined("Disabled Hint text"), disabled = true)()
          )
        )
      )
    })
    .build
  // EXAMPLE:END

  def apply() = component()
}
