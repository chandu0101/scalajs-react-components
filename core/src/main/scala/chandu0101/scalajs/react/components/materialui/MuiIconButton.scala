
package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
  
case class MuiIconButton(
	key:             js.UndefOr[String]                   = js.undefined,
	ref:             js.UndefOr[String]                   = js.undefined,
	/*  If you are using a stylesheet for your icons, enter the class name for the icon to be used here.*/
	iconClassName:   js.UndefOr[String]                   = js.undefined,
	/*  Overrides the inline-styles of the icon element.*/
	iconStyle:       js.UndefOr[CssProperties]            = js.undefined,
	/*  Override the inline-styles of the button's root element.*/
	style:           js.UndefOr[CssProperties]            = js.undefined,
	/*  The tooltip text to show.*/
	tooltip:         js.UndefOr[String]                   = js.undefined,
	/* default: bottom-center: Allows the tooltip to be viewed with different alignments: "bottom-center", "top-center", "bottom-right", "top-right", "bottom-left" and "top-left"*/
	tooltipPosition: js.UndefOr[String]                   = js.undefined,
	/*  Allows modification of tooltip styles.*/
	tooltipStyles:   js.UndefOr[CssProperties]            = js.undefined,
	/* default: false: If true, this component will render the touch sized tooltip.*/
	touch:           js.UndefOr[Boolean]                  = js.undefined,
	/* IconButton.onBlur(e): Callback function for when the component loses focus.*/
	onBlur:          js.UndefOr[ReactEvent => Callback]   = js.undefined,
	/* IconButton.onFocus(e): Callback function for when the component gains focus.*/
	onFocus:         js.UndefOr[ReactEvent => Callback]   = js.undefined)
{

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiIconButton](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.IconButton)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
