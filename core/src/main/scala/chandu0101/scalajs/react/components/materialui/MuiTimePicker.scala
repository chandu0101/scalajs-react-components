package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiTimePicker(
  key:                    js.UndefOr[String]                                     = js.undefined,
  ref:                    js.UndefOr[MuiTimePickerM => Unit]                     = js.undefined,
  /* default: false: If true, automatically accept and close the picker on set minutes.*/
  autoOk:                 js.UndefOr[Boolean]                                    = js.undefined,
  /* This is the initial time value of the component.*/
  defaultTime:            js.UndefOr[js.Date]                                    = js.undefined,
  /* default: ampm: Tells the component to display the picker in ampm (12hr) format or 24hr format.*/
  format:                 js.UndefOr[Ampm_24hr]                                  = js.undefined,
  /* function(null, time): Callback function that is fired when the time value changes. The time value is passed in a Date Object.Since there is no particular event associated with the change the first argument will always be null and the second argument will be the new Date instance.*/
  onChange:               js.UndefOr[(js.UndefOr[Nothing], js.Date) => Callback] = js.undefined,
  /* function(): Fired when the timepicker dialog is dismissed.*/
  onDismiss:              js.UndefOr[Callback]                                   = js.undefined,
  /* function(event): Callback function that is fired when the timepicker field gains focus.*/
  onFocus:                js.UndefOr[ReactFocusEventH => Callback]               = js.undefined,
  /* function(): Fired when the timepicker dialog is shown.*/
  onShow:                 js.UndefOr[Callback]                                   = js.undefined,
  onTouchTap:             js.UndefOr[ReactTouchEventH => Callback]               = js.undefined,
  /* default: false: It's technically more correct to refer to "12 noon" and "12 midnight"
rather than "12 a.m." and "12 p.m." and it avoids real confusion between different locales.
By default (for compatibility reasons) TimePicker uses (12 a.m./12 p.m.) To use (noon/midnight) set pedantic={true}.*/
  pedantic:               js.UndefOr[Boolean]                                    = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:                  js.UndefOr[CssProperties]                              = js.undefined,
  /* Override the inline-styles of TimePicker's TextField element.*/
  textFieldStyle:         js.UndefOr[CssProperties]                              = js.undefined,
  /* The css class name of the root element.
  (Passed on to TextField)*/
  className:              js.UndefOr[String]                                     = js.undefined,
  /* (Passed on to TextField)*/
  defaultValue:           js.UndefOr[String]                                     = js.undefined,
  /* (Passed on to TextField)*/
  disabled:               js.UndefOr[Boolean]                                    = js.undefined,
  /* (Passed on to TextField)*/
  errorStyle:             js.UndefOr[CssProperties]                              = js.undefined,
  /* (Passed on to TextField)*/
  errorText:              js.UndefOr[ReactNode]                                  = js.undefined,
  /* (Passed on to TextField)*/
  floatingLabelStyle:     js.UndefOr[CssProperties]                              = js.undefined,
  /* The text string to use for the floating label element.
  (Passed on to TextField)*/
  floatingLabelText:      js.UndefOr[ReactNode]                                  = js.undefined,
  /* (Passed on to TextField)*/
  fullWidth:              js.UndefOr[Boolean]                                    = js.undefined,
  /* (Passed on to TextField)*/
  hintStyle:              js.UndefOr[CssProperties]                              = js.undefined,
  /* The hint text string to display. Note, floatingLabelText will overide this.
  (Passed on to TextField)*/
  hintText:               js.UndefOr[ReactNode]                                  = js.undefined,
  /* (Passed on to TextField)*/
  id:                     js.UndefOr[String]                                     = js.undefined,
  /* (Passed on to TextField)*/
  inputStyle:             js.UndefOr[CssProperties]                              = js.undefined,
  /* (Passed on to TextField)*/
  multiLine:              js.UndefOr[Boolean]                                    = js.undefined,
  /* (Passed on to TextField)*/
  onBlur:                 js.UndefOr[ReactEventI => Callback]                    = js.undefined,
  /* (Passed on to TextField)*/
  onEnterKeyDown:         js.UndefOr[ReactKeyboardEventI => Callback]            = js.undefined,
  /* (Passed on to TextField)*/
  onKeyDown:              js.UndefOr[ReactKeyboardEventH => Callback]            = js.undefined,
  /* (Passed on to TextField)*/
  rows:                   js.UndefOr[Int]                                        = js.undefined,
  /* (Passed on to TextField)*/
  rowsMax:                js.UndefOr[Int]                                        = js.undefined,
  /* (Passed on to TextField)*/
  `type`:                 js.UndefOr[String]                                     = js.undefined,
  /* (Passed on to TextField)*/
  underlineDisabledStyle: js.UndefOr[CssProperties]                              = js.undefined,
  /* (Passed on to TextField)*/
  underlineFocusStyle:    js.UndefOr[CssProperties]                              = js.undefined,
  /* (Passed on to TextField)*/
  underlineShow:          js.UndefOr[Boolean]                                    = js.undefined,
  /* (Passed on to TextField)*/
  underlineStyle:         js.UndefOr[CssProperties]                              = js.undefined,
  /* (Passed on to TextField)*/
  value:                  js.UndefOr[String]                                     = js.undefined){

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiTimePicker](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.TimePicker)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}


@js.native
class MuiTimePickerM extends js.Object {
  /* Returns the current time value.*/
  def getTime(): js.Date = js.native

  /* Sets the time value to t, where t is a date object.*/
  def setTime(d: js.Date): Unit = js.native

  /* Formats the Date object to a current component's time format.*/
  def formatTime(d: js.Date): String = js.native

  /* Opens the time-picker dialog programmatically. Use this if you want to open the dialog in response to some event other than focus/tap on the input field, such as an external button click.*/
  def openDialog(): Unit = js.native

  /* An alias for the `openDialog()` method to allow more generic use alongside `TextField`.*/
  def focus(): Unit = js.native
}
