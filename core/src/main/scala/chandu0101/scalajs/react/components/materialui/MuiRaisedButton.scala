
package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
  
case class MuiRaisedButton(
	key:                     js.UndefOr[String]                            = js.undefined,
	ref:                     js.UndefOr[String]                            = js.undefined,
	/*  Override the background color. Always takes precedence unless the button is disabled.*/
	backgroundColor:         js.UndefOr[MuiColor]                          = js.undefined,
	/* default: button: This component will render a button element by default and an anchor element if linkButton is set to true. However, you can override this behavior by passing in a string or another react element into this prop. This is useful for generating link buttons with the react router link element.*/
	containerElement:        js.UndefOr[String | ReactElement]             = js.undefined,
	/*  Disables the button if set to true.*/
	disabled:                js.UndefOr[Boolean]                           = js.undefined,
	/*  Override the background color if the button is disabled.*/
	disabledBackgroundColor: js.UndefOr[MuiColor]                          = js.undefined,
	/*  Override the label color if the button is disabled.*/
	disabledLabelColor:      js.UndefOr[MuiColor]                          = js.undefined,
	/*  If true, will change the width of the button to span the full width of the parent.*/
	fullWidth:               js.UndefOr[Boolean]                           = js.undefined,
	/* required: This is what will be displayed inside the button. If a label is specified, the text within the label prop will be displayed. Otherwise, the component will expect children which will then be displayed (in our example, we are nesting an <input type="file" />and a span that acts as our label to be displayed.) This only applies to flat and raised buttons.*/
	label:                   js.UndefOr[String]                            = js.undefined,
	/*  Override the label color. Always takes precedence unless the button is disabled.*/
	labelColor:              js.UndefOr[MuiColor]                          = js.undefined,
	/* default: "before": Place label before or after the passed children*/
	labelPosition:           js.UndefOr[MuiRaisedButtonLabelPosition]      = js.undefined,
	/*  Override the inline-styles of the button's label element.*/
	labelStyle:              js.UndefOr[CssProperties]                     = js.undefined,
	/* default: false: If true, an anchor element will be generated instead of a button element.*/
	linkButton:              js.UndefOr[Boolean]                           = js.undefined,
	/* default: false: If true, the button will use the primary button colors.*/
	primary:                 js.UndefOr[Boolean]                           = js.undefined,
	/* default: false: If true, the button will use the secondary button colors.*/
	secondary:               js.UndefOr[Boolean]                           = js.undefined,
	/*  Override the inline-styles of the button's root element.*/
	style:                   js.UndefOr[CssProperties]                     = js.undefined,
	centerRipple:            js.UndefOr[Boolean]                           = js.undefined,
	disableFocusRipple:      js.UndefOr[Boolean]                           = js.undefined,
	disableKeyboardFocus:    js.UndefOr[Boolean]                           = js.undefined,
	disableTouchRipple:      js.UndefOr[Boolean]                           = js.undefined,
	keyboardFocused:         js.UndefOr[Boolean]                           = js.undefined,
	focusRippleColor:        js.UndefOr[MuiColor]                          = js.undefined,
	touchRippleColor:        js.UndefOr[MuiColor]                          = js.undefined,
	focusRippleOpacity:      js.UndefOr[Double]                            = js.undefined,
	touchRippleOpacity:      js.UndefOr[Double]                            = js.undefined,
	tabIndex:                js.UndefOr[Double]                            = js.undefined,
	onClick:                 js.UndefOr[ReactEventH => Callback]           = js.undefined,
	onBlur:                  js.UndefOr[ReactEventH => Callback]           = js.undefined,
	onFocus:                 js.UndefOr[ReactFocusEventH => Callback]      = js.undefined,
	onKeyboardFocus:         js.UndefOr[ReactKeyboardEventH => Callback]   = js.undefined,
	onKeyDown:               js.UndefOr[ReactKeyboardEventH => Callback]   = js.undefined,
	onKeyUp:                 js.UndefOr[ReactKeyboardEventH => Callback]   = js.undefined,
	/*  Called when a touch tap event occures on the button.*/
	onTouchTap:              js.UndefOr[ReactTouchEventH => Callback]      = js.undefined,
	onMouseLeave:            js.UndefOr[ReactEvent => Callback]            = js.undefined,
	onTouchStart:            js.UndefOr[ReactEvent => Callback]            = js.undefined,
	onMouseUp:               js.UndefOr[ReactEvent => Callback]            = js.undefined,
	onTouchEnd:              js.UndefOr[ReactEvent => Callback]            = js.undefined,
	className:               js.UndefOr[String]                            = js.undefined,
	onMouseEnter:            js.UndefOr[ReactEvent => Callback]            = js.undefined,
	onMouseDown:             js.UndefOr[ReactEvent => Callback]            = js.undefined)
{

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiRaisedButton](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.RaisedButton)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}


class MuiRaisedButtonLabelPosition(val value: String) extends AnyVal
object MuiRaisedButtonLabelPosition{
	val BEFORE = new MuiRaisedButtonLabelPosition("before")
	val AFTER = new MuiRaisedButtonLabelPosition("after")
	val values = List(BEFORE, AFTER)
}
