package chandu0101.scalajs.react.components
package materialui
import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
/**
 * This file is generated - submit issues instead of PR against it
 */
case class MuiIconMenu[T](
  key:                      js.UndefOr[String]                                       = js.undefined,
  ref:                      js.UndefOr[MuiIconMenuM => Unit]                         = js.undefined,
  /* This is the point on the icon where the menu
  `targetOrigin` will attach.
  Options:
  vertical: [top, middle, bottom]
  horizontal: [left, center, right].*/
  anchorOrigin:             js.UndefOr[Origin]                                       = js.undefined,
  /* If true, the popover will apply transitions when
  it gets added to the DOM.*/
  animated:                 js.UndefOr[Boolean]                                      = js.undefined,
  /* The CSS class name of the root element.*/
  className:                js.UndefOr[String]                                       = js.undefined,
  /* This is the `IconButton` to render. This button will open the menu.*/
  iconButtonElement:        ReactElement,
  /* Override the inline-styles of the underlying icon element.*/
  iconStyle:                js.UndefOr[CssProperties]                                = js.undefined,
  /* Override the inline-styles of the menu element.*/
  menuStyle:                js.UndefOr[CssProperties]                                = js.undefined,
  /* If true, the value can an be array and allow the menu to be a multi-select.*/
  multiple:                 js.UndefOr[Boolean]                                      = js.undefined,
  /* Callback function fired when a menu item is selected with a touch-tap.*/
  onItemTouchTap:           js.UndefOr[(ReactTouchEventH, ReactElement) => Callback] = js.undefined,
  /* Callback function fired when the `IconButton` element is focused or blurred by the keyboard.*/
  onKeyboardFocus:          js.UndefOr[ReactKeyboardEventH => Callback]              = js.undefined,
  onMouseDown:              js.UndefOr[ReactMouseEventH => Callback]                 = js.undefined,
  onMouseEnter:             js.UndefOr[ReactMouseEventH => Callback]                 = js.undefined,
  onMouseLeave:             js.UndefOr[ReactMouseEventH => Callback]                 = js.undefined,
  onMouseUp:                js.UndefOr[ReactMouseEventH => Callback]                 = js.undefined,
  /* Callback function fired when the `open` state of the menu is requested to be changed.
  'keyboard' and 'iconTap' for open requests; 'enter', 'escape', 'itemTap', and 'clickAway'
  for close requests.*/
  onRequestChange:          js.UndefOr[(Boolean, String) => Callback]                = js.undefined,
  /* Callback function fired when the `IconButton` element is touch-tapped.*/
  onTouchTap:               js.UndefOr[ReactTouchEventH => Callback]                 = js.undefined,
  /* If true, the `IconMenu` is opened.*/
  open:                     js.UndefOr[Boolean]                                      = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:                    js.UndefOr[CssProperties]                                = js.undefined,
  /* This is the point on the menu which will stick to the menu
  origin.
  Options:
  vertical: [top, middle, bottom]
  horizontal: [left, center, right].*/
  targetOrigin:             js.UndefOr[Origin]                                       = js.undefined,
  /* Sets the delay in milliseconds before closing the
  menu when an item is clicked.
  If set to 0 then the auto close functionality
  will be disabled.*/
  touchTapCloseDelay:       js.UndefOr[Int]                                          = js.undefined,
  /* If true, the popover will render on top of an invisible
  layer, which will prevent clicks to the underlying elements.*/
  useLayerForClickAway:     js.UndefOr[Boolean]                                      = js.undefined,
  /* If true, the width of the menu will be set automatically
  according to the widths of its children,
  using proper keyline increments (64px for desktop,
  56px otherwise).
  (Passed on to Menu)*/
  autoWidth:                js.UndefOr[Boolean]                                      = js.undefined,
  /* If true, the menu item will render with compact desktop styles.
  (Passed on to Menu)*/
  desktop:                  js.UndefOr[Boolean]                                      = js.undefined,
  /* If true, the menu will not be auto-focused.
  (Passed on to Menu)*/
  disableAutoFocus:         js.UndefOr[Boolean]                                      = js.undefined,
  /* If true, the menu will be keyboard-focused initially.
  (Passed on to Menu)*/
  initiallyKeyboardFocused: js.UndefOr[Boolean]                                      = js.undefined,
  /* Override the inline-styles of the underlying `List` element.
  (Passed on to Menu)*/
  listStyle:                js.UndefOr[CssProperties]                                = js.undefined,
  /* The maximum height of the menu in pixels. If specified,
  the menu will be scrollable if it is taller than the provided
  height.
  (Passed on to Menu)*/
  maxHeight:                js.UndefOr[Int]                                          = js.undefined,
  /* Callback function fired when a menu item with `value` not
  equal to the current `value` of the menu is touch-tapped.
  array with either the menu item's `value` added (if
  it wasn't already selected) or omitted (if it was already selected).
  Otherwise, the `value` of the menu item.
  (Passed on to Menu)*/
  onChange:                 js.UndefOr[(ReactEventH, T | js.Array[T]) => Callback]   = js.undefined,
  /* Callback function fired when the menu is focused and the *Esc* key
  is pressed.
  (Passed on to Menu)*/
  onEscKeyDown:             js.UndefOr[ReactKeyboardEventH => Callback]              = js.undefined,
  /* 
  (Passed on to Menu)*/
  onKeyDown:                js.UndefOr[ReactKeyboardEventH => Callback]              = js.undefined,
  /* This is the placement of the menu relative to the `IconButton`.
  (Passed on to Menu)*/
  @deprecated("Instead, use a [Popover](/#/components/popover).\n      It will be removed with v0.16.0.")
  openDirection:            js.UndefOr[Corners]                                      = js.undefined,
  /* Override the inline-styles of selected menu items.
  (Passed on to Menu)*/
  selectedMenuItemStyle:    js.UndefOr[CssProperties]                                = js.undefined,
  /* If `multiple` is true, an array of the `value`s of the selected
  menu items. Otherwise, the `value` of the selected menu item.
  If provided, the menu will be a controlled component.
  This component also supports valueLink.
  (Passed on to Menu)*/
  value:                    js.UndefOr[T | js.Array[T]]                              = js.undefined,
  /* ValueLink for the menu's `value`.
  (Passed on to Menu)*/
  valueLink:                js.UndefOr[js.Any]                                       = js.undefined,
  /* The width of the menu. If not specified, the menu's width
  will be set according to the widths of its children, using
  proper keyline increments (64px for desktop, 56px otherwise).
  (Passed on to Menu)*/
  width:                    js.UndefOr[String | Double]                              = js.undefined,
  /* Menu no longer supports `zDepth`. Instead, wrap it in `Paper`
  or another component that provides zDepth.
  (Passed on to Menu)*/
  zDepth:                   js.UndefOr[ZDepth]                                       = js.undefined,
  /* (Passed on to DOM)*/
  onAnimationEnd:           js.UndefOr[ReactEventH => Callback]                      = js.undefined,
  /* (Passed on to DOM)*/
  onAnimationIteration:     js.UndefOr[ReactEventH => Callback]                      = js.undefined,
  /* (Passed on to DOM)*/
  onAnimationStart:         js.UndefOr[ReactEventH => Callback]                      = js.undefined,
  /* (Passed on to DOM)*/
  onBlur:                   js.UndefOr[ReactFocusEventH => Callback]                 = js.undefined,
  /* (Passed on to DOM)*/
  onClick:                  js.UndefOr[ReactMouseEventH => Callback]                 = js.undefined,
  /* (Passed on to DOM)*/
  onCompositionEnd:         js.UndefOr[ReactCompositionEventH => Callback]           = js.undefined,
  /* (Passed on to DOM)*/
  onCompositionStart:       js.UndefOr[ReactCompositionEventH => Callback]           = js.undefined,
  /* (Passed on to DOM)*/
  onCompositionUpdate:      js.UndefOr[ReactCompositionEventH => Callback]           = js.undefined,
  /* (Passed on to DOM)*/
  onContextMenu:            js.UndefOr[ReactEventH => Callback]                      = js.undefined,
  /* (Passed on to DOM)*/
  onCopy:                   js.UndefOr[ReactClipboardEventH => Callback]             = js.undefined,
  /* (Passed on to DOM)*/
  onCut:                    js.UndefOr[ReactClipboardEventH => Callback]             = js.undefined,
  /* (Passed on to DOM)*/
  onDoubleClick:            js.UndefOr[ReactMouseEventH => Callback]                 = js.undefined,
  /* (Passed on to DOM)*/
  onDrag:                   js.UndefOr[ReactDragEventH => Callback]                  = js.undefined,
  /* (Passed on to DOM)*/
  onDragEnd:                js.UndefOr[ReactDragEventH => Callback]                  = js.undefined,
  /* (Passed on to DOM)*/
  onDragEnter:              js.UndefOr[ReactDragEventH => Callback]                  = js.undefined,
  /* (Passed on to DOM)*/
  onDragExit:               js.UndefOr[ReactDragEventH => Callback]                  = js.undefined,
  /* (Passed on to DOM)*/
  onDragLeave:              js.UndefOr[ReactDragEventH => Callback]                  = js.undefined,
  /* (Passed on to DOM)*/
  onDragOver:               js.UndefOr[ReactDragEventH => Callback]                  = js.undefined,
  /* (Passed on to DOM)*/
  onDragStart:              js.UndefOr[ReactDragEventH => Callback]                  = js.undefined,
  /* (Passed on to DOM)*/
  onDrop:                   js.UndefOr[ReactDragEventH => Callback]                  = js.undefined,
  /* (Passed on to DOM)*/
  onFocus:                  js.UndefOr[ReactFocusEventH => Callback]                 = js.undefined,
  /* (Passed on to DOM)*/
  onInput:                  js.UndefOr[ReactKeyboardEventH => Callback]              = js.undefined,
  /* (Passed on to DOM)*/
  onKeyPress:               js.UndefOr[ReactKeyboardEventH => Callback]              = js.undefined,
  /* (Passed on to DOM)*/
  onKeyUp:                  js.UndefOr[ReactKeyboardEventH => Callback]              = js.undefined,
  /* (Passed on to DOM)*/
  onMouseMove:              js.UndefOr[ReactMouseEventH => Callback]                 = js.undefined,
  /* (Passed on to DOM)*/
  onPaste:                  js.UndefOr[ReactClipboardEventH => Callback]             = js.undefined,
  /* (Passed on to DOM)*/
  onScroll:                 js.UndefOr[ReactUIEventH => Callback]                    = js.undefined,
  /* (Passed on to DOM)*/
  onSelect:                 js.UndefOr[ReactUIEventH => Callback]                    = js.undefined,
  /* (Passed on to DOM)*/
  onSubmit:                 js.UndefOr[ReactEventH => Callback]                      = js.undefined,
  /* (Passed on to DOM)*/
  onTouchCancel:            js.UndefOr[ReactTouchEventH => Callback]                 = js.undefined,
  /* (Passed on to DOM)*/
  onTouchEnd:               js.UndefOr[ReactTouchEventH => Callback]                 = js.undefined,
  /* (Passed on to DOM)*/
  onTouchMove:              js.UndefOr[ReactTouchEventH => Callback]                 = js.undefined,
  /* (Passed on to DOM)*/
  onTouchStart:             js.UndefOr[ReactTouchEventH => Callback]                 = js.undefined,
  /* (Passed on to DOM)*/
  onTransitionEnd:          js.UndefOr[ReactTouchEventH => Callback]                 = js.undefined,
  /* (Passed on to DOM)*/
  onWheel:                  js.UndefOr[ReactWheelEventH => Callback]                 = js.undefined){
  /**
   * @param children Should be used to pass `MenuItem` components.
   */
  def apply(children: ReactNode*) = {
    implicit def evT(t: T): js.Any = t.asInstanceOf[js.Any]
    val props = JSMacro[MuiIconMenu[T]](this)
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
class MuiIconMenuM extends js.Object {
  def close(reason: js.Any, isKeyboard: js.Any): js.Any = js.native

  def isOpen(): js.Any = js.native

  def open(reason: js.Any, event: js.Any): js.Any = js.native
}
