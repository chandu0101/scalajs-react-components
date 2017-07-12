package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.React
import japgolly.scalajs.react.vdom.{VdomElement, VdomNode}

import scala.scalajs.js

/**
  * This file is generated - submit issues instead of PR against it
  */
case class MuiMenuItem[T](key: js.UndefOr[String] = js.undefined,
                          ref: js.UndefOr[MuiMenuItemM => Unit] = js.undefined,
                          /* Override the default animation component used. */
                          animation: js.UndefOr[js.Function] = js.undefined,
                          /* If true, a left check mark will be rendered. */
                          checked: js.UndefOr[Boolean] = js.undefined,
                          /* If true, the menu item will render with compact desktop
     styles. */
                          desktop: js.UndefOr[Boolean] = js.undefined,
                          /* If true, the menu item will be disabled. */
                          disabled: js.UndefOr[Boolean] = js.undefined,
                          /* The focus state of the menu item. This prop is used to set the focus
     state of the underlying `ListItem`. */
                          focusState: js.UndefOr[NoneFocusedKeyboard_focused] = js.undefined,
                          /* Override the inline-styles of the inner div. */
                          innerDivStyle: js.UndefOr[CssProperties] = js.undefined,
                          /* If true, the children will be indented.
     This is only needed when there is no `leftIcon`. */
                          insetChildren: js.UndefOr[Boolean] = js.undefined,
                          /* The `SvgIcon` or `FontIcon` to be displayed on the left side. */
                          leftIcon: js.UndefOr[VdomElement] = js.undefined,
                          /* `MenuItem` elements to nest within the menu item. */
                          menuItems: js.UndefOr[VdomNode] = js.undefined,
                          /* Callback function fired when the menu item is touch-tapped.
     @param {object} event TouchTap event targeting the menu item. */
                          onTouchTap: js.UndefOr[TouchTapEvent => Callback] = js.undefined,
                          /* Can be used to render primary text within the menu item. */
                          primaryText: js.UndefOr[VdomNode] = js.undefined,
                          /* The `SvgIcon` or `FontIcon` to be displayed on the right side. */
                          rightIcon: js.UndefOr[VdomElement] = js.undefined,
                          /* Can be used to render secondary text within the menu item. */
                          secondaryText: js.UndefOr[VdomNode] = js.undefined,
                          /* Override the inline-styles of the root element. */
                          style: js.UndefOr[CssProperties] = js.undefined,
                          /* The value of the menu item. */
                          value: js.UndefOr[T] = js.undefined,
                          /* If true, generate a nested-list-indicator icon when nested list
     items are detected. Note that an indicator will not be created
     if a `rightIcon` or `rightIconButton` has been provided to
     the element.
     (Passed on to ListItem) */
                          autoGenerateNestedIndicator: js.UndefOr[Boolean] = js.undefined,
                          /* If true, the element will not be able to be focused by the keyboard.
     (Passed on to ListItem) */
                          disableKeyboardFocus: js.UndefOr[Boolean] = js.undefined,
                          /* Override the hover background color.
     (Passed on to ListItem) */
                          hoverColor: js.UndefOr[MuiColor] = js.undefined,
                          /* If true, the nested `ListItem`s are initially displayed.
     (Passed on to ListItem) */
                          initiallyOpen: js.UndefOr[Boolean] = js.undefined,
                          /* This is the `Avatar` element to be displayed on the left side.
     (Passed on to ListItem) */
                          leftAvatar: js.UndefOr[VdomElement] = js.undefined,
                          /* This is the `Checkbox` element to be displayed on the left side.
     (Passed on to ListItem) */
                          leftCheckbox: js.UndefOr[VdomElement] = js.undefined,
                          /* An array of `ListItem`s to nest underneath the current `ListItem`.
     (Passed on to ListItem) */
                          nestedItems: js.UndefOr[js.Array[VdomElement]] = js.undefined,
                          /* Controls how deep a `ListItem` appears.
     This property is automatically managed, so modify at your own risk.
     (Passed on to ListItem) */
                          nestedLevel: js.UndefOr[Int] = js.undefined,
                          /* Override the inline-styles of the nested items' `NestedList`.
     (Passed on to ListItem) */
                          nestedListStyle: js.UndefOr[CssProperties] = js.undefined,
                          /* Callback function fired when the `ListItem` is focused or blurred by the keyboard.
     (Passed on to ListItem)
     @param {object} event `focus` or `blur` event targeting the `ListItem`.
     @param {boolean} isKeyboardFocused If true, the `ListItem` is focused. */
                          onKeyboardFocus: js.UndefOr[(ReactFocusEvent, Boolean) => Callback] =
                            js.undefined,
                          /* (Passed on to ListItem) */
                          onMouseEnter: js.UndefOr[ReactMouseEvent => Callback] = js.undefined,
                          /* (Passed on to ListItem) */
                          onMouseLeave: js.UndefOr[ReactMouseEvent => Callback] = js.undefined,
                          /* Callbak function fired when the `ListItem` toggles its nested list.
     (Passed on to ListItem)
     @param {object} listItem The `ListItem`. */
                          onNestedListToggle: js.UndefOr[js.Any => Callback] = js.undefined,
                          /* (Passed on to ListItem) */
                          onTouchEnd: js.UndefOr[ReactTouchEvent => Callback] = js.undefined,
                          /* (Passed on to ListItem) */
                          onTouchStart: js.UndefOr[ReactTouchEvent => Callback] = js.undefined,
                          /* Control toggle state of nested list.
     (Passed on to ListItem) */
                          open: js.UndefOr[Boolean] = js.undefined,
                          /* If true, clicking or tapping the primary text of the `ListItem`
     toggles the nested list.
     (Passed on to ListItem) */
                          primaryTogglesNestedList: js.UndefOr[Boolean] = js.undefined,
                          /* This is the `Avatar` element to be displayed on the right side.
     (Passed on to ListItem) */
                          rightAvatar: js.UndefOr[VdomElement] = js.undefined,
                          /* This is the `IconButton` to be displayed on the right side.
     Hovering over this button will remove the `ListItem` hover.
     Also, clicking on this button will not trigger a
     ripple on the `ListItem`; the event will be stopped and prevented
     from bubbling up to cause a `ListItem` click.
     (Passed on to ListItem) */
                          rightIconButton: js.UndefOr[VdomElement] = js.undefined,
                          /* This is the `Toggle` element to display on the right side.
     (Passed on to ListItem) */
                          rightToggle: js.UndefOr[VdomElement] = js.undefined,
                          /* Can be 1 or 2. This is the number of secondary
     text lines before ellipsis will show.
     (Passed on to ListItem) */
                          secondaryTextLines: js.UndefOr[_1_2] = js.undefined) {

  /**
    * @param children Elements passed as children to the underlying `ListItem`.
    */
  def apply(children: VdomNode*) = {
    implicit def evT(t: T): js.Any = t.asInstanceOf[js.Any]
    val props                      = JSMacro[MuiMenuItem[T]](this)
    val component                  = JsComponent[js.Object, Children.Varargs, Null](Mui.MenuItem)
    component(props)(children: _*)
  }
}
@js.native
class MuiMenuItemM extends js.Object {
  def applyFocusState(): js.Dynamic = js.native
}
