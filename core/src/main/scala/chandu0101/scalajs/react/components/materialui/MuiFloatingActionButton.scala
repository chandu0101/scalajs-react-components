
package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
  
case class MuiFloatingActionButton(
	key:                  js.UndefOr[String]                            = js.undefined,
	ref:                  js.UndefOr[String]                            = js.undefined,
	/*  This value will override the default background color for the button. However it will not override thedefault disabled background color. This has to be set separately using the disabledColor attribute.*/
	backgroundColor:      js.UndefOr[MuiColor]                          = js.undefined,
	/* default: button: This component will render a button element by default and an anchor element if linkButton is set to true. However, you can override this behavior by passing in a string or another react element into this prop. This is useful for generating link buttons with the react router link element.*/
	containerElement:     js.UndefOr[String | ReactElement]             = js.undefined,
	/*  Disables the button if set to true.*/
	disabled:             js.UndefOr[Boolean]                           = js.undefined,
	/*  This value will override the default background color for the button when it is disabled.*/
	disabledColor:        js.UndefOr[MuiColor]                          = js.undefined,
	/*  The icon within the FloatingActionButton is a FontIcon component. This property is the classname of the icon to be displayed inside the button. An alternative to adding an iconClassName would be to manually insert a FontIcon component or custom SvgIcon component or as a child of FloatingActionButton.*/
	iconClassName:        js.UndefOr[String]                            = js.undefined,
	/*  This is the equivalent to iconClassName except that it is used for overriding the inline-styles of the FontIcon component.*/
	iconStyle:            js.UndefOr[CssProperties]                     = js.undefined,
	/* default: false: If true, an anchor element will be generated instead of a button element.*/
	linkButton:           js.UndefOr[Boolean]                           = js.undefined,
	/* default: false: If true, the button will be a small floating action button.*/
	mini:                 js.UndefOr[Boolean]                           = js.undefined,
	/* default: false: If true, the button will use the secondary button colors.*/
	secondary:            js.UndefOr[Boolean]                           = js.undefined,
	/*  Override the inline-styles of the button's root element.*/
	style:                js.UndefOr[CssProperties]                     = js.undefined,
	centerRipple:         js.UndefOr[Boolean]                           = js.undefined,
	disableFocusRipple:   js.UndefOr[Boolean]                           = js.undefined,
	disableKeyboardFocus: js.UndefOr[Boolean]                           = js.undefined,
	disableTouchRipple:   js.UndefOr[Boolean]                           = js.undefined,
	keyboardFocused:      js.UndefOr[Boolean]                           = js.undefined,
	focusRippleColor:     js.UndefOr[MuiColor]                          = js.undefined,
	touchRippleColor:     js.UndefOr[MuiColor]                          = js.undefined,
	focusRippleOpacity:   js.UndefOr[Double]                            = js.undefined,
	touchRippleOpacity:   js.UndefOr[Double]                            = js.undefined,
	tabIndex:             js.UndefOr[Double]                            = js.undefined,
	onClick:              js.UndefOr[ReactEventH => Callback]           = js.undefined,
	onBlur:               js.UndefOr[ReactEventH => Callback]           = js.undefined,
	onFocus:              js.UndefOr[ReactFocusEventH => Callback]      = js.undefined,
	onKeyboardFocus:      js.UndefOr[ReactKeyboardEventH => Callback]   = js.undefined,
	onKeyDown:            js.UndefOr[ReactKeyboardEventH => Callback]   = js.undefined,
	onKeyUp:              js.UndefOr[ReactKeyboardEventH => Callback]   = js.undefined,
	/*  Called when a touch tap event occures on the button.*/
	onTouchTap:           js.UndefOr[ReactTouchEventH => Callback]      = js.undefined)
{

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiFloatingActionButton](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.FloatingActionButton)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
