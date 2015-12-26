package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiSelectField(
  key:                    js.UndefOr[String]                                 = js.undefined,
  ref:                    js.UndefOr[String]                                 = js.undefined,
  autoWidth:              js.UndefOr[Boolean]                                = js.undefined,
  /* Disables the select field if set to true.*/
  disabled:               js.UndefOr[Boolean]                                = js.undefined,
  /* The style object to use to override error styles.*/
  errorStyle:             js.UndefOr[CssProperties]                          = js.undefined,
  /* The error content to display.*/
  errorText:              js.UndefOr[ReactNode]                              = js.undefined,
  /* The style object to use to override floating label styles.*/
  floatingLabelStyle:     js.UndefOr[CssProperties]                          = js.undefined,
  /* The content to use for the floating label element.*/
  floatingLabelText:      js.UndefOr[ReactNode]                              = js.undefined,
  /* If true, the field receives the property width 100%.*/
  fullWidth:              js.UndefOr[Boolean]                                = js.undefined,
  /* The hint content to display.*/
  hintText:               js.UndefOr[ReactNode]                              = js.undefined,
  /* Overrides the styles of SelectField's icon element.*/
  iconStyle:              js.UndefOr[CssProperties]                          = js.undefined,
  /* default: text: DropDownMenu will use text as default value, with this property you can choose another name.*/
  labelMember:            js.UndefOr[String]                                 = js.undefined,
  /* DEPRECATE*/
  labelStyle:             js.UndefOr[CssProperties]                          = js.undefined,
  /* DEPRECATE*/
  menuItems:              js.UndefOr[js.Array[MuiSelectItem]]                = js.undefined,
  /* DEPRECATE*/
  onBlur:                 js.UndefOr[ReactEventH => Callback]                = js.undefined,
  /* function(event, selectedIndex): Callback function that is fired when the selectfield's value changes.*/
  onChange:               js.UndefOr[(ReactEventI, Int, js.Any) => Callback] = js.undefined,
  /* function(event): Callback function that is fired when the selectfield gains focus.*/
  onFocus:                js.UndefOr[ReactFocusEventH => Callback]           = js.undefined,
  /* The style object to use to override the drop-down menu*/
  selectFieldRoot:        js.UndefOr[js.Any]                                 = js.undefined,
  /* default: 0: Index of the item selected.*/
  selectedIndex:          js.UndefOr[Int]                                    = js.undefined,
  /* DEPRECATE
Override the inline-styles of the root element.*/
  style:                  js.UndefOr[CssProperties]                          = js.undefined,
  /* Override the inline-styles of the SelectField's underline element when disabled.*/
  underlineDisabledStyle: js.UndefOr[CssProperties]                          = js.undefined,
  /* Override the inline-styles of the SelectField's underline element when focussed.*/
  underlineFocusStyle:    js.UndefOr[CssProperties]                          = js.undefined,
  /* Overrides the styles of SelectField's underline.*/
  underlineStyle:         js.UndefOr[CssProperties]                          = js.undefined,
  value:                  js.UndefOr[js.Any]                                 = js.undefined,
  /* The css class name of the root element.
  (Passed on to DropDownMenu)*/
  className:              js.UndefOr[String]                                 = js.undefined,
  /* `DropDownMenu` will use this member to display
the name of the item.
  (Passed on to DropDownMenu)*/
  @deprecated("Instead, use composability.")
  displayMember:          js.UndefOr[String]                                 = js.undefined,
  /* The maximum height of the `Menu` when it is displayed.
  (Passed on to DropDownMenu)*/
  maxHeight:              js.UndefOr[Int]                                    = js.undefined,
  /* Overrides the styles of `Menu` when the `DropDownMenu` is displayed.
  (Passed on to DropDownMenu)*/
  menuStyle:              js.UndefOr[CssProperties]                          = js.undefined,
  /* Set to true to have the `DropDownMenu` automatically open on mount.
  (Passed on to DropDownMenu)*/
  openImmediately:        js.UndefOr[Boolean]                                = js.undefined,
  /* Two-way binding link.
  (Passed on to DropDownMenu)*/
  @deprecated("It\'s deprecated by React too.")
  valueLink:              js.UndefOr[js.Any]                                 = js.undefined,
  /* `DropDownMenu` will use this member as the value representing an item.
  (Passed on to DropDownMenu)*/
  @deprecated("Instead, use composability.")
  valueMember:            js.UndefOr[String]                                 = js.undefined){

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiSelectField](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.SelectField)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
case class MuiSelectItem(payload: String, text: String){
	val toJS = JSMacro[MuiSelectItem](this)
}

