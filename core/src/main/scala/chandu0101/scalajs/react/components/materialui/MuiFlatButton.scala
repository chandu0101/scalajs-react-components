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
  /* Color of button when mouse is not hovering over it.*/
  backgroundColor:      js.UndefOr[MuiColor]                        = js.undefined,
  /* Disables the button if set to true.*/
  disabled:             js.UndefOr[Boolean]                         = js.undefined,
  /* Color of button when mouse hovers over.*/
  hoverColor:           js.UndefOr[MuiColor]                        = js.undefined,
  /* The URL to link to when the button is clicked.*/
  href:                 js.UndefOr[String]                          = js.undefined,
  /* Use this property to display an icon.*/
  icon:                 js.UndefOr[ReactNode]                       = js.undefined,
  /* Label for the button.*/
  label:                js.UndefOr[String]                          = js.undefined,
  /* Place label before or after the passed children.*/
  labelPosition:        js.UndefOr[BeforeAfter]                     = js.undefined,
  /* Override the inline-styles of the button's label element.*/
  labelStyle:           js.UndefOr[CssProperties]                   = js.undefined,
  /* Callback function fired when the element is focused or blurred by the keyboard.*/
  onKeyboardFocus:      js.UndefOr[ReactKeyboardEventH => Callback] = js.undefined,
  onMouseEnter:         js.UndefOr[ReactMouseEventH => Callback]    = js.undefined,
  onMouseLeave:         js.UndefOr[ReactMouseEventH => Callback]    = js.undefined,
  onTouchStart:         js.UndefOr[ReactTouchEventH => Callback]    = js.undefined,
  /* If true, colors button according to
  primaryTextColor from the Theme.*/
  primary:              js.UndefOr[Boolean]                         = js.undefined,
  /* Color for the ripple after button is clicked.*/
  rippleColor:          js.UndefOr[MuiColor]                        = js.undefined,
  /* If true, colors button according to secondaryTextColor from the theme.
  The primary prop has precendent if set to true.*/
  secondary:            js.UndefOr[Boolean]                         = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:                js.UndefOr[CssProperties]                   = js.undefined,
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
  @deprecated("LinkButton is no longer required when the `href` property is provided.\n      It will be removed with v0.16.0.")
  linkButton:           js.UndefOr[Boolean]                         = js.undefined,
  /* (Passed on to EnhancedButton)*/
  onBlur:               js.UndefOr[ReactFocusEventH => Callback]    = js.undefined,
  /* (Passed on to EnhancedButton)*/
  onClick:              js.UndefOr[ReactEventH => Callback]         = js.undefined,
  /* (Passed on to EnhancedButton)*/
  onFocus:              js.UndefOr[ReactFocusEventH => Callback]    = js.undefined,
  /* (Passed on to EnhancedButton)*/
  onKeyDown:            js.UndefOr[ReactKeyboardEventH => Callback] = js.undefined,
  /* (Passed on to EnhancedButton)*/
  onKeyUp:              js.UndefOr[ReactKeyboardEventH => Callback] = js.undefined,
  /* (Passed on to EnhancedButton)*/
  onMouseDown:          js.UndefOr[ReactMouseEventH => Callback]    = js.undefined,
  /* (Passed on to EnhancedButton)*/
  onMouseUp:            js.UndefOr[ReactMouseEventH => Callback]    = js.undefined,
  /* (Passed on to EnhancedButton)*/
  onTouchEnd:           js.UndefOr[ReactTouchEventH => Callback]    = js.undefined,
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
   * @param children This is what will be displayed inside the button.
If a label is specified, the text within the label prop will
be displayed. Otherwise, the component will expect children
which will then be displayed. (In our example,
we are nesting an `<input type="file" />` and a `span`
that acts as our label to be displayed.) This only
applies to flat and raised buttons.
   */
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
