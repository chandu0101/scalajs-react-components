package demo.components.elementalui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.elementalui._
import demo.components.CodeExample
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object EuiSpinnerDemo {
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  val component = ScalaComponent
    .builder[Unit]("EuiSpinnerDemo")
    .render(
      P =>
        CodeExample(code, "EuiSpinner")(
          <.div(
            <.h1("Spinner"),
            <.h2("Common Use Cases"),
            <.h3("Page Element"),
            EuiSpinner(size = SmMdLg.md)(),
            EuiSpinner(size = SmMdLg.md, `type` = DefaultPrimaryInverted.primary)(),
            EuiSpinner(size = SmMdLg.md, `type` = DefaultPrimaryInverted.inverted)(),
            <.h3("Inside Buttons"),
            EuiButton()(EuiSpinner()()),
            EuiButton(disabled = true)(EuiSpinner(`type` = DefaultPrimaryInverted.primary)(),
                                       "Saving"),
            EuiButton(`type` = ButtonType.primary)(
              EuiSpinner(`type` = DefaultPrimaryInverted.inverted)(),
              ("Submitting")),
            <.h3("Full Page Load"),
            EuiSpinner(size = SmMdLg.lg)()
          )
      ))
    .build

  // EXAMPLE:END

  def apply() = component()
}
