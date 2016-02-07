package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiSnackbar(
  key:              js.UndefOr[String]                       = js.undefined,
  ref:              js.UndefOr[MuiSnackbarM => Unit]         = js.undefined,
  /* The label for the action on the snackbar.*/
  action:           js.UndefOr[String]                       = js.undefined,
  /* The number of milliseconds to wait before automatically dismissing.
If no value is specified the snackbar will dismiss normally.
If a value is provided the snackbar can still be dismissed normally.
If a snackbar is dismissed before the timer expires, the timer will be cleared.*/
  autoHideDuration: js.UndefOr[Int]                          = js.undefined,
  /* Override the inline-styles of the body element.*/
  bodyStyle:        js.UndefOr[CssProperties]                = js.undefined,
  /* The css class name of the root element.*/
  className:        js.UndefOr[String]                       = js.undefined,
  /* The message to be displayed.*/
  message:          ReactNode,
  /* Fired when the action button is touchtapped.
@param {object} event Action button event.*/
  onActionTouchTap: js.UndefOr[ReactTouchEventH => Callback] = js.undefined,
  /* Fired when the `Snackbar` is dismissed.*/
  @deprecated("Instead, use the open property to control the component.")
  onDismiss:        js.UndefOr[Callback]                     = js.undefined,
  /* Fired when the `Snackbar` is requested to be closed by a click outside the `Snackbar`, or after the
`autoHideDuration` timer expires.
Typically `onRequestClose` is used to set state in the parent component, which is used to control the `Snackbar`
`open` prop.
The `reason` parameter can optionally be used to control the response to `onRequestClose`,
for example ignoring `clickaway`.
@param {string} reason Can be:`"timeout"` (`autoHideDuration` expired) or: `"clickaway"`*/
  onRequestClose:   String => Callback,
  /* Fired when the `Snackbar` is shown.*/
  @deprecated("Instead, use the open property to control the component.")
  onShow:           js.UndefOr[Callback]                     = js.undefined,
  /* Controls whether the `Snackbar` is opened or not.*/
  open:             Boolean,
  /* If true, the `Snackbar` will open once mounted.*/
  @deprecated("Instead, use the open property to control the component.")
  openOnMount:      js.UndefOr[Boolean]                      = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:            js.UndefOr[CssProperties]                = js.undefined){

  def apply() = {
    val props = JSMacro[MuiSnackbar](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Snackbar)
    f(props).asInstanceOf[ReactComponentU_]
  }
}
        


@js.native
class MuiSnackbarM extends js.Object {
  /* Hides the snackbar.*/
  def dismiss(): Unit = js.native

  /* Shows the snackbar.*/
  def show(): Unit = js.native
}
