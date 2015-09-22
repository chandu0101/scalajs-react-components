package demo
package components
package materialui

import chandu0101.scalajs.react.components._
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import scala.scalajs.js

object MuiDialogDemo {
  val dialogRef: RefJSComp[MuiDialogM] = Ref.toJS[MuiDialogM]("dialogref")

  val code =
    """
      | val actions: js.Array[ReactElement] = js.Array(
      |     MuiFlatButton(label = "Cancel",secondary = true,onTouchTap = B.handleDialogCancel _)(),
      |     MuiFlatButton(label = "Submit",secondary = true,onTouchTap = B.handleDialogSubmit _)()
      |    )
      |  MuiDialog(title = "Dialog With Actions",
      |          actions = actions,
      |          ref = "dialogref")(
      |            "Dialog example with floating buttons"
      |          )
      |
    """.stripMargin

  class Backend(t: BackendScope[_,_]) {
    val dialogRefC = callbackRef(dialogRef, t)

    def handleDialogCancel(e: ReactEventH): Callback =
      dialogRefC.map(_.dismiss()) >> Callback.info("Cancel Clicked")

    def handleDialogSubmit(e: ReactEventH): Callback =
      dialogRefC.map(_.dismiss()) << Callback.info("Submit Clicked")

    def openDialog(e: ReactEventH): Callback =
      dialogRefC.map(_.show())

    def render = {
      val actions: js.Array[ReactElement] = js.Array(
       MuiFlatButton(label = "Cancel",secondary = true,onTouchTap = handleDialogCancel _)(),
       MuiFlatButton(label = "Submit",secondary = true,onTouchTap = handleDialogSubmit _)()
      )
      <.div(
        CodeExample(code,"MuiDialog")(
        <.div(
          MuiDialog(title = "Dialog With Actions",
            actions = actions,
            ref = "dialogref")(
              "Dialog example with floating buttons"
            ),
          MuiRaisedButton(label = "Dialog", onTouchTap = openDialog _ )()
        )
        )
      )

    }

  }

  val component = ReactComponentB[Unit]("MuiDialogDemo")
    .renderBackend[Backend]
    .buildU

  def apply() = component()

}
