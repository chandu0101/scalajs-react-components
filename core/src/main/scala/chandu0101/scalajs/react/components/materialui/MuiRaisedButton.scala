package chandu0101.scalajs.react.components
package materialui
import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
/**
 * This file is generated - submit issues instead of PR against it
 */
case class MuiRaisedButton(
  key:                     js.UndefOr[String]                          = js.undefined,
  ref:                     js.UndefOr[String]                          = js.undefined,
  /* Override the default background color for the button,
  but not the default disabled background color
  (use `disabledBackgroundColor` for this).*/
  backgroundColor:         js.UndefOr[MuiColor]                        = js.undefined,
  /* The CSS class name of the root element.*/
  className:               js.UndefOr[String]                          = js.undefined,
  /* If true, the button will be disabled.*/
  disabled:                js.UndefOr[Boolean]                         = js.undefined,
  /* Override the default background color for the button
  when it is disabled.*/
  disabledBackgroundColor: js.UndefOr[MuiColor]                        = js.undefined,
  /* The color of the button's label when the button is disabled.*/
  disabledLabelColor:      js.UndefOr[MuiColor]                        = js.undefined,
  /* If true, the button will take up the full width of its container.*/
  fullWidth:               js.UndefOr[Boolean]                         = js.undefined,
  /* The URL to link to when the button is clicked.*/
  href:                    js.UndefOr[String]                          = js.undefined,
  /* An icon to be displayed within the button.*/
  icon:                    js.UndefOr[ReactNode]                       = js.undefined,
  /* The label to be displayed within the button.
  If content is provided via the `children` prop, that content will be
  displayed in addition to the label provided here.*/
  label:                   js.UndefOr[String]                          = js.undefined,
  /* The color of the button's label.*/
  labelColor:              js.UndefOr[MuiColor]                        = js.undefined,
  /* The position of the button's label relative to the button's `children`.*/
  labelPosition:           js.UndefOr[BeforeAfter]                     = js.undefined,
  /* Override the inline-styles of the button's label element.*/
  labelStyle:              js.UndefOr[CssProperties]                   = js.undefined,
  onMouseDown:             js.UndefOr[ReactMouseEventH => Callback]    = js.undefined,
  onMouseEnter:            js.UndefOr[ReactMouseEventH => Callback]    = js.undefined,
  onMouseLeave:            js.UndefOr[ReactMouseEventH => Callback]    = js.undefined,
  onMouseUp:               js.UndefOr[ReactMouseEventH => Callback]    = js.undefined,
  onTouchEnd:              js.UndefOr[ReactTouchEventH => Callback]    = js.undefined,
  onTouchStart:            js.UndefOr[ReactTouchEventH => Callback]    = js.undefined,
  /* If true, the button will use the theme's primary color.*/
  primary:                 js.UndefOr[Boolean]                         = js.undefined,
  /* Override the inline style of the ripple element.*/
  rippleStyle:             js.UndefOr[CssProperties]                   = js.undefined,
  /* If true, the button will use the theme's secondary color.
  If both `secondary` and `primary` are true, the button will use
  the theme's primary color.*/
  secondary:               js.UndefOr[Boolean]                         = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:                   js.UndefOr[CssProperties]                   = js.undefined,
  /* (Passed on to EnhancedButton)*/
  centerRipple:            js.UndefOr[Boolean]                         = js.undefined,
  /* (Passed on to EnhancedButton)*/
  containerElement:        js.UndefOr[String | ReactElement]           = js.undefined,
  /* (Passed on to EnhancedButton)*/
  disableFocusRipple:      js.UndefOr[Boolean]                         = js.undefined,
  /* (Passed on to EnhancedButton)*/
  disableKeyboardFocus:    js.UndefOr[Boolean]                         = js.undefined,
  /* (Passed on to EnhancedButton)*/
  disableTouchRipple:      js.UndefOr[Boolean]                         = js.undefined,
  /* (Passed on to EnhancedButton)*/
  focusRippleColor:        js.UndefOr[MuiColor]                        = js.undefined,
  /* (Passed on to EnhancedButton)*/
  focusRippleOpacity:      js.UndefOr[Double]                          = js.undefined,
  /* (Passed on to EnhancedButton)*/
  keyboardFocused:         js.UndefOr[Boolean]                         = js.undefined,
  /* (Passed on to EnhancedButton)*/
  @deprecated("LinkButton is no longer required when the `href` property is provided.\n      It will be removed with v0.16.0.")
  linkButton:              js.UndefOr[Boolean]                         = js.undefined,
  /* (Passed on to EnhancedButton)*/
  onBlur:                  js.UndefOr[ReactFocusEventH => Callback]    = js.undefined,
  /* (Passed on to EnhancedButton)*/
  onClick:                 js.UndefOr[ReactEventH => Callback]         = js.undefined,
  /* (Passed on to EnhancedButton)*/
  onFocus:                 js.UndefOr[ReactFocusEventH => Callback]    = js.undefined,
  /* (Passed on to EnhancedButton)*/
  onKeyDown:               js.UndefOr[ReactKeyboardEventH => Callback] = js.undefined,
  /* (Passed on to EnhancedButton)*/
  onKeyUp:                 js.UndefOr[ReactKeyboardEventH => Callback] = js.undefined,
  /* (Passed on to EnhancedButton)*/
  onKeyboardFocus:         js.UndefOr[ReactKeyboardEventH => Callback] = js.undefined,
  /* (Passed on to EnhancedButton)*/
  onTouchTap:              js.UndefOr[ReactTouchEventH => Callback]    = js.undefined,
  /* (Passed on to EnhancedButton)*/
  tabIndex:                js.UndefOr[Double]                          = js.undefined,
  /* (Passed on to EnhancedButton)*/
  touchRippleColor:        js.UndefOr[MuiColor]                        = js.undefined,
  /* (Passed on to EnhancedButton)*/
  touchRippleOpacity:      js.UndefOr[Double]                          = js.undefined,
  /* (Passed on to EnhancedButton)*/
  `type`:                  js.UndefOr[String]                          = js.undefined){
  /**
   * @param children The content of the button.
If a label is provided via the `label` prop, the text within the label
will be displayed in addition to the content provided here.
   */
  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiRaisedButton](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.RaisedButton)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
