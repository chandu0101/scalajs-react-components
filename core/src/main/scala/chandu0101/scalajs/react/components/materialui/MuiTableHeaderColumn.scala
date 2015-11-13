
package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
  
case class MuiTableHeaderColumn(
	key:          js.UndefOr[String]          = js.undefined,
	ref:          js.UndefOr[String]          = js.undefined,
	/*  Number to identify the header row. This property is automatically populated when used with TableHeader.*/
	columnNumber: js.UndefOr[Int]             = js.undefined,
	/*  Override the inline-styles of the table header column's root element.*/
	style:        js.UndefOr[CssProperties]   = js.undefined,
	/*  The string to supply to the tooltip. If not string is supplied no tooltip will be shown.*/
	tooltip:      js.UndefOr[String]          = js.undefined,
	/*  Additional styling that can be applied to the tooltip.*/
	tooltipStyle: js.UndefOr[CssProperties]   = js.undefined)
{

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiTableHeaderColumn](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.TableHeaderColumn)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
