package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiTable(
  key:             js.UndefOr[String]                                    = js.undefined,
  ref:             js.UndefOr[MuiTableM => Unit]                         = js.undefined,
  /* Set to true to indicate that all rows should be selected.*/
  allRowsSelected: js.UndefOr[Boolean]                                   = js.undefined,
  /* Override the inline-styles of the body's table element.*/
  bodyStyle:       js.UndefOr[CssProperties]                             = js.undefined,
  /* The css class name of the root element.*/
  className:       js.UndefOr[String]                                    = js.undefined,
  /* If true, the footer will appear fixed below the table.
  The default value is true.*/
  fixedFooter:     js.UndefOr[Boolean]                                   = js.undefined,
  /* If true, the header will appear fixed above the table.
  The default value is true.*/
  fixedHeader:     js.UndefOr[Boolean]                                   = js.undefined,
  /* Override the inline-styles of the footer's table element.*/
  footerStyle:     js.UndefOr[CssProperties]                             = js.undefined,
  /* Override the inline-styles of the header's table element.*/
  headerStyle:     js.UndefOr[CssProperties]                             = js.undefined,
  /* The height of the table.*/
  height:          js.UndefOr[String]                                    = js.undefined,
  /* If true, multiple table rows can be selected.
  CTRL/CMD+Click and SHIFT+Click are valid actions.
  The default value is false.*/
  multiSelectable: js.UndefOr[Boolean]                                   = js.undefined,
  /* Called when a row cell is clicked.
  rowNumber is the row number and columnId is
  the column number or the column key.*/
  onCellClick:     js.UndefOr[(RowId, ColumnId, ReactEvent) => Callback] = js.undefined,
  /* Called when a table cell is hovered.
  rowNumber is the row number of the hovered row
  and columnId is the column number or the column key of the cell.*/
  onCellHover:     js.UndefOr[(RowId, ColumnId, ReactEvent) => Callback] = js.undefined,
  /* Called when a table cell is no longer hovered.
  rowNumber is the row number of the row and columnId
  is the column number or the column key of the cell.*/
  onCellHoverExit: js.UndefOr[(RowId, ColumnId, ReactEvent) => Callback] = js.undefined,
  /* Called when a table row is hovered.
  rowNumber is the row number of the hovered row.*/
  onRowHover:      js.UndefOr[RowId => Callback]                         = js.undefined,
  /* Called when a table row is no longer hovered.
  rowNumber is the row number of the row that is no longer hovered.*/
  onRowHoverExit:  js.UndefOr[RowId => Callback]                         = js.undefined,
  /* Called when a row is selected.
  selectedRows is an array of all row selections.
  IF all rows have been selected, the string "all"
  will be returned instead to indicate that all rows have been selected.*/
  onRowSelection:  js.UndefOr[String | js.Array[RowId] => Callback]      = js.undefined,
  /* If true, table rows can be selected.
  If multiple row selection is desired, enable multiSelectable.
  The default value is true.*/
  selectable:      js.UndefOr[Boolean]                                   = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:           js.UndefOr[CssProperties]                             = js.undefined,
  /* Override the inline-styles of the table's wrapper element.*/
  wrapperStyle:    js.UndefOr[CssProperties]                             = js.undefined){
  /**
   * @param children Children passed to table.
   */
  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiTable](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Table)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}


@js.native
class MuiTableM extends js.Object {
  def createTableBody(base: js.Any): js.Any = js.native

  def createTableFooter(base: js.Any): js.Any = js.native

  def createTableHeader(base: js.Any): js.Any = js.native

  def isScrollbarVisible(): js.Any = js.native
}
