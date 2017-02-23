package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import org.scalajs.dom
import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiIconButton(
  key:                  js.UndefOr[String]                                 = js.undefined,
  ref:                  js.UndefOr[MuiIconButtonM => Unit]                 = js.undefined,
  /* The CSS class name of the root element. */
  className:            js.UndefOr[String]                                 = js.undefined,
  /* If true, the element's ripple effect will be disabled. */
  disableTouchRipple:   js.UndefOr[Boolean]                                = js.undefined,
  /* If true, the element will be disabled. */
  disabled:             js.UndefOr[Boolean]                                = js.undefined,
  /* Override the inline-styles of the root element when the component is hovered. */
  hoveredStyle:         js.UndefOr[CssProperties]                          = js.undefined,
  /* The URL to link to when the button is clicked. */
  href:                 js.UndefOr[String]                                 = js.undefined,
  /* The CSS class name of the icon. Used for setting the icon with a stylesheet. */
  iconClassName:        js.UndefOr[String]                                 = js.undefined,
  /* Override the inline-styles of the icon element.
     Note: you can specify iconHoverColor as a String inside this object. */
  iconStyle:            js.UndefOr[CssProperties]                          = js.undefined,
  onBlur:               js.UndefOr[ReactFocusEvent => Callback]            = js.undefined,
  onFocus:              js.UndefOr[ReactFocusEvent => Callback]            = js.undefined,
  /* Callback function fired when the element is focused or blurred by the keyboard.
     @param {object} event `focus` or `blur` event targeting the element.
     @param {boolean} keyboardFocused Indicates whether the element is focused. */
  onKeyboardFocus:      js.UndefOr[(ReactFocusEvent, Boolean) => Callback] = js.undefined,
  onMouseEnter:         js.UndefOr[ReactMouseEvent => Callback]            = js.undefined,
  onMouseLeave:         js.UndefOr[ReactMouseEvent => Callback]            = js.undefined,
  onMouseOut:           js.UndefOr[ReactMouseEvent => Callback]            = js.undefined,
  onTouchStart:         js.UndefOr[ReactTouchEvent => Callback]            = js.undefined,
  /* Override the inline-styles of the root element. */
  style:                js.UndefOr[CssProperties]                          = js.undefined,
  /* The text to supply to the element's tooltip. */
  tooltip:              js.UndefOr[ReactNode]                              = js.undefined,
  /* The vertical and horizontal positions, respectively, of the element's tooltip.
     Possible values are: "bottom-center", "top-center", "bottom-right", "top-right",
     "bottom-left", and "top-left". */
  tooltipPosition:      js.UndefOr[CornersAndCenter]                       = js.undefined,
  /* Override the inline-styles of the tooltip element. */
  tooltipStyles:        js.UndefOr[CssProperties]                          = js.undefined,
  /* If true, increase the tooltip element's size. Useful for increasing tooltip
     readability on mobile devices. */
  touch:                js.UndefOr[Boolean]                                = js.undefined,
  /* (Passed on to EnhancedButton) */
  centerRipple:         js.UndefOr[Boolean]                                = js.undefined,
  /* (Passed on to EnhancedButton) */
  containerElement:     js.UndefOr[String | ReactElement]                  = js.undefined,
  /* (Passed on to EnhancedButton) */
  disableFocusRipple:   js.UndefOr[Boolean]                                = js.undefined,
  /* (Passed on to EnhancedButton) */
  disableKeyboardFocus: js.UndefOr[Boolean]                                = js.undefined,
  /* (Passed on to EnhancedButton) */
  focusRippleColor:     js.UndefOr[MuiColor]                               = js.undefined,
  /* (Passed on to EnhancedButton) */
  focusRippleOpacity:   js.UndefOr[Double]                                 = js.undefined,
  /* (Passed on to EnhancedButton) */
  keyboardFocused:      js.UndefOr[Boolean]                                = js.undefined,
  /* (Passed on to EnhancedButton) */
  onClick:              js.UndefOr[ReactEvent => Callback]                 = js.undefined,
  /* (Passed on to EnhancedButton) */
  onKeyDown:            js.UndefOr[ReactKeyboardEvent => Callback]         = js.undefined,
  /* (Passed on to EnhancedButton) */
  onKeyUp:              js.UndefOr[ReactKeyboardEvent => Callback]         = js.undefined,
  /* (Passed on to EnhancedButton) */
  onTouchTap:           js.UndefOr[TouchTapEvent => Callback]              = js.undefined,
  /* (Passed on to EnhancedButton) */
  tabIndex:             js.UndefOr[Double]                                 = js.undefined,
  /* (Passed on to EnhancedButton) */
  touchRippleColor:     js.UndefOr[MuiColor]                               = js.undefined,
  /* (Passed on to EnhancedButton) */
  touchRippleOpacity:   js.UndefOr[Double]                                 = js.undefined,
  /* (Passed on to EnhancedButton) */
  `type`:               js.UndefOr[String]                                 = js.undefined){

  /**
    * @param children Can be used to pass a `FontIcon` element as the icon for the button.
   */
  def apply(children: ReactNode*) = {
    
    val props = JSMacro[MuiIconButton](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.IconButton)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}


@js.native
class MuiIconButtonM extends js.Object {
  def hideTooltip(): js.Dynamic = js.native

  def setKeyboardFocus(): js.Dynamic = js.native

  def showTooltip(): js.Dynamic = js.native
}
