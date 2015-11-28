
package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
  
case class MuiDatePicker(
	key:                   js.UndefOr[String]                                       = js.undefined,
	ref:                   js.UndefOr[MuiDatePickerM => Unit]                       = js.undefined,
	/* default: custom function defined inside utils/date-time.js that only supports en-US locale: Constructor for time formatting. Follow this specificaction: ECMAScript Internationalization API 1.0 (ECMA-402).*/
	DateTimeFormat:        js.UndefOr[js.Function]                                  = js.undefined,
	/* default: false: If true, automatically accept and close the picker on select a date.*/
	autoOk:                js.UndefOr[Boolean]                                      = js.undefined,
	/* default: dialog: Used to control how the DatePicker will be displayed when a user tries to set a date. `dialog` (default) displays the DatePicker as a dialog with a modal. `inline` displays the DatePicker below the input field (similar to auto complete)*/
	container:             js.UndefOr[MuiDatePickerContainer]                       = js.undefined,
	/*  This is the initial date value of the component. If either `value` or `valueLink` is provided they will override this prop with `value` taking precedence.*/
	defaultDate:           js.UndefOr[js.Date]                                      = js.undefined,
	/*  If true, year selection will be disabled, otherwise, year selection will be enabled.*/
	disableYearSelection:  js.UndefOr[Boolean]                                      = js.undefined,
	/*  The text string to use for the floating label element.*/
	floatingLabelText:     js.UndefOr[String]                                       = js.undefined,
	/* default: formats to M/D/YYYY: This function is called to format the date to display in the input box. By default, date objects are formatted to M/D/YYYY.*/
	formatDate:            js.UndefOr[js.Date => String]                            = js.undefined,
	/*  The hint text string to display. Note, floatingLabelText will overide this.*/
	hintText:              js.UndefOr[String]                                       = js.undefined,
	/* default: en-US: Locale used for formatting date. If you are not using the default value, you have to provide a DateTimeFormat that supports it. You can use Intl.DateTimeFormat if it's supported by your environment. https://github.com/andyearnshaw/Intl.js is a good polyfill.*/
	locale:                js.UndefOr[String]                                       = js.undefined,
	/*  The ending of a range of valid dates. The range includes the endDate. The default value is current date + 100 years.*/
	maxDate:               js.UndefOr[js.Date]                                      = js.undefined,
	/*  The beginning of a range of valid dates. The range includes the startDate. The default value is current date - 100 years.*/
	minDate:               js.UndefOr[js.Date]                                      = js.undefined,
	/* default: portrait: Tells the component to display the picker in portrait or landscape mode.*/
	mode:                  js.UndefOr[MuiDatePickerMode]                            = js.undefined,
	/*  Called during render time of a given day. If this method returns false the day is disabled otherwise it is displayed normally.*/
	shouldDisableDate:     js.UndefOr[js.Date => Boolean]                           = js.undefined,
	/*  Override the inline-styles of DatePicker's root element.*/
	style:                 js.UndefOr[CssProperties]                                = js.undefined,
	/*  Override the inline-styles of DatePicker's TextField element.*/
	textFieldStyle:        js.UndefOr[CssProperties]                                = js.undefined,
	/* default: {ok: 'OK', cancel: 'Cancel' }: Wordings used inside the button of the dialog.*/
	wordings:              js.UndefOr[Wordings]                                     = js.undefined,
	/* function(null, date): Callback function that is fired when the date value changes. Since there is no particular event associated with the change the first argument will always be null and the second argument will be the new Date instance.*/
	onChange:              js.UndefOr[(js.UndefOr[Nothing], js.Date) => Callback]   = js.undefined,
	/* function(): Fired when the datepicker dialog is dismissed.*/
	onDismiss:             js.UndefOr[Callback]                                     = js.undefined,
	/* function(event): Callback function that is fired when the datepicker field gains focus.*/
	onFocus:               js.UndefOr[ReactFocusEventH => Callback]                 = js.undefined,
	/* function(): Fired when the datepicker dialog is shown.*/
	onShow:                js.UndefOr[Callback]                                     = js.undefined,
	hideToolbarYearChange: js.UndefOr[Boolean]                                      = js.undefined,
	onTouchTap:            js.UndefOr[ReactTouchEventH => Callback]                 = js.undefined,
	value:                 js.UndefOr[js.Object]                                    = js.undefined,
	showYearSelector:      js.UndefOr[Boolean]                                      = js.undefined)
{

  def apply() = {
    val props = JSMacro[MuiDatePicker](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.DatePicker)
    f(props).asInstanceOf[ReactComponentU_]
  }
}
    

case class Wordings(ok: String, cancel: String){
  val toJS = JSMacro[Wordings](this)
}

      


class MuiDatePickerContainer(val value: String) extends AnyVal
object MuiDatePickerContainer{
	val DIALOG = new MuiDatePickerContainer("dialog")
	val INLINE = new MuiDatePickerContainer("inline")
	val values = List(DIALOG, INLINE)
}


class MuiDatePickerMode(val value: String) extends AnyVal
object MuiDatePickerMode{
	val PORTRAIT = new MuiDatePickerMode("portrait")
	val LANDSCAPE = new MuiDatePickerMode("landscape")
	val values = List(PORTRAIT, LANDSCAPE)
}


@js.native
class MuiDatePickerM extends js.Object{
	/* DatePicker.getDate(): Returns the current date value.*/
	def getDate(): js.Date = js.native

	/* DatePicker.setDate(d): Sets the date value to d, where d is a date object.*/
	def setDate(value: js.Date): Unit = js.native

	/* DatePicker.openDialog(): Opens the date-picker dialog programmatically. Use this if you want to open the dialog in response to some event other than focus/tap on the input field, such as an external button click.*/
	def openDialog(): Unit = js.native

	/* DatePicker.focus(): An alias for the `openDialog()` method to allow more generic use alongside `TextField`.*/
	def focus(): Unit = js.native
}
