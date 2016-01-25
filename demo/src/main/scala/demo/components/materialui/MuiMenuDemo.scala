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

  case class State(isOpen: Boolean, multiple: Set[String]){
    def touched(us: js.UndefOr[String]) = us.fold(this){
      case s if multiple contains s =>
        copy(multiple = multiple - s)
      case s =>
        copy(multiple = multiple + s)
    }
  }

  class Backend($: BackendScope[Unit, State]) {
    val toggleOpen: ReactEvent => Callback =
      e => $.modState(s => s.copy(isOpen = !s.isOpen))

    val onTouchTap: (ReactUIEventH, JsComponentM[MuiMenuItemProps, _, TopNode]) => Callback =
      (e, elem) => $.modState(_.touched(elem.props.value))

    def renderOpen(S: State) =
      <.div(
        MuiFlatButton(label = "close menu", onClick = toggleOpen)(),
        MuiMenu(
          desktop        = true,
          width          = 320,
          value          = S.multiple.toJsArray,
          multiple       = true,
          openDirection  = MuiMenuOpenDirection.BOTTOM_RIGHT,
          onItemTouchTap = onTouchTap,
          onKeyDown      = DummyEvents.f1("onKeyDown"),
          onEscKeyDown   = toggleOpen
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
    def renderClosed(S: State) =
      MuiFlatButton(label = "open menu", onClick = toggleOpen)()

    def render(S: State) =
      CodeExample(code, "MuiMenu")(
        <.div(
          Style.container,
          <.h3("Menus"),
          MuiTabs()(
            MuiTab(label = "Menu example")(
              <.div(
                Style.content,
                if (S.isOpen) renderOpen(S) else renderClosed(S)
              )
          )
        )
      )
    )
  }

val component = ReactComponentB[Unit] ("MuiMenuDemo")
  .initialState(State(isOpen = false, Set.empty))
  .renderBackend[Backend]
  .buildU

// EXAMPLE:END

def apply () = component ()

}
