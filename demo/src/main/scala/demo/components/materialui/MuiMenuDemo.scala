package demo
package components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js

object MuiMenuDemo {
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

    val onTouchTap: (TouchTapEvent, JsComponentM[HasValue[String], _, TopNode]) => Callback =
      (e, elem) => $.modState(_.touched(elem.props.value))

    def renderOpen(S: State) =
      <.div(
        MuiFlatButton(
          label      = "Close menu",
          onTouchTap = toggleOpen
        )(),
        MuiMenu[String](
          desktop        = true,
          width          = 320,
          value          = S.multiple.toJsArray,
          multiple       = true,
          onItemTouchTap = onTouchTap,
          onKeyDown      = CallbackDebug.f1("onKeyDown"),
          onEscKeyDown   = toggleOpen
        )(
          MuiMenuItem(value = "bold",   secondaryText = "⌘B", checked = true)("Bold"),
          MuiMenuItem(value = "italic", secondaryText = "⌘I")("Italic"),
          MuiMenuItem(value = "under",  secondaryText = "⌘U")("Underline"),
          MuiMenuItem(value = "strike", secondaryText = "Alt+Shift+5")("Strikethrough"),
          MuiMenuItem(value = "super",  secondaryText = "⌘.")("Superscript"),
          MuiMenuItem(value = "sub",    secondaryText = "⌘,")("Subscript"),
          MuiDivider()(),
          MuiMenuItem(value = "align")("Align")
        )
      )

    def renderClosed(S: State) =
      MuiFlatButton(
        label = "open menu",
        onTouchTap = toggleOpen
      )()

    def render(S: State) =
      CodeExample(code, "MuiMenu")(
        if (S.isOpen) renderOpen(S) else renderClosed(S)
    )
  }

  val component = ReactComponentB[Unit] ("MuiMenuDemo")
    .initialState(State(isOpen = false, Set.empty))
    .renderBackend[Backend]
    .build

  // EXAMPLE:END

  def apply() = component()
}
