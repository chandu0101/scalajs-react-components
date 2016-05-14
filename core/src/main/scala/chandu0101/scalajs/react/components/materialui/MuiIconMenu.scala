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
  key:                      js.UndefOr[String]                                               = js.undefined,
  ref:                      js.UndefOr[IconMenuM => Unit]                                    = js.undefined,
  /* This is the point on the icon where the menu
  `targetOrigin` will attach.
  Options:
  vertical: [top, middle, bottom]
  horizontal: [left, center, right].*/
  anchorOrigin:             js.UndefOr[Origin]                                               = js.undefined,
  /* The CSS class name of the root element.*/
  className:                js.UndefOr[String]                                               = js.undefined,
  /* This is the `IconButton` to render. This button will open the menu.*/
  iconButtonElement:        ReactElement,
  /* Override the inline-styles of the underlying icon element.*/
  iconStyle:                js.UndefOr[CssProperties]                                        = js.undefined,
  /* Override the inline-styles of the menu element.*/
  menuStyle:                js.UndefOr[CssProperties]                                        = js.undefined,
  /* If true, the value can an be array and allow the menu to be a multi-select.*/
  multiple:                 js.UndefOr[Boolean]                                              = js.undefined,
  /* Callback function fired when a menu item is selected with a touch-tap.*/
  onItemTouchTap:           js.UndefOr[(ReactTouchEventH, ReactElement) => Callback]         = js.undefined,
  /* Callback function fired when the `IconButton` element is focused or blurred by the keyboard.*/
  onKeyboardFocus:          js.UndefOr[ReactKeyboardEventH => Callback]                      = js.undefined,
  /* Callback function fired when a mouse button is pressed down on the `IconButton` element.*/
  onMouseDown:              js.UndefOr[ReactMouseEventH => Callback]                         = js.undefined,
  /* Callback function fired when the mouse enters the `IconButton` element.*/
  onMouseEnter:             js.UndefOr[ReactMouseEventH => Callback]                         = js.undefined,
  /* Callback function fired when the mouse leaves the `IconButton` element.*/
  onMouseLeave:             js.UndefOr[ReactMouseEventH => Callback]                         = js.undefined,
  /* Callback function fired when a mouse button is released on the `IconButton` element.*/
  onMouseUp:                js.UndefOr[ReactMouseEventH => Callback]                         = js.undefined,
  /* Callback function fired when the `open` state of the menu is requested to be changed.
  'keyboard' and 'iconTap' for open requests; 'enter', 'escape', 'itemTap', and 'clickAway'
  for close requests.*/
  onRequestChange:          js.UndefOr[(Boolean, String) => Callback]                        = js.undefined,
  /* Callback function fired when the `IconButton` element is touch-tapped.*/
  onTouchTap:               js.UndefOr[ReactTouchEventH => Callback]                         = js.undefined,
  /* If true, the `IconMenu` is opened.*/
  open:                     js.UndefOr[Boolean]                                              = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:                    js.UndefOr[CssProperties]                                        = js.undefined,
  /* This is the point on the menu which will stick to the menu
  origin.
  Options:
  vertical: [top, middle, bottom]
  horizontal: [left, center, right].*/
  targetOrigin:             js.UndefOr[Origin]                                               = js.undefined,
  /* Sets the delay in milliseconds before closing the
  menu when an item is clicked.
  If set to 0 then the auto close functionality
  will be disabled.*/
  touchTapCloseDelay:       js.UndefOr[Int]                                                  = js.undefined,
  /* If true, the popover will render on top of an invisible
  layer, which will prevent clicks to the underlying elements.*/
  useLayerForClickAway:     js.UndefOr[Boolean]                                              = js.undefined,
  /* If true, the menu will apply transitions when it
  is added to the DOM. In order for transitions to
  work, wrap the menu inside a `ReactTransitionGroup`.
  (Passed on to Menu)*/
  @deprecated("Instead, use a [Popover](/#/components/popover).")
  animated:                 js.UndefOr[Boolean]                                              = js.undefined,
  /* If true, the width of the menu will be set automatically
  according to the widths of its children,
  using proper keyline increments (64px for desktop,
  56px otherwise).
  (Passed on to Menu)*/
  autoWidth:                js.UndefOr[Boolean]                                              = js.undefined,
  /* If true, the menu item will render with compact desktop styles.
  (Passed on to Menu)*/
  desktop:                  js.UndefOr[Boolean]                                              = js.undefined,
  /* If true, the menu will not be auto-focused.
  (Passed on to Menu)*/
  disableAutoFocus:         js.UndefOr[Boolean]                                              = js.undefined,
  /* If true, the menu will be keyboard-focused initially.
  (Passed on to Menu)*/
  initiallyKeyboardFocused: js.UndefOr[Boolean]                                              = js.undefined,
  /* Override the inline-styles of the underlying `List` element.
  (Passed on to Menu)*/
  listStyle:                js.UndefOr[CssProperties]                                        = js.undefined,
  /* The maximum height of the menu in pixels. If specified,
  the menu will be scrollable if it is taller than the provided
  height.
  (Passed on to Menu)*/
  maxHeight:                js.UndefOr[Int]                                                  = js.undefined,
  /* Callback function fired when a menu item with `value` not
  equal to the current `value` of the menu is touch-tapped.
  array with either the menu item's `value` added (if
  it wasn't already selected) or omitted (if it was already selected).
  Otherwise, the `value` of the menu item.
  (Passed on to Menu)*/
  onChange:                 js.UndefOr[(ReactEventH, String | js.Array[String]) => Callback] = js.undefined,
  /* Callback function fired when the menu is focused and the *Esc* key
  is pressed.
  (Passed on to Menu)*/
  onEscKeyDown:             js.UndefOr[ReactKeyboardEventH => Callback]                      = js.undefined,
  /* Callback function fired when the menu is focused and a key
  is pressed.
  (Passed on to Menu)*/
  onKeyDown:                js.UndefOr[ReactKeyboardEventH => Callback]                      = js.undefined,
  /* This is the placement of the menu relative to the `IconButton`.
  (Passed on to Menu)*/
  @deprecated("Instead, use a [Popover](/#/components/popover).")
  openDirection:            js.UndefOr[Corners]                                              = js.undefined,
  /* Override the inline-styles of selected menu items.
  (Passed on to Menu)*/
  selectedMenuItemStyle:    js.UndefOr[CssProperties]                                        = js.undefined,
  /* If `multiple` is true, an array of the `value`s of the selected
  menu items. Otherwise, the `value` of the selected menu item.
  If provided, the menu will be a controlled component.
  This component also supports valueLink.
  (Passed on to Menu)*/
  value:                    js.UndefOr[String | js.Array[String]]                            = js.undefined,
  /* ValueLink for the menu's `value`.
  (Passed on to Menu)*/
  valueLink:                js.UndefOr[js.Any]                                               = js.undefined,
  /* The width of the menu. If not specified, the menu's width
  will be set according to the widths of its children, using
  proper keyline increments (64px for desktop, 56px otherwise).
  (Passed on to Menu)*/
  width:                    js.UndefOr[String | Double]                                      = js.undefined,
  /* Menu no longer supports `zDepth`. Instead, wrap it in `Paper`
  or another component that provides zDepth.
  (Passed on to Menu)*/
  @deprecated("Internal API")
  zDepth:                   js.UndefOr[ZDepth]                                               = js.undefined){
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


@js.native
class IconMenuM extends js.Object {
  def close(reason: js.Any, isKeyboard: js.Any): js.Any = js.native

  def isOpen(): js.Any = js.native

  def open(reason: js.Any, event: js.Any): js.Any = js.native
}
