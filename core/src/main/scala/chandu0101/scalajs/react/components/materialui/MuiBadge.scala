
package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
  
case class MuiBadge(
	key:          js.UndefOr[String]          = js.undefined,
	ref:          js.UndefOr[String]          = js.undefined,
	/* required: This is the content rendered within the badge.*/
	badgeContent: ReactNode,
	/*  Override the inline-styles of the badge element.*/
	badgeStyle:   js.UndefOr[CssProperties]   = js.undefined,
	/* default: false: If true, the badge will use the primary badge colors.*/
	primary:      js.UndefOr[Boolean]         = js.undefined,
	/* default: false: If true, the badge will use the secondary badge colors.*/
	secondary:    js.UndefOr[Boolean]         = js.undefined,
	/*  Override the inline-styles of the root element.*/
	style:        js.UndefOr[CssProperties]   = js.undefined,
	className:    js.UndefOr[String]          = js.undefined)
{

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiBadge](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Badge)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
