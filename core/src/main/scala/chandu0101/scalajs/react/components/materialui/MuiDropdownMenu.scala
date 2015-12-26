package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiDropDownMenu(
  key:             js.UndefOr[String]                                 = js.undefined,
  ref:             js.UndefOr[String]                                 = js.undefined,
  /* The width will automatically be set according to the items inside the menu.
To control this width in css instead, set this prop to false.*/
  autoWidth:       js.UndefOr[Boolean]                                = js.undefined,
  /* The css class name of the root element.*/
  className:       js.UndefOr[String]                                 = js.undefined,
  /* Disables the menu.*/
  disabled:        js.UndefOr[Boolean]                                = js.undefined,
  /* `DropDownMenu` will use this member to display
the name of the item.*/
  @deprecated("Instead, use composability.")
  displayMember:   js.UndefOr[String]                                 = js.undefined,
  /* Overrides the styles of icon element.*/
  iconStyle:       js.UndefOr[CssProperties]                          = js.undefined,
  /* `DropDownMenu` will use this member to display
the name of the item on the label.*/
  @deprecated("Instead, use composability.")
  labelMember:     js.UndefOr[String]                                 = js.undefined,
  /* Overrides the styles of label when the `DropDownMenu` is inactive.*/
  labelStyle:      js.UndefOr[CssProperties]                          = js.undefined,
  /* The maximum height of the `Menu` when it is displayed.*/
  maxHeight:       js.UndefOr[Int]                                    = js.undefined,
  /* JSON data representing all menu items in the dropdown.*/
  @deprecated("Instead, use composability.")
  menuItems:       js.UndefOr[js.Array[MuiDropDownMenuItem]]          = js.undefined,
  /* Overrides the styles of `Menu` when the `DropDownMenu` is displayed.*/
  menuStyle:       js.UndefOr[CssProperties]                          = js.undefined,
  /* Fired when a menu item is clicked that is not the one currently selected.*/
  onChange:        js.UndefOr[(ReactEventI, Int, js.Any) => Callback] = js.undefined,
  /* Set to true to have the `DropDownMenu` automatically open on mount.*/
  openImmediately: js.UndefOr[Boolean]                                = js.undefined,
  /* Index of the item selected.*/
  @deprecated("Use value instead to control the component.")
  selectedIndex:   js.UndefOr[Int]                                    = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:           js.UndefOr[CssProperties]                          = js.undefined,
  /* Overrides the inline-styles of the underline.*/
  underlineStyle:  js.UndefOr[CssProperties]                          = js.undefined,
  /* The value that is currently selected.*/
  value:           js.UndefOr[js.Any]                                 = js.undefined,
  /* Two-way binding link.*/
  @deprecated("It\'s deprecated by React too.")
  valueLink:       js.UndefOr[js.Any]                                 = js.undefined,
  /* `DropDownMenu` will use this member as the value representing an item.*/
  @deprecated("Instead, use composability.")
  valueMember:     js.UndefOr[String]                                 = js.undefined){
  /**
   * @param children The `MenuItem`s to populate the `Menu` with. If the `MenuItems` have the
prop `label` that value will be used to render the representation of that
item within the field.
   */
  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiDropDownMenu](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.DropDownMenu)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}

case class MuiDropDownMenuItem(payload: String, text: String) {
  val toJS = JSMacro[MuiDropDownMenuItem](this)
}

object DropDownMenuItem {
  def fromJson(obj: js.Dynamic) =
    MuiDropDownMenuItem(text = obj.text.toString, payload = obj.payload.toString)
}
      
