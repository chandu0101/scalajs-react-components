
package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
  
case class MuiPaper(
	key:               js.UndefOr[String]           = js.undefined,
	ref:               js.UndefOr[String]           = js.undefined,
	/* default: false: Set to true to generate a circlular paper container.*/
	circle:            js.UndefOr[Boolean]          = js.undefined,
	/* default: true: By default, the paper container will have a border radius. Set this to false to generate a container with sharp corners.*/
	rounded:           js.UndefOr[Boolean]          = js.undefined,
	/*  Override the inline-styles of Paper's root element.*/
	style:             js.UndefOr[CssProperties]    = js.undefined,
	/* default: true: Set to false to disable CSS transitions for the paper element.*/
	transitionEnabled: js.UndefOr[Boolean]          = js.undefined,
	/* default: 1: This number represents the zDepth of the paper shadow.*/
	zDepth:            js.UndefOr[MuiPaperZDepth]   = js.undefined)
{

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiPaper](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Paper)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}


class MuiPaperZDepth(val value: String) extends AnyVal
object MuiPaperZDepth{
	val _0 = new MuiPaperZDepth("0")
	val _1 = new MuiPaperZDepth("1")
	val _2 = new MuiPaperZDepth("2")
	val _3 = new MuiPaperZDepth("3")
	val _4 = new MuiPaperZDepth("4")
	val _5 = new MuiPaperZDepth("5")
}
