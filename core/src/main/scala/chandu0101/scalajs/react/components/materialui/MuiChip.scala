package chandu0101.scalajs.react.components
package materialui
import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
/**
 * This file is generated - submit issues instead of PR against it
 */
case class MuiChip(
  key:                  js.UndefOr[String]                                    = js.undefined,
  ref:                  js.UndefOr[String]                                    = js.undefined,
  /* Override the background color of the chip.*/
  backgroundColor:      js.UndefOr[MuiColor]                                  = js.undefined,
  /* CSS `className` of the root element.*/
  className:            js.UndefOr[ReactNode]                                 = js.undefined,
  /* Override the label color.*/
  labelColor:           js.UndefOr[MuiColor]                                  = js.undefined,
  /* Override the inline-styles of the label.*/
  labelStyle:           js.UndefOr[CssProperties]                             = js.undefined,
  onBlur:               js.UndefOr[ReactFocusEventH => Callback]              = js.undefined,
  onFocus:              js.UndefOr[ReactFocusEventH => Callback]              = js.undefined,
  onKeyDown:            js.UndefOr[ReactKeyboardEventH => Callback]           = js.undefined,
  onKeyboardFocus:      js.UndefOr[(ReactKeyboardEvent, Boolean) => Callback] = js.undefined,
  onMouseDown:          js.UndefOr[ReactMouseEventH => Callback]              = js.undefined,
  onMouseEnter:         js.UndefOr[ReactMouseEventH => Callback]              = js.undefined,
  onMouseLeave:         js.UndefOr[ReactMouseEventH => Callback]              = js.undefined,
  onMouseUp:            js.UndefOr[ReactMouseEventH => Callback]              = js.undefined,
  /* Callback function fired when the delete icon is clicked. If set, the delete icon will be shown.*/
  onRequestDelete:      js.UndefOr[ReactEvent => Callback]                    = js.undefined,
  onTouchEnd:           js.UndefOr[ReactTouchEventH => Callback]              = js.undefined,
  onTouchStart:         js.UndefOr[ReactTouchEventH => Callback]              = js.undefined,
  /* Callback function fired when the `Chip` element is touch-tapped.*/
  onTouchTap:           js.UndefOr[ReactTouchEventH => Callback]              = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:                js.UndefOr[CssProperties]                             = js.undefined,
  /* (Passed on to EnhancedButton)*/
  centerRipple:         js.UndefOr[Boolean]                                   = js.undefined,
  /* (Passed on to EnhancedButton)*/
  containerElement:     js.UndefOr[String | ReactElement]                     = js.undefined,
  /* (Passed on to EnhancedButton)*/
  disableFocusRipple:   js.UndefOr[Boolean]                                   = js.undefined,
  /* (Passed on to EnhancedButton)*/
  disableKeyboardFocus: js.UndefOr[Boolean]                                   = js.undefined,
  /* (Passed on to EnhancedButton)*/
  disableTouchRipple:   js.UndefOr[Boolean]                                   = js.undefined,
  /* (Passed on to EnhancedButton)*/
  disabled:             js.UndefOr[Boolean]                                   = js.undefined,
  /* (Passed on to EnhancedButton)*/
  focusRippleColor:     js.UndefOr[MuiColor]                                  = js.undefined,
  /* (Passed on to EnhancedButton)*/
  focusRippleOpacity:   js.UndefOr[Double]                                    = js.undefined,
  /* (Passed on to EnhancedButton)*/
  href:                 js.UndefOr[String]                                    = js.undefined,
  /* (Passed on to EnhancedButton)*/
  keyboardFocused:      js.UndefOr[Boolean]                                   = js.undefined,
  /* (Passed on to EnhancedButton)*/
  @deprecated("LinkButton is no longer required when the `href` property is provided.\n      It will be removed with v0.16.0.")
  linkButton:           js.UndefOr[Boolean]                                   = js.undefined,
  /* (Passed on to EnhancedButton)*/
  onClick:              js.UndefOr[ReactEventH => Callback]                   = js.undefined,
  /* (Passed on to EnhancedButton)*/
  onKeyUp:              js.UndefOr[ReactKeyboardEventH => Callback]           = js.undefined,
  /* (Passed on to EnhancedButton)*/
  tabIndex:             js.UndefOr[Double]                                    = js.undefined,
  /* (Passed on to EnhancedButton)*/
  touchRippleColor:     js.UndefOr[MuiColor]                                  = js.undefined,
  /* (Passed on to EnhancedButton)*/
  touchRippleOpacity:   js.UndefOr[Double]                                    = js.undefined,
  /* (Passed on to EnhancedButton)*/
  `type`:               js.UndefOr[String]                                    = js.undefined){
  /**
   * @param children Used to render elements inside the Chip.
   */
  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiChip](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Chip)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
