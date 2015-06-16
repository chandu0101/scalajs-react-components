package chandu0101.scalajs.react.components.demo.components.materialui.svgicons

import chandu0101.scalajs.react.components.materialui.MuiSvgIcon
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all.svg._
import japgolly.scalajs.react.vdom.prefix_<^._

object CommunicationChatBubble {


   val component = ReactComponentB[Unit]("CommunicationChatBubble")
     .render(P => {
     MuiSvgIcon()(
       path(^.key := "acg", d := "M20 2H4c-1.1 0-2 .9-2 2v18l4-4h14c1.1 0 2-.9 2-2V4c0-1.1-.9-2-2-2z")
     )
   }).buildU

   def apply() = component()
 }
