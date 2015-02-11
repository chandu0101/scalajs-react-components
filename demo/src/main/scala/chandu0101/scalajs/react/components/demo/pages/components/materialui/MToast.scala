package chandu0101.scalajs.react.components.demo.pages.components.materialui

import chandu0101.scalajs.react.components.demo.pages.util.CodeExample
import chandu0101.scalajs.react.components.materialui.{MuiRaisedButton, MuiToast}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._

/**
 * Created by chandrasekharkode .
 */
object MToast {


  val code =
    """
      |MuiToast( ref = theToastRef , message = "Hola I am MuiToast")
    """.stripMargin

  val theToastRef = Ref.to(MuiToast.component, "theToastRef")

  class Backend(t: BackendScope[_, _]) {
    def onButtonTap(e:ReactEventI) = theToastRef(t).get.backend.toggle
  }

  val component = ReactComponentB[Unit]("plain")
    .stateless
    .backend(new Backend(_))
    .render((P,S,B) => {
    div(
      h2(cls := "mui-font-style-headline")("MuiToast"),
      CodeExample(code)(
        MuiRaisedButton(label = "MuiToast Demo", onTouchTap = B.onButtonTap),
       MuiToast( ref = theToastRef , message = "Hola I am MuiToast")
      )
    )
  }).buildU

  def apply() = component()
}
