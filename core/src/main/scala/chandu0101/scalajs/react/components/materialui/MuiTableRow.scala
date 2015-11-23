
package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
  
case class MuiTableRow(
	key:             js.UndefOr[String]                           = js.undefined,
	ref:             js.UndefOr[String]                           = js.undefined,
	/* default: true: If true, row border will be displayed for the row. If false, no border will be drawn.*/
	displayBorder:   js.UndefOr[Boolean]                          = js.undefined,
	/* default: false: Controls whether or not the row reponseds to hover events.*/
	hoverable:       js.UndefOr[Boolean]                          = js.undefined,
	/*  Number to identify the row. This property is automatically populated when used with the TableBody component.*/
	rowNumber:       js.UndefOr[Int]                              = js.undefined,
	/* default: true: If true, table rows can be selected. If multiple row selection is desired, enable multiSelectable. The default value is true.*/
	selectable:      js.UndefOr[Boolean]                          = js.undefined,
	/* default: false: Indicates that a particular row is selected. This property can be used to programmatically select rows.*/
	selected:        js.UndefOr[Boolean]                          = js.undefined,
	/* default: false: Indicates whether or not the row is striped.*/
	striped:         js.UndefOr[Boolean]                          = js.undefined,
	/*  Override the inline-styles of the table row's root element.*/
	style:           js.UndefOr[CssProperties]                    = js.undefined,
	onCellHoverExit: js.UndefOr[(Int, Int) => Callback]           = js.undefined,
	onCellClick:     js.UndefOr[(Int, Int) => Callback]           = js.undefined,
	onRowHover:      js.UndefOr[Int => Callback]                  = js.undefined,
	onRowClick:      js.UndefOr[(ReactEventH, Int) => Callback]   = js.undefined,
	onRowHoverExit:  js.UndefOr[Int => Callback]                  = js.undefined,
	onCellHover:     js.UndefOr[(Int, Int) => Callback]           = js.undefined)
{

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiTableRow](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.TableRow)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
