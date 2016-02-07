package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiMenu(
  key:                      js.UndefOr[String]                                                                  = js.undefined,
  ref:                      js.UndefOr[String]                                                                  = js.undefined,
  /* If true, the menu will apply transitions when added it
gets added to the DOM. In order for transitions to
work, wrap the menu inside a ReactTransitionGroup.*/
  animated:                 js.UndefOr[Boolean]                                                                 = js.undefined,
  /* If true, the width will automatically be
set according to the items inside the menu
using the proper keyline increment.*/
  autoWidth:                js.UndefOr[Boolean]                                                                 = js.undefined,
  /* Indicates if the menu should render with compact desktop styles.*/
  desktop:                  js.UndefOr[Boolean]                                                                 = js.undefined,
  /* True if this item should be focused by the keyboard initially.*/
  initiallyKeyboardFocused: js.UndefOr[Boolean]                                                                 = js.undefined,
  /* The style object to use to override underlying list style.*/
  listStyle:                js.UndefOr[CssProperties]                                                           = js.undefined,
  /* The maxHeight of the menu in pixels. If
specified, the menu will scroll if larger than the maxHeight.*/
  maxHeight:                js.UndefOr[Int]                                                                     = js.undefined,
  /* If true, the value can an array and allow the menu to be a multi-select.*/
  multiple:                 js.UndefOr[Boolean]                                                                 = js.undefined,
  /* Fired when a menu item is touchTapped and the menu item
value is not equal to the current menu value.*/
  onChange:                 js.UndefOr[(ReactEventH, String | js.Array[String]) => Callback]                    = js.undefined,
  /* Fired when an Esc key is keyed down.*/
  onEscKeyDown:             js.UndefOr[ReactKeyboardEventH => Callback]                                         = js.undefined,
  /* Fired when a menu item is touchTapped.*/
  onItemTouchTap:           js.UndefOr[(ReactUIEventH, JsComponentM[MuiMenuItemProps, _, TopNode]) => Callback] = js.undefined,
  /* Fired when a key is pressed.*/
  onKeyDown:                js.UndefOr[ReactKeyboardEventH => Callback]                                         = js.undefined,
  /* This is the placement of the menu relative to the IconButton.*/
  openDirection:            js.UndefOr[Corners]                                                                 = js.undefined,
  /* Style for the selected Menu Item.*/
  selectedMenuItemStyle:    js.UndefOr[CssProperties]                                                           = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:                    js.UndefOr[CssProperties]                                                           = js.undefined,
  /* The value of the selected menu item. If passed in,
this will make the menu a controlled component.
This component also supports valueLink.*/
  value:                    js.UndefOr[String | js.Array[String]]                                               = js.undefined,
  /* ValueLink for this component when controlled.*/
  valueLink:                js.UndefOr[js.Any]                                                                  = js.undefined,
  /* Sets the width of the menu. If not specified, the menu
width will be dictated by its children. The rendered
width will always be a keyline increment
(64px for desktop, 56px otherwise).*/
  width:                    js.UndefOr[String | Double]                                                         = js.undefined,
  /* Sets the width of the menu. If not specified,
the menu width will be dictated by its children.
The rendered width will always be a keyline increment
(64px for desktop, 56px otherwise).*/
  zDepth:                   js.UndefOr[ZDepth]                                                                  = js.undefined){
  /**
   * @param children Children for the Menu. Usually MenuItems.
   */
  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiMenu](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Menu)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}

@js.native
trait MuiMenuItemProps extends js.Object {
	def value: js.UndefOr[String] = js.native
}
      
