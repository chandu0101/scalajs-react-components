package chandu0101.scalajs.react.components.materialui

import japgolly.scalajs.react._
import materialui.Mui

import scala.scalajs.js
import scala.scalajs.js.{Date => JDate}


/**
 *
key: PropTypes.string,
    style: PropTypes.js.Any,
    ref: PropTypes.String,
    hintText: PropTypes.String,
    defaultDate: React.PropTypes.JDate,
    formatDate: React.PropTypes. JDate => String,
    mode: React.PropTypes.MuiDatePickerMode,
    onFocus: React.PropTypes. ReactEventI => Unit,
    onTouchTap: React.PropTypes.ReactEventI => Unit,
    onChange: React.PropTypes.(JDate,JDate) => Unit
    onShow: React.PropTypes.() => Unit,
    onDismiss: React.PropTypes.() => Unit,
    minDate: React.PropTypes.JDate,
    maxDate: React.PropTypes.JDate,
    shouldDisableDate: React.PropTypes.func,
    hideToolbarYearChange: React.PropTypes.bool,
    autoOk: React.PropTypes.bool,
    showYearSelector: React.PropTypes.bool
 */

object MuiDatePicker {

  def apply(defaultDate : js.UndefOr[JDate] = js.undefined,
            onDismiss : js.UndefOr[() => Unit] = js.undefined,
            onShow : js.UndefOr[() => Unit] = js.undefined,
            style : js.UndefOr[js.Any] = js.undefined,
            onChange : js.UndefOr[(JDate,JDate) => Unit] = js.undefined,
            autoOk : js.UndefOr[Boolean]=js.undefined,
            ref : js.UndefOr[String] = js.undefined,
            maxDate : js.UndefOr[JDate] = js.undefined,
            hintText : js.UndefOr[String] = js.undefined,
            shouldDisableDate : js.UndefOr[js.Function] = js.undefined ,
            key : js.UndefOr[String] = js.undefined,
            hideToolbarYearChange : js.UndefOr[Boolean]=js.undefined,
            minDate : js.UndefOr[JDate] = js.undefined,
            onTouchTap : js.UndefOr[ReactEventI => Unit] = js.undefined,
            formatDate : js.UndefOr[ JDate => String] = js.undefined,
            onFocus : js.UndefOr[ ReactEventI => Unit] = js.undefined,
            mode : js.UndefOr[MuiDatePickerMode] = js.undefined,
            showYearSelector : js.UndefOr[Boolean]=js.undefined) = {

    val p = js.Dynamic.literal()
    defaultDate.foreach(v => p.updateDynamic("defaultDate")(v))
    onDismiss.foreach(v => p.updateDynamic("onDismiss")(v))
    onShow.foreach(v => p.updateDynamic("onShow")(v))
    style.foreach(v => p.updateDynamic("style")(v))
    onChange.foreach(v => p.updateDynamic("onChange")(v))
    autoOk.foreach(v => p.updateDynamic("autoOk")(v))
    ref.foreach(v => p.updateDynamic("ref")(v))
    maxDate.foreach(v => p.updateDynamic("maxDate")(v))
    hintText.foreach(v => p.updateDynamic("hintText")(v))
    shouldDisableDate.foreach(v => p.updateDynamic("shouldDisableDate")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    hideToolbarYearChange.foreach(v => p.updateDynamic("hideToolbarYearChange")(v))
    minDate.foreach(v => p.updateDynamic("minDate")(v))
    onTouchTap.foreach(v => p.updateDynamic("onTouchTap")(v))
    formatDate.foreach(v => p.updateDynamic("formatDate")(v))
    onFocus.foreach(v => p.updateDynamic("onFocus")(v))
    mode.foreach(v => p.updateDynamic("mode")(v.mode))
    showYearSelector.foreach(v => p.updateDynamic("showYearSelector")(v))

    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.DatePicker)
    f(p).asInstanceOf[ReactComponentU_]
  }

}


class MuiDatePickerMode private(val mode: String) extends AnyVal

object MuiDatePickerMode {

  val PROTRAIT =  new MuiDatePickerMode("portrait")

  val LANDSCAPE = new MuiDatePickerMode("landscape")

  def newMode(mode: String ) = new MuiDatePickerMode(mode)

}


trait MuiDatePickerM extends js.Object {

  def getDate(): JDate = js.native

  def setDate(d: JDate): Unit = js.native
}