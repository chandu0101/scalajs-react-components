package chandu0101.scalajs.react.components.demo.pages.components.materialui

import chandu0101.scalajs.react.components.demo.pages.util.CodeExample
import chandu0101.scalajs.react.components.materialui.MuiMenu
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._

/**
 * Created by chandrasekharkode .
 */
object MuiMenuDemo {

  val labelMenuCode =
    """
      |val labelMenuItems = List(
      |   MuiMenu.Item(index = 0 , text = "ID" , data = "1234567" , icon = "home"),
      |   MuiMenu.Item(index = 1 , text = "Type" , data = "Announcement" , icon = "home"),
      |   MuiMenu.Item(index = 2 , text = "Caller ID" , data = "(123) 456-7890" , icon = "home")
      |  )
      |MuiMenu(menuItems = labelMenuItems, onItemClick = B.onMenuItemCLick)
      |
    """.stripMargin

  val labelMenuItems = List(
    MuiMenu.Item(index = 0, text = "ID", data = "1234567", icon = "home"),
    MuiMenu.Item(index = 1, text = "Type", data = "Announcement", icon = "home"),
    MuiMenu.Item(index = 2, text = "Caller ID", data = "(123) 456-7890", icon = "home")
  )

  val numberMenuCode =
    """
      | val numberMenuItems =  List(
      |    MuiMenu.Item(index = 0 , text = "ID" , number = "23"),
      |    MuiMenu.Item(index = 0 , text = "ID" , number = "6"),
      |    MuiMenu.Item(index = 0 , text = "ID" , number = "11")
      |  )
      |MuiMenu(menuItems = numberMenuItems, onItemClick = B.onMenuItemCLick)
    """.stripMargin

  val numberMenuItems = List(
    MuiMenu.Item(index = 0, text = "All", number = "23"),
    MuiMenu.Item(index = 1, text = "Uncat", number = "6"),
    MuiMenu.Item(index = 2, text = "Trash", number = "11")
  )

  val iconMenuCode =
    """
      |  val iconMenuItems = List(
      |   MuiMenu.Item( index = 0, text = "Live Answer" , icon = "communication_phone" , number = "19"),
      |   MuiMenu.Item( index = 1, text = "Voicemail" , icon = "communication_voicemail" , number = "9"),
      |   MuiMenu.Item( index = 2, text = "Starred" , icon = "action_stars" , number = "92")
      |  )
      |  MuiMenu(menuItems = iconMenuItems, onItemClick = B.onMenuItemCLick)
      |
    """.stripMargin

  val iconMenuItems = List(
   MuiMenu.Item( index = 0, text = "Live Answer" , icon = "communication_phone" , number = "19"),
   MuiMenu.Item( index = 1, text = "Voicemail" , icon = "communication_voicemail" , number = "9"),
   MuiMenu.Item( index = 2, text = "Starred" , icon = "action_stars" , number = "92")
  )

  val filterMenuCoe =
    """
      |val filterMenuItems = List(
      |    MuiMenu.Item(index = 0 , text = "Text opt-In" ,toggle = true),
      |    MuiMenu.Item(index = 1 , text = "Text opt-Out" ,toggle = true),
      |    MuiMenu.Item(index = 2 , text = "Voice opt-In" ,toggle = true)
      |  )
      |
    """.stripMargin

  val filterMenuItems = List(
    MuiMenu.Item(index = 0 , text = "Text opt-In" ,toggle = true),
    MuiMenu.Item(index = 1 , text = "Text opt-Out" ,toggle = true),
    MuiMenu.Item(index = 2 , text = "Voice opt-In" ,toggle = true)
  )

  val nestedMenuCode =
    """
      | val nestedMenuItems = List(
      |   MuiMenu.Item(mtype = MuiMenu.Types.NESTED , text = "Repots" ,items = List(
      |      MuiMenu.Item( text = "Nested Item 1"),
      |      MuiMenu.Item(mtype = MuiMenu.Types.NESTED , text = "Nested Item 4" ,items = List(
      |        MuiMenu.Item(text = "Nested Item 5"),
      |        MuiMenu.Item(text = "Nested Item 6")
      |       )),
      |      MuiMenu.Item(text = "Nested Item 7")
      |     )),
      |    MuiMenu.Item(text = "Audio Library"),
      |    MuiMenu.Item(text = "Settings"),
      |    MuiMenu.Item(text = "Logout")
      |  )
      | MuiMenu(menuItems = nestedMenuItems, onItemClick = B.onMenuItemCLick)
      |
    """.stripMargin

  val nestedMenuItems = List(
   MuiMenu.Item(mtype = MuiMenu.Types.NESTED , text = "Repots" ,items = List(
      MuiMenu.Item( text = "Nested Item 1"),
      MuiMenu.Item(mtype = MuiMenu.Types.NESTED , text = "Nested Item 4" ,items = List(
        MuiMenu.Item(text = "Nested Item 5"),
        MuiMenu.Item(text = "Nested Item 6")
       )),
      MuiMenu.Item(text = "Nested Item 7")
     )),
    MuiMenu.Item(text = "Audio Library"),
    MuiMenu.Item(text = "Settings"),
    MuiMenu.Item(text = "Logout")
  )
  class Backend(t: BackendScope[_, _]) {

    def onMenuItemCLick(e: ReactEventI, index: Int, route: String) = {
      println("you clicked on menu index :" + index + "route : " + route)
    }
  }

  val component = ReactComponentB[Unit]("MuiMenuDemo")
    .stateless
    .backend(new Backend(_))
    .render((P, S, B) => {
    div(
      h3("Label Menu"),
      CodeExample(labelMenuCode)(
        div(width := "256px")(
          MuiMenu(menuItems = labelMenuItems, onItemClick = B.onMenuItemCLick)
        )
      ),
      h3("Number Menu"),
      CodeExample(numberMenuCode)(
        div(width := "256px")(
          MuiMenu(menuItems = numberMenuItems, onItemClick = B.onMenuItemCLick)
        )
      ),
      h3("Icon Menu"),
      CodeExample(iconMenuCode)(
        div(width := "256px")(
          MuiMenu(menuItems = iconMenuItems, onItemClick = B.onMenuItemCLick)
        )
      ),
      h3("Filter Menu"),
      CodeExample(filterMenuCoe)(
        div(width := "256px")(
          MuiMenu(menuItems = filterMenuItems, onItemClick = B.onMenuItemCLick)
        )
      ),
      h3("Nested Menu"),
      CodeExample(nestedMenuCode)(
        div(width := "256px")(
          MuiMenu(menuItems = nestedMenuItems, onItemClick = B.onMenuItemCLick)
        )
      )
    )
  }).buildU

  def apply() = component()

}
