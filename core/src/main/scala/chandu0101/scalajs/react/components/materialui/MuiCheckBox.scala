package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiCheckbox(
  key:                  js.UndefOr[String]                             = js.undefined,
  ref:                  js.UndefOr[MuiCheckboxM => Unit]               = js.undefined,
  checked:              js.UndefOr[Boolean]                            = js.undefined,
  /* The SvgIcon to use for the checked state. This is useful to create icon toggles.*/
  checkedIcon:          js.UndefOr[ReactElement]                       = js.undefined,
  /* default:false: The default state of our checkbox component.*/
  defaultChecked:       js.UndefOr[Boolean]                            = js.undefined,
  disabled:             js.UndefOr[Boolean]                            = js.undefined,
  /* Overrides the inline-styles of the icon element.*/
  iconStyle:            js.UndefOr[CssProperties]                      = js.undefined,
  /* default:"right": Where the label will be placed next to the checkbox. Options include "left" and "right" (case-sensitive). Default option is "right".*/
  labelPosition:        js.UndefOr[LeftRight]                          = js.undefined,
  /* Overrides the inline-styles of the Checkbox element label.*/
  labelStyle:           js.UndefOr[CssProperties]                      = js.undefined,
  /* Callback function that is fired when the checkbox is checked.*/
  onCheck:              js.UndefOr[(ReactEventH, Boolean) => Callback] = js.undefined,
  /* The SvgIcon to use for the unchecked state. This is useful to create icon toggles.*/
  unCheckedIcon:        js.UndefOr[ReactElement]                       = js.undefined,
  valueLink:            js.UndefOr[js.Any]                             = js.undefined,
  /* The css class name of the root element.
  (Passed on to EnhancedSwitch)*/
  className:            js.UndefOr[String]                             = js.undefined,
  /* (Passed on to EnhancedSwitch)*/
  defaultSwitched:      js.UndefOr[Boolean]                            = js.undefined,
  /* (Passed on to EnhancedSwitch)*/
  disableFocusRipple:   js.UndefOr[Boolean]                            = js.undefined,
  /* (Passed on to EnhancedSwitch)*/
  disableTouchRipple:   js.UndefOr[Boolean]                            = js.undefined,
  /* (Passed on to EnhancedSwitch)*/
  id:                   js.UndefOr[String]                             = js.undefined,
  /* (Passed on to EnhancedSwitch)*/
  inputType:            js.UndefOr[String]                             = js.undefined,
  /* The text that is displayed beside the checkbox.
  (Passed on to EnhancedSwitch)*/
  label:                js.UndefOr[ReactNode]                          = js.undefined,
  /* (Passed on to EnhancedSwitch)*/
  name:                 js.UndefOr[String]                             = js.undefined,
  /* (Passed on to EnhancedSwitch)*/
  onBlur:               js.UndefOr[ReactEventH => Callback]            = js.undefined,
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
  required:             js.UndefOr[Boolean]                            = js.undefined,
  /* (Passed on to EnhancedSwitch)*/
  rippleColor:          js.UndefOr[MuiColor]                           = js.undefined,
  /* (Passed on to EnhancedSwitch)*/
  rippleStyle:          js.UndefOr[CssProperties]                      = js.undefined,
  /* Override the inline-styles of the root element.
  (Passed on to EnhancedSwitch)*/
  style:                js.UndefOr[CssProperties]                      = js.undefined,
  /* (Passed on to EnhancedSwitch)*/
  switchElement:        js.UndefOr[ReactElement]                       = js.undefined,
  /* (Passed on to EnhancedSwitch)*/
  switched:             js.UndefOr[Boolean]                            = js.undefined,
  /* (Passed on to EnhancedSwitch)*/
  thumbStyle:           js.UndefOr[CssProperties]                      = js.undefined,
  /* (Passed on to EnhancedSwitch)*/
  trackStyle:           js.UndefOr[CssProperties]                      = js.undefined,
  /* (Passed on to EnhancedSwitch)*/
  value:                js.UndefOr[String]                             = js.undefined){

  def apply() = {
    val props = JSMacro[MuiCheckbox](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Checkbox)
    f(props).asInstanceOf[ReactComponentU_]
  }
}
        


@js.native
class MuiCheckboxM extends js.Object {
  /* Returns true if the checkbox is currently checked. Returns false otherwise*/
  def isChecked(): Boolean = js.native

  /* Sets the checkbox to the value of newCheckedValue. This method cannot be used while "checked" is defined as a property.*/
  def isChecked(newCheckedValue: Boolean): Unit = js.native
}
