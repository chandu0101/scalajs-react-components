package chandu0101.scalajs.react.components
package materialui
import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
/**
 * This file is generated - submit issues instead of PR against it
 */
case class MuiPopover(
  key:                    js.UndefOr[String]                             = js.undefined,
  ref:                    js.UndefOr[MuiPopoverM => Unit]                = js.undefined,
  /* This is the DOM element that will be used to set the position of the
  popover.*/
  anchorEl:               js.UndefOr[js.Any]                             = js.undefined,
  /* This is the point on the anchor where the popover's
  `targetOrigin` will attach to.
  Options:
  vertical: [top, middle, bottom];
  horizontal: [left, center, right].*/
  anchorOrigin:           js.UndefOr[Origin]                             = js.undefined,
  /* If true, the popover will apply transitions when
  it is added to the DOM.*/
  animated:               js.UndefOr[Boolean]                            = js.undefined,
  /* Override the default animation component used.*/
  animation:              js.UndefOr[js.Any]                             = js.undefined,
  /* If true, the popover will hide when the anchor is scrolled off the screen.*/
  autoCloseWhenOffScreen: js.UndefOr[Boolean]                            = js.undefined,
  /* If true, the popover (potentially) ignores `targetOrigin`
  and `anchorOrigin` to make itself fit on screen,
  which is useful for mobile devices.*/
  canAutoPosition:        js.UndefOr[Boolean]                            = js.undefined,
  /* The CSS class name of the root element.*/
  className:              js.UndefOr[String]                             = js.undefined,
  /* Callback function fired when the popover is requested to be closed.
  are 'clickAway' and 'offScreen'.*/
  onRequestClose:         js.UndefOr[Callback]                           = js.undefined,
  /* If true, the popover is visible.*/
  open:                   js.UndefOr[Boolean]                            = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:                  js.UndefOr[CssProperties]                      = js.undefined,
  /* This is the point on the popover which will attach to
  the anchor's origin.
  Options:
  vertical: [top, middle, bottom];
  horizontal: [left, center, right].*/
  targetOrigin:           js.UndefOr[Origin]                             = js.undefined,
  /* If true, the popover will render on top of an invisible
  layer, which will prevent clicks to the underlying
  elements, and trigger an `onRequestClose('clickAway')` call.*/
  useLayerForClickAway:   js.UndefOr[Boolean]                            = js.undefined,
  /* The zDepth of the popover.*/
  zDepth:                 js.UndefOr[ZDepth]                             = js.undefined,
  /* (Passed on to DOM)*/
  onAnimationEnd:         js.UndefOr[ReactEventH => Callback]            = js.undefined,
  /* (Passed on to DOM)*/
  onAnimationIteration:   js.UndefOr[ReactEventH => Callback]            = js.undefined,
  /* (Passed on to DOM)*/
  onAnimationStart:       js.UndefOr[ReactEventH => Callback]            = js.undefined,
  /* (Passed on to DOM)*/
  onBlur:                 js.UndefOr[ReactFocusEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onChange:               js.UndefOr[ReactEventH => Callback]            = js.undefined,
  /* (Passed on to DOM)*/
  onClick:                js.UndefOr[ReactMouseEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onCompositionEnd:       js.UndefOr[ReactCompositionEventH => Callback] = js.undefined,
  /* (Passed on to DOM)*/
  onCompositionStart:     js.UndefOr[ReactCompositionEventH => Callback] = js.undefined,
  /* (Passed on to DOM)*/
  onCompositionUpdate:    js.UndefOr[ReactCompositionEventH => Callback] = js.undefined,
  /* (Passed on to DOM)*/
  onContextMenu:          js.UndefOr[ReactEventH => Callback]            = js.undefined,
  /* (Passed on to DOM)*/
  onCopy:                 js.UndefOr[ReactClipboardEventH => Callback]   = js.undefined,
  /* (Passed on to DOM)*/
  onCut:                  js.UndefOr[ReactClipboardEventH => Callback]   = js.undefined,
  /* (Passed on to DOM)*/
  onDoubleClick:          js.UndefOr[ReactMouseEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onDrag:                 js.UndefOr[ReactDragEventH => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onDragEnd:              js.UndefOr[ReactDragEventH => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onDragEnter:            js.UndefOr[ReactDragEventH => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onDragExit:             js.UndefOr[ReactDragEventH => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onDragLeave:            js.UndefOr[ReactDragEventH => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onDragOver:             js.UndefOr[ReactDragEventH => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onDragStart:            js.UndefOr[ReactDragEventH => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onDrop:                 js.UndefOr[ReactDragEventH => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onFocus:                js.UndefOr[ReactFocusEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onInput:                js.UndefOr[ReactKeyboardEventH => Callback]    = js.undefined,
  /* (Passed on to DOM)*/
  onKeyDown:              js.UndefOr[ReactKeyboardEventH => Callback]    = js.undefined,
  /* (Passed on to DOM)*/
  onKeyPress:             js.UndefOr[ReactKeyboardEventH => Callback]    = js.undefined,
  /* (Passed on to DOM)*/
  onKeyUp:                js.UndefOr[ReactKeyboardEventH => Callback]    = js.undefined,
  /* (Passed on to DOM)*/
  onMouseDown:            js.UndefOr[ReactMouseEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onMouseEnter:           js.UndefOr[ReactMouseEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onMouseLeave:           js.UndefOr[ReactMouseEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onMouseMove:            js.UndefOr[ReactMouseEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onMouseUp:              js.UndefOr[ReactMouseEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onPaste:                js.UndefOr[ReactClipboardEventH => Callback]   = js.undefined,
  /* (Passed on to DOM)*/
  onScroll:               js.UndefOr[ReactUIEventH => Callback]          = js.undefined,
  /* (Passed on to DOM)*/
  onSelect:               js.UndefOr[ReactUIEventH => Callback]          = js.undefined,
  /* (Passed on to DOM)*/
  onSubmit:               js.UndefOr[ReactEventH => Callback]            = js.undefined,
  /* (Passed on to DOM)*/
  onTouchCancel:          js.UndefOr[ReactTouchEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onTouchEnd:             js.UndefOr[ReactTouchEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onTouchMove:            js.UndefOr[ReactTouchEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onTouchStart:           js.UndefOr[ReactTouchEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onTransitionEnd:        js.UndefOr[ReactTouchEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onWheel:                js.UndefOr[ReactWheelEventH => Callback]       = js.undefined){
  /**
   * @param children The content of the popover.
   */
  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiPopover](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Popover)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}


@js.native
class MuiPopoverM extends js.Object {
  def applyAutoPositionIfNeeded(anchor: js.Any, target: js.Any, targetOrigin: js.Any, anchorOrigin: js.Any, targetPosition: js.Any): js.Any = js.native

  def autoCloseWhenOffScreen(anchorPosition: js.Any): js.Any = js.native

  def getAnchorPosition(el: js.Any): js.Any = js.native

  def getOverlapMode(anchor: js.Any, target: js.Any, median: js.Any): js.Any = js.native

  def getPositions(anchor: js.Any, target: js.Any): js.Any = js.native

  def getTargetPosition(targetEl: js.Any): js.Any = js.native

  def requestClose(reason: js.Any): js.Any = js.native
}
