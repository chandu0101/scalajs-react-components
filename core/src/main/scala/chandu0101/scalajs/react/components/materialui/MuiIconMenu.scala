package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.{VdomElement, VdomNode}

import scala.scalajs.js
import scala.scalajs.js.`|`

/**
  * This file is generated - submit issues instead of PR against it
  */
case class MuiIconMenu[T](
    key: js.UndefOr[String] = js.undefined,
    ref: js.UndefOr[MuiIconMenuM => Unit] = js.undefined,
    /* This is the point on the icon where the menu
     `targetOrigin` will attach.
     Options:
     vertical: [top, center, bottom]
     horizontal: [left, middle, right]. */
    anchorOrigin: js.UndefOr[Origin] = js.undefined,
    /* If true, the popover will apply transitions when
     it gets added to the DOM. */
    animated: js.UndefOr[Boolean] = js.undefined,
    /* Override the default animation component used. */
    animation: js.UndefOr[js.Function] = js.undefined,
    /* The CSS class name of the root element. */
    className: js.UndefOr[String] = js.undefined,
    /* This is the `IconButton` to render. This button will open the menu. */
    iconButtonElement: VdomElement,
    /* Override the inline-styles of the underlying icon element. */
    iconStyle: js.UndefOr[CssProperties] = js.undefined,
    /* Override the inline-styles of the underlying `List` element. */
    listStyle: js.UndefOr[CssProperties] = js.undefined,
    /* Override the inline-styles of the menu element. */
    menuStyle: js.UndefOr[CssProperties] = js.undefined,
    /* If true, the value can an be array and allow the menu to be a multi-select. */
    multiple: js.UndefOr[Boolean] = js.undefined,
    /* Callback function fired when a menu item is selected with a touch-tap.
     @param {object} event TouchTap event targeting the selected menu item element.
     @param {object} child The selected element. */
    onItemTouchTap: js.UndefOr[(ReactTouchEvent, VdomElement) => Callback] = js.undefined,
    /* Callback function fired when the `IconButton` element is focused or blurred by the keyboard.
     @param {object} event `focus` or `blur` event targeting the `IconButton` element.
     @param {boolean} keyboardFocused If true, the `IconButton` element is focused. */
    onKeyboardFocus: js.UndefOr[(ReactFocusEvent, Boolean) => Callback] = js.undefined,
    onMouseDown: js.UndefOr[ReactMouseEvent => Callback] = js.undefined,
    onMouseEnter: js.UndefOr[ReactMouseEvent => Callback] = js.undefined,
    onMouseLeave: js.UndefOr[ReactMouseEvent => Callback] = js.undefined,
    onMouseUp: js.UndefOr[ReactMouseEvent => Callback] = js.undefined,
    /* Callback function fired when the `open` state of the menu is requested to be changed.
     @param {boolean} open If true, the menu was requested to be opened.
     @param {string} reason The reason for the open or close request. Possible values are
     'keyboard' and 'iconTap' for open requests; 'enter', 'escape', 'itemTap', and 'clickAway'
     for close requests. */
    onRequestChange: js.UndefOr[(Boolean, String) => Callback] = js.undefined,
    /* Callback function fired when the `IconButton` element is touch-tapped.
     @param {object} event TouchTap event targeting the `IconButton` element. */
    onTouchTap: js.UndefOr[TouchTapEvent => Callback] = js.undefined,
    /* If true, the `IconMenu` is opened. */
    open: js.UndefOr[Boolean] = js.undefined,
    /* Override the inline-styles of the root element. */
    style: js.UndefOr[CssProperties] = js.undefined,
    /* This is the point on the menu which will stick to the menu
     origin.
     Options:
     vertical: [top, center, bottom]
     horizontal: [left, middle, right]. */
    targetOrigin: js.UndefOr[Origin] = js.undefined,
    /* Sets the delay in milliseconds before closing the
     menu when an item is clicked.
     If set to 0 then the auto close functionality
     will be disabled. */
    touchTapCloseDelay: js.UndefOr[Int] = js.undefined,
    /* If true, the popover will render on top of an invisible
     layer, which will prevent clicks to the underlying elements. */
    useLayerForClickAway: js.UndefOr[Boolean] = js.undefined,
    /* If true, the width of the menu will be set automatically
     according to the widths of its children,
     using proper keyline increments (64px for desktop,
     56px otherwise).
     (Passed on to Menu) */
    autoWidth: js.UndefOr[Boolean] = js.undefined,
    /* If true, the menu item will render with compact desktop styles.
     (Passed on to Menu) */
    desktop: js.UndefOr[Boolean] = js.undefined,
    /* If true, the menu will not be auto-focused.
     (Passed on to Menu) */
    disableAutoFocus: js.UndefOr[Boolean] = js.undefined,
    /* If true, the menu will be keyboard-focused initially.
     (Passed on to Menu) */
    initiallyKeyboardFocused: js.UndefOr[Boolean] = js.undefined,
    /* The maximum height of the menu in pixels. If specified,
     the menu will be scrollable if it is taller than the provided
     height.
     (Passed on to Menu) */
    maxHeight: js.UndefOr[Int] = js.undefined,
    /* Override the inline-styles of menu items.
     (Passed on to Menu) */
    menuItemStyle: js.UndefOr[CssProperties] = js.undefined,
    /* Callback function fired when a menu item with `value` not
     equal to the current `value` of the menu is touch-tapped.
     (Passed on to Menu)
     @param {object} event TouchTap event targeting the menu item.
     @param {any}  value If `multiple` is true, the menu's `value`
     array with either the menu item's `value` added (if
     it wasn't already selected) or omitted (if it was already selected).
     Otherwise, the `value` of the menu item. */
    onChange: js.UndefOr[(TouchTapEvent, T | js.Array[T]) => Callback] = js.undefined,
    /* Callback function fired when the menu is focused and the *Esc* key
     is pressed.
     (Passed on to Menu)
     @param {object} event `keydown` event targeting the menu. */
    onEscKeyDown: js.UndefOr[ReactKeyboardEvent => Callback] = js.undefined,
    /* (Passed on to Menu) */
    onKeyDown: js.UndefOr[ReactKeyboardEvent => Callback] = js.undefined,
    /* Callback function fired when the focus on a `MenuItem` is changed.
     There will be some "duplicate" changes reported if two different
     focusing event happen, for example if a `MenuItem` is focused via
     the keyboard and then it is clicked on.
     (Passed on to Menu)
     @param {object} event The event that triggered the focus change.
     The event can be null since the focus can be changed for non-event
     reasons such as prop changes.
     @param {number} newFocusIndex The index of the newly focused
     `MenuItem` or `-1` if focus was lost. */
    onMenuItemFocusChange: js.UndefOr[(js.UndefOr[ReactEvent], Int) => Callback] = js.undefined,
    /* Override the inline-styles of selected menu items.
     (Passed on to Menu) */
    selectedMenuItemStyle: js.UndefOr[CssProperties] = js.undefined,
    /* If `multiple` is true, an array of the `value`s of the selected
     menu items. Otherwise, the `value` of the selected menu item.
     If provided, the menu will be a controlled component.
     This component also supports valueLink.
     (Passed on to Menu) */
    value: js.UndefOr[T | js.Array[T]] = js.undefined,
    /* ValueLink for the menu's `value`.
     (Passed on to Menu) */
    valueLink: js.UndefOr[js.Any] = js.undefined,
    /* The width of the menu. If not specified, the menu's width
     will be set according to the widths of its children, using
     proper keyline increments (64px for desktop, 56px otherwise).
     (Passed on to Menu) */
    width: js.UndefOr[String | Double] = js.undefined) {

  /**
    * @param children Should be used to pass `MenuItem` components.
    */
  def apply(children: VdomNode*) = {
    implicit def evT(t: T): js.Any = t.asInstanceOf[js.Any]
    val props                      = JSMacro[MuiIconMenu[T]](this)
    val component                  = JsComponent[js.Object, Children.Varargs, Null](Mui.IconMenu)
    component(props)(children: _*)
  }
}
@js.native
class MuiIconMenuM extends js.Object {
  def close(reason: js.Any, isKeyboard: js.Any): js.Dynamic = js.native

  def isOpen(): js.Dynamic = js.native

  def open(reason: js.Any, event: js.Any): js.Dynamic = js.native
}
