package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.React
import japgolly.scalajs.react.vdom.{TopNode, VdomNode}
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiMenu[T](
  key:                      js.UndefOr[String]                                                             = js.undefined,
  ref:                      js.UndefOr[MuiMenuM => Unit]                                                   = js.undefined,
  /* If true, the width of the menu will be set automatically
     according to the widths of its children,
     using proper keyline increments (64px for desktop,
     56px otherwise). */
  autoWidth:                js.UndefOr[Boolean]                                                            = js.undefined,
  /* If true, the menu item will render with compact desktop styles. */
  desktop:                  js.UndefOr[Boolean]                                                            = js.undefined,
  /* If true, the menu will not be auto-focused. */
  disableAutoFocus:         js.UndefOr[Boolean]                                                            = js.undefined,
  /* If true, the menu will be keyboard-focused initially. */
  initiallyKeyboardFocused: js.UndefOr[Boolean]                                                            = js.undefined,
  /* Override the inline-styles of the underlying `List` element. */
  listStyle:                js.UndefOr[CssProperties]                                                      = js.undefined,
  /* The maximum height of the menu in pixels. If specified,
     the menu will be scrollable if it is taller than the provided
     height. */
  maxHeight:                js.UndefOr[Int]                                                                = js.undefined,
  /* Override the inline-styles of menu items. */
  menuItemStyle:            js.UndefOr[CssProperties]                                                      = js.undefined,
  /* If true, `value` must be an array and the menu will support
     multiple selections. */
  multiple:                 js.UndefOr[Boolean]                                                            = js.undefined,
  /* Callback function fired when a menu item with `value` not
     equal to the current `value` of the menu is touch-tapped.
     @param {object} event TouchTap event targeting the menu item.
     @param {any}  value If `multiple` is true, the menu's `value`
     array with either the menu item's `value` added (if
     it wasn't already selected) or omitted (if it was already selected).
     Otherwise, the `value` of the menu item. */
  onChange:                 js.UndefOr[(TouchTapEvent, T | js.Array[T]) => Callback]                       = js.undefined,
  /* Callback function fired when the menu is focused and the *Esc* key
     is pressed.
     @param {object} event `keydown` event targeting the menu. */
  onEscKeyDown:             js.UndefOr[ReactKeyboardEvent => Callback]                                     = js.undefined,
  /* Callback function fired when a menu item is touch-tapped.
     @param {object} event TouchTap event targeting the menu item.
     @param {object} menuItem The menu item.
     @param {number} index The index of the menu item. */
  onItemTouchTap:           js.UndefOr[(TouchTapEvent, JsComponent.RawMounted) => Callback]   = js.undefined,
  onKeyDown:                js.UndefOr[ReactKeyboardEvent => Callback]                                     = js.undefined,
  /* Callback function fired when the focus on a `MenuItem` is changed.
     There will be some "duplicate" changes reported if two different
     focusing event happen, for example if a `MenuItem` is focused via
     the keyboard and then it is clicked on.
     @param {object} event The event that triggered the focus change.
     The event can be null since the focus can be changed for non-event
     reasons such as prop changes.
     @param {number} newFocusIndex The index of the newly focused
     `MenuItem` or `-1` if focus was lost. */
  onMenuItemFocusChange:    js.UndefOr[(js.UndefOr[ReactEvent], Int) => Callback]                          = js.undefined,
  /* Override the inline-styles of selected menu items. */
  selectedMenuItemStyle:    js.UndefOr[CssProperties]                                                      = js.undefined,
  /* Override the inline-styles of the root element. */
  style:                    js.UndefOr[CssProperties]                                                      = js.undefined,
  /* If `multiple` is true, an array of the `value`s of the selected
     menu items. Otherwise, the `value` of the selected menu item.
     If provided, the menu will be a controlled component.
     This component also supports valueLink. */
  value:                    js.UndefOr[T | js.Array[T]]                                                    = js.undefined,
  /* ValueLink for the menu's `value`. */
  valueLink:                js.UndefOr[js.Any]                                                             = js.undefined,
  /* The width of the menu. If not specified, the menu's width
     will be set according to the widths of its children, using
     proper keyline increments (64px for desktop, 56px otherwise). */
  width:                    js.UndefOr[String | Double]                                                    = js.undefined){

  /**
    * @param children The content of the menu. This is usually used to pass `MenuItem`
    elements.
   */
  def apply(children: VdomNode*) = {
    implicit def evT(t: T): js.Any = t.asInstanceOf[js.Any]
    val props = JSMacro[MuiMenu[T]](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Mui.Menu)
    component(props)(children: _*)
  }
}


@js.native
class MuiMenuM extends js.Object {
  def cancelScrollEvent(event: js.Any): js.Dynamic = js.native

  def cloneMenuItem(child: js.Any, childIndex: js.Any, styles: js.Any, index: js.Any): js.Dynamic = js.native

  def decrementKeyboardFocusIndex(event: js.Any): js.Dynamic = js.native

  def getFilteredChildren(children: js.Any): js.Dynamic = js.native

  def getMenuItemCount(filteredChildren: js.Any): js.Dynamic = js.native

  def getSelectedIndex(props: js.Any, filteredChildren: js.Any): js.Dynamic = js.native

  def getValueLink(props: js.Any): js.Dynamic = js.native

  def incrementKeyboardFocusIndex(event: js.Any, filteredChildren: js.Any): js.Dynamic = js.native

  def isChildSelected(child: js.Any, props: js.Any): js.Dynamic = js.native

  def setFocusIndex(event: js.Any, newIndex: js.Any, isKeyboardFocused: js.Any): js.Dynamic = js.native

  def setFocusIndexStartsWith(event: js.Any, keys: js.Any): js.Dynamic = js.native

  def setKeyboardFocused(keyboardFocused: js.Any): js.Dynamic = js.native

  def setScollPosition(): js.Dynamic = js.native

  def setWidth(): js.Dynamic = js.native
}
