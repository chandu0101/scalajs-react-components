
package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
  
case class MuiRadioButton(
	key:                  js.UndefOr[String]                               = js.undefined,
	ref:                  js.UndefOr[String]                               = js.undefined,
	/* default:false: The default value of the radio button when the page finishes loading.*/
	defaultChecked:       js.UndefOr[Boolean]                              = js.undefined,
	/*  Overrides the inline-styles of the icon element.*/
	iconStyle:            js.UndefOr[CssProperties]                        = js.undefined,
	/*  The text that is displayed beside the radio button.*/
	label:                js.UndefOr[ReactNode]                            = js.undefined,
	/* default:"right": Where the label will be placed next to the radio button. Options include "left" and "right" (case-sensitive). Default option is "right".*/
	labelPosition:        js.UndefOr[MuiRadioButtonLabelPosition]          = js.undefined,
	/*  Overrides the inline-styles of the RadioButton element label.*/
	labelStyle:           js.UndefOr[CssProperties]                        = js.undefined,
	/*  Override the inline-styles of the RadioButton's root element.*/
	style:                js.UndefOr[CssProperties]                        = js.undefined,
	/*  The value of our radio button component.*/
	value:                js.UndefOr[String]                               = js.undefined,
	id:                   js.UndefOr[String]                               = js.undefined,
	rippleStyle:          js.UndefOr[CssProperties]                        = js.undefined,
	rippleColor:          js.UndefOr[MuiColor]                             = js.undefined,
	thumbStyle:           js.UndefOr[CssProperties]                        = js.undefined,
	trackStyle:           js.UndefOr[CssProperties]                        = js.undefined,
	name:                 js.UndefOr[String]                               = js.undefined,
	required:             js.UndefOr[Boolean]                              = js.undefined,
	disabled:             js.UndefOr[Boolean]                              = js.undefined,
	defaultSwitched:      js.UndefOr[Boolean]                              = js.undefined,
	disableFocusRipple:   js.UndefOr[Boolean]                              = js.undefined,
	disableTouchRipple:   js.UndefOr[Boolean]                              = js.undefined,
	onParentShouldUpdate: js.UndefOr[Boolean => Callback]                  = js.undefined,
	onSwitch:             js.UndefOr[(ReactEvent, Boolean) => Callback]    = js.undefined,
	checked:              js.UndefOr[Boolean]                              = js.undefined,
	onCheck:              js.UndefOr[(ReactEventH, Boolean) => Callback]   = js.undefined)
{

  def apply() = {
    val props = JSMacro[MuiRadioButton](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.RadioButton)
    f(props).asInstanceOf[ReactComponentU_]
  }
}
    


class MuiRadioButtonLabelPosition(val value: String) extends AnyVal
object MuiRadioButtonLabelPosition{
	val LEFT = new MuiRadioButtonLabelPosition("left")
	val RIGHT = new MuiRadioButtonLabelPosition("right")
	val values = List(LEFT, RIGHT)
}
