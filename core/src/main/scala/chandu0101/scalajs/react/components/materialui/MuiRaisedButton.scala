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
    
case class MuiRaisedButton(
  key:                     js.UndefOr[String]                                 = js.undefined,
  ref:                     js.UndefOr[String]                                 = js.undefined,
  /* Override the default background color for the button,
     but not the default disabled background color
     (use `disabledBackgroundColor` for this). */
  backgroundColor:         js.UndefOr[MuiColor]                               = js.undefined,
  /* Override the inline-styles of the button element. */
  buttonStyle:             js.UndefOr[CssProperties]                          = js.undefined,
  /* The CSS class name of the root element. */
  className:               js.UndefOr[String]                                 = js.undefined,
  /* If true, the button will be disabled. */
  disabled:                js.UndefOr[Boolean]                                = js.undefined,
  /* Override the default background color for the button
     when it is disabled. */
  disabledBackgroundColor: js.UndefOr[MuiColor]                               = js.undefined,
  /* The color of the button's label when the button is disabled. */
  disabledLabelColor:      js.UndefOr[MuiColor]                               = js.undefined,
  /* If true, the button will take up the full width of its container. */
  fullWidth:               js.UndefOr[Boolean]                                = js.undefined,
  /* The URL to link to when the button is clicked. */
  href:                    js.UndefOr[String]                                 = js.undefined,
  /* An icon to be displayed within the button. */
  icon:                    js.UndefOr[VdomNode]                              = js.undefined,
  /* The label to be displayed within the button.
     If content is provided via the `children` prop, that content will be
     displayed in addition to the label provided here. */
  label:                   js.UndefOr[String]                                 = js.undefined,
  /* The color of the button's label. */
  labelColor:              js.UndefOr[MuiColor]                               = js.undefined,
  /* The position of the button's label relative to the button's `children`. */
  labelPosition:           js.UndefOr[BeforeAfter]                            = js.undefined,
  /* Override the inline-styles of the button's label element. */
  labelStyle:              js.UndefOr[CssProperties]                          = js.undefined,
  onMouseDown:             js.UndefOr[ReactMouseEvent => Callback]            = js.undefined,
  onMouseEnter:            js.UndefOr[ReactMouseEvent => Callback]            = js.undefined,
  onMouseLeave:            js.UndefOr[ReactMouseEvent => Callback]            = js.undefined,
  onMouseUp:               js.UndefOr[ReactMouseEvent => Callback]            = js.undefined,
  onTouchEnd:              js.UndefOr[ReactTouchEvent => Callback]            = js.undefined,
  onTouchStart:            js.UndefOr[ReactTouchEvent => Callback]            = js.undefined,
  /* Override the inline style of the button overlay. */
  overlayStyle:            js.UndefOr[CssProperties]                          = js.undefined,
  /* If true, the button will use the theme's primary color. */
  primary:                 js.UndefOr[Boolean]                                = js.undefined,
  /* Override the inline style of the ripple element. */
  rippleStyle:             js.UndefOr[CssProperties]                          = js.undefined,
  /* If true, the button will use the theme's secondary color.
     If both `secondary` and `primary` are true, the button will use
     the theme's primary color. */
  secondary:               js.UndefOr[Boolean]                                = js.undefined,
  /* Override the inline-styles of the root element. */
  style:                   js.UndefOr[CssProperties]                          = js.undefined,
  /* (Passed on to EnhancedButton) */
  centerRipple:            js.UndefOr[Boolean]                                = js.undefined,
  /* (Passed on to EnhancedButton) */
  containerElement:        js.UndefOr[String | VdomElement]                  = js.undefined,
  /* (Passed on to EnhancedButton) */
  disableFocusRipple:      js.UndefOr[Boolean]                                = js.undefined,
  /* (Passed on to EnhancedButton) */
  disableKeyboardFocus:    js.UndefOr[Boolean]                                = js.undefined,
  /* (Passed on to EnhancedButton) */
  disableTouchRipple:      js.UndefOr[Boolean]                                = js.undefined,
  /* (Passed on to EnhancedButton) */
  focusRippleColor:        js.UndefOr[MuiColor]                               = js.undefined,
  /* (Passed on to EnhancedButton) */
  focusRippleOpacity:      js.UndefOr[Double]                                 = js.undefined,
  /* (Passed on to EnhancedButton) */
  keyboardFocused:         js.UndefOr[Boolean]                                = js.undefined,
  /* (Passed on to EnhancedButton) */
  onBlur:                  js.UndefOr[ReactFocusEvent => Callback]            = js.undefined,
  /* (Passed on to EnhancedButton) */
  onClick:                 js.UndefOr[ReactEvent => Callback]                 = js.undefined,
  /* (Passed on to EnhancedButton) */
  onFocus:                 js.UndefOr[ReactFocusEvent => Callback]            = js.undefined,
  /* (Passed on to EnhancedButton) */
  onKeyDown:               js.UndefOr[ReactKeyboardEvent => Callback]         = js.undefined,
  /* (Passed on to EnhancedButton) */
  onKeyUp:                 js.UndefOr[ReactKeyboardEvent => Callback]         = js.undefined,
  /* (Passed on to EnhancedButton) */
  onKeyboardFocus:         js.UndefOr[(ReactFocusEvent, Boolean) => Callback] = js.undefined,
  /* (Passed on to EnhancedButton) */
  onTouchTap:              js.UndefOr[TouchTapEvent => Callback]              = js.undefined,
  /* (Passed on to EnhancedButton) */
  tabIndex:                js.UndefOr[Double]                                 = js.undefined,
  /* (Passed on to EnhancedButton) */
  touchRippleColor:        js.UndefOr[MuiColor]                               = js.undefined,
  /* (Passed on to EnhancedButton) */
  touchRippleOpacity:      js.UndefOr[Double]                                 = js.undefined,
  /* (Passed on to EnhancedButton) */
  `type`:                  js.UndefOr[String]                                 = js.undefined){

  /**
    * @param children The content of the button.
    If a label is provided via the `label` prop, the text within the label
    will be displayed in addition to the content provided here.
   */
  def apply(children: VdomNode*) = {
    
    val props = JSMacro[MuiRaisedButton](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Mui.RaisedButton)
    component(props)(children: _*)
  }
}
