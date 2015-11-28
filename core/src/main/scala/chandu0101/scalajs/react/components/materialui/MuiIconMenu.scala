
package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
  
case class MuiIconMenu(
	key:                 js.UndefOr[String]                                          = js.undefined,
	ref:                 js.UndefOr[String]                                          = js.undefined,
	/*  This is the point on the icon where the menu targetOrigin will stick to.
Options:
vertical: [top, middle, bottom]
horizontal: [left, center, right]
*/
	anchorOrigin:        js.UndefOr[Origin]                                          = js.undefined,
	/* default: true: If true, menu will close after an item is touchTapped.*/
	closeOnItemTouchTap: js.UndefOr[Boolean]                                         = js.undefined,
	/* default: false: Indicates if the menu should render with compact desktop styles.*/
	desktop:             js.UndefOr[Boolean]                                         = js.undefined,
	/* required: This is the IconButton to render. This button will open the menu.*/
	iconButtonElement:   ReactElement,
	/*  The style object to use to override underlying icon style.*/
	iconStyle:           js.UndefOr[CssProperties]                                   = js.undefined,
	/*  The style object to use to override underlying menu style.*/
	menuStyle:           js.UndefOr[CssProperties]                                   = js.undefined,
	/* default: false: If true, the value can an array and allow the menu to be a multi-select.*/
	multiple:            js.UndefOr[Boolean]                                         = js.undefined,
	/*  Override the inline-styles of the icon menu's root element.*/
	style:               js.UndefOr[CssProperties]                                   = js.undefined,
	/*  This is the point on the menu which will stick to the menu origin.Options:vertical: [top, middle, bottom]horizontal: [left, center, right]*/
	targetOrigin:        js.UndefOr[Origin]                                          = js.undefined,
	/* default: 200: Sets the delay in milliseconds before closing the menu when an item is clicked.*/
	touchTapCloseDelay:  js.UndefOr[Int]                                             = js.undefined,
	/*  The value of the selected menu item. If passed in, this will make the menu a controlled component. This component also supports valueLink.*/
	value:               js.UndefOr[String | js.Array[ReactElement]]                 = js.undefined,
	/*  Sets the width of the menu. If not specified, the menu width will be dictated by its children. The rendered width will always be a keyline increment (64px for desktop, 56px otherwise).*/
	width:               js.UndefOr[String | Double]                                 = js.undefined,
	/* function(event, item): Fired when a menu item is touchTapped.*/
	onItemTouchTap:      js.UndefOr[(ReactTouchEventH, ReactElement) => Callback]    = js.undefined,
	/* function(event, value): Fired when a menu item is touchTapped and the menu item value is not equal to the current menu value.*/
	onChange:            js.UndefOr[(ReactEventH, js.UndefOr[String]) => Callback]   = js.undefined,
	onMouseLeave:        js.UndefOr[ReactMouseEventH => Callback]                    = js.undefined,
	onMouseUp:           js.UndefOr[ReactMouseEventH => Callback]                    = js.undefined,
	onKeyboardFocus:     js.UndefOr[ReactKeyboardEventH => Callback]                 = js.undefined,
	onTouchTap:          js.UndefOr[ReactTouchEventH => Callback]                    = js.undefined,
	onMouseEnter:        js.UndefOr[ReactMouseEventH => Callback]                    = js.undefined,
	onMouseDown:         js.UndefOr[ReactMouseEventH => Callback]                    = js.undefined)
{

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiIconMenu](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.IconMenu)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
