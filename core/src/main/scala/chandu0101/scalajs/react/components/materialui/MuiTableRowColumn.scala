package chandu0101.scalajs.react.components
package materialui
import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
/**
 * This file is generated - submit issues instead of PR against it
 */
case class MuiTableRowColumn(
  key:          js.UndefOr[String]                              = js.undefined,
  ref:          js.UndefOr[String]                              = js.undefined,
  /* The css class name of the root element.*/
  className:    js.UndefOr[String]                              = js.undefined,
  /* Number to identify the header row. This property
  is automatically populated when used with TableHeader.*/
  columnNumber: js.UndefOr[Int]                                 = js.undefined,
  /* If true, this column responds to hover events.*/
  hoverable:    js.UndefOr[Boolean]                             = js.undefined,
  /* Callback function for click event.*/
  onClick:      js.UndefOr[(ReactEvent, ColumnId) => Callback]  = js.undefined,
  /* Callback function for hover event.*/
  onHover:      js.UndefOr[(ReactEventH, ColumnId) => Callback] = js.undefined,
  /* Callback function for hover exit event.*/
  onHoverExit:  js.UndefOr[(ReactEventH, ColumnId) => Callback] = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:        js.UndefOr[CssProperties]                       = js.undefined){
  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiTableRowColumn](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.TableRowColumn)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
