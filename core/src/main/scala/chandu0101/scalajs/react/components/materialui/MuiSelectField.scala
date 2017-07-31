package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import org.scalajs.dom
import scala.scalajs.js
import scala.scalajs.js.`|`

/**
  * This file is generated - submit issues instead of PR against it
  */
case class MuiSelectField[T](key: js.UndefOr[String] = js.undefined,
                             ref: js.UndefOr[String] = js.undefined,
                             /* If true, the width will automatically be set according to the
     items inside the menu.
     To control the width in CSS instead, leave this prop set to `false`. */
                             autoWidth: js.UndefOr[Boolean] = js.undefined,
                             /* If true, the select field will be disabled. */
                             disabled: js.UndefOr[Boolean] = js.undefined,
                             /* Override the inline-styles of the error element. */
                             errorStyle: js.UndefOr[CssProperties] = js.undefined,
                             /* The error content to display. */
                             errorText: js.UndefOr[ReactNode] = js.undefined,
                             /* If true, the floating label will float even when no value is selected. */
                             floatingLabelFixed: js.UndefOr[Boolean] = js.undefined,
                             /* Override the inline-styles of the floating label. */
                             floatingLabelStyle: js.UndefOr[CssProperties] = js.undefined,
                             /* The content of the floating label. */
                             floatingLabelText: js.UndefOr[ReactNode] = js.undefined,
                             /* If true, the select field will take up the full width of its container. */
                             fullWidth: js.UndefOr[Boolean] = js.undefined,
                             /* Override the inline-styles of the hint element. */
                             hintStyle: js.UndefOr[CssProperties] = js.undefined,
                             /* The hint content to display. */
                             hintText: js.UndefOr[ReactNode] = js.undefined,
                             /* Override the inline-styles of the icon element. */
                             iconStyle: js.UndefOr[CssProperties] = js.undefined,
                             /* The id prop for the text field. */
                             id: js.UndefOr[String] = js.undefined,
                             /* Override the label style when the select field is inactive. */
                             labelStyle: js.UndefOr[CssProperties] = js.undefined,
                             /* Override the inline-styles of the underlying `List` element. */
                             listStyle: js.UndefOr[CssProperties] = js.undefined,
                             /* Override the default max-height of the underlying `DropDownMenu` element. */
                             maxHeight: js.UndefOr[Int] = js.undefined,
                             /* Override the inline-styles of menu items. */
                             menuItemStyle: js.UndefOr[CssProperties] = js.undefined,
                             /* Override the inline-styles of the underlying `DropDownMenu` element. */
                             menuStyle: js.UndefOr[CssProperties] = js.undefined,
                             onBlur: js.UndefOr[ReactFocusEvent => Callback] = js.undefined,
                             /* Callback function fired when a menu item is selected.
     @param {object} event TouchTap event targeting the menu item
     that was selected.
     @param {number} key The index of the selected menu item.
     @param {any} payload The `value` prop of the selected menu item. */
                             onChange: js.UndefOr[(TouchTapEvent, Int, T) => Callback] =
                               js.undefined,
                             onFocus: js.UndefOr[ReactFocusEvent => Callback] = js.undefined,
                             /* Override the inline-styles of selected menu items. */
                             selectedMenuItemStyle: js.UndefOr[CssProperties] = js.undefined,
                             /* Override the inline-styles of the root element. */
                             style: js.UndefOr[CssProperties] = js.undefined,
                             /* Override the inline-styles of the underline element when the select
     field is disabled. */
                             underlineDisabledStyle: js.UndefOr[CssProperties] = js.undefined,
                             /* Override the inline-styles of the underline element when the select field
     is focused. */
                             underlineFocusStyle: js.UndefOr[CssProperties] = js.undefined,
                             /* Override the inline-styles of the underline element. */
                             underlineStyle: js.UndefOr[CssProperties] = js.undefined,
                             /* The value that is currently selected. */
                             value: js.UndefOr[T] = js.undefined,
                             /* If true, the popover will apply transitions when
     it gets added to the DOM.
     (Passed on to DropDownMenu) */
                             animated: js.UndefOr[Boolean] = js.undefined,
                             /* Override the default animation component used.
     (Passed on to DropDownMenu) */
                             animation: js.UndefOr[js.Function] = js.undefined,
                             /* The css class name of the root element.
     (Passed on to DropDownMenu) */
                             className: js.UndefOr[String] = js.undefined,
                             /* Overrides default `SvgIcon` dropdown arrow component.
     (Passed on to DropDownMenu) */
                             iconButton: js.UndefOr[ReactNode] = js.undefined,
                             /* Callback function fired when the menu is closed.
     (Passed on to DropDownMenu) */
                             onClose: js.UndefOr[Callback] = js.undefined,
                             /* Set to true to have the `DropDownMenu` automatically open on mount.
     (Passed on to DropDownMenu) */
                             openImmediately: js.UndefOr[Boolean] = js.undefined) {

  /**
    * @param children The `MenuItem` elements to populate the select field with.
    If the menu items have a `label` prop, that value will
    represent the selected menu item in the rendered select field.
    */
  def apply(children: ReactNode*) = {
    implicit def evT(t: T): js.Any = t.asInstanceOf[js.Any]
    val props                      = JSMacro[MuiSelectField[T]](this)
    val f                          = React.asInstanceOf[js.Dynamic].createFactory(Mui.SelectField)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
