
package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
  
case class MuiCheckbox(
	key:                  js.UndefOr[String]                              = js.undefined,
	ref:                  js.UndefOr[MuiCheckboxM => Unit]                = js.undefined,
	/*  The SvgIcon to use for the checked state. This is useful to create icon toggles.*/
	checkedIcon:          js.UndefOr[ReactElement]                        = js.undefined,
	/* default:false: The default state of our checkbox component.*/
	defaultChecked:       js.UndefOr[Boolean]                             = js.undefined,
	/*  Overrides the inline-styles of the icon element.*/
	iconStyle:            js.UndefOr[CssProperties]                       = js.undefined,
	/*  The text that is displayed beside the checkbox.*/
	label:                js.UndefOr[ReactNode]                           = js.undefined,
	/* default:"right": Where the label will be placed next to the checkbox. Options include "left" and "right" (case-sensitive). Default option is "right".*/
	labelPosition:        js.UndefOr[MuiCheckboxLabelPosition]            = js.undefined,
	/*  Overrides the inline-styles of the Checkbox element label.*/
	labelStyle:           js.UndefOr[CssProperties]                       = js.undefined,
	/*  Override the inline-styles of the Checkbox's root element.*/
	style:                js.UndefOr[CssProperties]                       = js.undefined,
	/*  The SvgIcon to use for the unchecked state. This is useful to create icon toggles.*/
	unCheckedIcon:        js.UndefOr[ReactElement]                        = js.undefined,
	/*  Callback function that is fired when the checkbox is checked.*/
	onCheck:              js.UndefOr[(ReactEvent, Boolean) => Callback]   = js.undefined,
	id:                   js.UndefOr[String]                              = js.undefined,
	rippleStyle:          js.UndefOr[CssProperties]                       = js.undefined,
	rippleColor:          js.UndefOr[MuiColor]                            = js.undefined,
	thumbStyle:           js.UndefOr[CssProperties]                       = js.undefined,
	trackStyle:           js.UndefOr[CssProperties]                       = js.undefined,
	name:                 js.UndefOr[String]                              = js.undefined,
	value:                js.UndefOr[String]                              = js.undefined,
	required:             js.UndefOr[Boolean]                             = js.undefined,
	disabled:             js.UndefOr[Boolean]                             = js.undefined,
	defaultSwitched:      js.UndefOr[Boolean]                             = js.undefined,
	disableFocusRipple:   js.UndefOr[Boolean]                             = js.undefined,
	disableTouchRipple:   js.UndefOr[Boolean]                             = js.undefined,
	onParentShouldUpdate: js.UndefOr[Boolean => Callback]                 = js.undefined,
	onSwitch:             js.UndefOr[(ReactEvent, Boolean) => Callback]   = js.undefined,
	checked:              js.UndefOr[Boolean]                             = js.undefined)
{

  def apply() = {
    val props = JSMacro[MuiCheckbox](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Checkbox)
    f(props).asInstanceOf[ReactComponentU_]
  }
}
    


class MuiCheckboxLabelPosition(val value: String) extends AnyVal
object MuiCheckboxLabelPosition{
	val LEFT = new MuiCheckboxLabelPosition("left")
	val RIGHT = new MuiCheckboxLabelPosition("right")
	val values = List(LEFT, RIGHT)
}


@js.native
class MuiCheckboxM extends js.Object{
	/* Checkbox.isChecked(): Returns true if the checkbox is currently checked. Returns false otherwise*/
	def isChecked(): Boolean = js.native

	/* Checkbox.setChecked(newCheckedValue): Sets the checkbox to the value of newCheckedValue. This method cannot be used while "checked" is defined as a property.*/
	def setChecked(b: Boolean): Unit = js.native
}
