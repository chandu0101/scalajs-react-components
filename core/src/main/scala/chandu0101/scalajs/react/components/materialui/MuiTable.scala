
package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
  
case class MuiTable(
	key:             js.UndefOr[String]                               = js.undefined,
	ref:             js.UndefOr[String]                               = js.undefined,
	/* default: false: Set to true to indicate that all rows should be selected.*/
	allRowsSelected: js.UndefOr[Boolean]                              = js.undefined,
	/*  If true, the footer will appear fixed below the table. The default value is true.*/
	fixedFooter:     js.UndefOr[Boolean]                              = js.undefined,
	/*  If true, the header will appear fixed above the table. The default value is true.*/
	fixedHeader:     js.UndefOr[Boolean]                              = js.undefined,
	/*  The height of the table.*/
	height:          js.UndefOr[String]                               = js.undefined,
	/*  If true, multiple table rows can be selected. CTRL/CMD+Click and SHIFT+Click are valid actions. The default value is false.*/
	multiSelectable: js.UndefOr[Boolean]                              = js.undefined,
	/*  If true, table rows can be selected. If multiple row selection is desired, enable multiSelectable. The default value is true.*/
	selectable:      js.UndefOr[Boolean]                              = js.undefined,
	/*  Override the inline-styles of the table's root element.*/
	style:           js.UndefOr[CssProperties]                        = js.undefined,
	/*  Called when a row is selected. selectedRows is an array of all row selections. IF all rows have been selected, the string "all" will be returned instead to indicate that all rows have been selected.*/
	onRowSelection:  js.UndefOr[String | js.Array[Int] => Callback]   = js.undefined,
	/*  Called when a row cell is clicked. rowNumber is the row number and columnId is the column number or the column key.*/
	onCellClick:     js.UndefOr[(Int, String) => Callback]            = js.undefined,
	/*  Called when a table row is hovered. rowNumber is the row number of the hovered row.*/
	onRowHover:      js.UndefOr[Int => Callback]                      = js.undefined,
	/*  Called when a table row is no longer hovered. rowNumber is the row number of the row that is no longer hovered.*/
	onRowHoverExit:  js.UndefOr[Int => Callback]                      = js.undefined,
	/*  Called when a table cell is hovered. rowNumber is the row number of the hovered row and columnId is the column number or the column key of the cell.*/
	onCellHover:     js.UndefOr[(Int, String) => Callback]            = js.undefined,
	/*  Called when a table cell is no longer hovered. rowNumber is the row number of the row and columnId is the column number or the column key of the cell.*/
	onCellHoverExit: js.UndefOr[(Int, String) => Callback]            = js.undefined)
{

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiTable](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Table)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
