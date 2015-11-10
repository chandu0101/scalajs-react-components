
package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
  
case class MuiTextField(
	key:                    js.UndefOr[String]                   = js.undefined,
	ref:                    js.UndefOr[MuiTextFieldM => Unit]    = js.undefined,
	/*  The text string to use for the default value.*/
	defaultValue:           js.UndefOr[String]                   = js.undefined,
	/*  Disables the text field if set to true.*/
	disabled:               js.UndefOr[Boolean]                  = js.undefined,
	/*  The style object to use to override error styles.*/
	errorStyle:             js.UndefOr[CssProperties]            = js.undefined,
	/*  The error text string to display.*/
	errorText:              js.UndefOr[String]                   = js.undefined,
	/*  The style object to use to override floating label styles.*/
	floatingLabelStyle:     js.UndefOr[CssProperties]            = js.undefined,
	/*  The text string to use for the floating label element.*/
	floatingLabelText:      js.UndefOr[String]                   = js.undefined,
	/*  If true, the field receives the property width 100%.*/
	fullWidth:              js.UndefOr[Boolean]                  = js.undefined,
	/*  Override the inline-styles of the TextField's hint text element.*/
	hintStyle:              js.UndefOr[CssProperties]            = js.undefined,
	/*  The hint text string to display.*/
	hintText:               js.UndefOr[String]                   = js.undefined,
	/*  Override the inline-styles of the TextField's input element.*/
	inputStyle:             js.UndefOr[CssProperties]            = js.undefined,
	/* default: false: If true, a textarea element will be rendered. The textarea also grows and shrinks according to the number of lines.*/
	multiLine:              js.UndefOr[Boolean]                  = js.undefined,
	/*  The function to call when the user presses the Enter key.*/
	onEnterKeyDown:         js.UndefOr[js.Function]              = js.undefined,
	/* default: 1: Number of rows to display when multiLine option is set to true.*/
	rows:                   js.UndefOr[Int]                      = js.undefined,
	/* default: null: Maximum number of rows to display when multiLine option is set to true.*/
	rowsMax:                js.UndefOr[Int]                      = js.undefined,
	/*  Override the inline-styles of the TextField's root element.*/
	style:                  js.UndefOr[CssProperties]            = js.undefined,
	/*  Specifies the type of input to display such as "password" or "text".*/
	`type`:                 js.UndefOr[String]                   = js.undefined,
	/*  Override the inline-styles of the TextField's underline element when disabled.*/
	underlineDisabledStyle: js.UndefOr[CssProperties]            = js.undefined,
	/*  Override the inline-styles of the TextField's underline element when focussed.*/
	underlineFocusStyle:    js.UndefOr[CssProperties]            = js.undefined,
	/*  Override the inline-styles of the TextField's underline element.*/
	underlineStyle:         js.UndefOr[CssProperties]            = js.undefined,
	/* function(event): Callback function that is fired when the textfield losesfocus.*/
	onBlur:                 js.UndefOr[ReactEvent => Callback]   = js.undefined,
	/* function(event): Callback function that is fired when the textfield's value changes.*/
	onChange:               js.UndefOr[ReactEvent => Callback]   = js.undefined,
	/* function(event): Callback function that is fired when the textfield gains focus.*/
	onFocus:                js.UndefOr[ReactEvent => Callback]   = js.undefined)
{

  def apply() = {
    val props = JSMacro[MuiTextField](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.TextField)
    f(props).asInstanceOf[ReactComponentU_]
  }
}
    


@js.native
class MuiTextFieldM extends js.Object{
	/* TextField.blur(): Removes focus on the input element.*/
	def blur(): Unit = js.native

	/* TextField.clearValue(): Clears the value on the input element.*/
	def clearValue(): Unit = js.native

	/* TextField.focus(): Sets the focus on the input element.*/
	def focus(): Unit = js.native

	/* TextField.getValue(): Returns the value of the input.*/
	def getValue(): Unit = js.native

	/* TextField.setErrorText(newErrorText): Sets the error text on the input element.*/
	def setErrorText(): Unit = js.native

	/* TextField.setValue(newValue): Sets the value of the input element.*/
	def setValue(): Unit = js.native
}
