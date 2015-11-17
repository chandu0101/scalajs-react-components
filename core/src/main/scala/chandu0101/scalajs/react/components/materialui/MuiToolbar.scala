
package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
  
case class MuiToolbar(
	key:   js.UndefOr[String]          = js.undefined,
	ref:   js.UndefOr[String]          = js.undefined,
	/*  Override the inline-styles of the toolbar group's root element.*/
	style: js.UndefOr[CssProperties]   = js.undefined)
{

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiToolbar](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Toolbar)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
