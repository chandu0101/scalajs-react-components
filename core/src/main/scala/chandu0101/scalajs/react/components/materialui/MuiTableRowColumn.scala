
package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
  
case class MuiTableRowColumn(
	key:          js.UndefOr[String]          = js.undefined,
	ref:          js.UndefOr[String]          = js.undefined,
	/*  Number to identify the header row. This property is automatically populated when used with TableHeader.*/
	columnNumber: js.UndefOr[Int]             = js.undefined,
	/* default: false: If true, this column responds to hover events.*/
	hoverable:    js.UndefOr[Boolean]         = js.undefined,
	/*  Override the inline-styles of the table row column's root element.*/
	style:        js.UndefOr[CssProperties]   = js.undefined)
{

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiTableRowColumn](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.TableRowColumn)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
