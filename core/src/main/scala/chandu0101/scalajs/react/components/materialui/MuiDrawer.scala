package chandu0101.scalajs.react.components
package materialui
import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
/**
 * This file is generated - submit issues instead of PR against it
 */
case class MuiDrawer(
  key:                  js.UndefOr[String]                             = js.undefined,
  ref:                  js.UndefOr[MuiDrawerM => Unit]                 = js.undefined,
  /* The CSS class name of the root element.*/
  className:            js.UndefOr[String]                             = js.undefined,
  /* The CSS class name of the container element.*/
  containerClassName:   js.UndefOr[String]                             = js.undefined,
  /* Override the inline-styles of the container element.*/
  containerStyle:       js.UndefOr[CssProperties]                      = js.undefined,
  /* If true, swiping sideways when the `Drawer` is closed will not open it.*/
  disableSwipeToOpen:   js.UndefOr[Boolean]                            = js.undefined,
  /* If true, the `Drawer` will be docked. In this state, the overlay won't show and
  clicking on a menu item will not close the `Drawer`.*/
  docked:               js.UndefOr[Boolean]                            = js.undefined,
  /* Callback function fired when the `open` state of the `Drawer` is requested to be changed.
  'swipe' for open requests; 'clickaway' (on overlay clicks),
  'escape' (on escape key press), and 'swipe' for close requests.*/
  onRequestChange:      js.UndefOr[(Boolean, String) => Callback]      = js.undefined,
  /* If true, the `Drawer` is opened.  Providing a value will turn the `Drawer`
  into a controlled component.*/
  open:                 js.UndefOr[Boolean]                            = js.undefined,
  /* If true, the `Drawer` is positioned to open from the opposite side.*/
  openSecondary:        js.UndefOr[Boolean]                            = js.undefined,
  /* The CSS class name to add to the `Overlay` component that is rendered behind the `Drawer`.*/
  overlayClassName:     js.UndefOr[String]                             = js.undefined,
  /* Override the inline-styles of the `Overlay` component that is rendered behind the `Drawer`.*/
  overlayStyle:         js.UndefOr[CssProperties]                      = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:                js.UndefOr[CssProperties]                      = js.undefined,
  /* The width of the left most (or right most) area in pixels where the `Drawer` can be
  swiped open from. Setting this to `null` spans that area to the entire page
  (**CAUTION!** Setting this property to `null` might cause issues with sliders and
  swipeable `Tabs`: use at your own risk).*/
  swipeAreaWidth:       js.UndefOr[Double]                             = js.undefined,
  /* The width of the `Drawer` in pixels. Defaults to using the values from theme.*/
  width:                js.UndefOr[Double]                             = js.undefined,
  /* The zDepth of the `Drawer`.*/
  zDepth:               js.UndefOr[ZDepth]                             = js.undefined,
  /* (Passed on to DOM)*/
  onAnimationEnd:       js.UndefOr[ReactEventH => Callback]            = js.undefined,
  /* (Passed on to DOM)*/
  onAnimationIteration: js.UndefOr[ReactEventH => Callback]            = js.undefined,
  /* (Passed on to DOM)*/
  onAnimationStart:     js.UndefOr[ReactEventH => Callback]            = js.undefined,
  /* (Passed on to DOM)*/
  onBlur:               js.UndefOr[ReactFocusEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onChange:             js.UndefOr[ReactEventH => Callback]            = js.undefined,
  /* (Passed on to DOM)*/
  onClick:              js.UndefOr[ReactMouseEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onCompositionEnd:     js.UndefOr[ReactCompositionEventH => Callback] = js.undefined,
  /* (Passed on to DOM)*/
  onCompositionStart:   js.UndefOr[ReactCompositionEventH => Callback] = js.undefined,
  /* (Passed on to DOM)*/
  onCompositionUpdate:  js.UndefOr[ReactCompositionEventH => Callback] = js.undefined,
  /* (Passed on to DOM)*/
  onContextMenu:        js.UndefOr[ReactEventH => Callback]            = js.undefined,
  /* (Passed on to DOM)*/
  onCopy:               js.UndefOr[ReactClipboardEventH => Callback]   = js.undefined,
  /* (Passed on to DOM)*/
  onCut:                js.UndefOr[ReactClipboardEventH => Callback]   = js.undefined,
  /* (Passed on to DOM)*/
  onDoubleClick:        js.UndefOr[ReactMouseEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onDrag:               js.UndefOr[ReactDragEventH => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onDragEnd:            js.UndefOr[ReactDragEventH => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onDragEnter:          js.UndefOr[ReactDragEventH => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onDragExit:           js.UndefOr[ReactDragEventH => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onDragLeave:          js.UndefOr[ReactDragEventH => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onDragOver:           js.UndefOr[ReactDragEventH => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onDragStart:          js.UndefOr[ReactDragEventH => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onDrop:               js.UndefOr[ReactDragEventH => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onFocus:              js.UndefOr[ReactFocusEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onInput:              js.UndefOr[ReactKeyboardEventH => Callback]    = js.undefined,
  /* (Passed on to DOM)*/
  onKeyDown:            js.UndefOr[ReactKeyboardEventH => Callback]    = js.undefined,
  /* (Passed on to DOM)*/
  onKeyPress:           js.UndefOr[ReactKeyboardEventH => Callback]    = js.undefined,
  /* (Passed on to DOM)*/
  onKeyUp:              js.UndefOr[ReactKeyboardEventH => Callback]    = js.undefined,
  /* (Passed on to DOM)*/
  onMouseDown:          js.UndefOr[ReactMouseEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onMouseEnter:         js.UndefOr[ReactMouseEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onMouseLeave:         js.UndefOr[ReactMouseEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onMouseMove:          js.UndefOr[ReactMouseEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onMouseUp:            js.UndefOr[ReactMouseEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onPaste:              js.UndefOr[ReactClipboardEventH => Callback]   = js.undefined,
  /* (Passed on to DOM)*/
  onScroll:             js.UndefOr[ReactUIEventH => Callback]          = js.undefined,
  /* (Passed on to DOM)*/
  onSelect:             js.UndefOr[ReactUIEventH => Callback]          = js.undefined,
  /* (Passed on to DOM)*/
  onSubmit:             js.UndefOr[ReactEventH => Callback]            = js.undefined,
  /* (Passed on to DOM)*/
  onTouchCancel:        js.UndefOr[ReactTouchEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onTouchEnd:           js.UndefOr[ReactTouchEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onTouchMove:          js.UndefOr[ReactTouchEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onTouchStart:         js.UndefOr[ReactTouchEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onTransitionEnd:      js.UndefOr[ReactTouchEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onWheel:              js.UndefOr[ReactWheelEventH => Callback]       = js.undefined){
  /**
   * @param children The contents of the `Drawer`
   */
  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiDrawer](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Drawer)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}


@js.native
class MuiDrawerM extends js.Object {
  def close(reason: js.Any): js.Any = js.native

  def disableSwipeHandling(): js.Any = js.native

  def enableSwipeHandling(): js.Any = js.native

  def getMaxTranslateX(): js.Any = js.native

  def getStyles(): js.Any = js.native

  def getTranslateMultiplier(): js.Any = js.native

  def getTranslateX(currentX: js.Any): js.Any = js.native

  def open(reason: js.Any): js.Any = js.native

  def setPosition(translateX: js.Any): js.Any = js.native

  def shouldShow(): js.Any = js.native
}
