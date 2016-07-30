package chandu0101.scalajs.react.components
package materialui
import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
/**
 * This file is generated - submit issues instead of PR against it
 */
case class MuiDialog(
  key:                       js.UndefOr[String]                             = js.undefined,
  ref:                       js.UndefOr[String]                             = js.undefined,
  /* Action buttons to display below the Dialog content (`children`).
  This property accepts either a React element, or an array of React elements.*/
  actions:                   js.UndefOr[ReactNode]                          = js.undefined,
  /* The `className` to add to the actions container's root element.*/
  actionsContainerClassName: js.UndefOr[String]                             = js.undefined,
  /* Overrides the inline-styles of the actions container's root element.*/
  actionsContainerStyle:     js.UndefOr[CssProperties]                      = js.undefined,
  /* If set to true, the height of the `Dialog` will be auto detected. A max height
  will be enforced so that the content does not extend beyond the viewport.*/
  autoDetectWindowHeight:    js.UndefOr[Boolean]                            = js.undefined,
  /* If set to true, the body content of the `Dialog` will be scrollable.*/
  autoScrollBodyContent:     js.UndefOr[Boolean]                            = js.undefined,
  /* The `className` to add to the content's root element under the title.*/
  bodyClassName:             js.UndefOr[String]                             = js.undefined,
  /* Overrides the inline-styles of the content's root element under the title.*/
  bodyStyle:                 js.UndefOr[CssProperties]                      = js.undefined,
  /* The css class name of the root element.*/
  className:                 js.UndefOr[String]                             = js.undefined,
  /* The `className` to add to the content container.*/
  contentClassName:          js.UndefOr[String]                             = js.undefined,
  /* Overrides the inline-styles of the content container.*/
  contentStyle:              js.UndefOr[CssProperties]                      = js.undefined,
  /* Force the user to use one of the actions in the `Dialog`.
  Clicking outside the `Dialog` will not trigger the `onRequestClose`.*/
  modal:                     js.UndefOr[Boolean]                            = js.undefined,
  /* Fired when the `Dialog` is requested to be closed by a click outside the `Dialog` or on the buttons.*/
  onRequestClose:            js.UndefOr[Boolean => Callback]                = js.undefined,
  /* Controls whether the Dialog is opened or not.*/
  open:                      Boolean,
  /* The `className` to add to the `Overlay` component that is rendered behind the `Dialog`.*/
  overlayClassName:          js.UndefOr[String]                             = js.undefined,
  /* Overrides the inline-styles of the `Overlay` component that is rendered behind the `Dialog`.*/
  overlayStyle:              js.UndefOr[CssProperties]                      = js.undefined,
  /* Determines whether the `Dialog` should be repositioned when it's contents are updated.*/
  repositionOnUpdate:        js.UndefOr[Boolean]                            = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:                     js.UndefOr[CssProperties]                      = js.undefined,
  /* The title to display on the `Dialog`. Could be number, string, element or an array containing these types.*/
  title:                     js.UndefOr[ReactNode]                          = js.undefined,
  /* The `className` to add to the title's root container element.*/
  titleClassName:            js.UndefOr[String]                             = js.undefined,
  /* Overrides the inline-styles of the title's root container element.*/
  titleStyle:                js.UndefOr[CssProperties]                      = js.undefined,
  /* (Passed on to DOM)*/
  onAnimationEnd:            js.UndefOr[ReactEventH => Callback]            = js.undefined,
  /* (Passed on to DOM)*/
  onAnimationIteration:      js.UndefOr[ReactEventH => Callback]            = js.undefined,
  /* (Passed on to DOM)*/
  onAnimationStart:          js.UndefOr[ReactEventH => Callback]            = js.undefined,
  /* (Passed on to DOM)*/
  onBlur:                    js.UndefOr[ReactFocusEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onChange:                  js.UndefOr[ReactEventH => Callback]            = js.undefined,
  /* (Passed on to DOM)*/
  onClick:                   js.UndefOr[ReactMouseEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onCompositionEnd:          js.UndefOr[ReactCompositionEventH => Callback] = js.undefined,
  /* (Passed on to DOM)*/
  onCompositionStart:        js.UndefOr[ReactCompositionEventH => Callback] = js.undefined,
  /* (Passed on to DOM)*/
  onCompositionUpdate:       js.UndefOr[ReactCompositionEventH => Callback] = js.undefined,
  /* (Passed on to DOM)*/
  onContextMenu:             js.UndefOr[ReactEventH => Callback]            = js.undefined,
  /* (Passed on to DOM)*/
  onCopy:                    js.UndefOr[ReactClipboardEventH => Callback]   = js.undefined,
  /* (Passed on to DOM)*/
  onCut:                     js.UndefOr[ReactClipboardEventH => Callback]   = js.undefined,
  /* (Passed on to DOM)*/
  onDoubleClick:             js.UndefOr[ReactMouseEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onDrag:                    js.UndefOr[ReactDragEventH => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onDragEnd:                 js.UndefOr[ReactDragEventH => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onDragEnter:               js.UndefOr[ReactDragEventH => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onDragExit:                js.UndefOr[ReactDragEventH => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onDragLeave:               js.UndefOr[ReactDragEventH => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onDragOver:                js.UndefOr[ReactDragEventH => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onDragStart:               js.UndefOr[ReactDragEventH => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onDrop:                    js.UndefOr[ReactDragEventH => Callback]        = js.undefined,
  /* (Passed on to DOM)*/
  onFocus:                   js.UndefOr[ReactFocusEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onInput:                   js.UndefOr[ReactKeyboardEventH => Callback]    = js.undefined,
  /* (Passed on to DOM)*/
  onKeyDown:                 js.UndefOr[ReactKeyboardEventH => Callback]    = js.undefined,
  /* (Passed on to DOM)*/
  onKeyPress:                js.UndefOr[ReactKeyboardEventH => Callback]    = js.undefined,
  /* (Passed on to DOM)*/
  onKeyUp:                   js.UndefOr[ReactKeyboardEventH => Callback]    = js.undefined,
  /* (Passed on to DOM)*/
  onMouseDown:               js.UndefOr[ReactMouseEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onMouseEnter:              js.UndefOr[ReactMouseEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onMouseLeave:              js.UndefOr[ReactMouseEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onMouseMove:               js.UndefOr[ReactMouseEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onMouseUp:                 js.UndefOr[ReactMouseEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onPaste:                   js.UndefOr[ReactClipboardEventH => Callback]   = js.undefined,
  /* (Passed on to DOM)*/
  onScroll:                  js.UndefOr[ReactUIEventH => Callback]          = js.undefined,
  /* (Passed on to DOM)*/
  onSelect:                  js.UndefOr[ReactUIEventH => Callback]          = js.undefined,
  /* (Passed on to DOM)*/
  onSubmit:                  js.UndefOr[ReactEventH => Callback]            = js.undefined,
  /* (Passed on to DOM)*/
  onTouchCancel:             js.UndefOr[ReactTouchEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onTouchEnd:                js.UndefOr[ReactTouchEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onTouchMove:               js.UndefOr[ReactTouchEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onTouchStart:              js.UndefOr[ReactTouchEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onTransitionEnd:           js.UndefOr[ReactTouchEventH => Callback]       = js.undefined,
  /* (Passed on to DOM)*/
  onWheel:                   js.UndefOr[ReactWheelEventH => Callback]       = js.undefined){
  /**
   * @param children The contents of the `Dialog`.
   */
  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiDialog](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Dialog)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
