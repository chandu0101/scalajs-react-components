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
      <.div(
        <.h1("Spinner"),
        <.h2("Common Use Cases"),
        <.h3("Page Element"),
        Spinner(size = SpinnerSize.MD)(),
        Spinner(size = SpinnerSize.MD, `type` = SpinnerType.PRIMARY)(),
        Spinner(size = SpinnerSize.MD, `type` = SpinnerType.INVERTED)(),
        <.h3("Inside Buttons"),
        Button()(Spinner()()),
        Button(disabled = true)(Spinner(`type` = SpinnerType.PRIMARY)(), ("Saving")),
        Button(`type` = ButtonType.PRIMARY)(Spinner(`type` = SpinnerType.INVERTED)(), ("Submitting")),
        <.h3("Full Page Load"),
        Spinner(size = SpinnerSize.LG)())
    }).buildU
  def apply() = component()
}
