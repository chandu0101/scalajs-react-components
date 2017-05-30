package demo.components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

import scalacss.ProdDefaults._

object ReactSlickInfo {

  object Style extends StyleSheet.Inline {
    import dsl._
    val content = style(
      textAlign.center,
      fontSize(30.px),
      paddingTop(40.px)
    )
  }

  val component = ScalaComponent
    .builder[Unit]("SlickInfo")
    .renderStatic(InfoTemplate(componentFilePath = "reactslick/ReactSlick.scala")())
    .build

  def apply() = component()
}
