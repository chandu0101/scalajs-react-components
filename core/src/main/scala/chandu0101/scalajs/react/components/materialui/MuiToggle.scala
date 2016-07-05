package chandu0101.scalajs.react.components
package materialui
import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
/**
 * This file is generated - submit issues instead of PR against it
 */
case class MuiToggle(
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
  value:                js.UndefOr[String]                             = js.undefined){
  def apply() = {
    val props = JSMacro[MuiToggle](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Toggle)
    f(props).asInstanceOf[ReactComponentU_]
  }
}


@js.native
class MuiToggleM extends js.Object {
  def isToggled(): Boolean = js.native

  def setToggled(newToggledValue: Boolean): Unit = js.native
}
