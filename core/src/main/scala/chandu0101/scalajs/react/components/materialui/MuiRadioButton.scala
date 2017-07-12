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
case class MuiRadioButton[T](key: js.UndefOr[String] = js.undefined,
                             ref: js.UndefOr[MuiRadioButtonM => Unit] = js.undefined,
                             /* checked if true
     Used internally by `RadioButtonGroup`. */
                             checked: js.UndefOr[Boolean] = js.undefined,
                             /* The icon element to show when the radio button is checked. */
                             checkedIcon: js.UndefOr[VdomElement] = js.undefined,
                             /* If true, the radio button is disabled. */
                             disabled: js.UndefOr[Boolean] = js.undefined,
                             /* Override the inline-styles of the icon element. */
                             iconStyle: js.UndefOr[CssProperties] = js.undefined,
                             /* Override the inline-styles of the input element. */
                             inputStyle: js.UndefOr[CssProperties] = js.undefined,
                             /* Used internally by `RadioButtonGroup`. Use the `labelPosition` property of `RadioButtonGroup` instead.
     Where the label will be placed next to the radio button. */
                             labelPosition: js.UndefOr[LeftRight] = js.undefined,
                             /* Override the inline-styles of the label element. */
                             labelStyle: js.UndefOr[CssProperties] = js.undefined,
                             /* Callback function fired when the radio button is checked. Note that this
     function will not be called if the radio button is part of a
     radio button group: in this case, use the `onChange` property of
     `RadioButtonGroup`.
     @param {object} event `change` event targeting the element.
     @param {string} value The element's `value`. */
                             onCheck: js.UndefOr[(ReactEvent, String) => Callback] = js.undefined,
                             /* Override the inline-styles of the root element. */
                             style: js.UndefOr[CssProperties] = js.undefined,
                             /* The icon element to show when the radio button is unchecked. */
                             uncheckedIcon: js.UndefOr[VdomElement] = js.undefined,
                             /* The value of the radio button. */
                             value: js.UndefOr[T] = js.undefined,
                             /* (Passed on to EnhancedSwitch) */
                             className: js.UndefOr[String] = js.undefined,
                             /* (Passed on to EnhancedSwitch) */
                             defaultChecked: js.UndefOr[Boolean] = js.undefined,
                             /* (Passed on to EnhancedSwitch) */
                             disableFocusRipple: js.UndefOr[Boolean] = js.undefined,
                             /* (Passed on to EnhancedSwitch) */
                             disableTouchRipple: js.UndefOr[Boolean] = js.undefined,
                             /* (Passed on to EnhancedSwitch) */
                             inputType: js.UndefOr[String] = js.undefined,
                             /* (Passed on to EnhancedSwitch) */
                             label: js.UndefOr[VdomNode] = js.undefined,
                             /* (Passed on to EnhancedSwitch) */
                             name: js.UndefOr[String] = js.undefined,
                             /* (Passed on to EnhancedSwitch) */
                             onBlur: js.UndefOr[ReactFocusEvent => Callback] = js.undefined,
                             /* (Passed on to EnhancedSwitch) */
                             onFocus: js.UndefOr[ReactFocusEvent => Callback] = js.undefined,
                             /* (Passed on to EnhancedSwitch) */
                             onMouseDown: js.UndefOr[ReactMouseEvent => Callback] = js.undefined,
                             /* (Passed on to EnhancedSwitch) */
                             onMouseLeave: js.UndefOr[ReactMouseEvent => Callback] = js.undefined,
                             /* (Passed on to EnhancedSwitch) */
                             onMouseUp: js.UndefOr[ReactMouseEvent => Callback] = js.undefined,
                             /* (Passed on to EnhancedSwitch) */
                             onParentShouldUpdate: js.UndefOr[Boolean => Callback] = js.undefined,
                             /* (Passed on to EnhancedSwitch) */
                             onSwitch: js.UndefOr[(ReactMouseEvent, Boolean) => Callback] =
                               js.undefined,
                             /* (Passed on to EnhancedSwitch) */
                             onTouchEnd: js.UndefOr[ReactTouchEvent => Callback] = js.undefined,
                             /* (Passed on to EnhancedSwitch) */
                             onTouchStart: js.UndefOr[ReactTouchEvent => Callback] = js.undefined,
                             /* (Passed on to EnhancedSwitch) */
                             rippleColor: js.UndefOr[MuiColor] = js.undefined,
                             /* (Passed on to EnhancedSwitch) */
                             rippleStyle: js.UndefOr[CssProperties] = js.undefined,
                             /* (Passed on to EnhancedSwitch) */
                             switchElement: js.UndefOr[VdomElement] = js.undefined,
                             /* (Passed on to EnhancedSwitch) */
                             switched: js.UndefOr[Boolean] = js.undefined,
                             /* (Passed on to EnhancedSwitch) */
                             thumbStyle: js.UndefOr[CssProperties] = js.undefined,
                             /* (Passed on to EnhancedSwitch) */
                             trackStyle: js.UndefOr[CssProperties] = js.undefined) {

  def apply() = {
    implicit def evT(t: T): js.Any = t.asInstanceOf[js.Any]
    val props                      = JSMacro[MuiRadioButton[T]](this)
    val component                  = JsComponent[js.Object, Children.None, Null](Mui.RadioButton)
    component(props)
  }
}
@js.native
class MuiRadioButtonM extends js.Object {
  def getValue(): js.Dynamic = js.native

  def isChecked(): js.Dynamic = js.native

  def setChecked(newCheckedValue: js.Any): js.Dynamic = js.native
}
