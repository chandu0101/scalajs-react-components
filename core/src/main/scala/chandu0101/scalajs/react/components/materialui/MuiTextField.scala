package chandu0101.scalajs.react.components.materialui

import japgolly.scalajs.react._
import materialui.Mui

import scala.scalajs.js

/**
 * key: PropTypes.string,
style: PropTypes.js.Any,
ref: PropTypes.String,
 errorText: React.PropTypes.string,
    floatingLabelText: React.PropTypes.string,
    hintText: React.PropTypes.string,
    id: React.PropTypes.string,
    multiLine: React.PropTypes.bool,
    disabled: React.PropTypes.bool,
    fullWidth: React.PropTypes.bool,
    onBlur: React.PropTypes.ReactEventI => Unit,
    onChange: React.PropTypes.ReactEventI => Unit,
    onFocus: React.PropTypes.ReactEventI => Unit,
    onKeyDown: React.PropTypes.ReactEventI => Unit,
    onEnterKeyDown: React.PropTypes.ReactEventI => Unit,
    type: React.PropTypes.string,
    rows: React.PropTypes.number,
    value :React.PropTypes.string,
    defaultValue:React.PropTypes.string

 */


object MuiTextField {

  def apply[T](onBlur: js.UndefOr[ReactEventI => Unit] = js.undefined,
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
            value: js.UndefOr[T] = js.undefined,
            defaultValue: js.UndefOr[T] = js.undefined,
            errorText: js.UndefOr[String] = js.undefined,
            onFocus: js.UndefOr[ReactEventI => Unit] = js.undefined,
            disabled: js.UndefOr[Boolean] = js.undefined,
            floatingLabelText: js.UndefOr[String] = js.undefined,
            `type`: js.UndefOr[String] = js.undefined,
            rows: js.UndefOr[Int] = js.undefined) = {

    val p = js.Dynamic.literal()
    onBlur.foreach(v => p.updateDynamic("onBlur")(v))
    multiLine.foreach(v => p.updateDynamic("multiLine")(v))
    fullWidth.foreach(v => p.updateDynamic("fullWidth")(v))
    onEnterKeyDown.foreach(v => p.updateDynamic("onEnterKeyDown")(v))
    onKeyDown.foreach(v => p.updateDynamic("onKeyDown")(v))
    style.foreach(v => p.updateDynamic("style")(v))
    onChange.foreach(v => p.updateDynamic("onChange")(v))
    ref.foreach(v => p.updateDynamic("ref")(v))
    hintText.foreach(v => p.updateDynamic("hintText")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    id.foreach(v => p.updateDynamic("id")(v))
    value.foreach(v => p.updateDynamic("value")(v.asInstanceOf[js.Any]))
    defaultValue.foreach(v => p.updateDynamic("defaultValue")(v.asInstanceOf[js.Any]))
    errorText.foreach(v => p.updateDynamic("errorText")(v))
    onFocus.foreach(v => p.updateDynamic("onFocus")(v))
    disabled.foreach(v => p.updateDynamic("disabled")(v))
    floatingLabelText.foreach(v => p.updateDynamic("floatingLabelText")(v))
    `type`.foreach(v => p.updateDynamic("type")(v))
    rows.foreach(v => p.updateDynamic("rows")(v))

    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.TextField)
    f(p).asInstanceOf[ReactComponentU_]
  }

}


trait MuiTextFieldM[T] extends js.Object {

  def blur(): Unit = js.native

  def clearValue(): Unit = js.native

  def focus(): Unit = js.native

  def getValue(): T = js.native

  def setValue(newValue: T): Unit = js.native

}