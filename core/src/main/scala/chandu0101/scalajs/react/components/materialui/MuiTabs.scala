package chandu0101.scalajs.react.components
package materialui
import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
/**
 * This file is generated - submit issues instead of PR against it
 */
case class MuiTabs[T](
  key:                       js.UndefOr[String]                                     = js.undefined,
  ref:                       js.UndefOr[MuiTabsM => Unit]                           = js.undefined,
  /* The css class name of the root element.*/
  className:                 js.UndefOr[String]                                     = js.undefined,
  /* The css class name of the content's container.*/
  contentContainerClassName: js.UndefOr[String]                                     = js.undefined,
  /* Override the inline-styles of the content's container.*/
  contentContainerStyle:     js.UndefOr[CssProperties]                              = js.undefined,
  /* Specify initial visible tab index.
  If `initialSelectedIndex` is set but larger than the total amount of specified tabs,
  `initialSelectedIndex` will revert back to default.
  If `initialSlectedIndex` is set to any negative value, no tab will be selected intially.*/
  initialSelectedIndex:      js.UndefOr[Int]                                        = js.undefined,
  /* Override the inline-styles of the InkBar.*/
  inkBarStyle:               js.UndefOr[CssProperties]                              = js.undefined,
  /* Called when the selected value change.*/
  onChange:                  js.UndefOr[(T, ReactEventH, ReactElement) => Callback] = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:                     js.UndefOr[CssProperties]                              = js.undefined,
  /* Override the inline-styles of the tab-labels container.*/
  tabItemContainerStyle:     js.UndefOr[CssProperties]                              = js.undefined,
  /* Override the default tab template used to wrap the content of each tab element.*/
  tabTemplate:               js.UndefOr[js.Any]                                     = js.undefined,
  /* Makes Tabs controllable and selects the tab whose value prop matches this prop.*/
  value:                     js.UndefOr[T]                                          = js.undefined,
  /* (Passed on to DOM)*/
  onAnimationEnd:            js.UndefOr[ReactEventH => Callback]                    = js.undefined,
  /* (Passed on to DOM)*/
  onAnimationIteration:      js.UndefOr[ReactEventH => Callback]                    = js.undefined,
  /* (Passed on to DOM)*/
  onAnimationStart:          js.UndefOr[ReactEventH => Callback]                    = js.undefined,
  /* (Passed on to DOM)*/
  onBlur:                    js.UndefOr[ReactFocusEventH => Callback]               = js.undefined,
  /* (Passed on to DOM)*/
  onClick:                   js.UndefOr[ReactMouseEventH => Callback]               = js.undefined,
  /* (Passed on to DOM)*/
  onCompositionEnd:          js.UndefOr[ReactCompositionEventH => Callback]         = js.undefined,
  /* (Passed on to DOM)*/
  onCompositionStart:        js.UndefOr[ReactCompositionEventH => Callback]         = js.undefined,
  /* (Passed on to DOM)*/
  onCompositionUpdate:       js.UndefOr[ReactCompositionEventH => Callback]         = js.undefined,
  /* (Passed on to DOM)*/
  onContextMenu:             js.UndefOr[ReactEventH => Callback]                    = js.undefined,
  /* (Passed on to DOM)*/
  onCopy:                    js.UndefOr[ReactClipboardEventH => Callback]           = js.undefined,
  /* (Passed on to DOM)*/
  onCut:                     js.UndefOr[ReactClipboardEventH => Callback]           = js.undefined,
  /* (Passed on to DOM)*/
  onDoubleClick:             js.UndefOr[ReactMouseEventH => Callback]               = js.undefined,
  /* (Passed on to DOM)*/
  onDrag:                    js.UndefOr[ReactDragEventH => Callback]                = js.undefined,
  /* (Passed on to DOM)*/
  onDragEnd:                 js.UndefOr[ReactDragEventH => Callback]                = js.undefined,
  /* (Passed on to DOM)*/
  onDragEnter:               js.UndefOr[ReactDragEventH => Callback]                = js.undefined,
  /* (Passed on to DOM)*/
  onDragExit:                js.UndefOr[ReactDragEventH => Callback]                = js.undefined,
  /* (Passed on to DOM)*/
  onDragLeave:               js.UndefOr[ReactDragEventH => Callback]                = js.undefined,
  /* (Passed on to DOM)*/
  onDragOver:                js.UndefOr[ReactDragEventH => Callback]                = js.undefined,
  /* (Passed on to DOM)*/
  onDragStart:               js.UndefOr[ReactDragEventH => Callback]                = js.undefined,
  /* (Passed on to DOM)*/
  onDrop:                    js.UndefOr[ReactDragEventH => Callback]                = js.undefined,
  /* (Passed on to DOM)*/
  onFocus:                   js.UndefOr[ReactFocusEventH => Callback]               = js.undefined,
  /* (Passed on to DOM)*/
  onInput:                   js.UndefOr[ReactKeyboardEventH => Callback]            = js.undefined,
  /* (Passed on to DOM)*/
  onKeyDown:                 js.UndefOr[ReactKeyboardEventH => Callback]            = js.undefined,
  /* (Passed on to DOM)*/
  onKeyPress:                js.UndefOr[ReactKeyboardEventH => Callback]            = js.undefined,
  /* (Passed on to DOM)*/
  onKeyUp:                   js.UndefOr[ReactKeyboardEventH => Callback]            = js.undefined,
  /* (Passed on to DOM)*/
  onMouseDown:               js.UndefOr[ReactMouseEventH => Callback]               = js.undefined,
  /* (Passed on to DOM)*/
  onMouseEnter:              js.UndefOr[ReactMouseEventH => Callback]               = js.undefined,
  /* (Passed on to DOM)*/
  onMouseLeave:              js.UndefOr[ReactMouseEventH => Callback]               = js.undefined,
  /* (Passed on to DOM)*/
  onMouseMove:               js.UndefOr[ReactMouseEventH => Callback]               = js.undefined,
  /* (Passed on to DOM)*/
  onMouseUp:                 js.UndefOr[ReactMouseEventH => Callback]               = js.undefined,
  /* (Passed on to DOM)*/
  onPaste:                   js.UndefOr[ReactClipboardEventH => Callback]           = js.undefined,
  /* (Passed on to DOM)*/
  onScroll:                  js.UndefOr[ReactUIEventH => Callback]                  = js.undefined,
  /* (Passed on to DOM)*/
  onSelect:                  js.UndefOr[ReactUIEventH => Callback]                  = js.undefined,
  /* (Passed on to DOM)*/
  onSubmit:                  js.UndefOr[ReactEventH => Callback]                    = js.undefined,
  /* (Passed on to DOM)*/
  onTouchCancel:             js.UndefOr[ReactTouchEventH => Callback]               = js.undefined,
  /* (Passed on to DOM)*/
  onTouchEnd:                js.UndefOr[ReactTouchEventH => Callback]               = js.undefined,
  /* (Passed on to DOM)*/
  onTouchMove:               js.UndefOr[ReactTouchEventH => Callback]               = js.undefined,
  /* (Passed on to DOM)*/
  onTouchStart:              js.UndefOr[ReactTouchEventH => Callback]               = js.undefined,
  /* (Passed on to DOM)*/
  onTransitionEnd:           js.UndefOr[ReactTouchEventH => Callback]               = js.undefined,
  /* (Passed on to DOM)*/
  onWheel:                   js.UndefOr[ReactWheelEventH => Callback]               = js.undefined){
  /**
   * @param children Should be used to pass `Tab` components.
   */
  def apply(children: ReactNode*) = {
    implicit def evT(t: T): js.Any = t.asInstanceOf[js.Any]
    val props = JSMacro[MuiTabs[T]](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Tabs)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}


@js.native
class MuiTabsM extends js.Object {
  def getEvenWidth(): js.Any = js.native

  def getSelected(tab: js.Any, index: js.Any): js.Any = js.native

  def getSelectedIndex(props: js.Any): js.Any = js.native

  def getTabCount(): js.Any = js.native

  def getTabs(): js.Any = js.native

  def getValueLink(props: js.Any): js.Any = js.native
}
