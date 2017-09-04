package demo
package components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom

import scala.scalajs.js

object MuiSnackbarDemo {
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  class Backend($ : BackendScope[_, Boolean]) {
    val close = $.setState(false)
    val open  = $.setState(true)

    val undoAdd: ReactEvent => Callback =
      e => close >> Callback(dom.window.alert("We removed Event from your calendar"))

    val closeRequested: String => Callback =
      reason => close >> Callback.info(s"onRequestClose: $reason")

    val toggleSnack: TouchTapEvent => Callback =
      e => $.modState(!_)

    def render(isOpen: Boolean) =
      CodeExample(code, "MuiSnackBar")(
        <.div(
          MuiSnackbar(
            autoHideDuration = js.defined(5000),
            message = "Event added to your calendar",
            action = js.defined("undo"),
            onActionTouchTap = undoAdd,
            onRequestClose = closeRequested,
            open = isOpen
          )(),
          MuiRaisedButton(
            label = "Add event to calendar",
            onTouchTap = toggleSnack
          )().unless(isOpen)
        )
      )
  }

  val component = ScalaComponent
    .builder[Unit]("MuiSnackBar")
    .initialState(false)
    .renderBackend[Backend]
    .build

  // EXAMPLE:END

  def apply() = component()
}
