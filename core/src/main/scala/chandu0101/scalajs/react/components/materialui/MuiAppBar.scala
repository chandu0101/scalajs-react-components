
package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
  
case class MuiAppBar(
	key:                       js.UndefOr[String]                        = js.undefined,
	ref:                       js.UndefOr[String]                        = js.undefined,
	/*  The classname of the icon on the left of the app bar. If you are using a stylesheet for your icons, enter the class name for the icon to be used here.*/
	iconClassNameLeft:         js.UndefOr[String]                        = js.undefined,
	/*  Similiar to the iconClassNameLeft prop except that it applies to the icon displayed on the right of the app bar.*/
	iconClassNameRight:        js.UndefOr[String]                        = js.undefined,
	/*  The custom element to be displayed on the left side of the app bar such as an SvgIcon.*/
	iconElementLeft:           js.UndefOr[ReactElement]                  = js.undefined,
	/*  Similiar to the iconElementLeft prop except that this element is displayed on the right of the app bar.*/
	iconElementRight:          js.UndefOr[ReactElement]                  = js.undefined,
	/*  Override the inline-styles of the element displayed on the right side of the app bar.*/
	iconStyleRight:            js.UndefOr[String]                        = js.undefined,
	/* default: true: Determines whether or not to display the Menu icon next to the title. Setting this prop to false will hide the icon.*/
	showMenuIconButton:        js.UndefOr[Boolean]                       = js.undefined,
	/*  Override the inline-styles of the app bar's root element.*/
	style:                     js.UndefOr[CssProperties]                 = js.undefined,
	/*  The title to display on the app bar. Could be number, string, element or an array containing these types.*/
	title:                     js.UndefOr[ReactNode]                     = js.undefined,
	/* default: 1: The zDepth of the app bar. The shadow of the app bar is also dependent on this property.*/
	zDepth:                    js.UndefOr[MuiZDepth]                     = js.undefined,
	/* AppBar.onLeftIconButtonTouchTap(e): Callback function for when the left icon is selected via a touch tap.*/
	onLeftIconButtonTouchTap:  js.UndefOr[ReactTouchEvent => Callback]   = js.undefined,
	/* AppBar.onRightIconButtonTouchTap(e): Callback function for when the right icon is selected via a touch tap.*/
	onRightIconButtonTouchTap: js.UndefOr[ReactTouchEvent => Callback]   = js.undefined,
	/* AppBar.onTitleTouchTap(e): Callback function for when the title text is selected via a touch tap.*/
	onTitleTouchTap:           js.UndefOr[ReactTouchEvent => Callback]   = js.undefined)
{

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiAppBar](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.AppBar)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
