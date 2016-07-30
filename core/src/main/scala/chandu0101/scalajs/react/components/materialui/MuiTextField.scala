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
  key:                     js.UndefOr[String]                             = js.undefined,
  ref:                     js.UndefOr[MuiTextFieldM => Unit]              = js.undefined,
  /* The css class name of the root element.*/
  className:               js.UndefOr[String]                             = js.undefined,
  /* The text string to use for the default value.*/
  defaultValue:            js.UndefOr[String]                             = js.undefined,
  /* Disables the text field if set to true.*/
  disabled:                js.UndefOr[Boolean]                            = js.undefined,
  /* The style object to use to override error styles.*/
  errorStyle:              js.UndefOr[CssProperties]                      = js.undefined,
  /* The error content to display.*/
  errorText:               js.UndefOr[ReactNode]                          = js.undefined,
  /* If true, the floating label will float even when there is no value.*/
  floatingLabelFixed:      js.UndefOr[Boolean]                            = js.undefined,
  /* The style object to use to override floating label styles when focused.*/
  floatingLabelFocusStyle: js.UndefOr[CssProperties]                      = js.undefined,
  /* The style object to use to override floating label styles.*/
  floatingLabelStyle:      js.UndefOr[CssProperties]                      = js.undefined,
  /* The content to use for the floating label element.*/
  floatingLabelText:       js.UndefOr[ReactNode]                          = js.undefined,
  /* If true, the field receives the property width 100%.*/
  fullWidth:               js.UndefOr[Boolean]                            = js.undefined,
  /* Override the inline-styles of the TextField's hint text element.*/
  hintStyle:               js.UndefOr[CssProperties]                      = js.undefined,
  /* The hint content to display.*/
  hintText:                js.UndefOr[ReactNode]                          = js.undefined,
  /* The id prop for the text field.*/
  id:                      js.UndefOr[String]                             = js.undefined,
  /* Override the inline-styles of the TextField's input element.
  When multiLine is false: define the style of the input element.
  When multiLine is true: define the style of the container of the textarea.*/
  inputStyle:              js.UndefOr[CssProperties]                      = js.undefined,
  /* If true, a textarea element will be rendered.
  The textarea also grows and shrinks according to the number of lines.*/
  multiLine:               js.UndefOr[Boolean]                            = js.undefined,
  /* Name applied to the input.*/
  name:                    js.UndefOr[String]                             = js.undefined,
  onBlur:                  js.UndefOr[ReactEventI => Callback]            = js.undefined,
  /* Callback function that is fired when the textfield's value changes.*/
  onChange:                js.UndefOr[ReactEventI => Callback]            = js.undefined,
  /* The function to call when the user presses the Enter key.*/
  @deprecated("Use onKeyDown and check for keycode instead. It will be removed with v0.16.0.")
  onEnterKeyDown:          js.UndefOr[ReactKeyboardEventI => Callback]    = js.undefined,
  onFocus:                 js.UndefOr[ReactFocusEventI => Callback]       = js.undefined,
  onKeyDown:               js.UndefOr[ReactKeyboardEventI => Callback]    = js.undefined,
  /* Number of rows to display when multiLine option is set to true.*/
  rows:                    js.UndefOr[Int]                                = js.undefined,
  /* Maximum number of rows to display when
  multiLine option is set to true.*/
  rowsMax:                 js.UndefOr[Int]                                = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:                   js.UndefOr[CssProperties]                      = js.undefined,
  /* Override the inline-styles of the TextField's textarea element.
  The TextField use either a textarea or an input,
  this property has effects only when multiLine is true.*/
  textareaStyle:           js.UndefOr[CssProperties]                      = js.undefined,
  /* Specifies the type of input to display
  such as "password" or "text".*/
  `type`:                  js.UndefOr[String]                             = js.undefined,
  /* Override the inline-styles of the
  TextField's underline element when disabled.*/
  underlineDisabledStyle:  js.UndefOr[CssProperties]                      = js.undefined,
  /* Override the inline-styles of the TextField's
  underline element when focussed.*/
  underlineFocusStyle:     js.UndefOr[CssProperties]                      = js.undefined,
  /* If true, shows the underline for the text field.*/
  underlineShow:           js.UndefOr[Boolean]                            = js.undefined,
  /* Override the inline-styles of the TextField's underline element.*/
  underlineStyle:          js.UndefOr[CssProperties]                      = js.undefined,
  /* The value of the text field.*/
  value:                   js.UndefOr[String]                             = js.undefined,
  /* (Passed on to EnhancedTextarea)*/
  onHeightChange:          js.UndefOr[(ReactEvent, Int)=> Callback]       = js.undefined,
  /* (Passed on to EnhancedTextarea)*/
  shadowStyle:             js.UndefOr[CssProperties]                      = js.undefined,
  /* (Passed on to EnhancedTextarea)*/
  valueLink:               js.UndefOr[js.Any]                             = js.undefined,
  /* (Passed on to DOM)*/
  onAnimationEnd:          js.UndefOr[ReactEventI => Callback]            = js.undefined,
  /* (Passed on to DOM)*/
  onAnimationIteration:    js.UndefOr[ReactEventI => Callback]            = js.undefined,
  /* (Passed on to DOM)*/
  onAnimationStart:        js.UndefOr[ReactEventI => Callback]            = js.undefined,
  /* (Passed on to DOM)*/
  onClick:                 js.UndefOr[ReactMouseEventI => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onCompositionEnd:        js.UndefOr[ReactCompositionEventI => Callback] = js.undefined,
  /* (Passed on to DOM)*/
  onCompositionStart:      js.UndefOr[ReactCompositionEventI => Callback] = js.undefined,
  /* (Passed on to DOM)*/
  onCompositionUpdate:     js.UndefOr[ReactCompositionEventI => Callback] = js.undefined,
  /* (Passed on to DOM)*/
  onContextMenu:           js.UndefOr[ReactEventI => Callback]            = js.undefined,
  /* (Passed on to DOM)*/
  onCopy:                  js.UndefOr[ReactClipboardEventI => Callback]   = js.undefined,
  /* (Passed on to DOM)*/
  onCut:                   js.UndefOr[ReactClipboardEventI => Callback]   = js.undefined,
  /* (Passed on to DOM)*/
  onDoubleClick:           js.UndefOr[ReactMouseEventI => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onDrag:                  js.UndefOr[ReactDragEventI => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onDragEnd:               js.UndefOr[ReactDragEventI => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onDragEnter:             js.UndefOr[ReactDragEventI => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onDragExit:              js.UndefOr[ReactDragEventI => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onDragLeave:             js.UndefOr[ReactDragEventI => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onDragOver:              js.UndefOr[ReactDragEventI => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onDragStart:             js.UndefOr[ReactDragEventI => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onDrop:                  js.UndefOr[ReactDragEventI => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onInput:                 js.UndefOr[ReactKeyboardEventI => Callback]    = js.undefined,
  /* (Passed on to DOM)*/
  onKeyPress:              js.UndefOr[ReactKeyboardEventI => Callback]    = js.undefined,
  /* (Passed on to DOM)*/
  onKeyUp:                 js.UndefOr[ReactKeyboardEventI => Callback]    = js.undefined,
  /* (Passed on to DOM)*/
  onMouseDown:             js.UndefOr[ReactMouseEventI => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onMouseEnter:            js.UndefOr[ReactMouseEventI => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onMouseLeave:            js.UndefOr[ReactMouseEventI => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onMouseMove:             js.UndefOr[ReactMouseEventI => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onMouseUp:               js.UndefOr[ReactMouseEventI => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onPaste:                 js.UndefOr[ReactClipboardEventI => Callback]   = js.undefined,
  /* (Passed on to DOM)*/
  onScroll:                js.UndefOr[ReactUIEventI => Callback]          = js.undefined,
  /* (Passed on to DOM)*/
  onSelect:                js.UndefOr[ReactUIEventI => Callback]          = js.undefined,
  /* (Passed on to DOM)*/
  onSubmit:                js.UndefOr[ReactEventI => Callback]            = js.undefined,
  /* (Passed on to DOM)*/
  onTouchCancel:           js.UndefOr[ReactTouchEventI => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onTouchEnd:              js.UndefOr[ReactTouchEventI => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onTouchMove:             js.UndefOr[ReactTouchEventI => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onTouchStart:            js.UndefOr[ReactTouchEventI => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onTransitionEnd:         js.UndefOr[ReactTouchEventI => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onWheel:                 js.UndefOr[ReactWheelEventI => Callback]       = js.undefined){
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


@js.native
class MuiTextFieldM extends js.Object {
  def blur(): Unit = js.native

  def focus(): Unit = js.native

  def getInputNode(): js.Any = js.native

  def getValue(): String = js.native

  def select(): js.Any = js.native
}
