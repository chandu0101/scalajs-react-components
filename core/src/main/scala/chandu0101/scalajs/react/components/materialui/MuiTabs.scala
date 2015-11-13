
package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
  
case class MuiTabs(
	key:                   js.UndefOr[String]                                           = js.undefined,
	ref:                   js.UndefOr[String]                                           = js.undefined,
	/*  Override the inline-styles of the content's container.*/
	contentContainerStyle: js.UndefOr[CssProperties]                                    = js.undefined,
	/*  Specify initial visible tab index. Initial selected index is set by default to 0. If initialSelectedIndex is set but larger than the total amount of specified tabs, initialSelectedIndex will revert back to default*/
	initialSelectedIndex:  js.UndefOr[Int]                                              = js.undefined,
	/*  Override the inline-styles of the InkBar.*/
	inkBarStyle:           js.UndefOr[CssProperties]                                    = js.undefined,
	/*  Override the inline-styles of the Tabs' root element.*/
	style:                 js.UndefOr[CssProperties]                                    = js.undefined,
	/*  Override the inline-styles of the tab-labels container.*/
	tabItemContainerStyle: js.UndefOr[CssProperties]                                    = js.undefined,
	/*  Override the default tab template used to wrap the content of each tab element.*/
	tabTemplate:           js.UndefOr[js.Any]                                           = js.undefined,
	/*  Makes Tabs controllable and selects the tab whose value prop matches this prop.*/
	value:                 js.UndefOr[String | Double]                                  = js.undefined,
	/*  Fired on touch or tap of a tab. Passes the value of the tab, the touchTap event and the tab element.*/
	onChange:              js.UndefOr[(String, ReactEvent, ReactElement) => Callback]   = js.undefined)
{

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiTabs](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Tabs)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
