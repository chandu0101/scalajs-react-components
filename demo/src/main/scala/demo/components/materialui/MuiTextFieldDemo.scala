package demo
package components
package materialui

import chandu0101.scalajs.react.components.materialui.MuiTextField
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.prefix_<^._

object MuiTextFieldDemo {

  val code =
    """
      |MuiTextField(hintText = "Hint Text"),
      |MuiTextField(hintText = "Hint Text",floatingLabelText = "Floating Label Text"),
      |MuiTextField(hintText = "Multi line Text", multiLine = true),
      |MuiTextField(hintText = "Multi line Text", multiLine = true,floatingLabelText = "Multi Line Floating Label Text"),
      |MuiTextField(hintText = "Disabled Hint text",disabled = true)
      |
    """.stripMargin

  val component = ReactComponentB[Unit]("MuiTextFieldDemo")
    .render(P => {
    <.div(
      CodeExample(code, "MuiTextField")(
       <.div(^.display.flex,^.flexDirection.column,
        MuiTextField(hintText = "Hint Text")(),
        MuiTextField(hintText = "Hint Text",floatingLabelText = "Floating Label Text")(),
        MuiTextField(hintText = "Multi line Text", multiLine = true)(),
        MuiTextField(hintText = "Multi line Text", multiLine = true,floatingLabelText = "Multi Line Floating Label Text")(),
        MuiTextField(hintText = "Disabled Hint text",disabled = true)()
      )
      )
    )
  }).buildU

  def apply() = component()
}
