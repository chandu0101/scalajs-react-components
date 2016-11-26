package chandu0101.scalajs.react.components
package materialui
import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
/**
 * This file is generated - submit issues instead of PR against it
 */
case class MuiAppBar(
  key:                       js.UndefOr[String]                             = js.undefined,
  ref:                       js.UndefOr[String]                             = js.undefined,
  /* Applied to the app bar's root element.*/
  className:                 js.UndefOr[String]                             = js.undefined,
  /* The classname of the icon on the left of the app bar.
  If you are using a stylesheet for your icons, enter the class name for the icon to be used here.*/
  iconClassNameLeft:         js.UndefOr[String]                             = js.undefined,
  /* Similiar to the iconClassNameLeft prop except that
  it applies to the icon displayed on the right of the app bar.*/
  iconClassNameRight:        js.UndefOr[String]                             = js.undefined,
  /* The custom element to be displayed on the left side of the
  app bar such as an SvgIcon.*/
  iconElementLeft:           js.UndefOr[ReactElement]                       = js.undefined,
  /* Similiar to the iconElementLeft prop except that this element is displayed on the right of the app bar.*/
  iconElementRight:          js.UndefOr[ReactElement]                       = js.undefined,
  /* Override the inline-styles of the element displayed on the left side of the app bar.*/
  iconStyleLeft:             js.UndefOr[CssProperties]                      = js.undefined,
  /* Override the inline-styles of the element displayed on the right side of the app bar.*/
  iconStyleRight:            js.UndefOr[CssProperties]                      = js.undefined,
  /* Callback function for when the left icon is selected via a touch tap.*/
  onLeftIconButtonTouchTap:  js.UndefOr[ReactTouchEventH => Callback]       = js.undefined,
  /* Callback function for when the right icon is selected via a touch tap.*/
  onRightIconButtonTouchTap: js.UndefOr[ReactTouchEventH => Callback]       = js.undefined,
  /* Callback function for when the title text is selected via a touch tap.*/
  onTitleTouchTap:           js.UndefOr[ReactTouchEventH => Callback]       = js.undefined,
  /* Determines whether or not to display the Menu icon next to the title.
  Setting this prop to false will hide the icon.*/
  showMenuIconButton:        js.UndefOr[Boolean]                            = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:                     js.UndefOr[CssProperties]                      = js.undefined,
  /* The title to display on the app bar.*/
  title:                     js.UndefOr[ReactNode]                          = js.undefined,
  /* Override the inline-styles of the app bar's title element.*/
  titleStyle:                js.UndefOr[CssProperties]                      = js.undefined,
  /* The zDepth of the component.
  The shadow of the app bar is also dependent on this property.*/
  zDepth:                    js.UndefOr[ZDepth]                             = js.undefined,
  /* Set to true to generate a circlular paper container.
  (Passed on to Paper)*/
  circle:                    js.UndefOr[Boolean]                            = js.undefined,
  /* By default, the paper container will have a border radius.
  Set this to false to generate a container with sharp corners.
  (Passed on to Paper)*/
  rounded:                   js.UndefOr[Boolean]                            = js.undefined,
  /* Set to false to disable CSS transitions for the paper element.
  (Passed on to Paper)*/
  transitionEnabled:         js.UndefOr[Boolean]                            = js.undefined,
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
   * @param children Can be used to render a tab inside an app bar for instance.
   */
  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiAppBar](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.AppBar)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
