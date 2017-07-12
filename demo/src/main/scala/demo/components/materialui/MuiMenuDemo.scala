package demo
package components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react._
import japgolly.scalajs.react.component.Js
import japgolly.scalajs.react.component.Js.RawMounted
import japgolly.scalajs.react.vdom.html_<^._

import scala.scalajs.js
import scala.scalajs.js.|

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

    val onTouchTap: (TouchTapEvent, RawMounted) => Callback =
      (e, elem) => {
        val mounted = Js.mounted[HasValue[String], js.Object](elem)
        $.modState(_.touched(mounted.props.value))
      }

    def renderOpen(S: State) = {
      val menuValue: String | js.Array[String] = js.Array[String](S.multiple.toSeq: _*)
      <.div(
        MuiFlatButton(
          label = "Close menu",
          onTouchTap = toggleOpen
        )(),
        MuiMenu[String](
          desktop = true,
          width = 320,
          value = menuValue,
          multiple = true,
          onItemTouchTap = onTouchTap,
          onKeyDown = CallbackDebug.f1("onKeyDown"),
          onEscKeyDown = toggleOpen
        )(
          MuiMenuItem[String](value = "bold", secondaryText = "⌘B", checked = true)("Bold"),
          MuiMenuItem[String](value = "italic", secondaryText = "⌘I")("Italic"),
          MuiMenuItem[String](value = "under", secondaryText = "⌘U")("Underline"),
          MuiMenuItem[String](value = "strike", secondaryText = "Alt+Shift+5")("Strikethrough"),
          MuiMenuItem[String](value = "super", secondaryText = "⌘.")("Superscript"),
          MuiMenuItem[String](value = "sub", secondaryText = "⌘,")("Subscript"),
          MuiDivider()(),
          MuiMenuItem[String](value = "align")("Align")
        )
      )
    }

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

  val component = ScalaComponent.builder[Unit] ("MuiMenuDemo")
    .initialState(State(isOpen = false, Set.empty))
    .renderBackend[Backend]
    .build

  // EXAMPLE:END

  def apply() = component()
}
