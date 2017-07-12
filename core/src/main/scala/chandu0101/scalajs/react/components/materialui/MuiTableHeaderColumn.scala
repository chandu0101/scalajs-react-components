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
    
case class MuiTableHeaderColumn(
  key:          js.UndefOr[String]                                  = js.undefined,
  ref:          js.UndefOr[String]                                  = js.undefined,
  /* The css class name of the root element. */
  className:    js.UndefOr[String]                                  = js.undefined,
  /* Number to identify the header row. This property
     is automatically populated when used with TableHeader. */
  columnNumber: js.UndefOr[Int]                                     = js.undefined,
  /* Not used here but we need to remove it from the root element. */
  hoverable:    js.UndefOr[Boolean]                                 = js.undefined,
  onClick:      js.UndefOr[(ReactMouseEvent, ColumnId) => Callback] = js.undefined,
  /* Not used here but we need to remove it from the root element. */
  onHover:      js.UndefOr[Callback]                                = js.undefined,
  /* Not used here but we need to remove it from the root element. */
  onHoverExit:  js.UndefOr[Callback]                                = js.undefined,
  /* Override the inline-styles of the root element. */
  style:        js.UndefOr[CssProperties]                           = js.undefined,
  /* The string to supply to the tooltip. If not
     string is supplied no tooltip will be shown. */
  tooltip:      js.UndefOr[String]                                  = js.undefined,
  /* Additional styling that can be applied to the tooltip. */
  tooltipStyle: js.UndefOr[CssProperties]                           = js.undefined){


  def apply(children: VdomNode*) = {
    
    val props = JSMacro[MuiTableHeaderColumn](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Mui.TableHeaderColumn)
    component(props)(children: _*)
  }
}
