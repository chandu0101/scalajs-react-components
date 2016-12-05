package chandu0101.scalajs.react.components
package materialui
import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
/**
 * This file is generated - submit issues instead of PR against it
 */
case class MuiTableRow(
  key:             js.UndefOr[String]                             = js.undefined,
  ref:             js.UndefOr[String]                             = js.undefined,
  /* The css class name of the root element.*/
  className:       js.UndefOr[String]                             = js.undefined,
  /* If true, row border will be displayed for the row.
  If false, no border will be drawn.*/
  displayBorder:   js.UndefOr[Boolean]                            = js.undefined,
  /* Controls whether or not the row reponseds to hover events.*/
  hoverable:       js.UndefOr[Boolean]                            = js.undefined,
  /* Controls whether or not the row should be rendered as being
  hovered. This property is evaluated in addition to this.state.hovered
  and can be used to synchronize the hovered state with some other
  external events.*/
  hovered:         js.UndefOr[Boolean]                            = js.undefined,
  /* Called when a row cell is clicked.
  rowNumber is the row number and columnId is
  the column number or the column key.*/
  onCellClick:     js.UndefOr[(ReactEvent, ColumnId) => Callback] = js.undefined,
  /* Called when a table cell is hovered.
  rowNumber is the row number of the hovered row
  and columnId is the column number or the column key of the cell.*/
  onCellHover:     js.UndefOr[(ReactEvent, ColumnId) => Callback] = js.undefined,
  /* Called when a table cell is no longer hovered.
  rowNumber is the row number of the row and columnId
  is the column number or the column key of the cell.*/
  onCellHoverExit: js.UndefOr[(ReactEvent, ColumnId) => Callback] = js.undefined,
  /* Called when row is clicked.*/
  onRowClick:      js.UndefOr[(ReactEventH, RowId) => Callback]   = js.undefined,
  /* Called when a table row is hovered.
  rowNumber is the row number of the hovered row.*/
  onRowHover:      js.UndefOr[ReactEvent => Callback]             = js.undefined,
  /* Called when a table row is no longer hovered.
  rowNumber is the row number of the row that is no longer hovered.*/
  onRowHoverExit:  js.UndefOr[(ReactEvent, RowId) => Callback]    = js.undefined,
  /* Number to identify the row. This property is
  automatically populated when used with the TableBody component.*/
  rowNumber:       js.UndefOr[Int]                                = js.undefined,
  /* If true, table rows can be selected. If multiple row
  selection is desired, enable multiSelectable.
  The default value is true.*/
  selectable:      js.UndefOr[Boolean]                            = js.undefined,
  /* Indicates that a particular row is selected.
  This property can be used to programmatically select rows.*/
  selected:        js.UndefOr[Boolean]                            = js.undefined,
  /* Indicates whether or not the row is striped.*/
  striped:         js.UndefOr[Boolean]                            = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:           js.UndefOr[CssProperties]                      = js.undefined){
  /**
   * @param children Children passed to table row.
   */
  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiTableRow](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.TableRow)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
