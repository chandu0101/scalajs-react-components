package chandu0101.scalajs.react.components.materialui.svgicons

import chandu0101.scalajs.react.components.all._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._



/**
  * Created by chandrasekharkode .
  */
object MuiNavigationChevronRight {

   val component = ReactComponentB[Props]("MuiNavigationChevronRight")
     .render(P => {
     MuiSvgIcon(props = P.props)(
       path(dsvg := "M10 6L8.59 7.41 13.17 12l-4.58 4.59L10 18l6-6z" , ^.key := "nav-right")
     )
   }).build

   def apply(props: TagMod*) = component(Props(props))

   case class Props(props: TagMod*)

 }
