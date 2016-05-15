package demo.components.elementalui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.elementalui._
import demo.components.CodeExample
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.concurrent.duration._
import scala.scalajs.js
import scala.scalajs.js.Dynamic.{global => g}

object EuiFormsDemo {
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  val flavors = js.Array(
    SelectOption("Caramel", "caramel"),
    SelectOption("Chocolate", "chocolate"),
    SelectOption("Vanilla", "vanilla"),
    SelectOption("Strawberry", "strawberry")
  )

  case class State(searching: Boolean = false,
                   inputSelect: String = "",
                   inlineRadioGroup: String = "",
                   inputEmail: String = "",
                   inputPassword: String = "",
                   inputConfirmPassword: String = "",
                   files: scala.scalajs.js.Array[File] = scala.scalajs.js.Array())

  case class Backend($: BackendScope[Unit, State]) {
    def onDrop(files: scala.scalajs.js.Array[File]) = {
      scala.scalajs.js.Dynamic.global.alert(files)
      $.modState(_.copy(files = files))
    }

    def updateInlineRadios(value: String) =
      $.modState(_.copy(inlineRadioGroup = value))

    def updateSelect(value: String) =
      $.modState(_.copy(inputSelect = value))

    def updateEmail(e: ReactEventI) = {
      val value = e.target.value
      $.modState(_.copy(inputEmail = value))
    }

    def updatePassword(e: ReactEventI) = {
      val value = e.target.value
      $.modState(_.copy(inputPassword = value))
    }

    def updateConfirmPassword(e: ReactEventI) = {
      val value = e.target.value
      $.modState(_.copy(inputConfirmPassword = value))
    }

    def validateConfirm(password: String) = {
      $.state.map(_.inputPassword == password).runNow()
    }

    def handleSearch(e: ReactEventH) = {
      val result = $.modState(_.copy(searching = true))
      scala.scalajs.js.timers.setTimeout(2 seconds) {
        $.modState(_.copy(searching = false)).runNow()
      }
      result
    }
    val renderBasicExample =
      <.div(^.className := "code-example__example",
        Form()(
          FormField(label = "Email address", htmlFor = "basic-form-input-email")(
            FormInput(autofocus = true, `type` = "email", placeholder = "Enter email", name = "basic-form-input-email")()),
          FormField(label = "Password", htmlFor = "basic-form-input-password")(
            FormInput(autofocus = true, `type` = "password", placeholder = "Enter Password", name = "basic-form-input-password")()),
          FormField()(
            CheckBox(label = "Check It")()),
          Button()("Submit")))

    val renderBasicExampleHorizontal =
      <.div(^.className := "code-example__example",
        Form(`type` = FormType.HORIZONTAL)(
          FormField(label = "Email address", htmlFor = "horizontal-input-email")(
            FormInput(autofocus = true, `type` = "email", placeholder = "Enter email", name = "horizontal-input-email")()
          ),
          FormField(label = "Password", htmlFor = "horizontal-input-password")(
            FormInput(autofocus = true, `type` = "password", placeholder = "Enter Password", name = "horizontal-input-password")()
          ),
          FormField(offsetAbsentLabel = true)(
            CheckBox(label = "Check It")()
          ),
          FormField(offsetAbsentLabel = true)(
            Button()("Submit")
          )
        )
      )

    val renderBasicExampleInline =
      <.div(^.className := "code-example__example",
        Form(`type` = FormType.INLINE)(
          FormField(label = "Email address", htmlFor = "inline-input-email")(
            FormInput(autofocus = true, `type` = "email", placeholder = "Enter email", name = "inline-input-email")()
          ),
          FormField(label = "Password", htmlFor = "inline-input-password")(
            FormInput(autofocus = true, `type` = "password", placeholder = "Enter Password", name = "inline-input-password")()
          ),
          FormField()(
            CheckBox(label = "Check It")()
          ),
          FormField()(
            Button()("Submit")
          )
        )
      )

    val renderInputGroupsContiguous =
      <.div(
        InputGroup(contiguous = true)(
          InputGroup.Section(grow = true)(
            FormInput(`type` = "text", placeholder = "Input Group Field")()
          ),
          InputGroup.Section()(
            Button()("Button")
          )
        ),
        InputGroup(contiguous = true)(
          InputGroup.Section(`type` = "primary")(
            Button()(Glyph(icon = Octicons.pencil)())
          ),
          InputGroup.Section()(
            FormInput(`type` = "text", placeholder = "Input Group Field")()
          )
        )
      )

    val renderInputGroupsSeparate =
      <.div(
        InputGroup()(
          InputGroup.Section(grow = true)(
            FormInput(`type` = "text", placeholder = "Input Group Field")()
          ),
          InputGroup.Section()(
            Button()("Button"))
        ),
        InputGroup()(
          InputGroup.Section(`type` = "primary")(
            Button()(Glyph(icon = Octicons.pencil)())
          ),
          InputGroup.Section()(
            FormInput(`type` = "text", placeholder = "Input Group Field")()
          )
        )
      )

    val renderSizes =
      <.div(
        FormField(label = "Input", htmlFor = "supported-controls-input")(
          FormInput(placeholder = "Input", name = "supported-controls-input")()
        ),
        FormField(label = "Large Input", htmlFor = "supported-controls-input-lg")(
          FormInput(placeholder = "Input", name = "supported-controls-input-lg", size = FormInputSize.LG)()
        ),
        FormField(label = "Small Input", htmlFor = "supported-controls-input-sm")(
          FormInput(placeholder = "Input", name = "supported-controls-input-sm", size = FormInputSize.SM)()
        )
      )

    val renderSupportedControls =
      <.div(
        FormInput(placeholder = "Input")(),
        FormInput(placeholder = "TextArea", multiline = true)(),
        FormSelect(
          options = flavors,
          firstOption = "Select",
          onChange = updateSelect _)(),
        FormField(label = "Checkboxes")(
          CheckBox(label = "Check me out")(),
          CheckBox(label = "I'm disabled", disabled = true)()
        ),
        FormField(label = "Radios")(
          Radio(name = "default_radios", label = "Pick Me")(),
          Radio(name = "default_radios", label = "No, pick me!")()
        ),
        FormField(label = "Inline Checkboxes")(
          CheckBox(label = "Check me out", inline = true)(),
          CheckBox(label = "I'm disabled", disabled = true, inline = true)()
        ),
        FormField(label = "Inline Radios")(
          Radio(name = "default_radios", label = "Pick Me", inline = true)(),
          Radio(name = "default_radios", label = "No, pick me!", inline = true)()
        )
      )

    val renderNotes =
      FormField(label = "Input with Notes")(FormInput()(),
        FormNote()(
          "A note to help the user understand it's associated field, may extend beyond one line"
        ),
        FormNote(`type` = NoteType.WARNING)(
          "A warning to help the user understand it's associated field, may extend beyond one line"
        )
      )

    val renderComplexForms =
      <.div(
        FormRow()(
          FormField(
            width = FormFieldWidth.one_half,
            label = "Credit Card Number",
            htmlFor = "credit-card-number")(
            FormInput(
              pattern = "[0-9]",
              placeholder = "Card Number",
              name = "credit-card-number")()
          ),
          FormField(
            width = FormFieldWidth.one_quarter,
            label = "Expiration",
            htmlFor = "credit-card-expiration")(
            FormInput(
              placeholder = "MM/YYYY",
              name = "credit-card-expiration")()
          ),
          FormField(
            width = FormFieldWidth.one_quarter,
            label = "Security Code (CCV)",
            htmlFor = "credit-card-security")(
            FormInput(
              pattern = "[0-9]",
              placeholder = "123",
              name = "credit-card-security")()
          )
        ),
        FormRow()(
          FormField(
            width = FormFieldWidth.one_half,
            label = "First Name",
            htmlFor = "first-name")(
            FormInput(
              placeholder = "First Name",
              name = "first-name")()
          ),
          FormField(
            width = FormFieldWidth.one_half,
            label = "Last Name",
            htmlFor = "last-name")(
            FormInput(
              placeholder = "Last Name",
              name = "last-name")()
          )
        ),
        FormField(
          label = "Billing Address",
          htmlFor = "billing-address")(
          FormInput(
            placeholder = "Address Line 1",
            name = "address-street1")()
        ),
        FormField()(
          FormInput(
            placeholder = "Address Line 2",
            name = "address-street2")()
        ),
        FormRow()(
          FormField(width = FormFieldWidth.two_thirds)(
            FormInput(placeholder = "City", name = "city")()
          ),
          FormField(width = FormFieldWidth.one_third)(
            FormInput(placeholder = "State", name = "state")()
          ),
          FormField(width = FormFieldWidth.one_third)(
            FormInput(placeholder = "Postal Code", name = "postal-code")()
          ),
          FormField(width = FormFieldWidth.two_thirds)(
            FormSelect(options = js.Array(
              SelectOption("Esperantujo", "esperantujo"),
              SelectOption("Volapuko", "volapuko"),
              SelectOption("Usono", "usono")), firstOption = "Country", onChange = updateSelect _)()
          )
        )
      )

    def renderIcons(S: State) =
      <.div(
        <.h3("Alignment"),
        FormRow()(
          FormIconField(width = FormFieldWidth.one_half, iconPosition = FormIconFieldPosition.LEFT, iconColor = IconColorVariant.DEFAULT, iconKey = Octicons.star)(
            FormInput(placeholder = "Left Aligned", name = "icon-alignment-left")()
          ),
          FormIconField(width = FormFieldWidth.one_half, iconPosition = FormIconFieldPosition.RIGHT, iconColor = IconColorVariant.DEFAULT, iconKey = Octicons.star)(
            FormInput(placeholder = "Right Aligned", name = "icon-alignment-right")()
          )
        ),

        <.h3("Context Variants Color"),
        FormRow()(
          FormIconField(width = FormFieldWidth.one_fifth, iconColor = IconColorVariant.DEFAULT, iconKey = Octicons.star)(FormInput(placeholder = "default")()),
          FormIconField(width = FormFieldWidth.one_fifth, iconColor = IconColorVariant.PRIMARY, iconKey = Octicons.star)(FormInput(placeholder = "default")()),
          FormIconField(width = FormFieldWidth.one_fifth, iconColor = IconColorVariant.SUCCESS, iconKey = Octicons.star)(FormInput(placeholder = "default")()),
          FormIconField(width = FormFieldWidth.one_fifth, iconColor = IconColorVariant.WARNING, iconKey = Octicons.star)(FormInput(placeholder = "default")()),
          FormIconField(width = FormFieldWidth.one_fifth, iconColor = IconColorVariant.DANGER, iconKey = Octicons.star)(FormInput(placeholder = "default")())
        ),

        <.h3("Context Variants Fill"),
        FormRow()(
          FormIconField(width = FormFieldWidth.one_fifth, iconFill = IconColorVariant.DEFAULT, iconKey = Octicons.star)(FormInput(placeholder = "default")()),
          FormIconField(width = FormFieldWidth.one_fifth, iconFill = IconColorVariant.PRIMARY, iconKey = Octicons.star)(FormInput(placeholder = "default")()),
          FormIconField(width = FormFieldWidth.one_fifth, iconFill = IconColorVariant.SUCCESS, iconKey = Octicons.star)(FormInput(placeholder = "default")()),
          FormIconField(width = FormFieldWidth.one_fifth, iconFill = IconColorVariant.WARNING, iconKey = Octicons.star)(FormInput(placeholder = "default")()),
          FormIconField(width = FormFieldWidth.one_fifth, iconFill = IconColorVariant.DANGER, iconKey = Octicons.star)(FormInput(placeholder = "default")())
        ),

        <.h3("Loading Indicator"),
        FormIconField(iconPosition = FormIconFieldPosition.RIGHT, iconKey = Octicons.search, iconColor = IconColorVariant.DEFAULT, iconIsLoading = S.searching)(
          FormInput(
            onChange = handleSearch _,
            `type` = "search",
            placeholder = "Search...",
            name = "icon-form-search")()
        )
      )

    def renderValidation(S: State) =
      Form()(
        RadioGroup(
          label = "Radios",
          value = S.inlineRadioGroup,
          onChange = updateInlineRadios _,
          options = flavors,
          name = "inlineRadioGroup",
          required = true,
          inline = true)(),

        FormSelect(
          label = "Select",
          value = S.inputSelect,
          onChange = updateSelect _,
          options = flavors,
          required = true,
          prependEmptyOption = true)(),

        EmailInputGroup(label = "Email",
          value = S.inputEmail,
          onChange = updateEmail _,
          required = true)(),

        PasswordInputGroup(label = "Password",
          value = S.inputPassword,
          onChange = updatePassword _,
          required = true)(),

        PasswordInputGroup(label = "Confirm",
          value = S.inputConfirmPassword,
          onChange = updateConfirmPassword _,
          required = true,
          validatePassword = validateConfirm _,
          invalidMessage = "Password validation doesn't match password")()
      )

    def renderFileUpload(S: State) =
      Form(`type` = FormType.HORIZONTAL)(
        FormField(label = "Image")(
          FileUpload(
            buttonLabelInitial = "Upload Image",
            buttonLabelChange = "Change Image",
            accept = "image/jpg, image/gif, image/png")()
        ),
        FormField()(
          FileDragAndDrop(files = S.files, onDrop = onDrop _)()
        )
      )


    def render(S: State) =
      CodeExample(code, "EuiForms")(
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
          renderSupportedControls,
          <.h2("Notes"),
          renderNotes,
          <.h2("ComplexForms"),
          renderComplexForms,
          <.h2("Icons"),
          renderIcons(S),
          <.h2("Validation"),
          renderValidation(S),
          <.h2("File Upload"),
          renderFileUpload(S)
        )
      )
  }

  val component = ReactComponentB[Unit]("EuiFormsDemo")
    .initialState(State())
    .renderBackend[Backend]
    .build

  // EXAMPLE:END

  def apply() = component()
}
