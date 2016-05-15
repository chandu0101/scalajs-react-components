package demo
package components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js

object MuiDropDownMenuDemo {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  val items = Seq(
    ("1", "Never"),
    ("2", "Every Night"),
    ("3", "Weeknights"),
    ("4", "Weekends"),
    ("5", "Weekly")
  )

  case class Backend($: BackendScope[Unit, js.Any]){
    val choose: (ReactEventI, Int, js.Any) => Callback =
      (e, idx, value) => $.setState(value) >> Callback.info(s"idx: $idx, value: $value")

    def render(chosen: js.Any) =
      <.div(
        CodeExample(code, "MuiDropDownMenu")(
          MuiDropDownMenu(
            onChange = choose, value = chosen)(
            items map {
              case (value, text) => MuiMenuItem(value = value, primaryText = text)()
            } :_*
          )
        )
      )
  }
  val component = ReactComponentB[Unit]("MuiDropDownMenuDemo")
    .initialState[js.Any](items.head._1)
    .renderBackend[Backend]
    .build

  // EXAMPLE:END

  def apply() = component()
}
