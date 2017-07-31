package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import org.scalajs.dom
import scala.scalajs.js
import scala.scalajs.js.`|`

/**
  * This file is generated - submit issues instead of PR against it
  */
case class MuiTableBody(key: js.UndefOr[String] = js.undefined,
                        ref: js.UndefOr[MuiTableBodyM => Unit] = js.undefined,
                        /* Set to true to indicate that all rows should be selected. */
                        allRowsSelected: js.UndefOr[Boolean] = js.undefined,
                        /* The css class name of the root element. */
                        className: js.UndefOr[String] = js.undefined,
                        /* Controls whether or not to deselect all selected
     rows after clicking outside the table. */
                        deselectOnClickaway: js.UndefOr[Boolean] = js.undefined,
                        /* Controls the display of the row checkbox. The default value is true. */
                        displayRowCheckbox: js.UndefOr[Boolean] = js.undefined,
                        /* If true, multiple table rows can be selected.
     CTRL/CMD+Click and SHIFT+Click are valid actions.
     The default value is false. */
                        multiSelectable: js.UndefOr[Boolean] = js.undefined,
                        /* Callback function for when a cell is clicked. */
                        onCellClick: js.UndefOr[(RowId, ColumnId) => Callback] = js.undefined,
                        /* Called when a table cell is hovered. rowNumber
     is the row number of the hovered row and columnId
     is the column number or the column key of the cell. */
                        onCellHover: js.UndefOr[(RowId, ColumnId) => Callback] = js.undefined,
                        /* Called when a table cell is no longer hovered.
     rowNumber is the row number of the row and columnId
     is the column number or the column key of the cell. */
                        onCellHoverExit: js.UndefOr[(RowId, ColumnId) => Callback] = js.undefined,
                        /* Called when a table row is hovered.
     rowNumber is the row number of the hovered row. */
                        onRowHover: js.UndefOr[RowId => Callback] = js.undefined,
                        /* Called when a table row is no longer
     hovered. rowNumber is the row number of the row
     that is no longer hovered. */
                        onRowHoverExit: js.UndefOr[RowId => Callback] = js.undefined,
                        /* Called when a row is selected. selectedRows is an
     array of all row selections. IF all rows have been selected,
     the string "all" will be returned instead to indicate that
     all rows have been selected. */
                        onRowSelection: js.UndefOr[String | js.Array[RowId] => Callback] =
                          js.undefined,
                        /* Controls whether or not the rows are pre-scanned to determine
     initial state. If your table has a large number of rows and
     you are experiencing a delay in rendering, turn off this property. */
                        preScanRows: js.UndefOr[Boolean] = js.undefined,
                        /* If true, table rows can be selected. If multiple
     row selection is desired, enable multiSelectable.
     The default value is true. */
                        selectable: js.UndefOr[Boolean] = js.undefined,
                        /* If true, table rows will be highlighted when
     the cursor is hovering over the row. The default
     value is false. */
                        showRowHover: js.UndefOr[Boolean] = js.undefined,
                        /* If true, every other table row starting
     with the first row will be striped. The default value is false. */
                        stripedRows: js.UndefOr[Boolean] = js.undefined,
                        /* Override the inline-styles of the root element. */
                        style: js.UndefOr[CssProperties] = js.undefined) {

  /**
    * @param children Children passed to table body.
    */
  def apply(children: ReactNode*) = {

    val props = JSMacro[MuiTableBody](this)
    val f     = React.asInstanceOf[js.Dynamic].createFactory(Mui.TableBody)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
@js.native
class MuiTableBodyM extends js.Object {
  def calculatePreselectedRows(props: js.Any): js.Dynamic = js.native

  def createRowCheckboxColumn(rowProps: js.Any): js.Dynamic = js.native

  def createRows(): js.Dynamic = js.native

  def flattenRanges(selectedRows: js.Any): js.Dynamic = js.native

  def genRangeOfValues(start: js.Any, offset: js.Any): js.Dynamic = js.native

  def getColumnId(columnNumber: js.Any): js.Dynamic = js.native

  def isRowSelected(rowNumber: js.Any): js.Dynamic = js.native

  def isValueInRange(value: js.Any, range: js.Any): js.Dynamic = js.native

  def processRowSelection(event: js.Any, rowNumber: js.Any): js.Dynamic =
    js.native

  def splitRange(range: js.Any, splitPoint: js.Any): js.Dynamic = js.native
}
