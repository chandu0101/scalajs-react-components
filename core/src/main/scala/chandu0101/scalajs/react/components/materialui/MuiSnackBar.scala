package chandu0101.scalajs.react.components.materialui

import japgolly.scalajs.react._
import materialui.Mui

import scala.scalajs.js

object MuiSnackBar {

  def apply(openOnMount: js.UndefOr[Boolean] = js.undefined,
            style: js.UndefOr[js.Any] = js.undefined,
            ref: js.UndefOr[String] = js.undefined,
            key: js.UndefOr[String] = js.undefined,
            onActionTouchTap: js.UndefOr[ReactEvent => Unit] = js.undefined,
            message: String,
            action: js.UndefOr[String] = js.undefined) = {

    val p = js.Dynamic.literal()
    openOnMount.foreach(v => p.updateDynamic("openOnMount")(v))
    style.foreach(v => p.updateDynamic("style")(v))
    ref.foreach(v => p.updateDynamic("ref")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    onActionTouchTap.foreach(v => p.updateDynamic("onActionTouchTap")(v))
    p.updateDynamic("message")(message)
    action.foreach(v => p.updateDynamic("action")(v))

    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Snackbar)
    f(p).asInstanceOf[ReactComponentU_]
  }

}

trait MuiSnackBarM extends js.Object {

  def dismiss(): Unit = js.native

  def show(): Unit = js.native

}