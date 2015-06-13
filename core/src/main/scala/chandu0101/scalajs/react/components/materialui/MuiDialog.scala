package chandu0101.scalajs.react.components.materialui

import japgolly.scalajs.react.{React, ReactComponentU_, ReactElement, ReactNode}
import materialui.Mui

import scala.scalajs.js


/**
 * key: PropTypes.string,
    style: PropTypes.js.Any,
    ref: PropTypes.String,
    title: React.PropTypes.string,
    contentInnerStyle: React.PropTypes.js.Any,
actions: React.PropTypes.js.Array[ReactElement],
    actionFocus: React.PropTypes.string,
    contentClassName: React.PropTypes.string,
    contentStyle: React.PropTypes.js.Any,
    openImmediately: React.PropTypes.bool,
    onDismiss: React.PropTypes.() => Unit,
    onShow: React.PropTypes.() => Unit,
    repositionOnUpdate: React.PropTypes.bool,
    modal: React.PropTypes.bool
 */

case class MuiDialog(contentClassName : js.UndefOr[String] = js.undefined,
                     modal : js.UndefOr[Boolean]=js.undefined,
                     onDismiss : js.UndefOr[() => Unit] = js.undefined,
                     onShow : js.UndefOr[() => Unit] = js.undefined,
                     openImmediately : js.UndefOr[Boolean]=js.undefined,
                     style : js.UndefOr[js.Any] = js.undefined,
                     ref : js.UndefOr[String] = js.undefined,
                     key : js.UndefOr[String] = js.undefined,
                     actions : js.UndefOr[js.Array[ReactElement]] = js.undefined,
                     contentInnerStyle : js.UndefOr[js.Any] = js.undefined,
                     contentStyle : js.UndefOr[js.Any] = js.undefined,
                     title :  js.UndefOr[String] = js.undefined,
                     actionFocus : js.UndefOr[String] = js.undefined,
                     repositionOnUpdate : js.UndefOr[Boolean]=js.undefined) {
  def toJS = {
    val p = js.Dynamic.literal()
    contentClassName.foreach(v => p.updateDynamic("contentClassName")(v))
    modal.foreach(v => p.updateDynamic("modal")(v))
    onDismiss.foreach(v => p.updateDynamic("onDismiss")(v))
    onShow.foreach(v => p.updateDynamic("onShow")(v))
    openImmediately.foreach(v => p.updateDynamic("openImmediately")(v))
    style.foreach(v => p.updateDynamic("style")(v))
    ref.foreach(v => p.updateDynamic("ref")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    actions.foreach(v => p.updateDynamic("actions")(v))
    contentInnerStyle.foreach(v => p.updateDynamic("contentInnerStyle")(v))
    contentStyle.foreach(v => p.updateDynamic("contentStyle")(v))
    title.foreach(v => p.updateDynamic("title")(v))
    actionFocus.foreach(v => p.updateDynamic("actionFocus")(v))
    repositionOnUpdate.foreach(v => p.updateDynamic("repositionOnUpdate")(v))
    p
  }

  def apply(children : ReactNode*) = {
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Dialog)
    f(toJS,children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}


trait MuiDialogM extends js.Object {

  def dismiss(): Unit = js.native

  def show(): Unit = js.native
}
