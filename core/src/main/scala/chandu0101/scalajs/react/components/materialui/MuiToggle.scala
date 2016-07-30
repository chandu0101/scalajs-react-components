package chandu0101.scalajs.react.components
package materialui
import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
/**
 * This file is generated - submit issues instead of PR against it
 */
case class MuiToggle[T](
  key:                  js.UndefOr[String]                             = js.undefined,
  ref:                  js.UndefOr[MuiToggleM => Unit]                 = js.undefined,
  /* Determines whether the Toggle is initially turned on.
  **Warning:** This cannot be used in conjunction with `toggled`.
  Decide between using a controlled or uncontrolled input element and remove one of these props.
  More info: https://fb.me/react-controlled-components*/
  defaultToggled:       js.UndefOr[Boolean]                            = js.undefined,
  /* Will disable the toggle if true.*/
  disabled:             js.UndefOr[Boolean]                            = js.undefined,
  /* Overrides the inline-styles of the Toggle element.*/
  elementStyle:         js.UndefOr[CssProperties]                      = js.undefined,
  /* Overrides the inline-styles of the Icon element.*/
  iconStyle:            js.UndefOr[CssProperties]                      = js.undefined,
  /* Overrides the inline-styles of the input element.*/
  inputStyle:           js.UndefOr[CssProperties]                      = js.undefined,
  /* Label for toggle.*/
  label:                js.UndefOr[String]                             = js.undefined,
  /* Where the label will be placed next to the toggle.*/
  labelPosition:        js.UndefOr[LeftRight]                          = js.undefined,
  /* Overrides the inline-styles of the Toggle element label.*/
  labelStyle:           js.UndefOr[CssProperties]                      = js.undefined,
  /* Callback function that is fired when the toggle switch is toggled.*/
  onToggle:             js.UndefOr[(ReactEventI, Boolean) => Callback] = js.undefined,
  /* Override style of ripple.*/
  rippleStyle:          js.UndefOr[CssProperties]                      = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:                js.UndefOr[CssProperties]                      = js.undefined,
  /* Override style for thumb.*/
  thumbStyle:           js.UndefOr[CssProperties]                      = js.undefined,
  /* Toggled if set to true.*/
  toggled:              js.UndefOr[Boolean]                            = js.undefined,
  /* Override style for track.*/
  trackStyle:           js.UndefOr[CssProperties]                      = js.undefined,
  /* ValueLink prop for when using controlled toggle.*/
  valueLink:            js.UndefOr[js.Any]                             = js.undefined,
  /* (Passed on to EnhancedSwitch)*/
  checked:              js.UndefOr[Boolean]                            = js.undefined,
  /* (Passed on to EnhancedSwitch)*/
  className:            js.UndefOr[String]                             = js.undefined,
  /* (Passed on to EnhancedSwitch)*/
  defaultChecked:       js.UndefOr[Boolean]                            = js.undefined,
  /* (Passed on to EnhancedSwitch)*/
  disableFocusRipple:   js.UndefOr[Boolean]                            = js.undefined,
  /* (Passed on to EnhancedSwitch)*/
  disableTouchRipple:   js.UndefOr[Boolean]                            = js.undefined,
  /* (Passed on to EnhancedSwitch)*/
  inputType:            js.UndefOr[String]                             = js.undefined,
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
  switchElement:        js.UndefOr[ReactElement]                       = js.undefined,
  /* (Passed on to EnhancedSwitch)*/
  switched:             js.UndefOr[Boolean]                            = js.undefined,
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
    val props = JSMacro[MuiToggle[T]](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Toggle)
    f(props).asInstanceOf[ReactComponentU_]
  }
}


@js.native
class MuiToggleM extends js.Object {
  def isToggled(): Boolean = js.native

  def setToggled(newToggledValue: Boolean): Unit = js.native
}
