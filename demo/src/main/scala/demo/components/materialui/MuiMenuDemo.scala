package demo
package components
package materialui

import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import scala.scalajs.js
import scalacss.Defaults._
import scalacss.ScalaCssReact._
import scalacss.mutable.StyleSheet.Inline

object MuiMenuDemo {

  val code =
    """
      | MuiAppBar(title = "Title")()
      |
    """.stripMargin

  val labelMenuCode =
    """
      |lazy val labelMenuItems = js.Array(
      |    MuiMenuItem(payload = "1",text = "ID",data = "12345678"),
      |    MuiMenuItem(payload = "2",text = "Type",data = "Announcement"),
      |    MuiMenuItem(payload = "3",text = "Caller ID",data = "(123) 456-7890")
      |  )
      | 
      |  MuiMenu(menuItems = labelMenuItems)
      | 
      |
    """.stripMargin

  val numberMenuCode =
    """
      |lazy val numberMenuItems = js.Array(
      |    MuiMenuItem(payload = "1",text = "All",number = "2"),
      |    MuiMenuItem(payload = "2",text = "Uncategorized",number = "6"),
      |    MuiMenuItem(payload = "3",text = "Trash",number = "11")
      |  )
      | 
      | MuiMenu(menuItems = numberMenuItems,autoWidth = false)
      |
    """.stripMargin

  val filterMenuCode =
    """
      | lazy val filterMenuItems = js.Array(
      |    MuiMenuItem(payload = "1",text = "Text Opt-in",toggle = true),
      |    MuiMenuItem(payload = "2",text = "Text Opt-out",toggle = true,defaultToggled = true),
      |    MuiMenuItem(payload = "3",text = "Voice Opt-out",toggle = true)
      |  )
      |
      | MuiMenu(menuItems = filterMenuItems,autoWidth = false)
      |
      |
    """.stripMargin

  object Style extends Inline {

    import dsl._

    val container = style(maxWidth(1024 px))


    val content = style(display.flex,
      padding(30.px),
      flexDirection.column,
      alignItems.center)
  }

  lazy val labelMenuItems = js.Array(
    MuiMenuItem(payload = "1",text = "ID",data = "12345678"),
    MuiMenuItem(payload = "2",text = "Type",data = "Announcement"),
    MuiMenuItem(payload = "3",text = "Caller ID",data = "(123) 456-7890")
  )

  lazy val numberMenuItems = js.Array(
    MuiMenuItem(payload = "1",text = "All",number = "2"),
    MuiMenuItem(payload = "2",text = "Uncategorized",number = "6"),
    MuiMenuItem(payload = "3",text = "Trash",number = "11")
  )

  lazy val filterMenuItems = js.Array(
    MuiMenuItem(payload = "1",text = "Text Opt-in",toggle = true),
    MuiMenuItem(payload = "2",text = "Text Opt-out",toggle = true,defaultToggled = true),
    MuiMenuItem(payload = "3",text = "Voice Opt-out",toggle = true)
  )

  val component = ReactComponentB[Unit]("MuiMenuDemo")
    .render(P => {
    <.div(Style.container,
      <.h3("Menus"),
      MuiTabs()(
        MuiTab(label = "Label Menu")(
          CodeExample(labelMenuCode)(
            <.div(Style.content,
              MuiMenu(menuItems = labelMenuItems,autoWidth = false)()
            )
          )
        ),
        MuiTab(label = "Number Menu")(
          CodeExample(numberMenuCode)(
            <.div(Style.content,
              MuiMenu(menuItems = numberMenuItems,autoWidth = false)()
            )
          )
        ),
        MuiTab(label = "Filter Menu")(
          CodeExample(filterMenuCode)(
            <.div(Style.content,
              MuiMenu(menuItems = filterMenuItems,autoWidth = false)()
            )
          )
        )
      )
    )
  }).buildU


  def apply() = component()


}
