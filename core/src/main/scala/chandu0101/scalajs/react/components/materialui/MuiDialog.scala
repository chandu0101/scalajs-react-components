
package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
  
case class MuiDialog(
	key:                    js.UndefOr[String]                   = js.undefined,
	ref:                    js.UndefOr[MuiDialogM => Unit]       = js.undefined,
	/*  The ref of the action to focus on when the dialog is displayed.*/
	actionFocus:            js.UndefOr[String]                   = js.undefined,
	/*  This prop can be either a JSON object containing the actions to render, or an array of react objects.*/
	actions:                js.UndefOr[js.Array[ReactElement]]   = js.undefined,
	/* default: true: If set to true, the height of the dialog will be auto detected. A max height will be enforced so that the content does not extend beyond the viewport.*/
	autoDetectWindowHeight: js.UndefOr[Boolean]                  = js.undefined,
	/* default: false: If set to true, the body content of the dialog will be scrollable.*/
	autoScrollBodyContent:  js.UndefOr[Boolean]                  = js.undefined,
	/*  Overrides the inline-styles of the dialog container under the title.*/
	bodyStyle:              js.UndefOr[CssProperties]            = js.undefined,
	/*  The className to add to the dialog window content container. This is the Paper element that is seen when the dialog is shown.*/
	contentClassName:       js.UndefOr[String]                   = js.undefined,
	/*  Overrides the inline-styles of the dialog window content container.*/
	contentStyle:           js.UndefOr[CssProperties]            = js.undefined,
	/* default: false: Set to true to have the dialog automatically open on mount.*/
	defaultOpen:            js.UndefOr[Boolean]                  = js.undefined,
	/* default: false: Force the user to use one of the actions in the dialog. Clicking outside the dialog will not dismiss the dialog.*/
	modal:                  js.UndefOr[Boolean]                  = js.undefined,
	/* default: null: Controls whether the Dialog is opened or not.*/
	open:                   js.UndefOr[Boolean]                  = js.undefined,
	/* default: false: Deprecated: Set to true to have the dialog automatically open on mount.*/
	@deprecated
	openImmediately:        js.UndefOr[Boolean]                  = js.undefined,
	/*  Override the inline-styles of the dialog's root element.*/
	style:                  js.UndefOr[CssProperties]            = js.undefined,
	/*  The title to display on the dialog. Could be number, string, element or an array containing these types.*/
	title:                  js.UndefOr[ReactNode]                = js.undefined,
	/* function(): Deprecated: Fired when the dialog is dismissed.*/
	@deprecated
	onDismiss:              js.UndefOr[Callback]                 = js.undefined,
	/* function(): Deprecated: Fired when the dialog is shown.*/
	@deprecated
	onShow:                 js.UndefOr[Callback]                 = js.undefined,
	/* function(buttonClicked): Fired when the dialog is requested to be closed by a click outside the dialog or on the buttons.*/
	onRequestClose:         js.UndefOr[Boolean => Callback]      = js.undefined,
	titleStyle:             js.UndefOr[CssProperties]            = js.undefined,
	repositionOnUpdate:     js.UndefOr[Boolean]                  = js.undefined)
{

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiDialog](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Dialog)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}


@js.native
class MuiDialogM extends js.Object{
	/* Dialog.dismiss(): Deprecated: Hides the dialog.*/
	@deprecated
	def dismiss(): Unit = js.native

	/* Dialog.show(): Deprecated: Shows the dialog.*/
	@deprecated
	def show(): Unit = js.native

	/* Dialog.isOpen(): Get the dialog open state.*/
	def isOpen(): Boolean = js.native
}
