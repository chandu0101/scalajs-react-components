package demo
package components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react.{ReactNode, ReactComponentB}
import japgolly.scalajs.react.vdom.prefix_<^._

object MuiTextFieldDemo {
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  val component = ReactComponentB[Unit]("MuiTextFieldDemo")
    .render(P => {
      <.div(
        CodeExample(code, "MuiTextField")(
          <.div(^.display.flex, ^.flexDirection.column,
            MuiTextField(
              hintText       = "Hint Text",
              onEnterKeyDown = DummyEvents.f1("onEnterKeyDown"),
              onBlur         = DummyEvents.f1("onBlur"),
              onChange       = DummyEvents.f1("onChange"),
              onFocus        = DummyEvents.f1("onFocus"),
              onKeyDown      = DummyEvents.f1("onKeyDown"))(),
            MuiTextField(hintText = "Hint Text", floatingLabelText = "Floating Label Text")(),
            MuiTextField(hintText = "Multi Line Text", multiLine = true)(),
            MuiTextField(hintText = "Multi Line Text", multiLine = true, floatingLabelText = "Multi Line Floating Label Text")(),
            MuiTextField(hintText = "Disabled Hint text", disabled = true)()
          )
        )
      )
    }).buildU
  // EXAMPLE:END

  def apply() = component()
}
