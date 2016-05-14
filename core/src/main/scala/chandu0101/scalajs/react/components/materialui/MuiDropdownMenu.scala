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
  ref:             js.UndefOr[DropDownMenuM => Unit]                  = js.undefined,
  /* The width will automatically be set according to the items inside the menu.
  To control this width in css instead, set this prop to `false`.*/
  autoWidth:       js.UndefOr[Boolean]                                = js.undefined,
  /* The css class name of the root element.*/
  className:       js.UndefOr[String]                                 = js.undefined,
  /* Disables the menu.*/
  disabled:        js.UndefOr[Boolean]                                = js.undefined,
  /* Overrides the styles of icon element.*/
  iconStyle:       js.UndefOr[CssProperties]                          = js.undefined,
  /* Overrides the styles of label when the `DropDownMenu` is inactive.*/
  labelStyle:      js.UndefOr[CssProperties]                          = js.undefined,
  /* The style object to use to override underlying list style.*/
  listStyle:       js.UndefOr[CssProperties]                          = js.undefined,
  /* The maximum height of the `Menu` when it is displayed.*/
  maxHeight:       js.UndefOr[Int]                                    = js.undefined,
  /* Overrides the styles of `Menu` when the `DropDownMenu` is displayed.*/
  menuStyle:       js.UndefOr[CssProperties]                          = js.undefined,
  /* Callback function fired when a menu item is clicked, other than the one currently selected.*/
  onChange:        js.UndefOr[(ReactEventI, Int, js.Any) => Callback] = js.undefined,
  /* Set to true to have the `DropDownMenu` automatically open on mount.*/
  openImmediately: js.UndefOr[Boolean]                                = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:           js.UndefOr[CssProperties]                          = js.undefined,
  /* Overrides the inline-styles of the underline.*/
  underlineStyle:  js.UndefOr[CssProperties]                          = js.undefined,
  /* The value that is currently selected.*/
  value:           js.UndefOr[js.Any]                                 = js.undefined){
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


@js.native
class DropDownMenuM extends js.Object {
  def getInputNode(): js.Any = js.native

  def setWidth(): js.Any = js.native
}
