package chandu0101.scalajs.react.components
package demo.components.materialui

import chandu0101.scalajs.react.components.demo.components.CodeExample
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import scala.scalajs.js

object MuiDialogDemo {

  val code =
    """
      | val actions : js.Array[ReactElement] = js.Array(
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


  class Backend(t : BackendScope[_,_]) {

    def handleDialogCancel(e : ReactEventH) = {
      println("Cancel Clicked")
      dialogRef(t).get.dismiss()
    }

    def handleDialogSubmit(e : ReactEventH) = {
      println("Submit Clicked")
      dialogRef(t).get.dismiss()
    }

    def openDialog(e : ReactEventH) = {
      dialogRef(t).get.show()
    }

  }

  val dialogRef = Ref.toJS[MuiDialogM]("dialogref")

  val component = ReactComponentB[Unit]("MuiDialogDemo")
    .stateless
    .backend(new Backend(_))
    .render((P,S,B) => {
    val actions : js.Array[ReactElement] = js.Array(
     MuiFlatButton(label = "Cancel",secondary = true,onTouchTap = B.handleDialogCancel _)(),
     MuiFlatButton(label = "Submit",secondary = true,onTouchTap = B.handleDialogSubmit _)()
    )
    <.div(
      CodeExample(code,"MuiDialog")(
      <.div(
        MuiDialog(title = "Dialog With Actions",
          actions = actions,
          ref = "dialogref")(
            "Dialog example with floating buttons"
          ),
        MuiRaisedButton(label = "Dialog",onTouchTap = B.openDialog _ )()
      )
      )
    )
  }).buildU


  def apply() = component()

}
