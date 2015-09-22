package demo
package components
package materialui

import chandu0101.scalajs.react.components._
import chandu0101.scalajs.react.components.materialui.{MuiRaisedButton, MuiSnackBar, MuiSnackBarM}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import org.scalajs.dom

object MuiSnackBarDemo {
  val snackBarRef = Ref.toJS[MuiSnackBarM]("snackbar")

  val code =
    """
      |  MuiSnackBar(message = " Event added to your calender",
      |          action = "undo",
      |          ref = "snackbar",
      |          onActionTouchTap = B.handleAction _)
      |
    """.stripMargin

  class Backend(t: BackendScope[_,_]) {
    val withSnackBar = withRef(snackBarRef, t) _

    def handleAction(e: ReactEvent) =
      Callback(dom.window.alert("We removed Event from your cal"))

    def buttonClick(e: ReactEventH): Callback =
      withSnackBar(r => Callback(r.show()))

    def render = {
      CodeExample(code, "MuiSnackBar")(
        MuiSnackBar(message = " Event added to your calender",
          action = "undo",
          ref = "snackbar",
          onActionTouchTap = handleAction _)(),
        MuiRaisedButton(label = " Snack Bar Demo",onTouchTap = buttonClick _)()
      )
    }
  }

  val component = ReactComponentB[Unit]("MuiAppBarDemo")
    .renderBackend[Backend]
    .buildU

  def apply() = component()
}
