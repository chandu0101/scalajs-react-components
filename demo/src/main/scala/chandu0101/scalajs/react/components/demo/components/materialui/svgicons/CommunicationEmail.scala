package chandu0101.scalajs.react.components.demo.components.materialui.svgicons

import chandu0101.scalajs.react.components.materialui.MuiSvgIcon
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all.svg._
import japgolly.scalajs.react.vdom.prefix_<^._

object CommunicationEmail {


   val component = ReactComponentB[Unit]("CommunicationEmail")
     .render(P => {
     MuiSvgIcon()(
       path(^.key := "acg", d := "M20 4H4c-1.1 0-1.99.9-1.99 2L2 18c0 1.1.9 2 2 2h16c1.1 0 2-.9 2-2V6c0-1.1-.9-2-2-2zm0 4l-8 5-8-5V6l8 5 8-5v2z")
     )
   }).buildU

   def apply() = component()
 }
