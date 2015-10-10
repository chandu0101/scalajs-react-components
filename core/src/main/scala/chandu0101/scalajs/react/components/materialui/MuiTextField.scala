package chandu0101.scalajs.react.components
package materialui

import japgolly.scalajs.react._
import scala.scalajs.js

case class MuiTextField(onBlur: U[ReactEventI => Callback] = uNone,
            multiLine: U[Boolean] = uNone,
            fullWidth: U[Boolean] = uNone,
            onEnterKeyDown: U[ReactEventI => Callback] = uNone,
            onKeyDown: U[ReactEventI => Callback] = uNone,
            style: U[js.Any] = uNone,
            onChange: U[ReactEventI => Callback] = uNone,
            ref: U[MuiTextFieldM => Unit] = uNone,
            hintText: U[String] = uNone,
            key: U[String] = uNone,
            id: U[String] = uNone,
            value: U[String] = uNone,
            defaultValue: U[String] = uNone,
            errorText: U[String] = uNone,
            onFocus: U[ReactEventI => Callback] = uNone,
            disabled: U[Boolean] = uNone,
            floatingLabelText: U[String] = uNone,
            `type`: U[String] = uNone,
            rows: U[Int] = uNone)  {

  def apply() = {
    val props = JSMacro[MuiTextField](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.TextField)
    f(props).asInstanceOf[ReactComponentU_]
  }

}

@js.native
trait MuiTextFieldM extends js.Object {

  def blur(): Unit = js.native

  def clearValue(): Unit = js.native

  def focus(): Unit = js.native

  def getValue(): String = js.native

  def setValue(newValue: String): Unit = js.native

}