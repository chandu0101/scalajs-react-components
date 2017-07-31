package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

/**
  * This file is generated - submit issues instead of PR against it
  */
case class MuiStepButton(
    key: js.UndefOr[String] = js.undefined,
    ref: js.UndefOr[String] = js.undefined,
    /* Passed from `Step` Is passed to StepLabel.*/
    active: js.UndefOr[Boolean] = js.undefined,
    /* Sets completed styling. Is passed to StepLabel.*/
    completed: js.UndefOr[Boolean] = js.undefined,
    /* Disables the button and sets disabled styling. Is passed to StepLabel.*/
    disabled: js.UndefOr[Boolean] = js.undefined,
    /* The icon displayed by the step label.*/
    icon: js.UndefOr[ReactElement | String | Double] = js.undefined,
    /* Callback function fired when the mouse enters the element.*/
    onMouseEnter: js.UndefOr[ReactMouseEventH => Callback] = js.undefined,
    /* Callback function fired when the mouse leaves the element.*/
    onMouseLeave: js.UndefOr[ReactMouseEventH => Callback] = js.undefined,
    /* Callback function fired when the element is touched.*/
    onTouchStart: js.UndefOr[ReactTouchEventH => Callback] = js.undefined,
    /* Override the inline-style of the root element.*/
    style: js.UndefOr[CssProperties] = js.undefined,
    /* (Passed on to EnhancedButton)*/
    centerRipple: js.UndefOr[Boolean] = js.undefined,
    /* (Passed on to EnhancedButton)*/
    containerElement: js.UndefOr[String | ReactElement] = js.undefined,
    /* (Passed on to EnhancedButton)*/
    disableFocusRipple: js.UndefOr[Boolean] = js.undefined,
    /* (Passed on to EnhancedButton)*/
    disableKeyboardFocus: js.UndefOr[Boolean] = js.undefined,
    /* (Passed on to EnhancedButton)*/
    disableTouchRipple: js.UndefOr[Boolean] = js.undefined,
    /* (Passed on to EnhancedButton)*/
    focusRippleColor: js.UndefOr[MuiColor] = js.undefined,
    /* (Passed on to EnhancedButton)*/
    focusRippleOpacity: js.UndefOr[Double] = js.undefined,
    /* (Passed on to EnhancedButton)*/
    keyboardFocused: js.UndefOr[Boolean] = js.undefined,
    /* (Passed on to EnhancedButton)*/
    linkButton: js.UndefOr[Boolean] = js.undefined,
    /* (Passed on to EnhancedButton)*/
    onBlur: js.UndefOr[ReactEventH => Callback] = js.undefined,
    /* (Passed on to EnhancedButton)*/
    onClick: js.UndefOr[ReactEventH => Callback] = js.undefined,
    /* (Passed on to EnhancedButton)*/
    onFocus: js.UndefOr[ReactFocusEventH => Callback] = js.undefined,
    /* (Passed on to EnhancedButton)*/
    onKeyDown: js.UndefOr[ReactKeyboardEventH => Callback] = js.undefined,
    /* (Passed on to EnhancedButton)*/
    onKeyUp: js.UndefOr[ReactKeyboardEventH => Callback] = js.undefined,
    /* (Passed on to EnhancedButton)*/
    onKeyboardFocus: js.UndefOr[ReactKeyboardEventH => Callback] = js.undefined,
    /* (Passed on to EnhancedButton)*/
    onTouchTap: js.UndefOr[ReactTouchEventH => Callback] = js.undefined,
    /* (Passed on to EnhancedButton)*/
    tabIndex: js.UndefOr[Double] = js.undefined,
    /* (Passed on to EnhancedButton)*/
    touchRippleColor: js.UndefOr[MuiColor] = js.undefined,
    /* (Passed on to EnhancedButton)*/
    touchRippleOpacity: js.UndefOr[Double] = js.undefined,
    /* (Passed on to EnhancedButton)*/
    `type`: js.UndefOr[String] = js.undefined) {

  /**
    * @param children Can be a `StepLabel` or a node to place inside `StepLabel` as children.
    */
  def apply(children: ReactNode*) = {

    val props = JSMacro[MuiStepButton](this)
    val f     = React.asInstanceOf[js.Dynamic].createFactory(Mui.StepButton)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
