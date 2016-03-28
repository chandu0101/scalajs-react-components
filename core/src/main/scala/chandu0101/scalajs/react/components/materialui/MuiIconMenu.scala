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
  key:                  js.UndefOr[String]                                       = js.undefined,
  ref:                  js.UndefOr[String]                                       = js.undefined,
  /* This is the point on the icon where the menu
  `targetOrigin` will attach.
  Options:
  vertical: [top, middle, bottom]
  horizontal: [left, center, right].*/
  anchorOrigin:         js.UndefOr[Origin]                                       = js.undefined,
  /* The CSS class name of the root element.*/
  className:            js.UndefOr[String]                                       = js.undefined,
  /* This is the `IconButton` to render. This button will open the menu.*/
  iconButtonElement:    ReactElement,
  /* Override the inline-styles of the underlying icon element.*/
  iconStyle:            js.UndefOr[CssProperties]                                = js.undefined,
  /* Override the inline-styles of the menu element.*/
  menuStyle:            js.UndefOr[CssProperties]                                = js.undefined,
  /* If true, the value can an be array and allow the menu to be a multi-select.*/
  multiple:             js.UndefOr[Boolean]                                      = js.undefined,
  /* Callback function fired when a menu item is selected with a touch-tap.*/
  onItemTouchTap:       js.UndefOr[(ReactTouchEventH, ReactElement) => Callback] = js.undefined,
  /* Callback function fired when the `IconButton` element is focused or blurred by the keyboard.*/
  onKeyboardFocus:      js.UndefOr[ReactKeyboardEventH => Callback]              = js.undefined,
  /* Callback function fired when a mouse button is pressed down on the `IconButton` element.*/
  onMouseDown:          js.UndefOr[ReactMouseEventH => Callback]                 = js.undefined,
  /* Callback function fired when the mouse enters the `IconButton` element.*/
  onMouseEnter:         js.UndefOr[ReactMouseEventH => Callback]                 = js.undefined,
  /* Callback function fired when the mouse leaves the `IconButton` element.*/
  onMouseLeave:         js.UndefOr[ReactMouseEventH => Callback]                 = js.undefined,
  /* Callback function fired when a mouse button is released on the `IconButton` element.*/
  onMouseUp:            js.UndefOr[ReactMouseEventH => Callback]                 = js.undefined,
  /* Callback function fired when the `open` state of the menu is requested to be changed.
  'keyboard' and 'iconTap' for open requests; 'enter', 'escape', 'itemTap', and 'clickAway'
  for close requests.*/
  onRequestChange:      js.UndefOr[(Boolean, String) => Callback]                = js.undefined,
  /* Callback function fired when the `IconButton` element is touch-tapped.*/
  onTouchTap:           js.UndefOr[ReactTouchEventH => Callback]                 = js.undefined,
  /* If true, the `IconMenu` is opened.*/
  open:                 js.UndefOr[Boolean]                                      = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:                js.UndefOr[CssProperties]                                = js.undefined,
  /* This is the point on the menu which will stick to the menu
  origin.
  Options:
  vertical: [top, middle, bottom]
  horizontal: [left, center, right].*/
  targetOrigin:         js.UndefOr[Origin]                                       = js.undefined,
  /* Sets the delay in milliseconds before closing the
  menu when an item is clicked.
  If set to 0 then the auto close functionality
  will be disabled.*/
  touchTapCloseDelay:   js.UndefOr[Int]                                          = js.undefined,
  /* If true, the popover will render on top of an invisible
  layer, which will prevent clicks to the underlying elements.*/
  useLayerForClickAway: js.UndefOr[Boolean]                                      = js.undefined){
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
