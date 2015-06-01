package chandu0101.scalajs.react.components.demo.pages.components.materialui

import chandu0101.scalajs.react.components.demo.pages.util.CodeExample
import chandu0101.scalajs.react.components.materialui.{MuiDialog, MuiRaisedButton}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._


/**
 * Created by chandrasekharkode .
 */
object MuiDialogDemo {


  val code =
    """
      |//dialog ref
      |val theDialogRef = Ref.to(MuiDialog.component, "theDialogRef")
      |
      |//dialog actions
      |val dialogActions = List(
      |    MuiDialog.Action( text = "CANCEL"),
      |    MuiDialog.Action( text = "SUBMIT" , onClick = B.onDialogSubmit))
      |
      |MuiDialog(ref = theDialogRef,title = "Title", actions = dialogActions)(
      | This is an example of a dialog component built with Facebook 's React and following
      | Google 's Material Design principles.
      | )
    """.stripMargin




  class Backend(t:BackendScope[_,_]) {

    def onButtonTouchTap(e:ReactEventI)= {
      theDialogRef(t).get.backend.show(e)
    }
    def onDialogSubmit(e:ReactEventI) = {
      println("dialog submitted")
      theDialogRef(t).get.backend.dismiss(e)
    }
  }

  val theDialogRef = Ref.to(MuiDialog.component, "theDialogRef")

  val component = ReactComponentB[Unit]("plain")
    .stateless
    .backend(new Backend(_))
    .render((P,S,B) => {
      val dialogActions = List(
      MuiDialog.Action( text = "CANCEL"),
      MuiDialog.Action( text = "SUBMIT" , onClick = B.onDialogSubmit))
     <.div(
       <.h3("MuiDialog"),
        CodeExample(code)(
         MuiRaisedButton(label = "Demo", onTouchTap = B.onButtonTouchTap)
        ),
        MuiDialog(ref = theDialogRef,title = "Title", actions = dialogActions)(
         """
           | This is an example of a dialog component built with Facebook's React and following
           | Google's Material Design principles.
         """.stripMargin
        )
       )
    }).buildU

  def apply() = component()


}
