
package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
  
case class MuiList(
	key:            js.UndefOr[String]          = js.undefined,
	ref:            js.UndefOr[String]          = js.undefined,
	/* default: false: If true, the subheader will be indented by 72px.*/
	insetSubheader: js.UndefOr[Boolean]         = js.undefined,
	/*  Override the inline-styles of the list's root element.*/
	style:          js.UndefOr[CssProperties]   = js.undefined,
	/*  The subheader string that will be displayed at the top of the list.*/
	subheader:      js.UndefOr[ReactNode]       = js.undefined,
	/*  The style object to override subheader styles.*/
	subheaderStyle: js.UndefOr[CssProperties]   = js.undefined,
	zDepth:         js.UndefOr[MuiZDepth]       = js.undefined)
{

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiList](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.List)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
