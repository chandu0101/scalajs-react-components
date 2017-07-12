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
    
case class MuiCheckbox[T](
  key:                  js.UndefOr[String]                                 = js.undefined,
  ref:                  js.UndefOr[MuiCheckboxM => Unit]                   = js.undefined,
  /* Checkbox is checked if true. */
  checked:              js.UndefOr[Boolean]                                = js.undefined,
  /* The SvgIcon to use for the checked state.
     This is useful to create icon toggles. */
  checkedIcon:          js.UndefOr[VdomElement]                           = js.undefined,
  /* The default state of our checkbox component.
     **Warning:** This cannot be used in conjunction with `checked`.
     Decide between using a controlled or uncontrolled input element and remove one of these props.
     More info: https://fb.me/react-controlled-components */
  defaultChecked:       js.UndefOr[Boolean]                                = js.undefined,
  /* Disabled if true. */
  disabled:             js.UndefOr[Boolean]                                = js.undefined,
  /* Overrides the inline-styles of the icon element. */
  iconStyle:            js.UndefOr[CssProperties]                          = js.undefined,
  /* Overrides the inline-styles of the input element. */
  inputStyle:           js.UndefOr[CssProperties]                          = js.undefined,
  /* Where the label will be placed next to the checkbox. */
  labelPosition:        js.UndefOr[LeftRight]                              = js.undefined,
  /* Overrides the inline-styles of the Checkbox element label. */
  labelStyle:           js.UndefOr[CssProperties]                          = js.undefined,
  /* Callback function that is fired when the checkbox is checked.
     @param {object} event `change` event targeting the underlying checkbox `input`.
     @param {boolean} isInputChecked The `checked` value of the underlying checkbox `input`. */
  onCheck:              js.UndefOr[(ReactMouseEvent, Boolean) => Callback] = js.undefined,
  /* Override the inline-styles of the root element. */
  style:                js.UndefOr[CssProperties]                          = js.undefined,
  /* The SvgIcon to use for the unchecked state.
     This is useful to create icon toggles. */
  uncheckedIcon:        js.UndefOr[VdomElement]                           = js.undefined,
  /* ValueLink for when using controlled checkbox. */
  valueLink:            js.UndefOr[js.Any]                                 = js.undefined,
  /* (Passed on to EnhancedSwitch) */
  className:            js.UndefOr[String]                                 = js.undefined,
  /* (Passed on to EnhancedSwitch) */
  disableFocusRipple:   js.UndefOr[Boolean]                                = js.undefined,
  /* (Passed on to EnhancedSwitch) */
  disableTouchRipple:   js.UndefOr[Boolean]                                = js.undefined,
  /* (Passed on to EnhancedSwitch) */
  inputType:            js.UndefOr[String]                                 = js.undefined,
  /* (Passed on to EnhancedSwitch) */
  label:                js.UndefOr[VdomNode]                              = js.undefined,
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
  rippleStyle:          js.UndefOr[CssProperties]                          = js.undefined,
  /* (Passed on to EnhancedSwitch) */
  switchElement:        js.UndefOr[VdomElement]                           = js.undefined,
  /* (Passed on to EnhancedSwitch) */
  switched:             js.UndefOr[Boolean]                                = js.undefined,
  /* (Passed on to EnhancedSwitch) */
  thumbStyle:           js.UndefOr[CssProperties]                          = js.undefined,
  /* (Passed on to EnhancedSwitch) */
  trackStyle:           js.UndefOr[CssProperties]                          = js.undefined,
  /* (Passed on to EnhancedSwitch) */
  value:                js.UndefOr[T]                                      = js.undefined){

  def apply() = {
    implicit def evT(t: T): js.Any = t.asInstanceOf[js.Any]
    val props = JSMacro[MuiCheckbox[T]](this)
    val component = JsComponent[js.Object, Children.None, Null](Mui.Checkbox)
    component(props)
  }
}



@js.native
class MuiCheckboxM extends js.Object {
  def isChecked(): Boolean = js.native

  def isChecked(newCheckedValue: Boolean): Unit = js.native
}
