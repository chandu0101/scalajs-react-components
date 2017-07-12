package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.React
import japgolly.scalajs.react.vdom.{VdomElement, VdomNode}

import scala.scalajs.js

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiToggle[T](
  key:                  js.UndefOr[String]                                 = js.undefined,
  ref:                  js.UndefOr[MuiToggleM => Unit]                     = js.undefined,
  /* Determines whether the Toggle is initially turned on.
     **Warning:** This cannot be used in conjunction with `toggled`.
     Decide between using a controlled or uncontrolled input element and remove one of these props.
     More info: https://fb.me/react-controlled-components */
  defaultToggled:       js.UndefOr[Boolean]                                = js.undefined,
  /* Will disable the toggle if true. */
  disabled:             js.UndefOr[Boolean]                                = js.undefined,
  /* Overrides the inline-styles of the Toggle element. */
  elementStyle:         js.UndefOr[CssProperties]                          = js.undefined,
  /* Overrides the inline-styles of the Icon element. */
  iconStyle:            js.UndefOr[CssProperties]                          = js.undefined,
  /* Overrides the inline-styles of the input element. */
  inputStyle:           js.UndefOr[CssProperties]                          = js.undefined,
  /* Label for toggle. */
  label:                js.UndefOr[VdomNode]                              = js.undefined,
  /* Where the label will be placed next to the toggle. */
  labelPosition:        js.UndefOr[LeftRight]                              = js.undefined,
  /* Overrides the inline-styles of the Toggle element label. */
  labelStyle:           js.UndefOr[CssProperties]                          = js.undefined,
  /* Callback function that is fired when the toggle switch is toggled.
     @param {object} event Change event targeting the toggle.
     @param {bool} isInputChecked The new value of the toggle. */
  onToggle:             js.UndefOr[(ReactMouseEvent, Boolean) => Callback] = js.undefined,
  /* Override style of ripple. */
  rippleStyle:          js.UndefOr[CssProperties]                          = js.undefined,
  /* Override the inline-styles of the root element. */
  style:                js.UndefOr[CssProperties]                          = js.undefined,
  /* Override style for thumb. */
  thumbStyle:           js.UndefOr[CssProperties]                          = js.undefined,
  /* Override the inline styles for thumb when the toggle switch is toggled on. */
  thumbSwitchedStyle:   js.UndefOr[CssProperties]                          = js.undefined,
  /* Toggled if set to true. */
  toggled:              js.UndefOr[Boolean]                                = js.undefined,
  /* Override style for track. */
  trackStyle:           js.UndefOr[CssProperties]                          = js.undefined,
  /* Override the inline styles for track when the toggle switch is toggled on. */
  trackSwitchedStyle:   js.UndefOr[CssProperties]                          = js.undefined,
  /* ValueLink prop for when using controlled toggle. */
  valueLink:            js.UndefOr[js.Any]                                 = js.undefined,
  /* (Passed on to EnhancedSwitch) */
  checked:              js.UndefOr[Boolean]                                = js.undefined,
  /* (Passed on to EnhancedSwitch) */
  className:            js.UndefOr[String]                                 = js.undefined,
  /* (Passed on to EnhancedSwitch) */
  defaultChecked:       js.UndefOr[Boolean]                                = js.undefined,
  /* (Passed on to EnhancedSwitch) */
  disableFocusRipple:   js.UndefOr[Boolean]                                = js.undefined,
  /* (Passed on to EnhancedSwitch) */
  disableTouchRipple:   js.UndefOr[Boolean]                                = js.undefined,
  /* (Passed on to EnhancedSwitch) */
  inputType:            js.UndefOr[String]                                 = js.undefined,
  /* (Passed on to EnhancedSwitch) */
  name:                 js.UndefOr[String]                                 = js.undefined,
  /* (Passed on to EnhancedSwitch) */
  onBlur:               js.UndefOr[ReactFocusEvent => Callback]            = js.undefined,
  /* (Passed on to EnhancedSwitch) */
  onFocus:              js.UndefOr[ReactFocusEvent => Callback]            = js.undefined,
  /* (Passed on to EnhancedSwitch) */
  onMouseDown:          js.UndefOr[ReactMouseEvent => Callback]            = js.undefined,
  /* (Passed on to EnhancedSwitch) */
  onMouseLeave:         js.UndefOr[ReactMouseEvent => Callback]            = js.undefined,
  /* (Passed on to EnhancedSwitch) */
  onMouseUp:            js.UndefOr[ReactMouseEvent => Callback]            = js.undefined,
  /* (Passed on to EnhancedSwitch) */
  onParentShouldUpdate: js.UndefOr[Boolean => Callback]                    = js.undefined,
  /* (Passed on to EnhancedSwitch) */
  onSwitch:             js.UndefOr[(ReactMouseEvent, Boolean) => Callback] = js.undefined,
  /* (Passed on to EnhancedSwitch) */
  onTouchEnd:           js.UndefOr[ReactTouchEvent => Callback]            = js.undefined,
  /* (Passed on to EnhancedSwitch) */
  onTouchStart:         js.UndefOr[ReactTouchEvent => Callback]            = js.undefined,
  /* (Passed on to EnhancedSwitch) */
  rippleColor:          js.UndefOr[MuiColor]                               = js.undefined,
  /* (Passed on to EnhancedSwitch) */
  switchElement:        js.UndefOr[VdomElement]                           = js.undefined,
  /* (Passed on to EnhancedSwitch) */
  switched:             js.UndefOr[Boolean]                                = js.undefined,
  /* (Passed on to EnhancedSwitch) */
  value:                js.UndefOr[T]                                      = js.undefined){

  def apply() = {
    implicit def evT(t: T): js.Any = t.asInstanceOf[js.Any]
    val props = JSMacro[MuiToggle[T]](this)
    val component = JsComponent[js.Object, Children.None, Null](Mui.Toggle)
    component(props)
  }
}
        


@js.native
class MuiToggleM extends js.Object {
  def isToggled(): Boolean = js.native

  def setToggled(newToggledValue: Boolean): Unit = js.native
}
