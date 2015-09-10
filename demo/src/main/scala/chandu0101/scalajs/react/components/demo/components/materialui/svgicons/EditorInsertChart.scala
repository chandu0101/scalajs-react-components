package chandu0101.scalajs.react.components
package demo.components.materialui.svgicons

import chandu0101.scalajs.react.components.materialui.MuiSvgIcon
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

object EditorInsertChart {


   val component = ReactComponentB[Unit]("EditorInsertChart")
     .render(P => {
     MuiSvgIcon()(
       <.svg.path(^.key := "acg", ^.svg.d := "M19 3H5c-1.1 0-2 .9-2 2v14c0 1.1.9 2 2 2h14c1.1 0 2-.9 2-2V5c0-1.1-.9-2-2-2zM9 17H7v-7h2v7zm4 0h-2V7h2v10zm4 0h-2v-4h2v4z")
     )
   }).buildU

   def apply() = component()
 }
