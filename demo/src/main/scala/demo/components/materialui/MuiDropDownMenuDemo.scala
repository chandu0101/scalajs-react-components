package demo
package components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js

object MuiDropDownMenuDemo {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  val component = ReactComponentB[Unit]("MuiDropDownMenuDemo")
    .render(P => {
      val menuItems = js.Array(
        MuiDropDownMenuItem(payload = "1", text = "Never"),
        MuiDropDownMenuItem(payload = "2", text = "Every Night"),
        MuiDropDownMenuItem(payload = "3", text = "Weeknights"),
        MuiDropDownMenuItem(payload = "4", text = "Weekends"),
        MuiDropDownMenuItem(payload = "5", text = "Weekly")
      )
      <.div(
        CodeExample(code, "MuiDropDownMenu")(
          MuiDropDownMenu(menuItems = menuItems,
            onChange = DummyEvents.f3("onChange"))()
        )
      )
    }).buildU

  // EXAMPLE:END

  def apply() = component()
}
