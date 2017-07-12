package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.React
import japgolly.scalajs.react.vdom.{VdomElement, VdomNode}

import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiTab[T](
  key:                  js.UndefOr[String]                                 = js.undefined,
  ref:                  js.UndefOr[String]                                 = js.undefined,
  /* Override the inline-styles of the button element. */
  buttonStyle:          js.UndefOr[CssProperties]                          = js.undefined,
  /* The css class name of the root element. */
  className:            js.UndefOr[String]                                 = js.undefined,
  /* Sets the icon of the tab, you can pass `FontIcon` or `SvgIcon` elements. */
  icon:                 js.UndefOr[VdomNode]                              = js.undefined,
  index:                js.UndefOr[js.Any]                                 = js.undefined,
  /* Sets the text value of the tab item to the string specified. */
  label:                js.UndefOr[VdomNode]                              = js.undefined,
  /* Fired when the active tab changes by touch or tap.
     Use this event to specify any functionality when an active tab changes.
     For example - we are using this to route to home when the third tab becomes active.
     This function will always recieve the active tab as it\'s first argument. */
  onActive:             js.UndefOr[VdomElement => Callback]               = js.undefined,
  /* This property is overriden by the Tabs component. */
  onTouchTap:           js.UndefOr[TouchTapEvent => Callback]              = js.undefined,
  /* Defines if the current tab is selected or not.
     The Tabs component is responsible for setting this property. */
  selected:             js.UndefOr[Boolean]                                = js.undefined,
  /* Override the inline-styles of the root element. */
  style:                js.UndefOr[CssProperties]                          = js.undefined,
  /* If value prop passed to Tabs component, this value prop is also required.
     It assigns a value to the tab so that it can be selected by the Tabs. */
  value:                js.UndefOr[T]                                      = js.undefined,
  /* This property is overriden by the Tabs component. */
  width:                js.UndefOr[String]                                 = js.undefined,
  /* (Passed on to EnhancedButton) */
  centerRipple:         js.UndefOr[Boolean]                                = js.undefined,
  /* (Passed on to EnhancedButton) */
  containerElement:     js.UndefOr[String | VdomElement]                  = js.undefined,
  /* (Passed on to EnhancedButton) */
  disableFocusRipple:   js.UndefOr[Boolean]                                = js.undefined,
  /* (Passed on to EnhancedButton) */
  disableKeyboardFocus: js.UndefOr[Boolean]                                = js.undefined,
  /* (Passed on to EnhancedButton) */
  disableTouchRipple:   js.UndefOr[Boolean]                                = js.undefined,
  /* (Passed on to EnhancedButton) */
  disabled:             js.UndefOr[Boolean]                                = js.undefined,
  /* (Passed on to EnhancedButton) */
  focusRippleColor:     js.UndefOr[MuiColor]                               = js.undefined,
  /* (Passed on to EnhancedButton) */
  focusRippleOpacity:   js.UndefOr[Double]                                 = js.undefined,
  /* (Passed on to EnhancedButton) */
  href:                 js.UndefOr[String]                                 = js.undefined,
  /* (Passed on to EnhancedButton) */
  keyboardFocused:      js.UndefOr[Boolean]                                = js.undefined,
  /* (Passed on to EnhancedButton) */
  onBlur:               js.UndefOr[ReactFocusEvent => Callback]            = js.undefined,
  /* (Passed on to EnhancedButton) */
  onClick:              js.UndefOr[ReactEvent => Callback]                 = js.undefined,
  /* (Passed on to EnhancedButton) */
  onFocus:              js.UndefOr[ReactFocusEvent => Callback]            = js.undefined,
  /* (Passed on to EnhancedButton) */
  onKeyDown:            js.UndefOr[ReactKeyboardEvent => Callback]         = js.undefined,
  /* (Passed on to EnhancedButton) */
  onKeyUp:              js.UndefOr[ReactKeyboardEvent => Callback]         = js.undefined,
  /* (Passed on to EnhancedButton) */
  onKeyboardFocus:      js.UndefOr[(ReactFocusEvent, Boolean) => Callback] = js.undefined,
  /* (Passed on to EnhancedButton) */
  tabIndex:             js.UndefOr[Double]                                 = js.undefined,
  /* (Passed on to EnhancedButton) */
  touchRippleColor:     js.UndefOr[MuiColor]                               = js.undefined,
  /* (Passed on to EnhancedButton) */
  touchRippleOpacity:   js.UndefOr[Double]                                 = js.undefined,
  /* (Passed on to EnhancedButton) */
  `type`:               js.UndefOr[String]                                 = js.undefined){


  def apply(children: VdomNode*) = {
    implicit def evT(t: T): js.Any = t.asInstanceOf[js.Any]
    val props = JSMacro[MuiTab[T]](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Mui.Tab)
    component(props)(children: _*)
  }
}
