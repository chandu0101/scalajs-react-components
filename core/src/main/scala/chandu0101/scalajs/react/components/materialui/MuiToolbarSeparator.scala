
package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
  
case class MuiToolbarSeparator(
	key:       js.UndefOr[String]          = js.undefined,
	ref:       js.UndefOr[String]          = js.undefined,
	/*  Override the inline-styles of the toolbar separator's root element.*/
	style:     js.UndefOr[CssProperties]   = js.undefined,
	className: js.UndefOr[String]          = js.undefined)
{

  def apply() = {
    val props = JSMacro[MuiToolbarSeparator](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.ToolbarSeparator)
    f(props).asInstanceOf[ReactComponentU_]
  }
}
    
