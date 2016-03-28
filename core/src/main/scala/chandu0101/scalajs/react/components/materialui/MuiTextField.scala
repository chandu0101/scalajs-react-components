package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiTextField(
  key:                    js.UndefOr[String]                          = js.undefined,
  ref:                    js.UndefOr[String]                          = js.undefined,
  /* The css class name of the root element.*/
  className:              js.UndefOr[String]                          = js.undefined,
  /* The text string to use for the default value.*/
  defaultValue:           js.UndefOr[String]                          = js.undefined,
  /* Disables the text field if set to true.*/
  disabled:               js.UndefOr[Boolean]                         = js.undefined,
  /* The style object to use to override error styles.*/
  errorStyle:             js.UndefOr[CssProperties]                   = js.undefined,
  /* The error content to display.*/
  errorText:              js.UndefOr[ReactNode]                       = js.undefined,
  /* If true, the floating label will float even when there is no value.*/
  floatingLabelFixed:     js.UndefOr[Boolean]                         = js.undefined,
  /* The style object to use to override floating label styles.*/
  floatingLabelStyle:     js.UndefOr[CssProperties]                   = js.undefined,
  /* The content to use for the floating label element.*/
  floatingLabelText:      js.UndefOr[ReactNode]                       = js.undefined,
  /* If true, the field receives the property width 100%.*/
  fullWidth:              js.UndefOr[Boolean]                         = js.undefined,
  /* Override the inline-styles of the TextField's hint text element.*/
  hintStyle:              js.UndefOr[CssProperties]                   = js.undefined,
  /* The hint content to display.*/
  hintText:               js.UndefOr[ReactNode]                       = js.undefined,
  /* The id prop for the text field.*/
  id:                     js.UndefOr[String]                          = js.undefined,
  /* Override the inline-styles of the TextField's input element.
  When multiLine is false: define the style of the input element.
  When multiLine is true: define the style of the container of the textarea.*/
  inputStyle:             js.UndefOr[CssProperties]                   = js.undefined,
  /* If true, a textarea element will be rendered.
  The textarea also grows and shrinks according to the number of lines.*/
  multiLine:              js.UndefOr[Boolean]                         = js.undefined,
  /* Name applied to the input.*/
  name:                   js.UndefOr[String]                          = js.undefined,
  /* Callback function that is fired when the textfield loses focus.*/
  onBlur:                 js.UndefOr[ReactEventI => Callback]         = js.undefined,
  /* Callback function that is fired when the textfield's value changes.*/
  onChange:               js.UndefOr[ReactEventI => Callback]         = js.undefined,
  /* The function to call when the user presses the Enter key.*/
  @deprecated("Use onKeyDown and check for keycode instead.")
  onEnterKeyDown:         js.UndefOr[ReactKeyboardEventI => Callback] = js.undefined,
  /* Callback function that is fired when the textfield gains focus.*/
  onFocus:                js.UndefOr[ReactFocusEventH => Callback]    = js.undefined,
  /* Callback function fired when key is pressed down.*/
  onKeyDown:              js.UndefOr[ReactKeyboardEventH => Callback] = js.undefined,
  /* Number of rows to display when multiLine option is set to true.*/
  rows:                   js.UndefOr[Int]                             = js.undefined,
  /* Maximum number of rows to display when
  multiLine option is set to true.*/
  rowsMax:                js.UndefOr[Int]                             = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:                  js.UndefOr[CssProperties]                   = js.undefined,
  /* Override the inline-styles of the TextField's textarea element.
  The TextField use either a textarea or an input,
  this property has effects only when multiLine is true.*/
  textareaStyle:          js.UndefOr[CssProperties]                   = js.undefined,
  /* Specifies the type of input to display
  such as "password" or "text".*/
  `type`:                 js.UndefOr[String]                          = js.undefined,
  /* Override the inline-styles of the
  TextField's underline element when disabled.*/
  underlineDisabledStyle: js.UndefOr[CssProperties]                   = js.undefined,
  /* Override the inline-styles of the TextField's
  underline element when focussed.*/
  underlineFocusStyle:    js.UndefOr[CssProperties]                   = js.undefined,
  /* If true, shows the underline for the text field.*/
  underlineShow:          js.UndefOr[Boolean]                         = js.undefined,
  /* Override the inline-styles of the TextField's underline element.*/
  underlineStyle:         js.UndefOr[CssProperties]                   = js.undefined,
  /* The value of the text field.*/
  value:                  js.UndefOr[String]                          = js.undefined,
  /* (Passed on to EnhancedTextarea)*/
  onHeightChange:         js.UndefOr[(ReactEvent, Int)=> Callback]    = js.undefined,
  /* (Passed on to EnhancedTextarea)*/
  shadowStyle:            js.UndefOr[CssProperties]                   = js.undefined,
  /* (Passed on to EnhancedTextarea)*/
  valueLink:              js.UndefOr[js.Any]                          = js.undefined){

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiTextField](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.TextField)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
