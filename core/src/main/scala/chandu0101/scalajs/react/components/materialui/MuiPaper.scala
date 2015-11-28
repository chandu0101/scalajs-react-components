
package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
  
case class MuiPaper(
	key:               js.UndefOr[String]          = js.undefined,
	ref:               js.UndefOr[String]          = js.undefined,
	/* default: false: Set to true to generate a circlular paper container.*/
	circle:            js.UndefOr[Boolean]         = js.undefined,
	/* default: true: By default, the paper container will have a border radius. Set this to false to generate a container with sharp corners.*/
	rounded:           js.UndefOr[Boolean]         = js.undefined,
	/*  Override the inline-styles of Paper's root element.*/
	style:             js.UndefOr[CssProperties]   = js.undefined,
	/* default: true: Set to false to disable CSS transitions for the paper element.*/
	transitionEnabled: js.UndefOr[Boolean]         = js.undefined,
	/* default: 1: This number represents the zDepth of the paper shadow.*/
	zDepth:            js.UndefOr[MuiZDepth]       = js.undefined)
{

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiPaper](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Paper)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
