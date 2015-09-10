package demo
package components
package materialui

import chandu0101.scalajs.react.components.materialui.{MuiRaisedButton, MuiSnackBar, MuiSnackBarM}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
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

    def handleAction(e: ReactEvent) = {
      dom.window.alert("We removed Event from your cal")
    }

    def buttonClick(e: ReactEventH) = {
      snackBarRef(t).get.show()
    }
  }

  val snackBarRef = Ref.toJS[MuiSnackBarM]("snackbar")

  val component = ReactComponentB[Unit]("MuiAppBarDemo")
    .stateless
    .backend(new Backend(_))
    .render((P,S,B) => {
    <.div(
      CodeExample(code, "MuiSnackBar")(
        MuiSnackBar(message = " Event added to your calender",
          action = "undo",
          ref = "snackbar",
          onActionTouchTap = B.handleAction _)(),
        MuiRaisedButton(label = " Snack Bar Demo",onTouchTap = B.buttonClick _)()

      )
    )
  }).buildU

  def apply() = component()
}
