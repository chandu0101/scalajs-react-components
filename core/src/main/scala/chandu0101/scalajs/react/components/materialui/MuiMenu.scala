
package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
  
case class MuiMenu(
	key:                      js.UndefOr[String]                                                = js.undefined,
	ref:                      js.UndefOr[String]                                                = js.undefined,
	/* default: false: If true, the menu will apply transitions when added it gets added to the DOM. In order for transitions to work, wrap the menu inside a ReactTransitionGroup.*/
	animated:                 js.UndefOr[Boolean]                                               = js.undefined,
	/* default: true: If true, the width will automatically be set according to the items inside the menu using the proper keyline increment.*/
	autoWidth:                js.UndefOr[Boolean]                                               = js.undefined,
	/* default: false: Indicates if the menu should render with compact desktop styles.*/
	desktop:                  js.UndefOr[Boolean]                                               = js.undefined,
	/*  The style object to use to override underlying list style.*/
	listStyle:                js.UndefOr[CssProperties]                                         = js.undefined,
	/*  The maxHeight of the menu in pixels. If specified, the menu will scroll if larger than the maxHeight.*/
	maxHeight:                js.UndefOr[Int]                                                   = js.undefined,
	/* default: false: If true, the value can an array and allow the menu to be a multi-select.*/
	multiple:                 js.UndefOr[Boolean]                                               = js.undefined,
	/* default: bottom-left: This is the placement of the menu relative to the IconButton.*/
	openDirection:            js.UndefOr[MuiMenuOpenDirection]                                  = js.undefined,
	/*  Override the inline-styles of the menu's root element.*/
	style:                    js.UndefOr[CssProperties]                                         = js.undefined,
	/*  The value of the selected menu item. If passed in, this will make the menu a controlled component. This component also supports valueLink.*/
	value:                    js.UndefOr[String | js.Array[String]]                             = js.undefined,
	/*  Sets the width of the menu. If not specified, the menu width will be dictated by its children. The rendered width will always be a keyline increment (64px for desktop, 56px otherwise).*/
	width:                    js.UndefOr[String | Int]                                          = js.undefined,
	/*  Sets the width of the menu. If not specified, the menu width will be dictated by its children. The rendered width will always be a keyline increment (64px for desktop, 56px otherwise).*/
	zDepth:                   js.UndefOr[MuiZDepth]                                             = js.undefined,
	/* function(event): Fired when an Esc key is keyed down.*/
	onEscKeyDown:             js.UndefOr[ReactKeyboardEvent => Callback]                        = js.undefined,
	/* function(event, item): Fired when a menu item is touchTapped.*/
	onItemTouchTap:           js.UndefOr[(ReactTouchEvent, ReactElement) => Callback]           = js.undefined,
	/* function(event, value): Fired when a menu item is touchTapped and the menu item value is not equal to the current menu value.*/
	onChange:                 js.UndefOr[(ReactEvent, String | js.Array[String]) => Callback]   = js.undefined,
	onKeyDown:                js.UndefOr[ReactEvent => Callback]                                = js.undefined,
	selectedMenuItemStyle:    js.UndefOr[CssProperties]                                         = js.undefined,
	initiallyKeyboardFocused: js.UndefOr[Boolean]                                               = js.undefined)
{

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiMenu](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Menu)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}


class MuiMenuOpenDirection(val value: String) extends AnyVal
object MuiMenuOpenDirection{
	val BOTTOM_LEFT = new MuiMenuOpenDirection("bottom-left")
	val BOTTOM_RIGHT = new MuiMenuOpenDirection("bottom-right")
	val TOP_LEFT = new MuiMenuOpenDirection("top-left")
	val TOP_RIGHT = new MuiMenuOpenDirection("top-right")
	val values = List(BOTTOM_LEFT, BOTTOM_RIGHT, TOP_LEFT, TOP_RIGHT)
}
