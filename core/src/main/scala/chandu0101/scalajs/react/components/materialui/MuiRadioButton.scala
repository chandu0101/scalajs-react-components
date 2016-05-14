package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiRadioButton(
  key:                  js.UndefOr[String]                             = js.undefined,
  ref:                  js.UndefOr[String]                             = js.undefined,
  /* checked if true
  Used internally by `RadioButtonGroup`.*/
  @deprecated("Internal API")
  checked:              js.UndefOr[Boolean]                            = js.undefined,
  /* The icon element to show when the radio button is checked.*/
  checkedIcon:          js.UndefOr[ReactElement]                       = js.undefined,
  /* If true, the radio button is disabled.*/
  disabled:             js.UndefOr[Boolean]                            = js.undefined,
  /* Override the inline-styles of the icon element.*/
  iconStyle:            js.UndefOr[CssProperties]                      = js.undefined,
  /* Override the inline-styles of the input element.*/
  inputStyle:           js.UndefOr[CssProperties]                      = js.undefined,
  /* Used internally by `RadioButtonGroup`. Use the `labelPosition` property of `RadioButtonGroup` instead.
  Where the label will be placed next to the radio button.*/
  @deprecated("Internal API")
  labelPosition:        js.UndefOr[LeftRight]                          = js.undefined,
  /* Override the inline-styles of the label element.*/
  labelStyle:           js.UndefOr[CssProperties]                      = js.undefined,
  /* Callback function fired when the radio button is checked. Note that this
  function will not be called if the radio button is part of a
  radio button group: in this case, use the `onChange` property of
  `RadioButtonGroup`.*/
  @deprecated("Internal API")
  onCheck:              js.UndefOr[(ReactEventH, Boolean) => Callback] = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:                js.UndefOr[CssProperties]                      = js.undefined,
  /* The icon element to show when the radio button is unchecked.*/
  uncheckedIcon:        js.UndefOr[ReactElement]                       = js.undefined,
  /* The value of the radio button.*/
  value:                js.UndefOr[String]                             = js.undefined,
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
  trackStyle:           js.UndefOr[CssProperties]                      = js.undefined){

  def apply() = {
    val props = JSMacro[MuiRadioButton](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.RadioButton)
    f(props).asInstanceOf[ReactComponentU_]
  }
}
        
