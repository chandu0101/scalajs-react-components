package demo.components.elementalui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.elementalui._
import demo.components.CodeExample
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

import scala.concurrent.duration._
import scala.scalajs.js
import scala.scalajs.js.Dynamic.{global => g}

object EuiFormsDemo {
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  val flavors = js.Array(
    FormSelectOption("Caramel", "caramel"),
    FormSelectOption("Chocolate", "chocolate"),
    FormSelectOption("Vanilla", "vanilla"),
    FormSelectOption("Strawberry", "strawberry")
  )

  case class State(
      searching: Boolean = false,
      inputSelect: String = "",
      inlineRadioGroup: String = "",
      inputEmail: String = "",
      inputPassword: String = "",
      inputConfirmPassword: String = "",
      files: scala.scalajs.js.Array[File] = scala.scalajs.js.Array()
  )

  val renderBasicExample =
    <.div(
      ^.className := "code-example__example",
      EuiForm()(
        EuiFormField(label = "Email address", htmlFor = "basic-form-input-email")(
          EuiFormInput(`type` = "email", name = "basic-form-input-email")()
        ),
        EuiFormField(label = "Password", htmlFor = "basic-form-input-password")(
          EuiFormInput(`type` = "password", name = "basic-form-input-password")()
        ),
        EuiFormField()(
          EuiCheckbox(label = "Check It")()
        ),
        EuiButton()("Submit")
      )
    )

  val renderBasicExampleHorizontal =
    <.div(
      ^.className := "code-example__example",
      EuiForm(`type` = FormType.horizontal)(
        EuiFormField(label = "Email address", htmlFor = "horizontal-input-email")(
          EuiFormInput(`type` = "email", name = "horizontal-input-email")()
        ),
        EuiFormField(label = "Password", htmlFor = "horizontal-input-password")(
          EuiFormInput(`type` = "password", name = "horizontal-input-password")()
        ),
        EuiFormField(offsetAbsentLabel = true)(
          EuiCheckbox(label = "Check It")()
        ),
        EuiFormField(offsetAbsentLabel = true)(
          EuiButton()("Submit")
        )
      )
    )

  val renderBasicExampleInline =
    <.div(
      ^.className := "code-example__example",
      EuiForm(`type` = FormType.inline)(
        EuiFormField(label = "Email address", htmlFor = "inline-input-email")(
          EuiFormInput(`type` = "email", name = "inline-input-email")()
        ),
        EuiFormField(label = "Password", htmlFor = "inline-input-password")(
          EuiFormInput(`type` = "password", name = "inline-input-password")()
        ),
        EuiFormField()(
          EuiCheckbox(label = "Check It")()
        ),
        EuiFormField()(
          EuiButton()("Submit")
        )
      )
    )

  val renderInputGroupsContiguous =
    <.div(
      EuiInputGroup(contiguous = true)(
        EuiInputGroupSection(grow = true)(
          EuiFormInput(`type` = "text")()
        ),
        EuiInputGroupSection()(
          EuiButton()("Button")
        )
      ),
      EuiInputGroup(contiguous = true)(
        EuiInputGroupSection()(
          EuiButton()(EuiGlyph(icon = Octicons.pencil)())
        ),
        EuiInputGroupSection()(
          EuiFormInput(`type` = "text")()
        )
      )
    )

  val renderInputGroupsSeparate =
    <.div(
      EuiInputGroup()(
        EuiInputGroupSection(grow = true)(
          EuiFormInput(`type` = "text")()
        ),
        EuiInputGroupSection()(
          EuiButton()("Button")
        )
      ),
      EuiInputGroup()(
        EuiInputGroupSection()(
          EuiButton()(EuiGlyph(icon = Octicons.pencil)())
        ),
        EuiInputGroupSection()(
          EuiFormInput(`type` = "text")()
        )
      )
    )

  val renderSizes =
    <.div(
      EuiFormField(label = "Input", htmlFor = "supported-controls-input")(
        EuiFormInput(name = "supported-controls-input")()
      ),
      EuiFormField(label = "Large Input", htmlFor = "supported-controls-input-lg")(
        EuiFormInput(name = "supported-controls-input-lg", size = LgSmXs.lg)()
      ),
      EuiFormField(label = "Small Input", htmlFor = "supported-controls-input-sm")(
        EuiFormInput(name = "supported-controls-input-sm", size = LgSmXs.sm)()
      )
    )

  val renderNotes =
    EuiFormField(label = "Input with Notes")(
      EuiFormInput()(),
      EuiFormNote()(
        "A note to help the user understand it's associated field, may extend beyond one line"
      ),
      EuiFormNote(`type` = NoteType.warning)(
        "A warning to help the user understand it's associated field, may extend beyond one line"
      )
    )

  case class Backend($ : BackendScope[Unit, State]) {
    def onDrop(files: scala.scalajs.js.Array[File]) = {
      scala.scalajs.js.Dynamic.global.alert(files)
      $.modState(_.copy(files = files))
    }

    def updateInlineRadios(value: String) =
      $.modState(_.copy(inlineRadioGroup = value))

    def updateSelect(value: String) =
      $.modState(_.copy(inputSelect = value))

    def updateEmail(e: ReactEventFromInput) = {
      val value = e.target.value
      $.modState(_.copy(inputEmail = value))
    }

    def updatePassword(e: ReactEventFromInput) = {
      val value = e.target.value
      $.modState(_.copy(inputPassword = value))
    }

    def updateConfirmPassword(e: ReactEventFromInput) = {
      val value = e.target.value
      $.modState(_.copy(inputConfirmPassword = value))
    }

    def validateConfirm(password: String) = {
      $.state.map(_.inputPassword == password)
    }

    def handleSearch(e: ReactEventFromHtml) = {
      val result = $.modState(_.copy(searching = true))
      scala.scalajs.js.timers.setTimeout(2 seconds) {
        $.modState(_.copy(searching = false)).runNow()
      }
      result
    }

    val renderSupportedControls =
      <.div(
        EuiFormInput()(),
        EuiFormInput(multiline = true)(),
        EuiFormSelect(
          options = flavors,
          firstOption = "Select",
          onChange = updateSelect _
        )(),
        EuiFormField(label = "Checkboxes")(
          EuiCheckbox(label = "Check me out")(),
          EuiCheckbox(label = "I'm disabled", disabled = true)()
        ),
        EuiFormField(label = "Radios")(
          EuiRadio(label = "Pick Me")(),
          EuiRadio(label = "No, pick me!")()
        ),
        EuiFormField(label = "Inline Checkboxes", className = "inline-controls")(
          EuiCheckbox(label = "Check me out")(),
          EuiCheckbox(label = "I'm disabled", disabled = true)()
        ),
        EuiFormField(label = "Inline Radios", className = "inline-controls")(
          EuiRadio(label = "Pick Me")(),
          EuiRadio(label = "No, pick me!")()
        )
      )

    val renderComplexForms =
      <.div(
        EuiFormRow()(
          EuiFormField(
            width = FormFieldWidth.one_half,
            label = "Credit Card Number",
            htmlFor = "credit-card-number"
          )(
            EuiFormInput(
              pattern = "[0-9]",
              name = "credit-card-number"
            )()
          ),
          EuiFormField(
            width = FormFieldWidth.one_quarter,
            label = "Expiration",
            htmlFor = "credit-card-expiration"
          )(
            EuiFormInput(
              name = "credit-card-expiration"
            )()
          ),
          EuiFormField(
            width = FormFieldWidth.one_quarter,
            label = "Security Code (CCV)",
            htmlFor = "credit-card-security"
          )(
            EuiFormInput(
              pattern = "[0-9]",
              name = "credit-card-security"
            )()
          )
        ),
        EuiFormRow()(
          EuiFormField(
            width = FormFieldWidth.one_half,
            label = "First Name",
            htmlFor = "first-name"
          )(
            EuiFormInput(
              name = "first-name"
            )()
          ),
          EuiFormField(
            width = FormFieldWidth.one_half,
            label = "Last Name",
            htmlFor = "last-name"
          )(
            EuiFormInput(
              name = "last-name"
            )()
          )
        ),
        EuiFormField(
          label = "Billing Address",
          htmlFor = "billing-address"
        )(
          EuiFormInput(
            name = "address-street1"
          )()
        ),
        EuiFormField()(
          EuiFormInput(
            name = "address-street2"
          )()
        ),
        EuiFormRow()(
          EuiFormField(width = FormFieldWidth.two_thirds)(
            EuiFormInput(name = "city")()
          ),
          EuiFormField(width = FormFieldWidth.one_third)(
            EuiFormInput(name = "state")()
          ),
          EuiFormField(width = FormFieldWidth.one_third)(
            EuiFormInput(name = "postal-code")()
          ),
          EuiFormField(width = FormFieldWidth.two_thirds)(
            EuiFormSelect(
              options = js.Array(
                FormSelectOption("Esperantujo", "esperantujo"),
                FormSelectOption("Volapuko", "volapuko"),
                FormSelectOption("Usono", "usono")
              ),
              firstOption = "Country",
              onChange = updateSelect _
            )()
          )
        )
      )

    def renderValidation(S: State) =
      EuiForm()(
        EuiRadioGroup(
          label = "Radios",
          value = S.inlineRadioGroup,
          onChange = updateInlineRadios _,
          options = flavors.map(_.asInstanceOf[js.Object]),
          required = true
        )(),
        EuiFormSelect(
          label = "Select",
          value = S.inputSelect,
          onChange = updateSelect _,
          options = flavors,
          required = true,
          prependEmptyOption = true
        )(),
        EuiEmailInputGroup(
          label = "Email",
          value = S.inputEmail,
          onChange = js.defined(updateEmail _),
          required = true
        )(),
        EuiPasswordInputGroup(
          label = "Password",
          value = S.inputPassword,
          onChange = js.defined(updatePassword _),
          required = true
        )(),
        EuiPasswordInputGroup(
          label = "Confirm",
          value = S.inputConfirmPassword,
          onChange = js.defined(updateConfirmPassword _),
          required = true,
          validatePassword = js.defined(validateConfirm _),
          invalidMessage = "Password validation doesn't match password"
        )()
      )

    def renderIcons(S: State) =
      <.div(
        <.h3("Alignment"),
        EuiFormRow()(
          EuiFormIconField(width = FormFieldWidth.one_half,
                           iconPosition = LeftRight.left,
                           iconColor = ColorVariant.default,
                           iconKey = Octicons.star)(
            EuiFormInput(name = "icon-alignment-left")()
          ),
          EuiFormIconField(width = FormFieldWidth.one_half,
                           iconPosition = LeftRight.right,
                           iconColor = ColorVariant.default,
                           iconKey = Octicons.star)(
            EuiFormInput(name = "icon-alignment-right")()
          )
        ),
        <.h3("Context Variants Color"),
        EuiFormRow()(
          EuiFormIconField(width = FormFieldWidth.one_fifth,
                           iconColor = ColorVariant.default,
                           iconKey = Octicons.star)(EuiFormInput()()),
          EuiFormIconField(width = FormFieldWidth.one_fifth,
                           iconColor = ColorVariant.primary,
                           iconKey = Octicons.star)(EuiFormInput()()),
          EuiFormIconField(width = FormFieldWidth.one_fifth,
                           iconColor = ColorVariant.success,
                           iconKey = Octicons.star)(EuiFormInput()()),
          EuiFormIconField(width = FormFieldWidth.one_fifth,
                           iconColor = ColorVariant.warning,
                           iconKey = Octicons.star)(EuiFormInput()()),
          EuiFormIconField(width = FormFieldWidth.one_fifth,
                           iconColor = ColorVariant.danger,
                           iconKey = Octicons.star)(EuiFormInput()())
        ),
        <.h3("Context Variants Fill"),
        EuiFormRow()(
          EuiFormIconField(width = FormFieldWidth.one_fifth,
                           iconFill = ColorVariant.default,
                           iconKey = Octicons.star)(EuiFormInput()()),
          EuiFormIconField(width = FormFieldWidth.one_fifth,
                           iconFill = ColorVariant.primary,
                           iconKey = Octicons.star)(EuiFormInput()()),
          EuiFormIconField(width = FormFieldWidth.one_fifth,
                           iconFill = ColorVariant.success,
                           iconKey = Octicons.star)(EuiFormInput()()),
          EuiFormIconField(width = FormFieldWidth.one_fifth,
                           iconFill = ColorVariant.warning,
                           iconKey = Octicons.star)(EuiFormInput()()),
          EuiFormIconField(width = FormFieldWidth.one_fifth,
                           iconFill = ColorVariant.danger,
                           iconKey = Octicons.star)(EuiFormInput()())
        ),
        <.h3("Loading Indicator"),
        EuiFormIconField(iconPosition = LeftRight.right,
                         iconKey = Octicons.search,
                         iconColor = ColorVariant.default,
                         iconIsLoading = S.searching)(
          EuiFormInput(
            onChange = js.defined(handleSearch _),
            `type` = "search",
            name = "icon-form-search"
          )()
        )
      )

    def renderFileUpload(S: State) =
      EuiForm(`type` = FormType.horizontal)(
        EuiFormField(label = "Image")(
          EuiFileUpload(
            buttonLabelInitial = "Upload Image",
            buttonLabelChange = "Change Image",
            accept = "image/jpg, image/gif, image/png"
          )()
        ),
        EuiFormField()(
          EuiDropzone( /*files = S.files, */ onDrop = onDrop _)()
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

  val component = ScalaComponent
    .builder[Unit]("EuiFormsDemo")
    .initialState(State())
    .renderBackend[Backend]
    .build

  // EXAMPLE:END

  def apply() = component()
}
