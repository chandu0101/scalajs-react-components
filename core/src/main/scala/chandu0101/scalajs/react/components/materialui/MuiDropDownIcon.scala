package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiDropDownIcon(
  key:                     js.UndefOr[String]                                 = js.undefined,
  ref:                     js.UndefOr[String]                                 = js.undefined,
  closeOnMenuItemTouchTap: js.UndefOr[Boolean]                                = js.undefined,
  iconClassName:           js.UndefOr[String]                                 = js.undefined,
  iconLigature:            js.UndefOr[String]                                 = js.undefined,
  iconStyle:               js.UndefOr[CssProperties]                          = js.undefined,
  menuItems:               js.Array[MuiMenuItemJson],
  onChange:                js.UndefOr[(ReactEventI, Int, js.Any) => Callback] = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:                   js.UndefOr[CssProperties]                          = js.undefined){

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiDropDownIcon](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.DropDownIcon)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
