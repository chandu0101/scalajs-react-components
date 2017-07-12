package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.React
import japgolly.scalajs.react.vdom.VdomNode

import scala.scalajs.js

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiDatePicker(
  key:                      js.UndefOr[String]                                     = js.undefined,
  ref:                      js.UndefOr[MuiDatePickerM => Unit]                     = js.undefined,
  /* Constructor for date formatting for the specified `locale`.
     The constructor must follow this specification: ECMAScript Internationalization API 1.0 (ECMA-402).
     `Intl.DateTimeFormat` is supported by most modern browsers, see http://caniuse.com/#search=intl,
     otherwise https://github.com/andyearnshaw/Intl.js is a good polyfill.
     By default, a built-in `DateTimeFormat` is used which supports the 'en-US' `locale`. */
  DateTimeFormat:           js.UndefOr[js.Function]                                = js.undefined,
  /* If true, automatically accept and close the picker on select a date. */
  autoOk:                   js.UndefOr[Boolean]                                    = js.undefined,
  /* Override the default text of the 'Cancel' button. */
  cancelLabel:              js.UndefOr[VdomNode]                                  = js.undefined,
  /* The css class name of the root element. */
  className:                js.UndefOr[String]                                     = js.undefined,
  /* Used to control how the Date Picker will be displayed when the input field is focused.
     `dialog` (default) displays the DatePicker as a dialog with a modal.
     `inline` displays the DatePicker below the input field (similar to auto complete). */
  container:                js.UndefOr[DialogInline]                               = js.undefined,
  /* This is the initial date value of the component.
     If either `value` or `valueLink` is provided they will override this
     prop with `value` taking precedence. */
  defaultDate:              js.UndefOr[js.Date]                                    = js.undefined,
  /* Override the inline-styles of DatePickerDialog's Container element. */
  dialogContainerStyle:     js.UndefOr[CssProperties]                              = js.undefined,
  /* Disables the year selection in the date picker. */
  disableYearSelection:     js.UndefOr[Boolean]                                    = js.undefined,
  /* Disables the DatePicker. */
  disabled:                 js.UndefOr[Boolean]                                    = js.undefined,
  /* Used to change the first day of week. It varies from
     Saturday to Monday between different locales.
     The allowed range is 0 (Sunday) to 6 (Saturday).
     The default is `1`, Monday, as per ISO 8601. */
  firstDayOfWeek:           js.UndefOr[Double]                                     = js.undefined,
  /* This function is called to format the date displayed in the input field, and should return a string.
     By default if no `locale` and `DateTimeFormat` is provided date objects are formatted to ISO 8601 YYYY-MM-DD.
     @param {object} date Date object to be formatted.
     @returns {any} The formatted date. */
  formatDate:               js.UndefOr[js.Date => String]                          = js.undefined,
  /* Locale used for formatting the `DatePicker` date strings. Other than for 'en-US', you
     must provide a `DateTimeFormat` that supports the chosen `locale`. */
  locale:                   js.UndefOr[String]                                     = js.undefined,
  /* The ending of a range of valid dates. The range includes the endDate.
     The default value is current date + 100 years. */
  maxDate:                  js.UndefOr[js.Date]                                    = js.undefined,
  /* The beginning of a range of valid dates. The range includes the startDate.
     The default value is current date - 100 years. */
  minDate:                  js.UndefOr[js.Date]                                    = js.undefined,
  /* Tells the component to display the picker in portrait or landscape mode. */
  mode:                     js.UndefOr[PortraitLandscape]                          = js.undefined,
  /* Override the default text of the 'OK' button. */
  okLabel:                  js.UndefOr[VdomNode]                                  = js.undefined,
  /* Callback function that is fired when the date value changes.
     @param {null} null Since there is no particular event associated with the change,
     the first argument will always be null.
     @param {object} date The new date. */
  onChange:                 js.UndefOr[(js.UndefOr[Nothing], js.Date) => Callback] = js.undefined,
  /* Callback function that is fired when the Date Picker's dialog is dismissed. */
  onDismiss:                js.UndefOr[Callback]                                   = js.undefined,
  /* Callback function that is fired when the Date Picker's `TextField` gains focus. */
  onFocus:                  js.UndefOr[ReactFocusEvent => Callback]                = js.undefined,
  /* Callback function that is fired when the Date Picker's dialog is shown. */
  onShow:                   js.UndefOr[Callback]                                   = js.undefined,
  /* Callback function that is fired when a touch tap event occurs on the Date Picker's `TextField`.
     @param {object} event TouchTap event targeting the `TextField`. */
  onTouchTap:               js.UndefOr[TouchTapEvent => Callback]                  = js.undefined,
  /* Callback function used to determine if a day's entry should be disabled on the calendar.
     @param {object} day Date object of a day.
     @returns {boolean} Indicates whether the day should be disabled. */
  shouldDisableDate:        js.UndefOr[js.Date => Boolean]                         = js.undefined,
  /* Override the inline-styles of the root element. */
  style:                    js.UndefOr[CssProperties]                              = js.undefined,
  /* Override the inline-styles of DatePicker's TextField element. */
  textFieldStyle:           js.UndefOr[CssProperties]                              = js.undefined,
  /* Sets the date for the Date Picker programmatically. */
  value:                    js.UndefOr[js.Date]                                    = js.undefined,
  /* The text string to use for the default value.
     (Passed on to TextField) */
  defaultValue:             js.UndefOr[String]                                     = js.undefined,
  /* The style object to use to override error styles.
     (Passed on to TextField) */
  errorStyle:               js.UndefOr[CssProperties]                              = js.undefined,
  /* The error content to display.
     (Passed on to TextField) */
  errorText:                js.UndefOr[VdomNode]                                  = js.undefined,
  /* If true, the floating label will float even when there is no value.
     (Passed on to TextField) */
  floatingLabelFixed:       js.UndefOr[Boolean]                                    = js.undefined,
  /* The style object to use to override floating label styles when focused.
     (Passed on to TextField) */
  floatingLabelFocusStyle:  js.UndefOr[CssProperties]                              = js.undefined,
  /* The style object to use to override floating label styles when shrunk.
     (Passed on to TextField) */
  floatingLabelShrinkStyle: js.UndefOr[CssProperties]                              = js.undefined,
  /* The style object to use to override floating label styles.
     (Passed on to TextField) */
  floatingLabelStyle:       js.UndefOr[CssProperties]                              = js.undefined,
  /* The content to use for the floating label element.
     (Passed on to TextField) */
  floatingLabelText:        js.UndefOr[VdomNode]                                  = js.undefined,
  /* If true, the field receives the property width 100%.
     (Passed on to TextField) */
  fullWidth:                js.UndefOr[Boolean]                                    = js.undefined,
  /* Override the inline-styles of the TextField's hint text element.
     (Passed on to TextField) */
  hintStyle:                js.UndefOr[CssProperties]                              = js.undefined,
  /* The hint content to display.
     (Passed on to TextField) */
  hintText:                 js.UndefOr[VdomNode]                                  = js.undefined,
  /* The id prop for the text field.
     (Passed on to TextField) */
  id:                       js.UndefOr[String]                                     = js.undefined,
  /* Override the inline-styles of the TextField's input element.
     When multiLine is false: define the style of the input element.
     When multiLine is true: define the style of the container of the textarea.
     (Passed on to TextField) */
  inputStyle:               js.UndefOr[CssProperties]                              = js.undefined,
  /* If true, a textarea element will be rendered.
     The textarea also grows and shrinks according to the number of lines.
     (Passed on to TextField) */
  multiLine:                js.UndefOr[Boolean]                                    = js.undefined,
  /* Name applied to the input.
     (Passed on to TextField) */
  name:                     js.UndefOr[String]                                     = js.undefined,
  /* (Passed on to TextField) */
  onBlur:                   js.UndefOr[ReactFocusEventFromInput => Callback]               = js.undefined,
  /* Number of rows to display when multiLine option is set to true.
     (Passed on to TextField) */
  rows:                     js.UndefOr[Int]                                        = js.undefined,
  /* Maximum number of rows to display when
     multiLine option is set to true.
     (Passed on to TextField) */
  rowsMax:                  js.UndefOr[Int]                                        = js.undefined,
  /* Override the inline-styles of the TextField's textarea element.
     The TextField use either a textarea or an input,
     this property has effects only when multiLine is true.
     (Passed on to TextField) */
  textareaStyle:            js.UndefOr[CssProperties]                              = js.undefined,
  /* Specifies the type of input to display
     such as "password" or "text".
     (Passed on to TextField) */
  `type`:                   js.UndefOr[String]                                     = js.undefined,
  /* Override the inline-styles of the
     TextField's underline element when disabled.
     (Passed on to TextField) */
  underlineDisabledStyle:   js.UndefOr[CssProperties]                              = js.undefined,
  /* Override the inline-styles of the TextField's
     underline element when focussed.
     (Passed on to TextField) */
  underlineFocusStyle:      js.UndefOr[CssProperties]                              = js.undefined,
  /* If true, shows the underline for the text field.
     (Passed on to TextField) */
  underlineShow:            js.UndefOr[Boolean]                                    = js.undefined,
  /* Override the inline-styles of the TextField's underline element.
     (Passed on to TextField) */
  underlineStyle:           js.UndefOr[CssProperties]                              = js.undefined){


  def apply(children: VdomNode*) = {
    
    val props = JSMacro[MuiDatePicker](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Mui.DatePicker)
    component(props)(children: _*)
  }
}


@js.native
class MuiDatePickerM extends js.Object {
  def focus(): Unit = js.native

  def getControlledDate(): js.Dynamic = js.native

  def getDate(): js.Date = js.native

  def isControlled(): js.Dynamic = js.native

  def openDialog(): Unit = js.native
}
