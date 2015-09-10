package demo
package components
package materialui.svgicons

import chandu0101.scalajs.react.components.materialui.MuiSvgIcon
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

object ActionInfo {


   val component = ReactComponentB[Unit]("ActionGrade")
     .render(P => {
     MuiSvgIcon()(
       <.svg.path(^.key := "acg", ^.svg.d := "M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm1 15h-2v-6h2v6zm0-8h-2V7h2v2z")
     )
   }).buildU

   def apply() = component()
 }
