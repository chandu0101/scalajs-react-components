
package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
  
case class MuiGridList(
	key:        js.UndefOr[String]          = js.undefined,
	ref:        js.UndefOr[String]          = js.undefined,
	/*  Number of px for one cell height. Defaults to 180.*/
	cellHeight: js.UndefOr[Int]             = js.undefined,
	/*  Number of columns. Defaults to 2.*/
	cols:       js.UndefOr[Int]             = js.undefined,
	/*  Number of px for the padding/spacing between items. Defaults to 4.*/
	padding:    js.UndefOr[Int]             = js.undefined,
	/*  Override the inline-styles of the grid list's root element.*/
	style:      js.UndefOr[CssProperties]   = js.undefined)
{

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiGridList](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.GridList)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
