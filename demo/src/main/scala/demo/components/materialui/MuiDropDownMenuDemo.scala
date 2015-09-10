package demo
package components
package materialui

import chandu0101.scalajs.react.components.materialui.{MuiDropdownMenu, MuiDropdownMenuItem}
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.prefix_<^._
import scala.scalajs.js

object MuiDropDownMenuDemo {

  val code =
    """
      | val menuItems = js.Array(
      |      MuiDropdownMenu.Item(payload = "1",text = "Never"),
      |      MuiDropdownMenu.Item(payload = "2",text = "Every Night"),
      |      MuiDropdownMenu.Item(payload = "3",text = "Weeknights"),
      |      MuiDropdownMenu.Item(payload = "4",text = "Weekends"),
      |      MuiDropdownMenu.Item(payload = "5",text = "Weekly")
      |    )
      |
      | MuiDropdownMenu(menuItems = menuItems)
      |
    """.stripMargin

  val component = ReactComponentB[Unit]("MuiDropDownMenuDemo")
    .render(P => {
    val menuItems = js.Array(
      MuiDropdownMenuItem(payload = "1",text = "Never"),
      MuiDropdownMenuItem(payload = "2",text = "Every Night"),
      MuiDropdownMenuItem(payload = "3",text = "Weeknights"),
      MuiDropdownMenuItem(payload = "4",text = "Weekends"),
      MuiDropdownMenuItem(payload = "5",text = "Weekly")
    )
    <.div(
      CodeExample(code, "MuiDropDownMenu")(
        MuiDropdownMenu(menuItems = menuItems)()
      )
    )
  }).buildU

  def apply() = component()
}
