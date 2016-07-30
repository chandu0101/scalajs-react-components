package chandu0101.scalajs.react.components
package materialui
import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
/**
 * This file is generated - submit issues instead of PR against it
 */
case class MuiCheckbox[T](
  key:                  js.UndefOr[String]                             = js.undefined,
  ref:                  js.UndefOr[MuiCheckboxM => Unit]               = js.undefined,
  /* Checkbox is checked if true.*/
  checked:              js.UndefOr[Boolean]                            = js.undefined,
  /* The SvgIcon to use for the checked state.
  This is useful to create icon toggles.*/
  checkedIcon:          js.UndefOr[ReactElement]                       = js.undefined,
  /* The default state of our checkbox component.
  **Warning:** This cannot be used in conjunction with `checked`.
  Decide between using a controlled or uncontrolled input element and remove one of these props.
  More info: https://fb.me/react-controlled-components*/
  defaultChecked:       js.UndefOr[Boolean]                            = js.undefined,
  /* Disabled if true.*/
  disabled:             js.UndefOr[Boolean]                            = js.undefined,
  /* Overrides the inline-styles of the icon element.*/
  iconStyle:            js.UndefOr[CssProperties]                      = js.undefined,
  /* Overrides the inline-styles of the input element.*/
  inputStyle:           js.UndefOr[CssProperties]                      = js.undefined,
  /* Where the label will be placed next to the checkbox.*/
  labelPosition:        js.UndefOr[LeftRight]                          = js.undefined,
  /* Overrides the inline-styles of the Checkbox element label.*/
  labelStyle:           js.UndefOr[CssProperties]                      = js.undefined,
  /* Callback function that is fired when the checkbox is checked.*/
  onCheck:              js.UndefOr[(ReactEventH, Boolean) => Callback] = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:                js.UndefOr[CssProperties]                      = js.undefined,
  /* The SvgIcon to use for the unchecked state.
  This is useful to create icon toggles.*/
  @deprecated("Use uncheckedIcon instead. It will be removed with v0.16.0.")
  unCheckedIcon:        js.UndefOr[ReactElement]                       = js.undefined,
  /* The SvgIcon to use for the unchecked state.
  This is useful to create icon toggles.*/
  uncheckedIcon:        js.UndefOr[ReactElement]                       = js.undefined,
  /* ValueLink for when using controlled checkbox.*/
  valueLink:            js.UndefOr[js.Any]                             = js.undefined,
  /* (Passed on to EnhancedSwitch)*/
  className:            js.UndefOr[String]                             = js.undefined,
  /* (Passed on to EnhancedSwitch)*/
  disableFocusRipple:   js.UndefOr[Boolean]                            = js.undefined,
  /* (Passed on to EnhancedSwitch)*/
  disableTouchRipple:   js.UndefOr[Boolean]                            = js.undefined,
  /* (Passed on to EnhancedSwitch)*/
  inputType:            js.UndefOr[String]                             = js.undefined,
  /* (Passed on to EnhancedSwitch)*/
  label:                js.UndefOr[ReactNode]                          = js.undefined,
  /* (Passed on to EnhancedSwitch)*/
  name:                 js.UndefOr[String]                             = js.undefined,
  /* (Passed on to EnhancedSwitch)*/
  onBlur:               js.UndefOr[ReactFocusEventH => Callback]       = js.undefined,
  /* (Passed on to EnhancedSwitch)*/
  onFocus:              js.UndefOr[ReactFocusEventH => Callback]       = js.undefined,
  /* (Passed on to EnhancedSwitch)*/
  onMouseDown:          js.UndefOr[ReactMouseEventH => Callback]       = js.undefined,
  /* (Passed on to EnhancedSwitch)*/
  onMouseLeave:         js.UndefOr[ReactMouseEventH => Callback]       = js.undefined,
  /* (Passed on to EnhancedSwitch)*/
  onMouseUp:            js.UndefOr[ReactMouseEventH => Callback]       = js.undefined,
  /* (Passed on to EnhancedSwitch)*/
  onParentShouldUpdate: js.UndefOr[Boolean => Callback]                = js.undefined,
  /* (Passed on to EnhancedSwitch)*/
  onSwitch:             js.UndefOr[(ReactEventI, Boolean) => Callback] = js.undefined,
  /* (Passed on to EnhancedSwitch)*/
  onTouchEnd:           js.UndefOr[ReactTouchEventH => Callback]       = js.undefined,
  /* (Passed on to EnhancedSwitch)*/
  onTouchStart:         js.UndefOr[ReactTouchEventH => Callback]       = js.undefined,
  /* (Passed on to EnhancedSwitch)*/
  rippleColor:          js.UndefOr[MuiColor]                           = js.undefined,
  /* (Passed on to EnhancedSwitch)*/
  rippleStyle:          js.UndefOr[CssProperties]                      = js.undefined,
  /* (Passed on to EnhancedSwitch)*/
  switchElement:        js.UndefOr[ReactElement]                       = js.undefined,
  /* (Passed on to EnhancedSwitch)*/
  switched:             js.UndefOr[Boolean]                            = js.undefined,
  /* (Passed on to EnhancedSwitch)*/
  thumbStyle:           js.UndefOr[CssProperties]                      = js.undefined,
  /* (Passed on to EnhancedSwitch)*/
  trackStyle:           js.UndefOr[CssProperties]                      = js.undefined,
  /* (Passed on to EnhancedSwitch)*/
  value:                js.UndefOr[T]                                  = js.undefined,
  /* (Passed on to DOM)*/
  onAnimationEnd:       js.UndefOr[ReactEventH => Callback]            = js.undefined,
  /* (Passed on to DOM)*/
  onAnimationIteration: js.UndefOr[ReactEventH => Callback]            = js.undefined,
  /* (Passed on to DOM)*/
  onAnimationStart:     js.UndefOr[ReactEventH => Callback]            = js.undefined,
  /* (Passed on to DOM)*/
  onChange:             js.UndefOr[ReactEventH => Callback]            = js.undefined,
  /* (Passed on to DOM)*/
  onClick:              js.UndefOr[ReactMouseEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onCompositionEnd:     js.UndefOr[ReactCompositionEventH => Callback] = js.undefined,
  /* (Passed on to DOM)*/
  onCompositionStart:   js.UndefOr[ReactCompositionEventH => Callback] = js.undefined,
  /* (Passed on to DOM)*/
  onCompositionUpdate:  js.UndefOr[ReactCompositionEventH => Callback] = js.undefined,
  /* (Passed on to DOM)*/
  onContextMenu:        js.UndefOr[ReactEventH => Callback]            = js.undefined,
  /* (Passed on to DOM)*/
  onCopy:               js.UndefOr[ReactClipboardEventH => Callback]   = js.undefined,
  /* (Passed on to DOM)*/
  onCut:                js.UndefOr[ReactClipboardEventH => Callback]   = js.undefined,
  /* (Passed on to DOM)*/
  onDoubleClick:        js.UndefOr[ReactMouseEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onDrag:               js.UndefOr[ReactDragEventH => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onDragEnd:            js.UndefOr[ReactDragEventH => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onDragEnter:          js.UndefOr[ReactDragEventH => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onDragExit:           js.UndefOr[ReactDragEventH => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onDragLeave:          js.UndefOr[ReactDragEventH => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onDragOver:           js.UndefOr[ReactDragEventH => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onDragStart:          js.UndefOr[ReactDragEventH => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onDrop:               js.UndefOr[ReactDragEventH => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onInput:              js.UndefOr[ReactKeyboardEventH => Callback]    = js.undefined,
  /* (Passed on to DOM)*/
  onKeyDown:            js.UndefOr[ReactKeyboardEventH => Callback]    = js.undefined,
  /* (Passed on to DOM)*/
  onKeyPress:           js.UndefOr[ReactKeyboardEventH => Callback]    = js.undefined,
  /* (Passed on to DOM)*/
  onKeyUp:              js.UndefOr[ReactKeyboardEventH => Callback]    = js.undefined,
  /* (Passed on to DOM)*/
  onMouseEnter:         js.UndefOr[ReactMouseEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onMouseMove:          js.UndefOr[ReactMouseEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onPaste:              js.UndefOr[ReactClipboardEventH => Callback]   = js.undefined,
  /* (Passed on to DOM)*/
  onScroll:             js.UndefOr[ReactUIEventH => Callback]          = js.undefined,
  /* (Passed on to DOM)*/
  onSelect:             js.UndefOr[ReactUIEventH => Callback]          = js.undefined,
  /* (Passed on to DOM)*/
  onSubmit:             js.UndefOr[ReactEventH => Callback]            = js.undefined,
  /* (Passed on to DOM)*/
  onTouchCancel:        js.UndefOr[ReactTouchEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onTouchMove:          js.UndefOr[ReactTouchEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onTransitionEnd:      js.UndefOr[ReactTouchEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onWheel:              js.UndefOr[ReactWheelEventH => Callback]       = js.undefined){
  def apply() = {
    implicit def evT(t: T): js.Any = t.asInstanceOf[js.Any]
    val props = JSMacro[MuiCheckbox[T]](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Checkbox)
    f(props).asInstanceOf[ReactComponentU_]
  }
}


@js.native
class MuiCheckboxM extends js.Object {
  def isChecked(): Boolean = js.native

  def isChecked(newCheckedValue: Boolean): Unit = js.native
}
