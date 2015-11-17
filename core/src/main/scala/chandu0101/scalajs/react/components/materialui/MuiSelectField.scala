
package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
  
case class MuiSelectField(
	key:                    js.UndefOr[String]                                  = js.undefined,
	ref:                    js.UndefOr[String]                                  = js.undefined,
	/*  Disables the select field if set to true.*/
	disabled:               js.UndefOr[Boolean]                                 = js.undefined,
	/* default: text: SelectField will use text as default value, with this property you can choose another name.*/
	displayMember:          js.UndefOr[String]                                  = js.undefined,
	/*  The style object to use to override error styles.*/
	errorStyle:             js.UndefOr[CssProperties]                           = js.undefined,
	/*  The error text string to display.*/
	errorText:              js.UndefOr[String]                                  = js.undefined,
	/*  The style object to use to override floating label styles.*/
	floatingLabelStyle:     js.UndefOr[CssProperties]                           = js.undefined,
	/*  The text string to use for the floating label element.*/
	floatingLabelText:      js.UndefOr[String]                                  = js.undefined,
	/*  If true, the field receives the property width 100%.*/
	fullWidth:              js.UndefOr[Boolean]                                 = js.undefined,
	/*  The hint text string to display.*/
	hintText:               js.UndefOr[String]                                  = js.undefined,
	/*  Overrides the styles of SelectField's icon element.*/
	iconStyle:              js.UndefOr[CssProperties]                           = js.undefined,
	/*  Overrides the styles of SelectField's label when the SelectField is inactive.*/
	labelStyle:             js.UndefOr[CssProperties]                           = js.undefined,
	/*  Overrides the inline-styles of the MenuItems when the SelectField is expanded.*/
	menuItemStyle:          js.UndefOr[CssProperties]                           = js.undefined,
	/* required: An array of objects to show. The name and payload of the object will be picked by specifying valueMember and displayMember props */
	menuItems:              js.Array[MuiSelectItem],
	/*  The style object to use to override the drop-down menu*/
	selectFieldRoot:        js.UndefOr[CssProperties]                           = js.undefined,
	/* default: 0: Index of the item selected.*/
	selectedIndex:          js.UndefOr[Int]                                     = js.undefined,
	/*  Override the inline-styles of the SelectField's root element.*/
	style:                  js.UndefOr[CssProperties]                           = js.undefined,
	/*  Override the inline-styles of the SelectField's underline element when disabled.*/
	underlineDisabledStyle: js.UndefOr[CssProperties]                           = js.undefined,
	/*  Overrides the styles of SelectField's underline.*/
	underlineStyle:         js.UndefOr[CssProperties]                           = js.undefined,
	/* default: payload: SelectField will use payload as default value, with this property you can choose another name.*/
	valueMember:            js.UndefOr[String]                                  = js.undefined,
	/* function(event): Callback function that is fired when the selectfield losesfocus.*/
	onBlur:                 js.UndefOr[ReactEvent => Callback]                  = js.undefined,
	/* function(event, selectedIndex, item): Callback function that is fired when the selectfield's value changes.*/
	onChange:               js.UndefOr[(ReactEvent, Int, js.Any) => Callback]   = js.undefined,
	/* function(event): Callback function that is fired when the selectfield gains focus.*/
	onFocus:                js.UndefOr[ReactEvent => Callback]                  = js.undefined)
{

  def apply() = {
    val props = JSMacro[MuiSelectField](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.SelectField)
    f(props).asInstanceOf[ReactComponentU_]
  }
}
    
case class MuiSelectItem(payload: String, text: String){
	val toJS = JSMacro[MuiSelectItem](this)
}

