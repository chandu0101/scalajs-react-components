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
  ref:                  js.UndefOr[String]                          = js.undefined,
  /* The css class name of the root element.*/
  className:            js.UndefOr[String]                          = js.undefined,
  /* Disables the icon button.*/
  disabled:             js.UndefOr[Boolean]                         = js.undefined,
  /* If you are using a stylesheet for your
icons, enter the class name for the icon to be used here.*/
  iconClassName:        js.UndefOr[String]                          = js.undefined,
  /* Overrides the inline-styles of the icon element.*/
  iconStyle:            js.UndefOr[CssProperties]                   = js.undefined,
  /* Callback function for when the component loses focus.*/
  onBlur:               js.UndefOr[ReactEventH => Callback]         = js.undefined,
  /* Callback function for when the component gains focus.*/
  onFocus:              js.UndefOr[ReactFocusEventH => Callback]    = js.undefined,
  /* Callback function for when the component
receives keyboard focus.*/
  onKeyboardFocus:      js.UndefOr[ReactKeyboardEventH => Callback] = js.undefined,
  /* Callback function for when mouse enters element.*/
  onMouseEnter:         js.UndefOr[ReactMouseEventH => Callback]    = js.undefined,
  /* Callback function for when mouse leaves element.*/
  onMouseLeave:         js.UndefOr[ReactMouseEventH => Callback]    = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:                js.UndefOr[CssProperties]                   = js.undefined,
  /* The tooltip text to show.*/
  tooltip:              js.UndefOr[ReactNode]                       = js.undefined,
  /* Allows the tooltip to be viewed with different
alignments: "bottom-center", "top-center",
"bottom-right", "top-right", "bottom-left" and "top-left".*/
  tooltipPosition:      js.UndefOr[CornersAndCenter]                = js.undefined,
  /* Styles prop passed down to the tooltip.*/
  tooltipStyles:        js.UndefOr[CssProperties]                   = js.undefined,
  /* Prop for tooltip to make it larger for mobile.*/
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
  disableTouchRipple:   js.UndefOr[Boolean]                         = js.undefined,
  /* (Passed on to EnhancedButton)*/
  focusRippleColor:     js.UndefOr[MuiColor]                        = js.undefined,
  /* (Passed on to EnhancedButton)*/
  focusRippleOpacity:   js.UndefOr[Double]                          = js.undefined,
  /* (Passed on to EnhancedButton)*/
  keyboardFocused:      js.UndefOr[Boolean]                         = js.undefined,
  /* (Passed on to EnhancedButton)*/
  linkButton:           js.UndefOr[Boolean]                         = js.undefined,
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
   * @param children Can be used to pass a font icon as the icon for the button.
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
