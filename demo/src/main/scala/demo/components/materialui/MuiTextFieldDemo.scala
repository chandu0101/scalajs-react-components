package demo
package components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react.ScalaComponent
import japgolly.scalajs.react.vdom.html_<^._

object MuiTextFieldDemo {
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  val component = ScalaComponent
    .builder[Unit]("MuiTextFieldDemo")
    .render(P => {
      <.div(
        CodeExample(code, "MuiTextField")(
          <.div(
            ^.display.flex,
            ^.flexDirection.column,
            MuiTextField(hintText = "Hint Text",
                         onBlur = CallbackDebug.f1("onBlur"),
                         onChange = CallbackDebug.f2("onChange"),
                         onFocus = CallbackDebug.f1("onFocus"))(),
            MuiTextField(hintText = "Hint Text", floatingLabelText = "Floating Label Text")(),
            MuiTextField(hintText = "Multi Line Text", multiLine = true)(),
            MuiTextField(hintText = "Multi Line Text",
                         multiLine = true,
                         floatingLabelText = "Multi Line Floating Label Text")(),
            MuiTextField(hintText = "Disabled Hint text", disabled = true)()
          )
        )
      )
    })
    .build
  // EXAMPLE:END

  def apply() = component()
}
