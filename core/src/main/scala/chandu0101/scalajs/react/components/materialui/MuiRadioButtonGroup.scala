
package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
  
case class MuiRadioButtonGroup(
	key:             js.UndefOr[String]                             = js.undefined,
	ref:             js.UndefOr[MuiRadioButtonGroupM => Unit]       = js.undefined,
	/*  Sets the default radio button to be the one whose value matches defaultSelected (case-sensitive). This will override any individual radio button with the defaultChecked or checked property stated.*/
	defaultSelected: js.UndefOr[String]                             = js.undefined,
	/*  Where the label will be placed for all radio buttons. Options include "left" and "right" (case-sensitive). This will override any labelPosition properties defined for an individual radio button.*/
	labelPosition:   js.UndefOr[MuiRadioButtonGroupLabelPosition]   = js.undefined,
	/* required: The name that will be applied to all radio buttons inside it.*/
	name:            String,
	/*  Override the inline-styles of the RadioButtonGroup's root element.*/
	style:           js.UndefOr[CssProperties]                      = js.undefined,
	/*  The value of the currently selected radio button.*/
	valueSelected:   js.UndefOr[String]                             = js.undefined,
	/*  Callback function that is fired when a radio button has been clicked. Returns the event and the value of the radio button that has been selected.*/
	onChange:        js.UndefOr[(ReactEvent, String) => Callback]   = js.undefined)
{

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiRadioButtonGroup](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.RadioButtonGroup)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}


class MuiRadioButtonGroupLabelPosition(val value: String) extends AnyVal
object MuiRadioButtonGroupLabelPosition{
	val LEFT = new MuiRadioButtonGroupLabelPosition("left")
	val RIGHT = new MuiRadioButtonGroupLabelPosition("right")
}


@js.native
class MuiRadioButtonGroupM extends js.Object{
	/* RadioButtonGroup.getSelectedValue(): Returns the string value of the radio button that is currently selected. If nothing has been selected, an empty string is returned.*/
	def getSelectedValue(): String = js.native

	/* RadioButtonGroup.setSelectedValue(newSelectionValue): Sets the selected radio button to the radio button whose value matches newSelectionValue*/
	def setSelectedValue(value: String): Unit = js.native

	/* RadioButtonGroup.clearValue(): Clears the selected value for the radio button group.*/
	def clearValue(): Unit = js.native
}
