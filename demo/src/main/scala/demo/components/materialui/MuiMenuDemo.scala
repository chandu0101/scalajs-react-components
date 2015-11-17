package demo
package components
package materialui

import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js
import scala.scalajs.js.`|`
import scalacss.Defaults._
import scalacss.ScalaCssReact._
import scalacss.mutable.StyleSheet.Inline

object MuiMenuDemo {


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
    MuiMenuItemJson(payload = "1", text = "ID", data = "12345678"),
    MuiMenuItemJson(payload = "2", text = "Type", data = "Announcement"),
    MuiMenuItemJson(payload = "3", text = "Caller ID", data = "(123) 456-7890")
  )

  lazy val numberMenuItems = js.Array(
    MuiMenuItemJson(payload = "1", text = "All", number = "2"),
    MuiMenuItemJson(payload = "2", text = "Uncategorized", number = "6"),
    MuiMenuItemJson(payload = "3", text = "Trash", number = "11")
  )

  lazy val filterMenuItems = js.Array(
    MuiMenuItemJson(payload = "1", text = "Text Opt-in", toggle = true),
    MuiMenuItemJson(payload = "2", text = "Text Opt-out", toggle = true, defaultToggled = true),
    MuiMenuItemJson(payload = "3", text = "Voice Opt-out", toggle = true)
  )

  case class State(selected: String | js.Array[String])

  class Backend($: BackendScope[Unit, State]) {
    val onChange: (ReactEvent, (String | js.Array[String])) => Callback =
      (e, value) => Callback.info(s"chose $value") >> $.setState(State(value))
    val onItemTouchTap: (ReactTouchEvent, ReactElement) => Callback =
      (e, elem) => Callback.info(s"touched $elem")

    def render(S: State) = {
      <.div(Style.container,
        <.h3("Menus"),
        MuiTabs()(
          MuiTab(label = "Menu example")(
            CodeExample(filterMenuCode)(
              <.div(Style.content,
                MuiMenu(
                  desktop = true,
                  width = 320: (String | Int),
                  onChange = onChange,
                  onItemTouchTap = onItemTouchTap,
                  value = S.selected,
                  multiple = true,
                  openDirection = MuiMenuOpenDirection.TOP_LEFT
                )(
                  MuiMenuItem(primaryText = "Bold", value = "bold", checked = true, secondaryText = "&#8984;B")(),
                  MuiMenuItem(primaryText = "Italic", value = "italic", secondaryText = "&#8984;I")(),
                  MuiMenuItem(primaryText = "Underline", value = "under", secondaryText = "&#8984;U")(),
                  MuiMenuItem(primaryText = "Strikethrough", value = "strike", secondaryText = "Alt+Shift+5")(),
                  MuiMenuItem(primaryText = "Superscript", value = "super", secondaryText = "&#8984;.")(),
                  MuiMenuItem(primaryText = "Subscript", value = "sub", secondaryText = "&#8984;,")(),
                  MuiMenuDivider()(),
                  MuiMenuItem(primaryText = "Align", value = "align")()
                )
              )
            )
          )
        )
      )
    }
  }

  val component = ReactComponentB[Unit]("MuiMenuDemo")
    .initialState(State(js.Array[String]()))
    .renderBackend[Backend]
    .buildU

  def apply() = component()

}
