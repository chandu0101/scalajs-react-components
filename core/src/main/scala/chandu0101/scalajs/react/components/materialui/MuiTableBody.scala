
package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
  
case class MuiTableBody(
	key:                 js.UndefOr[String]          = js.undefined,
	ref:                 js.UndefOr[String]          = js.undefined,
	/* default: false: Set to true to indicate that all rows should be selected.*/
	allRowsSelected:     js.UndefOr[Boolean]         = js.undefined,
	/* default: true: Controls whether or not to deselect all selected rows after clicking outside the table.*/
	deselectOnClickaway: js.UndefOr[Boolean]         = js.undefined,
	/*  Controls the display of the row checkbox. The default value is true.*/
	displayRowCheckbox:  js.UndefOr[Boolean]         = js.undefined,
	/*  If true, multiple table rows can be selected. CTRL/CMD+Click and SHIFT+Click are valid actions. The default value is false.*/
	multiSelectable:     js.UndefOr[Boolean]         = js.undefined,
	/* default: true: Controls whether or not the rows are pre-scanned to determine initial state. If your table has a large number of rows and you are experiencing a delay in rendering, turn off this property.*/
	preScanRows:         js.UndefOr[Boolean]         = js.undefined,
	/*  If true, table rows can be selected. If multiple row selection is desired, enable multiSelectable. The default value is true.*/
	selectable:          js.UndefOr[Boolean]         = js.undefined,
	/*  If true, table rows will be highlighted when the cursor is hovering over the row. The default value is false.*/
	showRowHover:        js.UndefOr[Boolean]         = js.undefined,
	/*  If true, every other table row starting with the first row will be striped. The default value is false.*/
	stripedRows:         js.UndefOr[Boolean]         = js.undefined,
	/*  Override the inline-styles of the table body's root element.*/
	style:               js.UndefOr[CssProperties]   = js.undefined)
{

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiTableBody](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.TableBody)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
