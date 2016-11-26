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
  ref:                      js.UndefOr[MuiMenuM => Unit]                                                   = js.undefined,
  /* If true, the menu will apply transitions when it
  is added to the DOM. In order for transitions to
  work, wrap the menu inside a `ReactTransitionGroup`.*/
  @deprecated("Instead, use a [Popover](/#/components/popover).\n      It will be removed with v0.16.0.")
  animated:                 js.UndefOr[Boolean]                                                            = js.undefined,
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
  /* This is the placement of the menu relative to the `IconButton`.*/
  @deprecated("Instead, use a [Popover](/#/components/popover).\n      It will be removed with v0.16.0.")
  openDirection:            js.UndefOr[Corners]                                                            = js.undefined,
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
  width:                    js.UndefOr[String | Double]                                                    = js.undefined,
  /* Menu no longer supports `zDepth`. Instead, wrap it in `Paper`
  or another component that provides zDepth.*/
  zDepth:                   js.UndefOr[ZDepth]                                                             = js.undefined,
  /* If true, the subheader will be indented by 72px.
  (Passed on to List)*/
  @deprecated("Refer to the `subheader` property. It will be removed with v0.16.0.")
  insetSubheader:           js.UndefOr[Boolean]                                                            = js.undefined,
  /* The subheader string that will be displayed at the top of the list.
  (Passed on to List)*/
  @deprecated("Instead, nest the `Subheader` component directly inside the `List`. It will be removed with v0.16.0.")
  subheader:                js.UndefOr[ReactNode]                                                          = js.undefined,
  /* Override the inline-styles of the subheader element.
  (Passed on to List)*/
  @deprecated("Refer to the `subheader` property. It will be removed with v0.16.0.")
  subheaderStyle:           js.UndefOr[CssProperties]                                                      = js.undefined,
  /* (Passed on to DOM)*/
  onAnimationEnd:           js.UndefOr[ReactEventH => Callback]                                            = js.undefined,
  /* (Passed on to DOM)*/
  onAnimationIteration:     js.UndefOr[ReactEventH => Callback]                                            = js.undefined,
  /* (Passed on to DOM)*/
  onAnimationStart:         js.UndefOr[ReactEventH => Callback]                                            = js.undefined,
  /* (Passed on to DOM)*/
  onBlur:                   js.UndefOr[ReactFocusEventH => Callback]                                       = js.undefined,
  /* (Passed on to DOM)*/
  onClick:                  js.UndefOr[ReactMouseEventH => Callback]                                       = js.undefined,
  /* (Passed on to DOM)*/
  onCompositionEnd:         js.UndefOr[ReactCompositionEventH => Callback]                                 = js.undefined,
  /* (Passed on to DOM)*/
  onCompositionStart:       js.UndefOr[ReactCompositionEventH => Callback]                                 = js.undefined,
  /* (Passed on to DOM)*/
  onCompositionUpdate:      js.UndefOr[ReactCompositionEventH => Callback]                                 = js.undefined,
  /* (Passed on to DOM)*/
  onContextMenu:            js.UndefOr[ReactEventH => Callback]                                            = js.undefined,
  /* (Passed on to DOM)*/
  onCopy:                   js.UndefOr[ReactClipboardEventH => Callback]                                   = js.undefined,
  /* (Passed on to DOM)*/
  onCut:                    js.UndefOr[ReactClipboardEventH => Callback]                                   = js.undefined,
  /* (Passed on to DOM)*/
  onDoubleClick:            js.UndefOr[ReactMouseEventH => Callback]                                       = js.undefined,
  /* (Passed on to DOM)*/
  onDrag:                   js.UndefOr[ReactDragEventH => Callback]                                        = js.undefined,
  /* (Passed on to DOM)*/
  onDragEnd:                js.UndefOr[ReactDragEventH => Callback]                                        = js.undefined,
  /* (Passed on to DOM)*/
  onDragEnter:              js.UndefOr[ReactDragEventH => Callback]                                        = js.undefined,
  /* (Passed on to DOM)*/
  onDragExit:               js.UndefOr[ReactDragEventH => Callback]                                        = js.undefined,
  /* (Passed on to DOM)*/
  onDragLeave:              js.UndefOr[ReactDragEventH => Callback]                                        = js.undefined,
  /* (Passed on to DOM)*/
  onDragOver:               js.UndefOr[ReactDragEventH => Callback]                                        = js.undefined,
  /* (Passed on to DOM)*/
  onDragStart:              js.UndefOr[ReactDragEventH => Callback]                                        = js.undefined,
  /* (Passed on to DOM)*/
  onDrop:                   js.UndefOr[ReactDragEventH => Callback]                                        = js.undefined,
  /* (Passed on to DOM)*/
  onFocus:                  js.UndefOr[ReactFocusEventH => Callback]                                       = js.undefined,
  /* (Passed on to DOM)*/
  onInput:                  js.UndefOr[ReactKeyboardEventH => Callback]                                    = js.undefined,
  /* (Passed on to DOM)*/
  onKeyPress:               js.UndefOr[ReactKeyboardEventH => Callback]                                    = js.undefined,
  /* (Passed on to DOM)*/
  onKeyUp:                  js.UndefOr[ReactKeyboardEventH => Callback]                                    = js.undefined,
  /* (Passed on to DOM)*/
  onMouseDown:              js.UndefOr[ReactMouseEventH => Callback]                                       = js.undefined,
  /* (Passed on to DOM)*/
  onMouseEnter:             js.UndefOr[ReactMouseEventH => Callback]                                       = js.undefined,
  /* (Passed on to DOM)*/
  onMouseLeave:             js.UndefOr[ReactMouseEventH => Callback]                                       = js.undefined,
  /* (Passed on to DOM)*/
  onMouseMove:              js.UndefOr[ReactMouseEventH => Callback]                                       = js.undefined,
  /* (Passed on to DOM)*/
  onMouseUp:                js.UndefOr[ReactMouseEventH => Callback]                                       = js.undefined,
  /* (Passed on to DOM)*/
  onPaste:                  js.UndefOr[ReactClipboardEventH => Callback]                                   = js.undefined,
  /* (Passed on to DOM)*/
  onScroll:                 js.UndefOr[ReactUIEventH => Callback]                                          = js.undefined,
  /* (Passed on to DOM)*/
  onSelect:                 js.UndefOr[ReactUIEventH => Callback]                                          = js.undefined,
  /* (Passed on to DOM)*/
  onSubmit:                 js.UndefOr[ReactEventH => Callback]                                            = js.undefined,
  /* (Passed on to DOM)*/
  onTouchCancel:            js.UndefOr[ReactTouchEventH => Callback]                                       = js.undefined,
  /* (Passed on to DOM)*/
  onTouchEnd:               js.UndefOr[ReactTouchEventH => Callback]                                       = js.undefined,
  /* (Passed on to DOM)*/
  onTouchMove:              js.UndefOr[ReactTouchEventH => Callback]                                       = js.undefined,
  /* (Passed on to DOM)*/
  onTouchStart:             js.UndefOr[ReactTouchEventH => Callback]                                       = js.undefined,
  /* (Passed on to DOM)*/
  onTransitionEnd:          js.UndefOr[ReactTouchEventH => Callback]                                       = js.undefined,
  /* (Passed on to DOM)*/
  onWheel:                  js.UndefOr[ReactWheelEventH => Callback]                                       = js.undefined){
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


@js.native
class MuiMenuM extends js.Object {
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

  def setFocusIndexStartsWith(keys: js.Any): js.Any = js.native

  def setKeyboardFocused(keyboardFocused: js.Any): js.Any = js.native

  def setScollPosition(): js.Any = js.native

  def setWidth(): js.Any = js.native
}
