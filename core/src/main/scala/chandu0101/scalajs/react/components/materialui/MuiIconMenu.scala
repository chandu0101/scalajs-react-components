package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiIconMenu(
  key:                 js.UndefOr[String]                                       = js.undefined,
  ref:                 js.UndefOr[String]                                       = js.undefined,
  /* This is the point on the icon where the menu
targetOrigin will stick to.
Options:
vertical: [top, middle, bottom]
horizontal: [left, center, right].*/
  anchorOrigin:        js.UndefOr[Origin]                                       = js.undefined,
  /* The css class name of the root element.*/
  className:           js.UndefOr[String]                                       = js.undefined,
  /* If true, menu will close after an item is touchTapped.*/
  closeOnItemTouchTap: js.UndefOr[Boolean]                                      = js.undefined,
  /* This is the IconButton to render. This button will open the menu.*/
  iconButtonElement:   ReactElement,
  /* The style object to use to override underlying icon style.*/
  iconStyle:           js.UndefOr[CssProperties]                                = js.undefined,
  /* The style object to use to override underlying menu style.*/
  menuStyle:           js.UndefOr[CssProperties]                                = js.undefined,
  /* Fired when a menu item is touchTapped.*/
  onItemTouchTap:      js.UndefOr[(ReactTouchEventH, ReactElement) => Callback] = js.undefined,
  /* Fired when keyobard focuses on element.*/
  onKeyboardFocus:     js.UndefOr[ReactKeyboardEventH => Callback]              = js.undefined,
  /* Fired when mouse is pressed on element.*/
  onMouseDown:         js.UndefOr[ReactMouseEventH => Callback]                 = js.undefined,
  /* Fired when mouse enters the element.*/
  onMouseEnter:        js.UndefOr[ReactMouseEventH => Callback]                 = js.undefined,
  /* Fired when mouse leaves the element.*/
  onMouseLeave:        js.UndefOr[ReactMouseEventH => Callback]                 = js.undefined,
  /* Fired when mouse is lifted inside the element.*/
  onMouseUp:           js.UndefOr[ReactMouseEventH => Callback]                 = js.undefined,
  /* Callback function that is fired when the open state
of the menu is requested to be changed. The provided
open argument determines whether the menu is requested
to be opened or closed. Also, the reason argument states
why the menu got closed or opened. It can be 'keyboard',
'iconTap' for open action and 'enter', 'escape', 'itemTap',
'clickAway' for close action.*/
  onRequestChange:     js.UndefOr[(Boolean, String) => Callback]                = js.undefined,
  /* Fired when element is touch tapped.*/
  onTouchTap:          js.UndefOr[ReactTouchEventH => Callback]                 = js.undefined,
  /* Controls whether the IconMenu is opened or not.*/
  open:                js.UndefOr[Boolean]                                      = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:               js.UndefOr[CssProperties]                                = js.undefined,
  /* This is the point on the menu which will stick to the menu
origin.
Options:
vertical: [top, middle, bottom]
horizontal: [left, center, right].*/
  targetOrigin:        js.UndefOr[Origin]                                       = js.undefined,
  /* Sets the delay in milliseconds before closing the
menu when an item is clicked.*/
  touchTapCloseDelay:  js.UndefOr[Int]                                          = js.undefined){
  /**
   * @param children Should be used to pass `MenuItem` components.
   */
  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiIconMenu](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.IconMenu)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
