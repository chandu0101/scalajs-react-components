package chandu0101.scalajs.react.components
package materialui

import japgolly.scalajs.react.{React, ReactComponentU_, ReactElement, ReactNode}
import scala.scalajs.js

case class MuiDialog(contentClassName: U[String] = uNone,
                     modal: U[Boolean]=uNone,
                     onDismiss: U[() => Unit] = uNone,
                     onShow: U[() => Unit] = uNone,
                     openImmediately: U[Boolean]=uNone,
                     style: U[js.Any] = uNone,
                     ref: U[String] = uNone,
                     key: U[String] = uNone,
                     actions: U[js.Array[ReactElement]] = uNone,
                     contentInnerStyle: U[js.Any] = uNone,
                     contentStyle: U[js.Any] = uNone,
                     title:  U[String] = uNone,
                     actionFocus: U[String] = uNone,
                     repositionOnUpdate: U[Boolean]=uNone) {

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
