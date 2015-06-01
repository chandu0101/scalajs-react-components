package chandu0101.scalajs.react.components.demo.pages.components.materialui

import chandu0101.scalajs.react.components.demo.pages.util.CodeExample
import chandu0101.scalajs.react.components.materialui.MuiInput
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._


/**
 * Created by chandrasekharkode .
 */
object MInputs {

 val code =
   """
     |MuiInput( placeholder = "First name" ,description = "your first name as DOB" ,name = "firstname" ,onChange = B.onTextChange),
     |MuiInput( placeholder = "Disabled MuiInput"  ,name = "disabled", disabled = true ),
     |MuiInput( placeholder = "Disabled With Value", defaultValue = "Default Value" , name = "disabled", disabled = true )
   """.stripMargin

  class Backend(t:BackendScope[_,_]) {

    def onTextChange(e:ReactEventI,text : String) = println("entered text :" + text)
  }
  val component = ReactComponentB[Unit]("plain")
    .stateless
    .backend(new Backend(_))
    .render((P,S,B) => {
     <.div(
      <.h2(^.cls := "mui-font-style-headline")("Inputs"),
       CodeExample(code)(
        MuiInput( placeholder = "First name" ,description = "your first name as DOB" ,name = "firstname" ,onChange = B.onTextChange),
        MuiInput( placeholder = "Disabled MuiInput"  ,name = "disabled", disabled = true ),
        MuiInput( placeholder = "Disabled With Value", defaultValue = "Default Value" , name = "disabled", disabled = true )
       )
      )
    }).buildU

  def apply() = component()

}
