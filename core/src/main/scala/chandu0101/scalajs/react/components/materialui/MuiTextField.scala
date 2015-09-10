package chandu0101.scalajs.react.components
package materialui

import japgolly.scalajs.react._
import scala.scalajs.js


case class MuiTextField(onBlur: js.UndefOr[ReactEventI => Unit] = js.undefined,
            multiLine: js.UndefOr[Boolean] = js.undefined,
            fullWidth: js.UndefOr[Boolean] = js.undefined,
            onEnterKeyDown: js.UndefOr[ReactEventI => Unit] = js.undefined,
            onKeyDown: js.UndefOr[ReactEventI => Unit] = js.undefined,
            style: js.UndefOr[js.Any] = js.undefined,
            onChange: js.UndefOr[ReactEventI => Unit] = js.undefined,
            ref: js.UndefOr[String] = js.undefined,
            hintText: js.UndefOr[String] = js.undefined,
            key: js.UndefOr[String] = js.undefined,
            id: js.UndefOr[String] = js.undefined,
            value: js.UndefOr[String] = js.undefined,
            defaultValue: js.UndefOr[String] = js.undefined,
            errorText: js.UndefOr[String] = js.undefined,
            onFocus: js.UndefOr[ReactEventI => Unit] = js.undefined,
            disabled: js.UndefOr[Boolean] = js.undefined,
            floatingLabelText: js.UndefOr[String] = js.undefined,
            `type`: js.UndefOr[String] = js.undefined,
            rows: js.UndefOr[Int] = js.undefined)  {

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