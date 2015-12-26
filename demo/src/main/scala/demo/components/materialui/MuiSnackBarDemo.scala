package demo
package components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components._
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react._
import org.scalajs.dom

object MuiSnackbarDemo {
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  class Backend(t: BackendScope[_, _]) {
    val snackBarRef = RefHolder[MuiSnackbarM]

    val handleAction: ReactEvent => Callback =
      e => Callback(dom.window.alert("We removed Event from your calendar"))

    val buttonClick: ReactEventH => Callback =
      e => snackBarRef().map(_.show())

    def render = {
      CodeExample(code, "MuiSnackBar")(
        MuiSnackbar(
          message = "Event added to your calendar",
          action = "undo",
          ref = snackBarRef.set,
          onActionTouchTap = handleAction,
          open = true
        )(),
        MuiRaisedButton(
          label = "Snack Bar Demo",
          onTouchTap = buttonClick
        )()
      )
    }
  }

  val component = ReactComponentB[Unit]("MuiSnackBar")
    .renderBackend[Backend]
    .buildU

  // EXAMPLE:END

  def apply() = component()
}
