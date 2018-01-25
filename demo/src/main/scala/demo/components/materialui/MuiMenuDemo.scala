package demo
package components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

import scala.scalajs.js
import scala.scalajs.js.JSConverters._
import scala.scalajs.js.JSON

object MuiMenuDemo {
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  case class State(isOpen: Boolean, multiple: Set[String]) {
    def touched(us: js.UndefOr[String]) = us.fold(this) {
      case s if multiple contains s =>
        copy(multiple = multiple - s)
      case s =>
        copy(multiple = multiple + s)
    }
  }

  class Backend($ : BackendScope[Unit, State]) {
    val toggleOpen: ReactEvent => Callback =
      e => $.modState(s => s.copy(isOpen = !s.isOpen))

    val onClick: (ReactEvent, js.Object) => Callback =
      (e, elem) => $.modState(_.touched(JSON.stringify(elem)))

    def renderOpen(S: State) =
      <.div(
        MuiFlatButton(
          label = "Close menu",
          onClick = toggleOpen
        )(),
        MuiMenu[String](
          desktop = true,
          width = 320,
          value = S.multiple.toJSArray,
          multiple = true,
          onItemClick = onClick,
          onKeyDown = CallbackDebug.f1("onKeyDown"),
          onEscKeyDown = toggleOpen
        )(
          MuiMenuItem[String](value = "bold", secondaryText = js.defined("⌘B"), checked = true)(
            "Bold"),
          MuiMenuItem[String](value = "italic", secondaryText = js.defined("⌘I"))("Italic"),
          MuiMenuItem[String](value = "under", secondaryText = js.defined("⌘U"))("Underline"),
          MuiMenuItem[String](value = "strike", secondaryText = js.defined("Alt+Shift+5"))(
            "Strikethrough"),
          MuiMenuItem[String](value = "super", secondaryText = js.defined("⌘."))("Superscript"),
          MuiMenuItem[String](value = "sub", secondaryText = js.defined("⌘,"))("Subscript"),
          MuiDivider()(),
          MuiMenuItem[String](value = "align")("Align")
        )
      )

    def renderClosed(S: State) =
      MuiFlatButton(
        label = "open menu",
        onClick = toggleOpen
      )()

    def render(S: State) =
      CodeExample(code, "MuiMenu")(
        if (S.isOpen) renderOpen(S) else renderClosed(S)
      )
  }

  val component = ScalaComponent
    .builder[Unit]("MuiMenuDemo")
    .initialState(State(isOpen = false, Set.empty))
    .renderBackend[Backend]
    .build

  // EXAMPLE:END

  def apply() = component()
}
