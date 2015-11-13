package demo
package components
package materialui

import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.prefix_<^._
import scala.scalajs.js

object MuiDropDownMenuDemo {

  val code =
    """
      | val menuItems = js.Array(
      |      MuiDropDownMenu.Item(payload = "1",text = "Never"),
      |      MuiDropDownMenu.Item(payload = "2",text = "Every Night"),
      |      MuiDropDownMenu.Item(payload = "3",text = "Weeknights"),
      |      MuiDropDownMenu.Item(payload = "4",text = "Weekends"),
      |      MuiDropDownMenu.Item(payload = "5",text = "Weekly")
      |    )
      |
      | MuiDropDownMenu(menuItems = menuItems)
      |
    """.stripMargin

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
          MuiDropDownMenu(menuItems = menuItems)()
        )
      )
    }).buildU

  def apply() = component()
}
