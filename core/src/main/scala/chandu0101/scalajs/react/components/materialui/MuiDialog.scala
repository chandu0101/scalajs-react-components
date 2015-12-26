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
  key:                       js.UndefOr[String]              = js.undefined,
  ref:                       js.UndefOr[MuiDialogM => Unit]  = js.undefined,
  /* The `ref` of the action to focus on when the `Dialog` is displayed.*/
  @deprecated("Instead, use a custom `actions` property.")
  actionFocus:               js.UndefOr[String]              = js.undefined,
  /* This prop can be either a JSON object containing the actions to render (This is **DEPRECATED**),
a react elements, or an array of react elements.*/
  actions:                   js.UndefOr[ReactNode]           = js.undefined,
  /* The `className` to add to the actions container's root element.*/
  actionsContainerClassName: js.UndefOr[String]              = js.undefined,
  /* Overrides the inline-styles of the actions container's root element.*/
  actionsContainerStyle:     js.UndefOr[CssProperties]       = js.undefined,
  /* If set to true, the height of the `Dialog` will be auto detected. A max height
will be enforced so that the content does not extend beyond the viewport.*/
  autoDetectWindowHeight:    js.UndefOr[Boolean]             = js.undefined,
  /* If set to true, the body content of the `Dialog` will be scrollable.*/
  autoScrollBodyContent:     js.UndefOr[Boolean]             = js.undefined,
  /* The `className` to add to the content's root element under the title.*/
  bodyClassName:             js.UndefOr[String]              = js.undefined,
  /* Overrides the inline-styles of the content's root element under the title.*/
  bodyStyle:                 js.UndefOr[CssProperties]       = js.undefined,
  /* The css class name of the root element.*/
  className:                 js.UndefOr[String]              = js.undefined,
  /* The `className` to add to the content container.*/
  contentClassName:          js.UndefOr[String]              = js.undefined,
  /* Overrides the inline-styles of the content container.*/
  contentStyle:              js.UndefOr[CssProperties]       = js.undefined,
  /* Force the user to use one of the actions in the `Dialog`.
Clicking outside the `Dialog` will not trigger the `onRequestClose`.*/
  modal:                     js.UndefOr[Boolean]             = js.undefined,
  /* Fired when the `Dialog is requested to be closed by a click outside the `Dialog` or on the buttons.*/
  onRequestClose:            js.UndefOr[Boolean => Callback] = js.undefined,
  /* Controls whether the Dialog is opened or not.*/
  open:                      Boolean,
  /* The `className` to add to the `Overlay` component that is rendered behind the `Dialog`.*/
  overlayClassName:          js.UndefOr[String]              = js.undefined,
  /* Overrides the inline-styles of the `Overlay` component that is rendered behind the `Dialog`.*/
  overlayStyle:              js.UndefOr[CssProperties]       = js.undefined,
  /* Determines whether the `Dialog` should be repositioned when it's contents are updated.*/
  repositionOnUpdate:        js.UndefOr[Boolean]             = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:                     js.UndefOr[CssProperties]       = js.undefined,
  /* The title to display on the `Dialog`. Could be number, string, element or an array containing these types.*/
  title:                     js.UndefOr[ReactNode]           = js.undefined,
  /* The `className` to add to the title's root container element.*/
  titleClassName:            js.UndefOr[String]              = js.undefined,
  /* Overrides the inline-styles of the title's root container element.*/
  titleStyle:                js.UndefOr[CssProperties]       = js.undefined,
  /* Changes the width of the `Dialog`.*/
  width:                     js.UndefOr[Int]                 = js.undefined){
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


@js.native
class MuiDialogM extends js.Object {
  /* Deprecated: Hides the dialog.*/
  @deprecated
  def dismiss(): Unit = js.native

  /* Deprecated: Shows the dialog.*/
  @deprecated
  def show(): Unit = js.native

  /* Get the dialog open state.*/
  def isOpen(): Boolean = js.native
}
