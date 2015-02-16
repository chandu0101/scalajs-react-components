package chandu0101.scalajs.react.components.demo.pages.components.materialui

import chandu0101.scalajs.react.components.demo.pages.util.CodeExample
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._

/**
 * Created by chandrasekharkode .
 */
object MuiToolbarDemo {

  val codeValue =
    """
      | val filteredOptions = List(
      |    MuiMenu.Item(index = 0, text = "All Broadcasts"),
      |    MuiMenu.Item(index = 1, text = "All Voice"),
      |    MuiMenu.Item(index = 2, text = "All Text"),
      |    MuiMenu.Item(index = 3, text = "Completed Voice"),
      |    MuiMenu.Item(index = 4, text = "Active Voice"),
      |    MuiMenu.Item(index = 5, text = "Active Text")
      |  )
      |
      | val iconMenuItems = List(
      |    MuiMenu.Item(text = "Download"),
      |    MuiMenu.Item(text = "More Info")
      |  )
      |
      |  MuiToolbar()(
      |            MuiToolbarGroup(key = 0, float = "left")(
      |              MuiDropdownMenu(menuItems = filteredOptions)
      |            ),
      |            MuiToolbarGroup(key = 1, float = "right")(
      |              MuiFontIcon(className = "mui-icon-pie"),
      |              MuiFontIcon(className = "mui-icon-sort"),
      |              MuiDropDownIcon(iconClassName ="navigation-expand-more" ,menuItems = iconMenuItems),
      |              span(cls := "mui-toolbar-separator")(" "),
      |              MuiRaisedButton(label = "Create Broadcast", primary = true)
      |            )
      |          )
    """.stripMargin

  val filteredOptions = List(
    MuiMenu.Item(index = 0, text = "All Broadcasts"),
    MuiMenu.Item(index = 1, text = "All Voice"),
    MuiMenu.Item(index = 2, text = "All Text"),
    MuiMenu.Item(index = 3, text = "Completed Voice"),
    MuiMenu.Item(index = 4, text = "Active Voice"),
    MuiMenu.Item(index = 5, text = "Active Text")
  )

  val iconMenuItems = List(
    MuiMenu.Item(text = "Download"),
    MuiMenu.Item(text = "More Info")
  )

  val component = ReactComponentB[Unit]("MuiToolbarDemo")
    .render(P => {
    div(
      h3("Toolbars"),
        div(
          MuiToolbar()(
            MuiToolbarGroup(key = 0, float = "left")(
              MuiDropdownMenu(menuItems = filteredOptions)
            ),
            MuiToolbarGroup(key = 1, float = "right")(
              MuiFontIcon(className = "mui-icon-pie"),
              MuiFontIcon(className = "mui-icon-sort"),
              MuiDropDownIcon(iconClassName ="navigation-expand-more" ,menuItems = iconMenuItems),
              span(cls := "mui-toolbar-separator")(" "),
              MuiRaisedButton(label = "Create Broadcast", primary = true)
            )
          ),
        div(marginTop := "70px")(
          pre(cls := "code-block")(code(codeValue))
        )

        )
    )
  })
    .configure(CodeExample.installSyntaxHighlighting)
    .buildU

  def apply() = component()
}
