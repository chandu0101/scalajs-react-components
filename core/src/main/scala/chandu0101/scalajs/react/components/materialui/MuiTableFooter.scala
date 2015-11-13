
package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
  
case class MuiTableFooter(
	key:               js.UndefOr[String]          = js.undefined,
	ref:               js.UndefOr[String]          = js.undefined,
	/* default: true: Controls whether or not header rows should be adjusted for a checkbox column. If the select all checkbox is true, this property will not influence the number of columns. This is mainly useful for "super header" rows so that the checkbox column does not create an offset that needs to be accounted for manually.*/
	adjustForCheckbox: js.UndefOr[Boolean]         = js.undefined,
	/*  Override the inline-styles of the table footer's root element.*/
	style:             js.UndefOr[CssProperties]   = js.undefined)
{

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiTableFooter](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.TableFooter)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
