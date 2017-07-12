package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.React
import japgolly.scalajs.react.vdom.VdomNode
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiTableRowColumn(
  key:          js.UndefOr[String]                                  = js.undefined,
  ref:          js.UndefOr[String]                                  = js.undefined,
  /* The css class name of the root element. */
  className:    js.UndefOr[String]                                  = js.undefined,
  /* Number to identify the header row. This property
     is automatically populated when used with TableHeader. */
  columnNumber: js.UndefOr[Int]                                     = js.undefined,
  /* If true, this column responds to hover events. */
  hoverable:    js.UndefOr[Boolean]                                 = js.undefined,
  onClick:      js.UndefOr[(ReactMouseEvent, ColumnId) => Callback] = js.undefined,
  onHover:      js.UndefOr[(ReactMouseEvent, ColumnId) => Callback] = js.undefined,
  /* Callback function for hover exit event. */
  onHoverExit:  js.UndefOr[(ReactMouseEvent, ColumnId) => Callback] = js.undefined,
  /* Override the inline-styles of the root element. */
  style:        js.UndefOr[CssProperties]                           = js.undefined){


  def apply(children: VdomNode*) = {
    
    val props = JSMacro[MuiTableRowColumn](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Mui.TableRowColumn)
    component(props)(children: _*)
  }
}
