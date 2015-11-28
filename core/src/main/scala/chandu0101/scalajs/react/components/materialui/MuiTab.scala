
package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
  
case class MuiTab(
	key:        js.UndefOr[String]                         = js.undefined,
	ref:        js.UndefOr[String]                         = js.undefined,
	/*  Sets the text value of the tab item to the string specified.*/
	label:      js.UndefOr[String]                         = js.undefined,
	/*  If value prop passed to Tabs component, this value prop is also required. It assigns a value to the tab so that it can be selected by the Tabs.*/
	value:      js.UndefOr[String]                         = js.undefined,
	/*  Fired when the active tab changes by touch or tap. Use this event to specify any functionality when an active tab changes. For example - we are using this to route to home when the third tab becomes active. This function will always recieve the active tab as it's first argument.*/
	onActive:   js.UndefOr[ReactElement => Callback]       = js.undefined,
	style:      js.UndefOr[CssProperties]                  = js.undefined,
	selected:   js.UndefOr[Boolean]                        = js.undefined,
	onTouchTap: js.UndefOr[ReactTouchEventH => Callback]   = js.undefined,
	width:      js.UndefOr[String]                         = js.undefined)
{

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiTab](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Tab)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
