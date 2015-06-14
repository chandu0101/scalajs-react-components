package chandu0101.scalajs.react.components.materialui

import japgolly.scalajs.react._
import materialui.Mui

import scala.scalajs.js
import scala.scalajs.js.{Date => JDate}


/**
 * key: PropTypes.string,
style: PropTypes.js.Any,
ref: PropTypes.String,
hintText: PropTypes.String,
 defaultTime: React.PropTypes.JDate,
    format: React.PropTypes.MuiTimePickerFormat,
    onFocus: React.PropTypes.ReactEventI => Unit,
    onTouchTap: React.PropTypes.ReactEventI => Unit,
    onChange: React.PropTypes.(JDate,JDate) => Unit,
    onShow: React.PropTypes.() => Unit,
    onDismiss: React.PropTypes.() => Unit,
 */
object MuiTimePicker {

  def apply(format: js.UndefOr[MuiTimePickerFormat] = js.undefined,
            onDismiss: js.UndefOr[() => Unit] = js.undefined,
            onShow: js.UndefOr[() => Unit] = js.undefined,
            style: js.UndefOr[js.Any] = js.undefined,
            onChange: js.UndefOr[(JDate, JDate) => Unit] = js.undefined,
            ref: js.UndefOr[String] = js.undefined,
            hintText: js.UndefOr[String] = js.undefined,
            key: js.UndefOr[String] = js.undefined,
            defaultTime: js.UndefOr[JDate] = js.undefined,
            onTouchTap: js.UndefOr[ReactEventI => Unit] = js.undefined,
            onFocus: js.UndefOr[ReactEventI => Unit] = js.undefined) = {

    val p = js.Dynamic.literal()
    format.foreach(v => p.updateDynamic("format")(v.format))
    onDismiss.foreach(v => p.updateDynamic("onDismiss")(v))
    onShow.foreach(v => p.updateDynamic("onShow")(v))
    style.foreach(v => p.updateDynamic("style")(v))
    onChange.foreach(v => p.updateDynamic("onChange")(v))
    ref.foreach(v => p.updateDynamic("ref")(v))
    hintText.foreach(v => p.updateDynamic("hintText")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    defaultTime.foreach(v => p.updateDynamic("defaultTime")(v))
    onTouchTap.foreach(v => p.updateDynamic("onTouchTap")(v))
    onFocus.foreach(v => p.updateDynamic("onFocus")(v))

    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.TimePicker)
    f(p).asInstanceOf[ReactComponentU_]
  }

}


class MuiTimePickerFormat private(val format: String) extends AnyVal

object MuiTimePickerFormat {

  val AM_PM = new MuiTimePickerFormat("ampm")

  val TWENTY_FOUR_HOUR = new MuiTimePickerFormat("24hr")

  def newFormat(format: String) = new MuiTimePickerFormat(format)

}