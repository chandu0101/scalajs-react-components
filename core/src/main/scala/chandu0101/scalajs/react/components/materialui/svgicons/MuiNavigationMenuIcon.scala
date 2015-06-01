package chandu0101.scalajs.react.components.materialui.svgicons

import chandu0101.scalajs.react.components.all._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._



/**
  * Created by chandrasekharkode .
  */
object MuiNavigationMenuIcon {

   val component = ReactComponentB[Props]("MuiNavigationMenuIcon")
     .render(P => {
     MuiSvgIcon(props = P.props)(
       path(dsvg := "M3 18h18v-2H3v2zm0-5h18v-2H3v2zm0-7v2h18V6H3z" , ^.key := "nav-menu")
     )
   }).build

   def apply(props: TagMod*) = component(Props(props))

   case class Props(props: TagMod*)

 }
