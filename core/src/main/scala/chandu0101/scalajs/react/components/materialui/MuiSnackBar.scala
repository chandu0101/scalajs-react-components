package chandu0101.scalajs.react.components
package materialui

import japgolly.scalajs.react._
import scala.scalajs.js

case class MuiSnackBar(openOnMount: js.UndefOr[Boolean] = js.undefined,
                       style: js.UndefOr[js.Any] = js.undefined,
                       ref: js.UndefOr[String] = js.undefined,
                       key: js.UndefOr[String] = js.undefined,
                       onActionTouchTap: js.UndefOr[ReactEvent => Unit] = js.undefined,
                       message: String,
                       action: js.UndefOr[String] = js.undefined) {

  def apply() = {
    val props = JSMacro[MuiSnackBar](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Snackbar)
    f(props).asInstanceOf[ReactComponentU_]
  }

}

@js.native
trait MuiSnackBarM extends js.Object {

  def dismiss(): Unit = js.native

  def show(): Unit = js.native

}