package demo
package components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

import scala.scalajs.js
import scala.scalajs.js.|

object MuiMenuDemo {
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START
  sealed abstract class Value
  object Value {
    case object Bold   extends Value
    case object Italic extends Value
    case object Under  extends Value
    case object Strike extends Value
    case object Super  extends Value
    case object Sub    extends Value
    case object Align  extends Value
  }

  case class State(isOpen: Boolean, values: js.Array[Value])

  class Backend($ : BackendScope[Unit, State]) {
    val toggleOpen: ReactEvent => Callback =
      e => $.modState(s => s.copy(isOpen = !s.isOpen))

    val onChange: (TouchTapEvent, Value | js.Array[Value]) => Callback =
      (e, values) =>
        values match {
          case v: Value            => $.modState(_.copy(values = js.Array(v)))
          case vs: js.Array[Value] => $.modState(_.copy(values = vs))
      }

    def renderOpen(S: State) = {
      <.div(
        MuiFlatButton(
          label = "Close menu",
          onClick = toggleOpen
        )(),
        MuiMenu[Value](
          width = 320,
          value = S.values,
          desktop = true,
          multiple = true,
          onEscKeyDown = toggleOpen,
          onChange = js.defined(onChange)
        )(
          MuiMenuItem(value = Value.Bold, secondaryText = js.defined("⌘B"))("Bold"),
          MuiMenuItem(value = Value.Italic, secondaryText = js.defined("⌘I"))("Italic"),
          MuiMenuItem(value = Value.Under, secondaryText = js.defined("⌘U"))("Underline"),
          MuiMenuItem(value = Value.Strike, secondaryText = js.defined("Alt+Shift+5"))(
            "Strikethrough"),
          MuiMenuItem(value = Value.Super, secondaryText = js.defined("⌘."))("Superscript"),
          MuiMenuItem(value = Value.Sub, secondaryText = js.defined("⌘,"))("Subscript"),
          MuiDivider()(),
          MuiMenuItem(value = Value.Align)("Align")
        )
      )
    }

    def renderClosed(S: State) =
      MuiFlatButton(
        label = "open menu",
        onClick = toggleOpen
      )()

    def render(S: State) =
      CodeExample(code, "MuiMenu")(
        if (S.isOpen) renderOpen(S) else renderClosed(S),
        s"Has chosen: ${S.values.mkString(", ")}"
      )
  }

  val component = ScalaComponent
    .builder[Unit]("MuiMenuDemo")
    .initialState(State(isOpen = false, values = js.Array[Value](Value.Bold)))
    .renderBackend[Backend]
    .build

  // EXAMPLE:END

  def apply() = component()
}
