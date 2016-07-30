package demo.components

import japgolly.scalajs.react._

import scalacss.Defaults._

object ReactSlickInfo {

   object Style extends StyleSheet.Inline {
       import dsl._
       val content = style(textAlign.center,
         fontSize(30.px),
         paddingTop(40.px))
     }

  val component = ReactComponentB[Unit]("SlickInfo")
    .render(P => {
    InfoTemplate(componentFilePath = "reactslick/ReactSlick.scala")()

    }).build

  def apply() = component()
}
