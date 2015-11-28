
package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
  
case class MuiPopover(
	key:                    js.UndefOr[String]          = js.undefined,
	ref:                    js.UndefOr[String]          = js.undefined,
	/*  */
	anchorEl:               js.UndefOr[js.Any]          = js.undefined,
	/*  This is the point on the anchor where the popover targetOrigin will stick to.
Options:
vertical: [top, middle, bottom]
horizontal: [left, center, right]
*/
	anchorOrigin:           js.UndefOr[Origin]          = js.undefined,
	/* default: false: If true, the popover will apply transitions when added it gets added to the DOM.*/
	animated:               js.UndefOr[Boolean]         = js.undefined,
	/* default: true: If true, the popover will hide when the anchor scrolls off the screen*/
	autoCloseWhenOffScreen: js.UndefOr[Boolean]         = js.undefined,
	/* default: true: If true, the popover (potentially) ignores targetOrigin and anchorOrigin to make itself fit on screen,which is useful for mobile devices.*/
	canAutoPosition:        js.UndefOr[Boolean]         = js.undefined,
	/* default: false: Controls the visibility of the popover.*/
	open:                   js.UndefOr[Boolean]         = js.undefined,
	/*  This is the point on the popover which will stick to the anchors origin.Options:vertical: [top, middle, bottom]horizontal: [left, center, right]*/
	targetOrigin:           js.UndefOr[Origin]          = js.undefined,
	/* default: 1: This number represents the zDepth of the paper shadow.*/
	zDepth:                 js.UndefOr[MuiZDepth]       = js.undefined,
	/* function(): This is a callback that fires when the popover thinks it should close. (e.g. click-away or scroll off-screen)*/
	onRequestClose:         js.UndefOr[Callback]        = js.undefined,
	children:               js.UndefOr[js.Object]       = js.undefined,
	style:                  js.UndefOr[CssProperties]   = js.undefined,
	className:              js.UndefOr[String]          = js.undefined)
{

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiPopover](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Popover)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
case class Origin(vertical: MuiPopoverVertical, horizontal: MuiPopoverHorizontal){
	val toJS = JSMacro[Origin](this)
}

class MuiPopoverVertical(val value: String) extends AnyVal
object MuiPopoverVertical{
	val top    = new MuiPopoverVertical("top")
	val center = new MuiPopoverVertical("center")
	val bottom = new MuiPopoverVertical("bottom")
 val values = List(top, center, bottom)
}

class MuiPopoverHorizontal(val value: String) extends AnyVal
object MuiPopoverHorizontal{
	val left   = new MuiPopoverHorizontal("left")
	val middle = new MuiPopoverHorizontal("middle")
	val right  = new MuiPopoverHorizontal("right")
 val values = List(left, middle, right)
}

