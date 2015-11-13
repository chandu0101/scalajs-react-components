package demo.components.elementalui

import chandu0101.scalajs.react.components.elementalui._
import demo.components.materialui.svgicons.ActionGrade
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import scalacss.Defaults._
import scalacss.ScalaCssReact._
import scalacss.mutable.StyleSheet.Inline
import scala.scalajs.js.{ Array ⇒ JArray }

object EuiFormsDemo {
  val component = ReactComponentB[Unit]("EuiFormsDemo")
    .render(P ⇒ {
      def renderBasicExample = {
        <.div(^.className := "code-example__example",
          Form()(
            FormField(label = "Email address", htmlFor = "basic-form-input-email")(
              FormInput(autofocus = true, `type` = "email", placeholder = "Enter email", name = "basic-form-input-email")()),
            FormField(label = "Password", htmlFor = "basic-form-input-password")(
              FormInput(autofocus = true, `type` = "password", placeholder = "Enter Password", name = "basic-form-input-password")()),
            FormField()(
              CheckBox(label = "Check It")()),
            Button()("Submit")))
      }
      def renderBasicExampleHorizontal = {
        <.div(^.className := "code-example__example",
          Form(`type` = FormType.HORIZONTAL)(
            FormField(label = "Email address", htmlFor = "horizontal-input-email")(
              FormInput(autofocus = true, `type` = "email", placeholder = "Enter email", name = "horizontal-input-email")()),
            FormField(label = "Password", htmlFor = "horizontal-input-password")(
              FormInput(autofocus = true, `type` = "password", placeholder = "Enter Password", name = "horizontal-input-password")()),
            FormField(offsetAbsentLabel = true)(
              CheckBox(label = "Check It")()),
            FormField(offsetAbsentLabel = true)(
              Button()("Submit"))))
      }
      def renderBasicExampleInline = {
        <.div(^.className := "code-example__example",
          Form(`type` = FormType.INLINE)(
            FormField(label = "Email address", htmlFor = "inline-input-email")(
              FormInput(autofocus = true, `type` = "email", placeholder = "Enter email", name = "inline-input-email")()),
            FormField(label = "Password", htmlFor = "inline-input-password")(
              FormInput(autofocus = true, `type` = "password", placeholder = "Enter Password", name = "inline-input-password")()),
            FormField()(
              CheckBox(label = "Check It")()),
            FormField()(
              Button()("Submit"))))
      }

      def renderInputGroupsContiguous = {
        <.div(
          InputGroup(contiguous = true)(
            InputGroup.Section(grow = true)(FormInput(`type` = "text", placeholder = "Input Group Field")()),
            InputGroup.Section()(Button()("Button"))),
          InputGroup(contiguous = true)(
            InputGroup.Section(`type` = "primary")(Button()(Glyph(icon = Octicons.pencil)())),
            InputGroup.Section()(FormInput(`type` = "text", placeholder = "Input Group Field")())))
      }
      def renderInputGroupsSeparate = {
        <.div(
          InputGroup()(
            InputGroup.Section(grow = true)(FormInput(`type` = "text", placeholder = "Input Group Field")()),
            InputGroup.Section()(Button()("Button"))),
          InputGroup()(
            InputGroup.Section(`type` = "primary")(Button()(Glyph(icon = Octicons.pencil)())),
            InputGroup.Section()(FormInput(`type` = "text", placeholder = "Input Group Field")())))
      }
      def renderSizes = {
        <.div(
          FormField(label = "Input", htmlFor = "supported-controls-input")(
            FormInput(placeholder = "Input", name = "supported-controls-input")()),
          FormField(label = "Large Input", htmlFor = "supported-controls-input-lg")(
            FormInput(placeholder = "Input", name = "supported-controls-input-lg", size = FormInputSize.LG)()),
          FormField(label = "Small Input", htmlFor = "supported-controls-input-sm")(
            FormInput(placeholder = "Input", name = "supported-controls-input-sm", size = FormInputSize.SM)()))
      }

      //      def updateSelect(e: ReactEventI) = {
      //        val value = e.target.value
      //        $.modState(_.copy(releaseName = Some(value)))
      //      }

      def renderSupportedControls = {
        <.div(
          FormInput(placeholder = "Input")(),
          FormInput(placeholder = "TextArea", multiline = true)(),
          FormSelect(options = JArray(
            FormSelect.Option("Caramel", "caramel"),
            FormSelect.Option("Chocolate", "chocolate"),
            FormSelect.Option("Vanilla", "vanilla"),
            FormSelect.Option("Strawberry", "strawberry")), firstOption = "Select")())
      }

      <.div(
        <.h1("Forms"),
        <.h2("Basic Example"),
        renderBasicExample,
        <.h2("Horizontal Form"),
        renderBasicExampleHorizontal,
        <.h2("Inline Form"),
        renderBasicExampleInline,
        <.h2("Input Groups"),
        <.h3("Contiguous Form Elements"),
        renderInputGroupsContiguous,
        <.h3("Separate When Required"),
        renderInputGroupsSeparate,
        <.h2("Sizes"),
        renderSizes,
        <.h2("Supported Controls"),
        renderSupportedControls)

    }).buildU
  def apply() = component()
}
