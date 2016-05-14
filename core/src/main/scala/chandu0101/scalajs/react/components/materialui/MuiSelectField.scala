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
  /* If true, the width will automatically be set according to the
  items inside the menu.
  To control this width in css instead, leave this prop to `false`.*/
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
  /* The style object to use to override hint styles.*/
  hintStyle:              js.UndefOr[CssProperties]                          = js.undefined,
  /* The hint content to display.*/
  hintText:               js.UndefOr[ReactNode]                              = js.undefined,
  /* Overrides the styles of the icon element.*/
  iconStyle:              js.UndefOr[CssProperties]                          = js.undefined,
  /* The id prop for the text field.*/
  id:                     js.UndefOr[String]                                 = js.undefined,
  /* Overrides the styles of label when the `SelectField` is inactive.*/
  labelStyle:             js.UndefOr[CssProperties]                          = js.undefined,
  /* Callback function that is fired when the `SelectField` loses focus.*/
  onBlur:                 js.UndefOr[ReactEventH => Callback]                = js.undefined,
  /* Callback function that is fired when the value changes.*/
  onChange:               js.UndefOr[(ReactEventI, Int, js.Any) => Callback] = js.undefined,
  /* Callback function that is fired when the `SelectField` gains focus.*/
  onFocus:                js.UndefOr[ReactFocusEventH => Callback]           = js.undefined,
  /* The style object to use to override the `DropDownMenu`.*/
  selectFieldRoot:        js.UndefOr[js.Any]                                 = js.undefined,
  /* Must be changed!
  Override the inline-styles of the root element.*/
  style:                  js.UndefOr[CssProperties]                          = js.undefined,
  /* Override the inline-styles of the underline element when disabled.*/
  underlineDisabledStyle: js.UndefOr[CssProperties]                          = js.undefined,
  /* Override the inline-styles of the underline element when focused.*/
  underlineFocusStyle:    js.UndefOr[CssProperties]                          = js.undefined,
  /* Overrides the styles of the underline element.*/
  underlineStyle:         js.UndefOr[CssProperties]                          = js.undefined,
  /* The value that is currently selected.*/
  value:                  js.UndefOr[js.Any]                                 = js.undefined,
  /* The css class name of the root element.
  (Passed on to DropDownMenu)*/
  className:              js.UndefOr[String]                                 = js.undefined,
  /* The style object to use to override underlying list style.
  (Passed on to DropDownMenu)*/
  listStyle:              js.UndefOr[CssProperties]                          = js.undefined,
  /* The maximum height of the `Menu` when it is displayed.
  (Passed on to DropDownMenu)*/
  maxHeight:              js.UndefOr[Int]                                    = js.undefined,
  /* Overrides the styles of `Menu` when the `DropDownMenu` is displayed.
  (Passed on to DropDownMenu)*/
  menuStyle:              js.UndefOr[CssProperties]                          = js.undefined,
  /* Set to true to have the `DropDownMenu` automatically open on mount.
  (Passed on to DropDownMenu)*/
  openImmediately:        js.UndefOr[Boolean]                                = js.undefined){
  /**
   * @param children The `MenuItem` elements to populate the `Menu` with.
If the MenuItems have the prop `label` that value will
be used to render the representation of that
item within the field.
   */
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

