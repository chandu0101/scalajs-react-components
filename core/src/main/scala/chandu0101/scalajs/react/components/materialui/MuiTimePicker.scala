
package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
  
case class MuiTimePicker(
	key:               js.UndefOr[String]                                       = js.undefined,
	ref:               js.UndefOr[MuiTimePickerM => Unit]                       = js.undefined,
	/* default: false: If true, automatically accept and close the picker on set minutes.*/
	autoOk:            js.UndefOr[Boolean]                                      = js.undefined,
	/*  This is the initial time value of the component.*/
	defaultTime:       js.UndefOr[js.Date]                                      = js.undefined,
	/*  The text string to use for the floating label element.*/
	floatingLabelText: js.UndefOr[String]                                       = js.undefined,
	/* default: ampm: Tells the component to display the picker in ampm (12hr) format or 24hr format.*/
	format:            js.UndefOr[MuiTimePickerFormat]                          = js.undefined,
	/*  The hint text string to display. Note, floatingLabelText will overide this.*/
	hintText:          js.UndefOr[String]                                       = js.undefined,
	/* default: false: It's technically more correct to refer to "12 noon" and "12 midnight" rather than "12 a.m." and "12 p.m." and it avoids real confusion between different locales. By default (for compatibility reasons) TimePicker uses (12 a.m./12 p.m.) To use (noon/midnight) set pedantic={true}.*/
	pedantic:          js.UndefOr[Boolean]                                      = js.undefined,
	/*  Override the inline-styles of TimePicker's root element.*/
	style:             js.UndefOr[CssProperties]                                = js.undefined,
	/*  Override the inline-styles of TimePicker's TextField element.*/
	textFieldStyle:    js.UndefOr[CssProperties]                                = js.undefined,
	/* function(null, time): Callback function that is fired when the time value changes. The time value is passed in a Date Object.Since there is no particular event associated with the change the first argument will always be null and the second argument will be the new Date instance.*/
	onChange:          js.UndefOr[(js.UndefOr[Nothing], js.Date) => Callback]   = js.undefined,
	/* function(): Fired when the timepicker dialog is dismissed.*/
	onDismiss:         js.UndefOr[Callback]                                     = js.undefined,
	/* function(event): Callback function that is fired when the timepicker field gains focus.*/
	onFocus:           js.UndefOr[ReactEvent => Callback]                       = js.undefined,
	/* function(): Fired when the timepicker dialog is shown.*/
	onShow:            js.UndefOr[Callback]                                     = js.undefined)
{

  def apply() = {
    val props = JSMacro[MuiTimePicker](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.TimePicker)
    f(props).asInstanceOf[ReactComponentU_]
  }
}
    


class MuiTimePickerFormat(val value: String) extends AnyVal
object MuiTimePickerFormat{
	val AMPM = new MuiTimePickerFormat("ampm")
	val _24HR = new MuiTimePickerFormat("24hr")
	val values = List(AMPM, _24HR)
}


@js.native
class MuiTimePickerM extends js.Object{
	/* TimePicker.getTime(): Returns the current time value.*/
	def getTime(): js.Date = js.native

	/* TimePicker.setTime(t): Sets the time value to t, where t is a date object.*/
	def setTime(value: js.Date): Unit = js.native

	/* TimePicker.formatTime(time): Formats the Date object to a current component's time format.*/
	def formatTime(value: js.Date): String = js.native

	/* TimePicker.openDialog(): Opens the time-picker dialog programmatically. Use this if you want to open the dialog in response to some event other than focus/tap on the input field, such as an external button click.*/
	def openDialog(): Unit = js.native

	/* TimePicker.focus(): An alias for the `openDialog()` method to allow more generic use alongside `TextField`.*/
	def focus(): Unit = js.native
}
