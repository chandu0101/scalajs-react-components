package chandu0101.scalajs.react.components.materialui.svgicons

import chandu0101.scalajs.react.components.all._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._


/**
  * Created by chandrasekharkode .
  */
object MuiToggleRadioButtonOn {

   val component = ReactComponentB[Props]("MuiToggleRadioButtonOn")
     .render(P => {
     MuiSvgIcon(P.props)(
       path(key := "toglleradioon", dsvg := "M12 7c-2.76 0-5 2.24-5 5s2.24 5 5 5 5-2.24 5-5-2.24-5-5-5zm0-5C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm0 18c-4.42 0-8-3.58-8-8s3.58-8 8-8 8 3.58 8 8-3.58 8-8 8z")
     )
   }).build


   case class Props(props: TagMod*)

   def apply(props: TagMod*) = component(Props(props))

 }
