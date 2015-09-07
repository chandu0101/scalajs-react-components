package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react.{React, ReactComponentU_, ReactElement, ReactNode}
import materialui.Mui

import scala.scalajs.js


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

  def apply(children : ReactNode*) = {
    val props = JSMacro[MuiDialog](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Dialog)
    f(props,children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}


@js.native
trait MuiDialogM extends js.Object {

  def dismiss(): Unit = js.native

  def show(): Unit = js.native
}
