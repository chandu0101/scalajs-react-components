package demo.components.elementalui

import chandu0101.scalajs.react.components.elementalui._
import demo.components.materialui.svgicons.ActionGrade
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import scalacss.Defaults._
import scalacss.ScalaCssReact._
import scalacss.mutable.StyleSheet.Inline

object EuiSpinnerDemo {
  val component = ReactComponentB[Unit]("EuiSpinnerDemo")
    .render(P ⇒ {
      <.p("")
    }).buildU
  def apply() = component()
}
