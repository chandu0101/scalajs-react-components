package demo.components.materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import demo.components.CodeExample
import japgolly.scalajs.react._

import scala.scalajs.js

object MuiSelectFieldDemo {
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  case class State(selected: js.UndefOr[Int])

  case class Backend($: BackendScope[Unit, State]) {

    val onChange: (ReactEvent, Int, js.Any) => Callback =
      (e, idx, chosen) => {
        val payload = chosen.asInstanceOf[js.Dynamic].payload
        $.modState(_.copy(selected = idx)) >>
          DemoEvents.f3("onChange")(e, idx, chosen)
      }

    val menuItems = js.Array(
      MuiSelectItem("1", "Never"),
      MuiSelectItem("2", "Every Night"),
      MuiSelectItem("3", "Weeknights"),
      MuiSelectItem("4", "Weekends"),
      MuiSelectItem("5", "Weekly")
    )

    def render(S: State) =
      CodeExample(code, "MuiSelectField")(
        MuiSelectField(
          menuItems = menuItems,
          onChange = onChange,
          selectedIndex = S.selected,
          onBlur         = DemoEvents.f1("onBlur"),
          onFocus        = DemoEvents.f1("onFocus"),
          onEnterKeyDown = DemoEvents.f1("onEnterKeyDown"),
          onKeyDown      = DemoEvents.f1("onKeyDown")
        )()
      )
  }

  val component =
    ReactComponentB[Unit]("MuiSelectFieldDemo")
      .initialState(State(js.undefined))
      .renderBackend[Backend]
      .buildU

  // EXAMPLE:END

  def apply() = component()
}
