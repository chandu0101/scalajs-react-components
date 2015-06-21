package chandu0101.scalajs.react.components.demo.components.materialui

import chandu0101.scalajs.react.components.demo.components.InfoTemplate
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

  val component = ReactComponentB[Unit]("MuiInfo")
    .render(P => {
    InfoTemplate(componentFilePath = "materialui/package.scala")(
      <.h3("Material-ui :"),
      <.p("port wrapper")
    )

  }).buildU

  def apply() = component()
}
