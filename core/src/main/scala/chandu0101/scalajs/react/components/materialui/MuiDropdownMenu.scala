
package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
  
case class MuiDropDownMenu(
	key:             js.UndefOr[String]                                  = js.undefined,
	ref:             js.UndefOr[String]                                  = js.undefined,
	/* default: true: The width will automatically be set according to the items inside the menu. To control this width in Css instead, set this prop to false.*/
	autoWidth:       js.UndefOr[Boolean]                                 = js.undefined,
	/* default: false: Disables the menu.*/
	disabled:        js.UndefOr[Boolean]                                 = js.undefined,
	/* default: text: DropDownMenu will use text as default value, with this property you can choose another name.*/
	displayMember:   js.UndefOr[String]                                  = js.undefined,
	/*  Overrides the styles of DropDownMenu's icon element.*/
	iconStyle:       js.UndefOr[CssProperties]                           = js.undefined,
	/*  Overrides the styles of DropDownMenu's label when the DropDownMenu is inactive.*/
	labelStyle:      js.UndefOr[CssProperties]                           = js.undefined,
	/*  Overrides the inline-styles of the MenuItems when the DropDownMenu is expanded.*/
	menuItemStyle:   js.UndefOr[CssProperties]                           = js.undefined,
	/* required: JSON data representing all menu items in the dropdown.*/
	menuItems:       js.Array[MuiDropDownMenuItem],
	/* default: false: Set to true to have the DropDownMenu automatically open on mount.*/
	openImmediately: js.UndefOr[Boolean]                                 = js.undefined,
	/* default: 0: Index of the item selected.*/
	selectedIndex:   js.UndefOr[Int]                                     = js.undefined,
	/*  Overrides the inline-styles of DropDownMenu's root element.*/
	style:           js.UndefOr[CssProperties]                           = js.undefined,
	/*  Overrides the styles of DropDownMenu's underline.*/
	underlineStyle:  js.UndefOr[CssProperties]                           = js.undefined,
	/* default: payload: DropDownMenu will use payload as default value, with this property you can choose another name.*/
	valueMember:     js.UndefOr[String]                                  = js.undefined,
	/* function(event, selectedIndex, menuItem): Fired when a menu item is clicked that is not the one currently selected.*/
	onChange:        js.UndefOr[(ReactEvent, Int, js.Any) => Callback]   = js.undefined,
	className:       js.UndefOr[String]                                  = js.undefined,
	value:           js.UndefOr[js.Object]                               = js.undefined)
{

  def apply() = {
    val props = JSMacro[MuiDropDownMenu](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.DropDownMenu)
    f(props).asInstanceOf[ReactComponentU_]
  }
}
    

case class MuiDropDownMenuItem(payload: String, text: String) {
  val toJS = JSMacro[MuiDropDownMenuItem](this)
}

object MuiDropDownMenuItem {
  def fromJson(obj: js.Dynamic) =
    MuiDropDownMenuItem(text = obj.text.toString, payload = obj.payload.toString)
}
      
