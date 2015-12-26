package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiFlatButton(
  key:                  js.UndefOr[String]                          = js.undefined,
  ref:                  js.UndefOr[String]                          = js.undefined,
  backgroundColor:      js.UndefOr[MuiColor]                        = js.undefined,
  /* Disables the button if set to true.*/
  disabled:             js.UndefOr[Boolean]                         = js.undefined,
  /* Override the inline hover color of the button's root element.*/
  hoverColor:           js.UndefOr[MuiColor]                        = js.undefined,
  label:                js.UndefOr[String]                          = js.undefined,
  /* default: "before": Place label before or after the passed children*/
  labelPosition:        js.UndefOr[BeforeAfter]                     = js.undefined,
  /* Override the inline-styles of the button's label element.*/
  labelStyle:           js.UndefOr[CssProperties]                   = js.undefined,
  onKeyboardFocus:      js.UndefOr[ReactKeyboardEventH => Callback] = js.undefined,
  onMouseEnter:         js.UndefOr[ReactMouseEventH => Callback]    = js.undefined,
  onMouseLeave:         js.UndefOr[ReactMouseEventH => Callback]    = js.undefined,
  onTouchStart:         js.UndefOr[ReactTouchEventH => Callback]    = js.undefined,
  /* default: false: If true, the button will use the primary button colors.*/
  primary:              js.UndefOr[Boolean]                         = js.undefined,
  /* Override the inline color of the button's ripple element.*/
  rippleColor:          js.UndefOr[MuiColor]                        = js.undefined,
  /* default: false: If true, the button will use the secondary button colors.*/
  secondary:            js.UndefOr[Boolean]                         = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:                js.UndefOr[CssProperties]                   = js.undefined,
  /* (Passed on to EnhancedButton)*/
  centerRipple:         js.UndefOr[Boolean]                         = js.undefined,
  /* default: button: This component will render a button element by default and an anchor element if linkButton is set to true. However, you can override this behavior by passing in a string or another react element into this prop. This is useful for generating link buttons with the react router link element.
  (Passed on to EnhancedButton)*/
  containerElement:     js.UndefOr[String | ReactElement]           = js.undefined,
  /* (Passed on to EnhancedButton)*/
  disableFocusRipple:   js.UndefOr[Boolean]                         = js.undefined,
  /* (Passed on to EnhancedButton)*/
  disableKeyboardFocus: js.UndefOr[Boolean]                         = js.undefined,
  /* (Passed on to EnhancedButton)*/
  disableTouchRipple:   js.UndefOr[Boolean]                         = js.undefined,
  /* (Passed on to EnhancedButton)*/
  focusRippleColor:     js.UndefOr[MuiColor]                        = js.undefined,
  /* (Passed on to EnhancedButton)*/
  focusRippleOpacity:   js.UndefOr[Double]                          = js.undefined,
  /* (Passed on to EnhancedButton)*/
  keyboardFocused:      js.UndefOr[Boolean]                         = js.undefined,
  /* default: false: If true, an anchor element will be generated instead of a button element.
  (Passed on to EnhancedButton)*/
  linkButton:           js.UndefOr[Boolean]                         = js.undefined,
  /* (Passed on to EnhancedButton)*/
  onBlur:               js.UndefOr[ReactEventH => Callback]         = js.undefined,
  /* (Passed on to EnhancedButton)*/
  onFocus:              js.UndefOr[ReactFocusEventH => Callback]    = js.undefined,
  /* (Passed on to EnhancedButton)*/
  onKeyDown:            js.UndefOr[ReactKeyboardEventH => Callback] = js.undefined,
  /* (Passed on to EnhancedButton)*/
  onKeyUp:              js.UndefOr[ReactKeyboardEventH => Callback] = js.undefined,
  /* (Passed on to EnhancedButton)*/
  onTouchTap:           js.UndefOr[ReactTouchEventH => Callback]    = js.undefined,
  /* (Passed on to EnhancedButton)*/
  tabIndex:             js.UndefOr[Double]                          = js.undefined,
  /* (Passed on to EnhancedButton)*/
  touchRippleColor:     js.UndefOr[MuiColor]                        = js.undefined,
  /* (Passed on to EnhancedButton)*/
  touchRippleOpacity:   js.UndefOr[Double]                          = js.undefined,
  /* (Passed on to EnhancedButton)*/
  `type`:               js.UndefOr[String]                          = js.undefined){

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiFlatButton](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.FlatButton)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
