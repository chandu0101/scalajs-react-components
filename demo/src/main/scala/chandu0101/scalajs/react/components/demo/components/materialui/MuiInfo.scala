package chandu0101.scalajs.react.components.demo.components.materialui

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import scala.scalajs.js
import scalacss.Defaults._
import scalacss.ScalaCssReact._
object MuiInfo {

   object Style extends StyleSheet.Inline {
       import dsl._
       val content = style(textAlign.center,
         fontSize(30.px),
         paddingTop(40.px))
     }

     val component = ReactComponentB.static("MuiInfo",
       <.div(Style.content, "Material ui wrappper ")
     ).buildU

     def apply() = component()
}
