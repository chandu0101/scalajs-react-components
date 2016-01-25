package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiDatePicker(
  key:                    js.UndefOr[String]                                     = js.undefined,
  ref:                    js.UndefOr[MuiDatePickerM => Unit]                     = js.undefined,
  /* Constructor for time formatting.
Follow this specificaction: ECMAScript Internationalization API 1.0 (ECMA-402).*/
  DateTimeFormat:         js.UndefOr[js.Function]                                = js.undefined,
  /* If true, automatically accept and close the picker on select a date.*/
  autoOk:                 js.UndefOr[Boolean]                                    = js.undefined,
  /* Used to control how the DatePicker will be displayed when a user tries to set a date.
`dialog` (default) displays the DatePicker as a dialog with a modal.
`inline` displays the DatePicker below the input field (similar to auto complete).*/
  container:              js.UndefOr[DialogInline]                               = js.undefined,
  /* This is the initial date value of the component.
If either `value` or `valueLink` is provided they will override this
prop with `value` taking precedence.*/
  defaultDate:            js.UndefOr[js.Date]                                    = js.undefined,
  /* Disables the year selection in the date picker.*/
  disableYearSelection:   js.UndefOr[Boolean]                                    = js.undefined,
  /* Used to change the first day of week. It drastically varies from
Saturday to Monday (could even be Friday) between different locales.
The allowed range is 0 (Sunday) to 6 (Saturday).*/
  firstDayOfWeek:         js.UndefOr[Double]                                     = js.undefined,
  /* This function is called to format the date to display in the input box.
By default, date objects are formatted to MM/DD/YYYY.*/
  formatDate:             js.UndefOr[js.Date => String]                          = js.undefined,
  /* Locale used for formatting date. If you are not using the default value, you
have to provide a DateTimeFormat that supports it. You can use Intl.DateTimeFormat
if it's supported by your environment.
https:github.com/andyearnshaw/Intl.js is a good polyfill.*/
  locale:                 js.UndefOr[String]                                     = js.undefined,
  /* The ending of a range of valid dates. The range includes the endDate.
The default value is current date + 100 years.*/
  maxDate:                js.UndefOr[js.Date]                                    = js.undefined,
  /* The beginning of a range of valid dates. The range includes the startDate.
The default value is current date - 100 years.*/
  minDate:                js.UndefOr[js.Date]                                    = js.undefined,
  /* Tells the component to display the picker in portrait or landscape mode.*/
  mode:                   js.UndefOr[PortraitLandscape]                          = js.undefined,
  /* Callback function that is fired when the date value changes. Since there
is no particular event associated with the change the first argument
will always be null and the second argument will be the new Date instance.*/
  onChange:               js.UndefOr[(js.UndefOr[Nothing], js.Date) => Callback] = js.undefined,
  /* Fired when the datepicker dialog is dismissed.*/
  onDismiss:              js.UndefOr[Callback]                                   = js.undefined,
  /* Callback function that is fired when the datepicker field gains focus.*/
  onFocus:                js.UndefOr[ReactFocusEventH => Callback]               = js.undefined,
  /* Fired when the datepicker dialog is shown.*/
  onShow:                 js.UndefOr[Callback]                                   = js.undefined,
  /* Called when touch tap event occurs on text-field.*/
  onTouchTap:             js.UndefOr[ReactTouchEventH => Callback]               = js.undefined,
  /* Called during render time of a given day. If this method returns
false the day is disabled otherwise it is displayed normally.*/
  shouldDisableDate:      js.UndefOr[js.Date => Boolean]                         = js.undefined,
  /* Enables the year selection in the date picker.*/
  @deprecated("Instead, use disableYearSelection.")
  showYearSelector:       js.UndefOr[Boolean]                                    = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:                  js.UndefOr[CssProperties]                              = js.undefined,
  /* Override the inline-styles of DatePicker's TextField element.*/
  textFieldStyle:         js.UndefOr[CssProperties]                              = js.undefined,
  /* Sets the date for the Date Picker programmatically.*/
  value:                  js.UndefOr[js.Date]                                    = js.undefined,
  /* Creates a ValueLink with the value of date picker.*/
  valueLink:              js.UndefOr[js.Any]                                     = js.undefined,
  /* Wordings used inside the button of the dialog.*/
  wordings:               js.UndefOr[Wordings]                                   = js.undefined,
  /* The css class name of the root element.
  (Passed on to TextField)*/
  className:              js.UndefOr[String]                                     = js.undefined,
  /* The text string to use for the default value.
  (Passed on to TextField)*/
  defaultValue:           js.UndefOr[String]                                     = js.undefined,
  /* Disables the text field if set to true.
  (Passed on to TextField)*/
  disabled:               js.UndefOr[Boolean]                                    = js.undefined,
  /* The style object to use to override error styles.
  (Passed on to TextField)*/
  errorStyle:             js.UndefOr[CssProperties]                              = js.undefined,
  /* The error content to display.
  (Passed on to TextField)*/
  errorText:              js.UndefOr[ReactNode]                                  = js.undefined,
  /* The style object to use to override floating label styles.
  (Passed on to TextField)*/
  floatingLabelStyle:     js.UndefOr[CssProperties]                              = js.undefined,
  /* The content to use for the floating label element.
  (Passed on to TextField)*/
  floatingLabelText:      js.UndefOr[ReactNode]                                  = js.undefined,
  /* If true, the field receives the property width 100%.
  (Passed on to TextField)*/
  fullWidth:              js.UndefOr[Boolean]                                    = js.undefined,
  /* Override the inline-styles of the TextField's hint text element.
  (Passed on to TextField)*/
  hintStyle:              js.UndefOr[CssProperties]                              = js.undefined,
  /* The hint content to display.
  (Passed on to TextField)*/
  hintText:               js.UndefOr[ReactNode]                                  = js.undefined,
  /* The id prop for the text field.
  (Passed on to TextField)*/
  id:                     js.UndefOr[String]                                     = js.undefined,
  /* Override the inline-styles of the TextField's input element.
  (Passed on to TextField)*/
  inputStyle:             js.UndefOr[CssProperties]                              = js.undefined,
  /* If true, a textarea element will be rendered.
The textarea also grows and shrinks according to the number of lines.
  (Passed on to TextField)*/
  multiLine:              js.UndefOr[Boolean]                                    = js.undefined,
  /* Callback function that is fired when the textfield loses focus.
  (Passed on to TextField)*/
  onBlur:                 js.UndefOr[ReactEventI => Callback]                    = js.undefined,
  /* The function to call when the user presses the Enter key.
  (Passed on to TextField)*/
  onEnterKeyDown:         js.UndefOr[ReactKeyboardEventI => Callback]            = js.undefined,
  /* Callback function fired when key is pressed down.
  (Passed on to TextField)*/
  onKeyDown:              js.UndefOr[ReactKeyboardEventH => Callback]            = js.undefined,
  /* Number of rows to display when multiLine option is set to true.
  (Passed on to TextField)*/
  rows:                   js.UndefOr[Int]                                        = js.undefined,
  /* Maximum number of rows to display when
multiLine option is set to true.
  (Passed on to TextField)*/
  rowsMax:                js.UndefOr[Int]                                        = js.undefined,
  /* Specifies the type of input to display
such as "password" or "text".
  (Passed on to TextField)*/
  `type`:                 js.UndefOr[String]                                     = js.undefined,
  /* Override the inline-styles of the
TextField's underline element when disabled.
  (Passed on to TextField)*/
  underlineDisabledStyle: js.UndefOr[CssProperties]                              = js.undefined,
  /* Override the inline-styles of the TextField's
underline element when focussed.
  (Passed on to TextField)*/
  underlineFocusStyle:    js.UndefOr[CssProperties]                              = js.undefined,
  /* If true, shows the underline for the text field.
  (Passed on to TextField)*/
  underlineShow:          js.UndefOr[Boolean]                                    = js.undefined,
  /* Override the inline-styles of the TextField's underline element.
  (Passed on to TextField)*/
  underlineStyle:         js.UndefOr[CssProperties]                              = js.undefined){

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiDatePicker](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.DatePicker)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}

case class Wordings(ok: String, cancel: String){
  val toJS = JSMacro[Wordings](this)
}

      


@js.native
class MuiDatePickerM extends js.Object {
  /* Returns the current date value.*/
  def getDate(): js.Date = js.native

  /* Sets the date value to d, where d is a date object.*/
  def setDate(d: js.Date): Unit = js.native

  /* Opens the date-picker dialog programmatically. Use this if you want to open the dialog in response to some event other than focus/tap on the input field, such as an external button click.*/
  def openDialog(): Unit = js.native

  /* An alias for the `openDialog()` method to allow more generic use alongside `TextField`.*/
  def focus(): Unit = js.native
}
