
package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
  
case class MuiToggle(
	key:                  js.UndefOr[String]                              = js.undefined,
	ref:                  js.UndefOr[MuiToggleM => Unit]                  = js.undefined,
	/* default:false: The value of the toggle button. Is true when toggle has been turned on. False otherwise.*/
	defaultToggled:       js.UndefOr[Boolean]                             = js.undefined,
	/*  Overrides the inline-styles of the Toggle element.*/
	elementStyle:         js.UndefOr[CssProperties]                       = js.undefined,
	/*  The text that is displayed beside the toggle switch.*/
	label:                js.UndefOr[ReactNode]                           = js.undefined,
	/* default:"left": Where the label will be placed next to the toggle switch. Options include "left" and "right" (case-sensitive). Default option is "left".*/
	labelPosition:        js.UndefOr[MuiToggleLabelPosition]              = js.undefined,
	/*  Overrides the inline-styles of the Toggle element label.*/
	labelStyle:           js.UndefOr[CssProperties]                       = js.undefined,
	/*  This is the name of the toggle.*/
	name:                 js.UndefOr[String]                              = js.undefined,
	/*  Override the inline-styles of the Toggle's root element.*/
	style:                js.UndefOr[CssProperties]                       = js.undefined,
	/*  The value of our toggle component.*/
	value:                js.UndefOr[String]                              = js.undefined,
	/*  Callback function that is fired when the toggle switch is toggled.*/
	onToggle:             js.UndefOr[(ReactEvent, Boolean) => Callback]   = js.undefined,
	id:                   js.UndefOr[String]                              = js.undefined,
	rippleStyle:          js.UndefOr[CssProperties]                       = js.undefined,
	rippleColor:          js.UndefOr[MuiColor]                            = js.undefined,
	iconStyle:            js.UndefOr[CssProperties]                       = js.undefined,
	thumbStyle:           js.UndefOr[CssProperties]                       = js.undefined,
	trackStyle:           js.UndefOr[CssProperties]                       = js.undefined,
	required:             js.UndefOr[Boolean]                             = js.undefined,
	disabled:             js.UndefOr[Boolean]                             = js.undefined,
	defaultSwitched:      js.UndefOr[Boolean]                             = js.undefined,
	disableFocusRipple:   js.UndefOr[Boolean]                             = js.undefined,
	disableTouchRipple:   js.UndefOr[Boolean]                             = js.undefined,
	onParentShouldUpdate: js.UndefOr[Boolean => Callback]                 = js.undefined,
	onSwitch:             js.UndefOr[(ReactEvent, Boolean) => Callback]   = js.undefined,
	toggled:              js.UndefOr[Boolean]                             = js.undefined)
{

  def apply() = {
    val props = JSMacro[MuiToggle](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Toggle)
    f(props).asInstanceOf[ReactComponentU_]
  }
}
    


class MuiToggleLabelPosition(val value: String) extends AnyVal
object MuiToggleLabelPosition{
	val LEFT = new MuiToggleLabelPosition("left")
	val RIGHT = new MuiToggleLabelPosition("right")
	val values = List(LEFT, RIGHT)
}


@js.native
class MuiToggleM extends js.Object{
	/* Toggle.isToggled(): Returns true if the checkbox is currently checked. Returns false otherwise*/
	def isToggled(): Unit = js.native

	/* Toggle.setToggled(newToggledValue): Sets the toggle to the value of newToggledValue. This method cannot be used while "checked" is defined as a property.*/
	def setToggled(): Unit = js.native
}
