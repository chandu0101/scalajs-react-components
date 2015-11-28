
package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
  
case class MuiSnackbar(
	key:              js.UndefOr[String]                         = js.undefined,
	ref:              js.UndefOr[MuiSnackbarM => Unit]           = js.undefined,
	/*  The name of the action on the snackbar.*/
	action:           js.UndefOr[String]                         = js.undefined,
	/*  The number of milliseconds to wait before automatically dismissing. If no value is specified the snackbar will dismiss normally. If a value is provided the snackbar can still be dismissed normally. If a snackbar is dismissed before the timer expires, the timer will be cleared.*/
	autoHideDuration: js.UndefOr[Int]                            = js.undefined,
	/*  Override the inline-styles of the Snackbar's body element.*/
	bodyStyle:        js.UndefOr[CssProperties]                  = js.undefined,
	/* required: The message to be displayed on the snackbar.*/
	message:          String,
	/* default: false: If true, the snackbar will open once mounted.*/
	openOnMount:      js.UndefOr[Boolean]                        = js.undefined,
	/*  Override the inline-styles of the Snackbar's root element.*/
	style:            js.UndefOr[CssProperties]                  = js.undefined,
	/* function(event): Fired when the action button is touchtapped.*/
	onActionTouchTap: js.UndefOr[ReactTouchEventH => Callback]   = js.undefined,
	/* function(): Fired when the snackbar is dismissed.*/
	onDismiss:        js.UndefOr[Callback]                       = js.undefined,
	/* function(): Fired when the snackbar is shown.*/
	onShow:           js.UndefOr[Callback]                       = js.undefined)
{

  def apply() = {
    val props = JSMacro[MuiSnackbar](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Snackbar)
    f(props).asInstanceOf[ReactComponentU_]
  }
}
    


@js.native
class MuiSnackbarM extends js.Object{
	/* Snackbar.dismiss(): Hides the snackbar.*/
	def dismiss(): Unit = js.native

	/* Snackbar.show(): Shows the snackbar.*/
	def show(): Unit = js.native
}
