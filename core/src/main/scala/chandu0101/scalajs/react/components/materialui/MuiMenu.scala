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
  ref:                      js.UndefOr[MenuM => Unit]                                                           = js.undefined,
  /* If true, the menu will apply transitions when it
  is added to the DOM. In order for transitions to
  work, wrap the menu inside a `ReactTransitionGroup`.*/
  @deprecated("Instead, use a [Popover](/#/components/popover).")
  animated:                 js.UndefOr[Boolean]                                                                 = js.undefined,
  /* If true, the width of the menu will be set automatically
  according to the widths of its children,
  using proper keyline increments (64px for desktop,
  56px otherwise).*/
  autoWidth:                js.UndefOr[Boolean]                                                                 = js.undefined,
  /* If true, the menu item will render with compact desktop styles.*/
  desktop:                  js.UndefOr[Boolean]                                                                 = js.undefined,
  /* If true, the menu will not be auto-focused.*/
  disableAutoFocus:         js.UndefOr[Boolean]                                                                 = js.undefined,
  /* If true, the menu will be keyboard-focused initially.*/
  initiallyKeyboardFocused: js.UndefOr[Boolean]                                                                 = js.undefined,
  /* Override the inline-styles of the underlying `List` element.*/
  listStyle:                js.UndefOr[CssProperties]                                                           = js.undefined,
  /* The maximum height of the menu in pixels. If specified,
  the menu will be scrollable if it is taller than the provided
  height.*/
  maxHeight:                js.UndefOr[Int]                                                                     = js.undefined,
  /* If true, `value` must be an array and the menu will support
  multiple selections.*/
  multiple:                 js.UndefOr[Boolean]                                                                 = js.undefined,
  /* Callback function fired when a menu item with `value` not
  equal to the current `value` of the menu is touch-tapped.
  array with either the menu item's `value` added (if
  it wasn't already selected) or omitted (if it was already selected).
  Otherwise, the `value` of the menu item.*/
  onChange:                 js.UndefOr[(ReactEventH, String | js.Array[String]) => Callback]                    = js.undefined,
  /* Callback function fired when the menu is focused and the *Esc* key
  is pressed.*/
  onEscKeyDown:             js.UndefOr[ReactKeyboardEventH => Callback]                                         = js.undefined,
  /* Callback function fired when a menu item is touch-tapped.*/
  onItemTouchTap:           js.UndefOr[(ReactUIEventH, JsComponentM[MuiMenuItemProps, _, TopNode]) => Callback] = js.undefined,
  /* Callback function fired when the menu is focused and a key
  is pressed.*/
  onKeyDown:                js.UndefOr[ReactKeyboardEventH => Callback]                                         = js.undefined,
  /* This is the placement of the menu relative to the `IconButton`.*/
  @deprecated("Instead, use a [Popover](/#/components/popover).")
  openDirection:            js.UndefOr[Corners]                                                                 = js.undefined,
  /* Override the inline-styles of selected menu items.*/
  selectedMenuItemStyle:    js.UndefOr[CssProperties]                                                           = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:                    js.UndefOr[CssProperties]                                                           = js.undefined,
  /* If `multiple` is true, an array of the `value`s of the selected
  menu items. Otherwise, the `value` of the selected menu item.
  If provided, the menu will be a controlled component.
  This component also supports valueLink.*/
  value:                    js.UndefOr[String | js.Array[String]]                                               = js.undefined,
  /* ValueLink for the menu's `value`.*/
  valueLink:                js.UndefOr[js.Any]                                                                  = js.undefined,
  /* The width of the menu. If not specified, the menu's width
  will be set according to the widths of its children, using
  proper keyline increments (64px for desktop, 56px otherwise).*/
  width:                    js.UndefOr[String | Double]                                                         = js.undefined,
  /* Menu no longer supports `zDepth`. Instead, wrap it in `Paper`
  or another component that provides zDepth.*/
  @deprecated("Internal API")
  zDepth:                   js.UndefOr[ZDepth]                                                                  = js.undefined,
  /* If true, the subheader will be indented by 72px.
  (Passed on to List)*/
  @deprecated("Refer to the `subheader` property.")
  insetSubheader:           js.UndefOr[Boolean]                                                                 = js.undefined,
  /* The subheader string that will be displayed at the top of the list.
  (Passed on to List)*/
  @deprecated("Instead, nest the `Subheader` component directly inside the `List`.")
  subheader:                js.UndefOr[ReactNode]                                                               = js.undefined,
  /* Override the inline-styles of the subheader element.
  (Passed on to List)*/
  @deprecated("Refer to the `subheader` property.")
  subheaderStyle:           js.UndefOr[CssProperties]                                                           = js.undefined){
  /**
   * @param children The content of the menu. This is usually used to pass `MenuItem`
elements.
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
      


@js.native
class MenuM extends js.Object {
  def animateOpen(): js.Any = js.native

  def cloneMenuItem(child: js.Any, childIndex: js.Any, styles: js.Any, index: js.Any): js.Any = js.native

  def decrementKeyboardFocusIndex(): js.Any = js.native

  def getCascadeChildrenCount(filteredChildren: js.Any): js.Any = js.native

  def getFilteredChildren(children: js.Any): js.Any = js.native

  def getMenuItemCount(filteredChildren: js.Any): js.Any = js.native

  def getSelectedIndex(props: js.Any, filteredChildren: js.Any): js.Any = js.native

  def getValueLink(props: js.Any): js.Any = js.native

  def incrementKeyboardFocusIndex(filteredChildren: js.Any): js.Any = js.native

  def isChildSelected(child: js.Any, props: js.Any): js.Any = js.native

  def setFocusIndex(newIndex: js.Any, isKeyboardFocused: js.Any): js.Any = js.native

  def setKeyboardFocused(keyboardFocused: js.Any): js.Any = js.native

  def setScollPosition(): js.Any = js.native

  def setWidth(): js.Any = js.native
}
