
package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
  
case class MuiTableHeader(
	key:               js.UndefOr[String]                = js.undefined,
	ref:               js.UndefOr[String]                = js.undefined,
	/* default: true: Controls whether or not header rows should be adjusted for a checkbox column. If the select all checkbox is true, this property will not influence the number of columns. This is mainly useful for "super header" rows so that the checkbox column does not create an offset that needs to be accounted for manually.*/
	adjustForCheckbox: js.UndefOr[Boolean]               = js.undefined,
	/* default: true: Controls whether or not the select all checkbox is displayed.*/
	displaySelectAll:  js.UndefOr[Boolean]               = js.undefined,
	/* default: true: If set to true, the select all button will be interactable. If set to false, the button will not be interactable. To hide the checkbox, set displaySelectAll to false.*/
	enableSelectAll:   js.UndefOr[Boolean]               = js.undefined,
	/* default: true: If set to true the select all checkbox will be programmatically checked and will not trigger the select all event.*/
	selectAllSelected: js.UndefOr[Boolean]               = js.undefined,
	/*  Override the inline-styles of the table header's root element.*/
	style:             js.UndefOr[CssProperties]         = js.undefined,
	/*  Called when the select all checkbox has been toggled.*/
	onSelectAll:       js.UndefOr[Boolean => Callback]   = js.undefined)
{

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiTableHeader](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.TableHeader)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
