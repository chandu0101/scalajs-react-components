package demo
package components
package materialui.svgicons

import chandu0101.scalajs.react.components.materialui.MuiSvgIcon
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

object ContentSend {


   val component = ReactComponentB[Unit]("ContentSend")
     .render(P => {
     MuiSvgIcon()(
       <.svg.path(^.key := "acg", ^.svg.d := "M2.01 21L23 12 2.01 3 2 10l15 2-15 2z")
     )
   }).buildU

   def apply() = component()
 }
