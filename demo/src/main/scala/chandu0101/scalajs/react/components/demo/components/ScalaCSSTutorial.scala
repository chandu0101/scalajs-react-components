package chandu0101.scalajs.react.components.demo.components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scalacss.Defaults._
import scalacss.ScalaCssReact._

object ScalaCSSTutorial {

  object Style extends StyleSheet.Inline {

    import dsl._
    val content = style(textAlign.center,
      fontSize(30.px),
      paddingTop(40.px))
  }

  val component = ReactComponentB.static("ScalaCSSTutorial",
    <.div(Style.content, "Item 1 ")
  ).buildU

  def apply() = component()

}
