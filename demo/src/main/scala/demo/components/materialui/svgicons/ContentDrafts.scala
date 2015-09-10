package demo
package components
package materialui.svgicons

import chandu0101.scalajs.react.components.materialui.MuiSvgIcon
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

object ContentDrafts {


   val component = ReactComponentB[Unit]("ContentDrafts")
     .render(P => {
     MuiSvgIcon()(
       <.svg.path(^.key := "acg", ^.svg.d := "M21.99 8c0-.72-.37-1.35-.94-1.7L12 1 2.95 6.3C2.38 6.65 2 7.28 2 8v10c0 1.1.9 2 2 2h16c1.1 0 2-.9 2-2l-.01-10zM12 13L3.74 7.84 12 3l8.26 4.84L12 13z")
     )
   }).buildU

   def apply() = component()
 }
