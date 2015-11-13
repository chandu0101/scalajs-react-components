
package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
  
case class MuiMenuItem(
	key:           js.UndefOr[String]          = js.undefined,
	ref:           js.UndefOr[String]          = js.undefined,
	/* default: false: If true, a left check mark will be rendered*/
	checked:       js.UndefOr[Boolean]         = js.undefined,
	/* default: false: Indicates if the menu should render with compact desktop styles.*/
	desktop:       js.UndefOr[Boolean]         = js.undefined,
	/* default: false: Disables a menu item.*/
	disabled:      js.UndefOr[Boolean]         = js.undefined,
	/*  Style overrides for the inner div.*/
	innerDivStyle: js.UndefOr[CssProperties]   = js.undefined,
	/* default: false: If true, the children will be indented. Only needed when there is no leftIcon.*/
	insetChildren: js.UndefOr[Boolean]         = js.undefined,
	/*  This is the SvgIcon or FontIcon to be displayed on the left side.*/
	leftIcon:      js.UndefOr[ReactElement]    = js.undefined,
	/*  This is the block element that contains the primary text. If a string is passed in, a div tag will be rendered.*/
	primaryText:   js.UndefOr[ReactNode]       = js.undefined,
	/*  This is the SvgIcon or FontIcon to be displayed on the right side.*/
	rightIcon:     js.UndefOr[ReactElement]    = js.undefined,
	/*  This is the block element that contains the secondary text. If a string is passed in, a div tag will be rendered.*/
	secondaryText: js.UndefOr[ReactNode]       = js.undefined,
	/*  Override the inline-styles of the menu item's root element.*/
	style:         js.UndefOr[CssProperties]   = js.undefined,
	/*  The value of the menu item.*/
	value:         js.UndefOr[String]          = js.undefined)
{

  def apply() = {
    val props = JSMacro[MuiMenuItem](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.MenuItem)
    f(props).asInstanceOf[ReactComponentU_]
  }
}
    
