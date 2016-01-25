package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiFloatingActionButton(
  key:                  js.UndefOr[String]                          = js.undefined,
  ref:                  js.UndefOr[String]                          = js.undefined,
  /* This value will override the default background color for the button.
However it will not override the default disabled background color.
This has to be set separately using the disabledColor attribute.*/
  backgroundColor:      js.UndefOr[MuiColor]                        = js.undefined,
  /* Disables the button if set to true.*/
  disabled:             js.UndefOr[Boolean]                         = js.undefined,
  /* This value will override the default background color for the button when it is disabled.*/
  disabledColor:        js.UndefOr[MuiColor]                        = js.undefined,
  /* URL to link to when button clicked if `linkButton` is set to true.*/
  href:                 js.UndefOr[String]                          = js.undefined,
  /* The icon within the FloatingActionButton is a FontIcon component.
This property is the classname of the icon to be displayed inside the button.
An alternative to adding an iconClassName would be to manually insert a
FontIcon component or custom SvgIcon component or as a child of FloatingActionButton.*/
  iconClassName:        js.UndefOr[String]                          = js.undefined,
  /* This is the equivalent to iconClassName except that it is used for
overriding the inline-styles of the FontIcon component.*/
  iconStyle:            js.UndefOr[CssProperties]                   = js.undefined,
  /* Enables use of `href` property to provide a URL to link to if set to true.*/
  linkButton:           js.UndefOr[Boolean]                         = js.undefined,
  /* If true, the button will be a small floating action button.*/
  mini:                 js.UndefOr[Boolean]                         = js.undefined,
  /* Called when mouse down event occurs on the button.*/
  onMouseDown:          js.UndefOr[ReactMouseEventH => Callback]    = js.undefined,
  /* Called when mouse enter event occurs on the button.*/
  onMouseEnter:         js.UndefOr[ReactMouseEventH => Callback]    = js.undefined,
  /* Called when mouse leave event occurs on the button.*/
  onMouseLeave:         js.UndefOr[ReactMouseEventH => Callback]    = js.undefined,
  /* Called when mouse up event occurs on the button.*/
  onMouseUp:            js.UndefOr[ReactMouseEventH => Callback]    = js.undefined,
  /* Called when touch end event occurs on the button.*/
  onTouchEnd:           js.UndefOr[ReactTouchEventH => Callback]    = js.undefined,
  /* Called when touch start event occurs on the button.*/
  onTouchStart:         js.UndefOr[ReactTouchEventH => Callback]    = js.undefined,
  /* If true, the button will use the secondary button colors.*/
  secondary:            js.UndefOr[Boolean]                         = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:                js.UndefOr[CssProperties]                   = js.undefined,
  /* (Passed on to EnhancedButton)*/
  centerRipple:         js.UndefOr[Boolean]                         = js.undefined,
  /* default: button: This component will render a button element by default and an anchor element
if linkButton is set to true.
However, you can override this behavior by passing in a string or another react element into this prop.
This is useful for generating link buttons with the react router link element.
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
  /* (Passed on to EnhancedButton)*/
  onBlur:               js.UndefOr[ReactEventH => Callback]         = js.undefined,
  /* (Passed on to EnhancedButton)*/
  onFocus:              js.UndefOr[ReactFocusEventH => Callback]    = js.undefined,
  /* (Passed on to EnhancedButton)*/
  onKeyDown:            js.UndefOr[ReactKeyboardEventH => Callback] = js.undefined,
  /* (Passed on to EnhancedButton)*/
  onKeyUp:              js.UndefOr[ReactKeyboardEventH => Callback] = js.undefined,
  /* (Passed on to EnhancedButton)*/
  onKeyboardFocus:      js.UndefOr[ReactKeyboardEventH => Callback] = js.undefined,
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
   * @param children This is what displayed inside the floating action button; for example, a SVG Icon.
   */
  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiFloatingActionButton](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.FloatingActionButton)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
