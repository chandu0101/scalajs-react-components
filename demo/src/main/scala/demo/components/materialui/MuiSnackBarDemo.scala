package demo
package components
package materialui

import chandu0101.scalajs.react.components._
import chandu0101.scalajs.react.components.materialui.{MuiRaisedButton, MuiSnackBar, MuiSnackBarM}
import japgolly.scalajs.react._
import org.scalajs.dom

object MuiSnackBarDemo {
  val code =
    """
      |  MuiSnackBar(message = " Event added to your calender",
      |          action = "undo",
      |          ref = "snackbar",
      |          onActionTouchTap = B.handleAction _)
      |
    """.stripMargin

  class Backend(t: BackendScope[_,_]) {
    val snackBarRef = RefHolder[MuiSnackBarM]

    val handleAction: ReactEvent => Callback =
      e ⇒ Callback(dom.window.alert("We removed Event from your cal"))

    val buttonClick: ReactEventH => Callback =
      e => snackBarRef().map(_.show())

    def render = {
      CodeExample(code, "MuiSnackBar")(
        MuiSnackBar(
          message = "Event added to your calender",
          action = "undo",
          ref = snackBarRef.set,
          onActionTouchTap = handleAction
        )(),
        MuiRaisedButton(
          label = " Snack Bar Demo",
          onTouchTap = buttonClick
        )()
      )
    }
  }

  val component = ReactComponentB[Unit]("MuiAppBarDemo")
    .renderBackend[Backend]
    .buildU

  def apply() = component()
}
