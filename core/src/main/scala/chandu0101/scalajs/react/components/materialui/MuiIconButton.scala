package chandu0101.scalajs.react.components
package materialui
import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
/**
 * This file is generated - submit issues instead of PR against it
 */
case class MuiIconButton(
  key:                  js.UndefOr[String]                          = js.undefined,
  ref:                  js.UndefOr[MuiIconButtonM => Unit]          = js.undefined,
  /* The CSS class name of the root element.*/
  className:            js.UndefOr[String]                          = js.undefined,
  /* If true, the element's ripple effect will be disabled.*/
  disableTouchRipple:   js.UndefOr[Boolean]                         = js.undefined,
  /* If true, the element will be disabled.*/
  disabled:             js.UndefOr[Boolean]                         = js.undefined,
  /* The CSS class name of the icon. Used for setting the icon with a stylesheet.*/
  iconClassName:        js.UndefOr[String]                          = js.undefined,
  /* Override the inline-styles of the icon element.*/
  iconStyle:            js.UndefOr[CssProperties]                   = js.undefined,
  /* Callback function fired when the element loses focus.*/
  onBlur:               js.UndefOr[ReactEventH => Callback]         = js.undefined,
  /* Callback function fired when the element gains focus.*/
  onFocus:              js.UndefOr[ReactFocusEventH => Callback]    = js.undefined,
  /* Callback function fired when the element is focused or blurred by the keyboard.*/
  onKeyboardFocus:      js.UndefOr[ReactKeyboardEventH => Callback] = js.undefined,
  /* Callback function fired when the mouse enters the element.*/
  onMouseEnter:         js.UndefOr[ReactMouseEventH => Callback]    = js.undefined,
  /* Callback function fired when the mouse leaves the element.*/
  onMouseLeave:         js.UndefOr[ReactMouseEventH => Callback]    = js.undefined,
  /* Callback function fired when the mouse leaves the element. Unlike `onMouseLeave`,
  this callback will fire on disabled icon buttons.*/
  onMouseOut:           js.UndefOr[ReactMouseEventH => Callback]    = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:                js.UndefOr[CssProperties]                   = js.undefined,
  /* The text to supply to the element's tooltip.*/
  tooltip:              js.UndefOr[ReactNode]                       = js.undefined,
  /* The vertical and horizontal positions, respectively, of the element's tooltip.
  Possible values are: "bottom-center", "top-center", "bottom-right", "top-right",
  "bottom-left", and "top-left".*/
  tooltipPosition:      js.UndefOr[CornersAndCenter]                = js.undefined,
  /* Override the inline-styles of the tooltip element.*/
  tooltipStyles:        js.UndefOr[CssProperties]                   = js.undefined,
  /* If true, increase the tooltip element's size.  Useful for increasing tooltip
  readability on mobile devices.*/
  touch:                js.UndefOr[Boolean]                         = js.undefined,
  /* (Passed on to EnhancedButton)*/
  centerRipple:         js.UndefOr[Boolean]                         = js.undefined,
  /* (Passed on to EnhancedButton)*/
  containerElement:     js.UndefOr[String | ReactElement]           = js.undefined,
  /* (Passed on to EnhancedButton)*/
  disableFocusRipple:   js.UndefOr[Boolean]                         = js.undefined,
  /* (Passed on to EnhancedButton)*/
  disableKeyboardFocus: js.UndefOr[Boolean]                         = js.undefined,
  /* (Passed on to EnhancedButton)*/
  focusRippleColor:     js.UndefOr[MuiColor]                        = js.undefined,
  /* (Passed on to EnhancedButton)*/
  focusRippleOpacity:   js.UndefOr[Double]                          = js.undefined,
  /* (Passed on to EnhancedButton)*/
  keyboardFocused:      js.UndefOr[Boolean]                         = js.undefined,
  /* (Passed on to EnhancedButton)*/
  linkButton:           js.UndefOr[Boolean]                         = js.undefined,
  /* (Passed on to EnhancedButton)*/
  onClick:              js.UndefOr[ReactEventH => Callback]         = js.undefined,
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
  def hideTooltip(): js.Any = js.native

  def setKeyboardFocus(): js.Any = js.native

  def showTooltip(): js.Any = js.native
}
