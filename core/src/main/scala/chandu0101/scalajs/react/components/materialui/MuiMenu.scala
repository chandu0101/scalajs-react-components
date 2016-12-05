package chandu0101.scalajs.react.components
package materialui
import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
/**
 * This file is generated - submit issues instead of PR against it
 */
case class MuiMenu[T](
  key:                      js.UndefOr[String]                                                             = js.undefined,
  ref:                      js.UndefOr[String]                                                             = js.undefined,
  /* If true, the width of the menu will be set automatically
  according to the widths of its children,
  using proper keyline increments (64px for desktop,
  56px otherwise).*/
  autoWidth:                js.UndefOr[Boolean]                                                            = js.undefined,
  /* If true, the menu item will render with compact desktop styles.*/
  desktop:                  js.UndefOr[Boolean]                                                            = js.undefined,
  /* If true, the menu will not be auto-focused.*/
  disableAutoFocus:         js.UndefOr[Boolean]                                                            = js.undefined,
  /* If true, the menu will be keyboard-focused initially.*/
  initiallyKeyboardFocused: js.UndefOr[Boolean]                                                            = js.undefined,
  /* Override the inline-styles of the underlying `List` element.*/
  listStyle:                js.UndefOr[CssProperties]                                                      = js.undefined,
  /* The maximum height of the menu in pixels. If specified,
  the menu will be scrollable if it is taller than the provided
  height.*/
  maxHeight:                js.UndefOr[Int]                                                                = js.undefined,
  /* If true, `value` must be an array and the menu will support
  multiple selections.*/
  multiple:                 js.UndefOr[Boolean]                                                            = js.undefined,
  /* Callback function fired when a menu item with `value` not
  equal to the current `value` of the menu is touch-tapped.
  array with either the menu item's `value` added (if
  it wasn't already selected) or omitted (if it was already selected).
  Otherwise, the `value` of the menu item.*/
  onChange:                 js.UndefOr[(ReactEventH, T | js.Array[T]) => Callback]                         = js.undefined,
  /* Callback function fired when the menu is focused and the *Esc* key
  is pressed.*/
  onEscKeyDown:             js.UndefOr[ReactKeyboardEventH => Callback]                                    = js.undefined,
  /* Callback function fired when a menu item is touch-tapped.*/
  onItemTouchTap:           js.UndefOr[(ReactUIEventH, JsComponentM[HasValue[T], _, TopNode]) => Callback] = js.undefined,
  onKeyDown:                js.UndefOr[ReactKeyboardEventH => Callback]                                    = js.undefined,
  /* Override the inline-styles of selected menu items.*/
  selectedMenuItemStyle:    js.UndefOr[CssProperties]                                                      = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:                    js.UndefOr[CssProperties]                                                      = js.undefined,
  /* If `multiple` is true, an array of the `value`s of the selected
  menu items. Otherwise, the `value` of the selected menu item.
  If provided, the menu will be a controlled component.
  This component also supports valueLink.*/
  value:                    js.UndefOr[T | js.Array[T]]                                                    = js.undefined,
  /* ValueLink for the menu's `value`.*/
  valueLink:                js.UndefOr[js.Any]                                                             = js.undefined,
  /* The width of the menu. If not specified, the menu's width
  will be set according to the widths of its children, using
  proper keyline increments (64px for desktop, 56px otherwise).*/
  width:                    js.UndefOr[String | Double]                                                    = js.undefined){
  /**
   * @param children The content of the menu. This is usually used to pass `MenuItem`
elements.
   */
  def apply(children: ReactNode*) = {
    implicit def evT(t: T): js.Any = t.asInstanceOf[js.Any]
    val props = JSMacro[MuiMenu[T]](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Menu)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
