package chandu0101.scalajs.react.components.materialui.svgicons

import chandu0101.scalajs.react.components.all._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._



/**
  * Created by chandrasekharkode .
  */
object MuiActionGrade {

   val component = ReactComponentB[Props]("MuiActionGrade")
     .render(P => {
     MuiSvgIcon(props = P.props)(
       path(dsvg := "M12 17.27L18.18 21l-1.64-7.03L22 9.24l-7.19-.61L12 2 9.19 8.63 2 9.24l5.46 4.73L5.82 21z" , ^.key := "action-rade")
     )
   }).build

   def apply(props: TagMod*) = component(Props(props))

   case class Props(props: TagMod*)

 }
