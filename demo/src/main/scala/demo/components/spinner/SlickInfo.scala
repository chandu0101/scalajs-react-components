package demo.components.spinner

import demo.components._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scalacss.Defaults._

object SlickInfo {

   object Style extends StyleSheet.Inline {
       import dsl._
       val content = style(textAlign.center,
         fontSize(30.px),
         paddingTop(40.px))
     }

  val component = ReactComponentB[Unit]("SlickInfo")
    .render(P => {
    InfoTemplate(componentFilePath = "reactslick/ReactSlick.scala")()

    }).buildU

  def apply() = component()
}
