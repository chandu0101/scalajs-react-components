
package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
  
case class MuiToolbarTitle(
	key:   js.UndefOr[String]          = js.undefined,
	ref:   js.UndefOr[String]          = js.undefined,
	/*  Override the inline-styles of the toolbar title's root element.*/
	style: js.UndefOr[CssProperties]   = js.undefined,
	/*  The text to be displayed for the element.*/
	text:  js.UndefOr[String]          = js.undefined)
{

  def apply() = {
    val props = JSMacro[MuiToolbarTitle](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.ToolbarTitle)
    f(props).asInstanceOf[ReactComponentU_]
  }
}
    
