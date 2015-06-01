package chandu0101.scalajs.react.components.demo.pages.components.materialui

import chandu0101.scalajs.react.components.demo.pages.util.CodeExample
import chandu0101.scalajs.react.components.materialui.{MuiDropdownMenu, MuiMenu}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._


/**
 * Created by chandrasekharkode .
 */
object MuiDropdownMenuDemo {

  val code =
    """
      |val menuItems = List(
      |   MuiMenu.Item(text = "Never", index = 0),
      |   MuiMenu.Item(text = "Every Night", index = 1),
      |   MuiMenu.Item(text = "Weeknights", index = 2),
      |   MuiMenu.Item(text = "Weekends", index = 3),
      |   MuiMenu.Item(text = "Weekly", index = 4)
      |  )
      |
      | MuiDropdownMenu(menuItems = menuItems)
      |
    """.stripMargin

  val menuItems = List(
   MuiMenu.Item(text = "Never", index = 0),
   MuiMenu.Item(text = "Every Night", index = 1),
   MuiMenu.Item(text = "Weeknights", index = 2),
   MuiMenu.Item(text = "Weekends", index = 3),
   MuiMenu.Item(text = "Weekly", index = 4)
  )

  val component = ReactComponentB[Unit]("MuiDropdownMenuDemo")
    .render(P => {
     <.div(
      <.h3("DropDown"),
       CodeExample(code)(
        <.div(MuiDropdownMenu(menuItems = menuItems))
       )
      )
    }).buildU

  def apply() = component()

}
