package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiTableHeaderColumn(
  key:          js.UndefOr[String]                             = js.undefined,
  ref:          js.UndefOr[String]                             = js.undefined,
  /* The css class name of the root element.*/
  className:    js.UndefOr[String]                             = js.undefined,
  /* Number to identify the header row. This property
  is automatically populated when used with TableHeader.*/
  columnNumber: js.UndefOr[Int]                                = js.undefined,
  /* Callback function for click event.*/
  @deprecated("Internal API")
  onClick:      js.UndefOr[(ReactEvent, ColumnId) => Callback] = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:        js.UndefOr[CssProperties]                      = js.undefined,
  /* The string to supply to the tooltip. If not
  string is supplied no tooltip will be shown.*/
  tooltip:      js.UndefOr[String]                             = js.undefined,
  /* Additional styling that can be applied to the tooltip.*/
  tooltipStyle: js.UndefOr[CssProperties]                      = js.undefined){

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiTableHeaderColumn](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.TableHeaderColumn)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
