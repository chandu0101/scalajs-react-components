package demo
package components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js
import scala.scalajs.js.`|`
import scalacss.Defaults._
import scalacss.ScalaCssReact._
import scalacss.mutable.StyleSheet.Inline

object MuiMenuDemo {

  object Style extends Inline {

    import dsl._

    val container = style(maxWidth(1024 px))

    val content = style(display.flex,
      padding(30.px),
      flexDirection.column,
      alignItems.center)
  }

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  case class State(selected: String | js.Array[String])

  class Backend($: BackendScope[Unit, State]) {

    val onChange: (ReactEvent, (String | js.Array[String])) => Callback =
      (e, value) => Callback.info(s"chose $value") >> $.setState(State(value))
    val onItemTouchTap: (ReactTouchEvent, ReactElement) => Callback =
      (e, elem) => Callback.info(s"touched $elem")

    def render(S: State) =
      CodeExample(code)(
        <.div(Style.container,
          <.h3("Menus"),
          MuiTabs()(
            MuiTab(label = "Menu example")(
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

val component = ReactComponentB[Unit] ("MuiMenuDemo")
.initialState (State (js.Array[String] () ) )
.renderBackend[Backend]
.buildU

// EXAMPLE:END

def apply () = component ()

}
