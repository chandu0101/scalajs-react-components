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
case class MuiDropDownMenu[T](key: js.UndefOr[String] = js.undefined,
                              ref: js.UndefOr[MuiDropDownMenuM => Unit] = js.undefined,
                              /* If true, the popover will apply transitions when
     it gets added to the DOM. */
                              animated: js.UndefOr[Boolean] = js.undefined,
                              /* Override the default animation component used. */
                              animation: js.UndefOr[js.Function] = js.undefined,
                              /* The width will automatically be set according to the items inside the menu.
     To control this width in css instead, set this prop to `false`. */
                              autoWidth: js.UndefOr[Boolean] = js.undefined,
                              /* The css class name of the root element. */
                              className: js.UndefOr[String] = js.undefined,
                              /* Disables the menu. */
                              disabled: js.UndefOr[Boolean] = js.undefined,
                              /* Overrides default `SvgIcon` dropdown arrow component. */
                              iconButton: js.UndefOr[ReactNode] = js.undefined,
                              /* Overrides the styles of icon element. */
                              iconStyle: js.UndefOr[CssProperties] = js.undefined,
                              /* Overrides the styles of label when the `DropDownMenu` is inactive. */
                              labelStyle: js.UndefOr[CssProperties] = js.undefined,
                              /* The style object to use to override underlying list style. */
                              listStyle: js.UndefOr[CssProperties] = js.undefined,
                              /* The maximum height of the `Menu` when it is displayed. */
                              maxHeight: js.UndefOr[Int] = js.undefined,
                              /* Override the inline-styles of menu items. */
                              menuItemStyle: js.UndefOr[CssProperties] = js.undefined,
                              /* Overrides the styles of `Menu` when the `DropDownMenu` is displayed. */
                              menuStyle: js.UndefOr[CssProperties] = js.undefined,
                              /* Callback function fired when a menu item is clicked, other than the one currently selected.
     @param {object} event TouchTap event targeting the menu item that was clicked.
     @param {number} key The index of the clicked menu item in the `children` collection.
     @param {any} payload The `value` prop of the clicked menu item. */
                              onChange: js.UndefOr[(TouchTapEvent, Int, T) => Callback] =
                                js.undefined,
                              /* Callback function fired when the menu is closed. */
                              onClose: js.UndefOr[Callback] = js.undefined,
                              /* Set to true to have the `DropDownMenu` automatically open on mount. */
                              openImmediately: js.UndefOr[Boolean] = js.undefined,
                              /* Override the inline-styles of selected menu items. */
                              selectedMenuItemStyle: js.UndefOr[CssProperties] = js.undefined,
                              /* Override the inline-styles of the root element. */
                              style: js.UndefOr[CssProperties] = js.undefined,
                              /* Overrides the inline-styles of the underline. */
                              underlineStyle: js.UndefOr[CssProperties] = js.undefined,
                              /* The value that is currently selected. */
                              value: js.UndefOr[T] = js.undefined) {

  /**
    * @param children The `MenuItem`s to populate the `Menu` with. If the `MenuItems` have the
    prop `label` that value will be used to render the representation of that
    item within the field.
    */
  def apply(children: ReactNode*) = {
    implicit def evT(t: T): js.Any = t.asInstanceOf[js.Any]
    val props                      = JSMacro[MuiDropDownMenu[T]](this)
    val f                          = React.asInstanceOf[js.Dynamic].createFactory(Mui.DropDownMenu)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
@js.native
class MuiDropDownMenuM extends js.Object {
  def getInputNode(): js.Dynamic = js.native

  def setWidth(): js.Dynamic = js.native
}
