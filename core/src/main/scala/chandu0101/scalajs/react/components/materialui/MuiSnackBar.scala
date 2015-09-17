package chandu0101.scalajs.react.components
package materialui

import japgolly.scalajs.react._
import scala.scalajs.js

case class MuiSnackBar(openOnMount: U[Boolean] = uNone,
                       style: U[js.Any] = uNone,
                       ref: U[String] = uNone,
                       key: U[String] = uNone,
                       onActionTouchTap: U[ReactEvent => Unit] = uNone,
                       message: String,
                       action: U[String] = uNone) {

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