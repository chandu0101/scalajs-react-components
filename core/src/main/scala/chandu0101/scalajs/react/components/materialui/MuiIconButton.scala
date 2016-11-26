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
  key:                  js.UndefOr[String]                             = js.undefined,
  ref:                  js.UndefOr[MuiIconButtonM => Unit]             = js.undefined,
  /* The CSS class name of the root element.*/
  className:            js.UndefOr[String]                             = js.undefined,
  /* If true, the element's ripple effect will be disabled.*/
  disableTouchRipple:   js.UndefOr[Boolean]                            = js.undefined,
  /* If true, the element will be disabled.*/
  disabled:             js.UndefOr[Boolean]                            = js.undefined,
  /* The URL to link to when the button is clicked.*/
  href:                 js.UndefOr[String]                             = js.undefined,
  /* The CSS class name of the icon. Used for setting the icon with a stylesheet.*/
  iconClassName:        js.UndefOr[String]                             = js.undefined,
  /* Override the inline-styles of the icon element.*/
  iconStyle:            js.UndefOr[CssProperties]                      = js.undefined,
  onBlur:               js.UndefOr[ReactFocusEventH => Callback]       = js.undefined,
  onFocus:              js.UndefOr[ReactFocusEventH => Callback]       = js.undefined,
  /* Callback function fired when the element is focused or blurred by the keyboard.*/
  onKeyboardFocus:      js.UndefOr[ReactKeyboardEventH => Callback]    = js.undefined,
  onMouseEnter:         js.UndefOr[ReactMouseEventH => Callback]       = js.undefined,
  onMouseLeave:         js.UndefOr[ReactMouseEventH => Callback]       = js.undefined,
  onMouseOut:           js.UndefOr[ReactMouseEventH => Callback]       = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:                js.UndefOr[CssProperties]                      = js.undefined,
  /* The text to supply to the element's tooltip.*/
  tooltip:              js.UndefOr[ReactNode]                          = js.undefined,
  /* The vertical and horizontal positions, respectively, of the element's tooltip.
  Possible values are: "bottom-center", "top-center", "bottom-right", "top-right",
  "bottom-left", and "top-left".*/
  tooltipPosition:      js.UndefOr[CornersAndCenter]                   = js.undefined,
  /* Override the inline-styles of the tooltip element.*/
  tooltipStyles:        js.UndefOr[CssProperties]                      = js.undefined,
  /* If true, increase the tooltip element's size.  Useful for increasing tooltip
  readability on mobile devices.*/
  touch:                js.UndefOr[Boolean]                            = js.undefined,
  /* (Passed on to EnhancedButton)*/
  centerRipple:         js.UndefOr[Boolean]                            = js.undefined,
  /* (Passed on to EnhancedButton)*/
  containerElement:     js.UndefOr[String | ReactElement]              = js.undefined,
  /* (Passed on to EnhancedButton)*/
  disableFocusRipple:   js.UndefOr[Boolean]                            = js.undefined,
  /* (Passed on to EnhancedButton)*/
  disableKeyboardFocus: js.UndefOr[Boolean]                            = js.undefined,
  /* (Passed on to EnhancedButton)*/
  focusRippleColor:     js.UndefOr[MuiColor]                           = js.undefined,
  /* (Passed on to EnhancedButton)*/
  focusRippleOpacity:   js.UndefOr[Double]                             = js.undefined,
  /* (Passed on to EnhancedButton)*/
  keyboardFocused:      js.UndefOr[Boolean]                            = js.undefined,
  /* (Passed on to EnhancedButton)*/
  @deprecated("LinkButton is no longer required when the `href` property is provided.\n      It will be removed with v0.16.0.")
  linkButton:           js.UndefOr[Boolean]                            = js.undefined,
  /* (Passed on to EnhancedButton)*/
  onClick:              js.UndefOr[ReactEventH => Callback]            = js.undefined,
  /* (Passed on to EnhancedButton)*/
  onKeyDown:            js.UndefOr[ReactKeyboardEventH => Callback]    = js.undefined,
  /* (Passed on to EnhancedButton)*/
  onKeyUp:              js.UndefOr[ReactKeyboardEventH => Callback]    = js.undefined,
  /* (Passed on to EnhancedButton)*/
  onMouseDown:          js.UndefOr[ReactMouseEventH => Callback]       = js.undefined,
  /* (Passed on to EnhancedButton)*/
  onMouseUp:            js.UndefOr[ReactMouseEventH => Callback]       = js.undefined,
  /* (Passed on to EnhancedButton)*/
  onTouchEnd:           js.UndefOr[ReactTouchEventH => Callback]       = js.undefined,
  /* (Passed on to EnhancedButton)*/
  onTouchStart:         js.UndefOr[ReactTouchEventH => Callback]       = js.undefined,
  /* (Passed on to EnhancedButton)*/
  onTouchTap:           js.UndefOr[ReactTouchEventH => Callback]       = js.undefined,
  /* (Passed on to EnhancedButton)*/
  tabIndex:             js.UndefOr[Double]                             = js.undefined,
  /* (Passed on to EnhancedButton)*/
  touchRippleColor:     js.UndefOr[MuiColor]                           = js.undefined,
  /* (Passed on to EnhancedButton)*/
  touchRippleOpacity:   js.UndefOr[Double]                             = js.undefined,
  /* (Passed on to EnhancedButton)*/
  `type`:               js.UndefOr[String]                             = js.undefined,
  /* (Passed on to DOM)*/
  onAnimationEnd:       js.UndefOr[ReactEventH => Callback]            = js.undefined,
  /* (Passed on to DOM)*/
  onAnimationIteration: js.UndefOr[ReactEventH => Callback]            = js.undefined,
  /* (Passed on to DOM)*/
  onAnimationStart:     js.UndefOr[ReactEventH => Callback]            = js.undefined,
  /* (Passed on to DOM)*/
  onChange:             js.UndefOr[ReactEventH => Callback]            = js.undefined,
  /* (Passed on to DOM)*/
  onCompositionEnd:     js.UndefOr[ReactCompositionEventH => Callback] = js.undefined,
  /* (Passed on to DOM)*/
  onCompositionStart:   js.UndefOr[ReactCompositionEventH => Callback] = js.undefined,
  /* (Passed on to DOM)*/
  onCompositionUpdate:  js.UndefOr[ReactCompositionEventH => Callback] = js.undefined,
  /* (Passed on to DOM)*/
  onContextMenu:        js.UndefOr[ReactEventH => Callback]            = js.undefined,
  /* (Passed on to DOM)*/
  onCopy:               js.UndefOr[ReactClipboardEventH => Callback]   = js.undefined,
  /* (Passed on to DOM)*/
  onCut:                js.UndefOr[ReactClipboardEventH => Callback]   = js.undefined,
  /* (Passed on to DOM)*/
  onDoubleClick:        js.UndefOr[ReactMouseEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onDrag:               js.UndefOr[ReactDragEventH => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onDragEnd:            js.UndefOr[ReactDragEventH => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onDragEnter:          js.UndefOr[ReactDragEventH => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onDragExit:           js.UndefOr[ReactDragEventH => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onDragLeave:          js.UndefOr[ReactDragEventH => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onDragOver:           js.UndefOr[ReactDragEventH => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onDragStart:          js.UndefOr[ReactDragEventH => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onDrop:               js.UndefOr[ReactDragEventH => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onInput:              js.UndefOr[ReactKeyboardEventH => Callback]    = js.undefined,
  /* (Passed on to DOM)*/
  onKeyPress:           js.UndefOr[ReactKeyboardEventH => Callback]    = js.undefined,
  /* (Passed on to DOM)*/
  onMouseMove:          js.UndefOr[ReactMouseEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onPaste:              js.UndefOr[ReactClipboardEventH => Callback]   = js.undefined,
  /* (Passed on to DOM)*/
  onScroll:             js.UndefOr[ReactUIEventH => Callback]          = js.undefined,
  /* (Passed on to DOM)*/
  onSelect:             js.UndefOr[ReactUIEventH => Callback]          = js.undefined,
  /* (Passed on to DOM)*/
  onSubmit:             js.UndefOr[ReactEventH => Callback]            = js.undefined,
  /* (Passed on to DOM)*/
  onTouchCancel:        js.UndefOr[ReactTouchEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onTouchMove:          js.UndefOr[ReactTouchEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onTransitionEnd:      js.UndefOr[ReactTouchEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onWheel:              js.UndefOr[ReactWheelEventH => Callback]       = js.undefined){
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
