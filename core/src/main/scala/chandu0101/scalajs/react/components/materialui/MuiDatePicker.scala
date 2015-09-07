package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import materialui.Mui

import scala.scalajs.js
import scala.scalajs.js.{Date => JDate}


case class MuiDatePicker(defaultDate: js.UndefOr[JDate] = js.undefined,
                         onDismiss: js.UndefOr[() => Unit] = js.undefined,
                         onShow: js.UndefOr[() => Unit] = js.undefined,
                         style: js.UndefOr[js.Any] = js.undefined,
                         onChange: js.UndefOr[(JDate, JDate) => Unit] = js.undefined,
                         autoOk: js.UndefOr[Boolean] = js.undefined,
                         ref: js.UndefOr[String] = js.undefined,
                         maxDate: js.UndefOr[JDate] = js.undefined,
                         hintText: js.UndefOr[String] = js.undefined,
                         shouldDisableDate: js.UndefOr[js.Function] = js.undefined,
                         key: js.UndefOr[String] = js.undefined,
                         hideToolbarYearChange: js.UndefOr[Boolean] = js.undefined,
                         minDate: js.UndefOr[JDate] = js.undefined,
                         onTouchTap: js.UndefOr[ReactEventI => Unit] = js.undefined,
                         formatDate: js.UndefOr[JDate => String] = js.undefined,
                         onFocus: js.UndefOr[ReactEventI => Unit] = js.undefined,
                         mode: js.UndefOr[MuiDatePickerMode] = js.undefined,
                         showYearSelector: js.UndefOr[Boolean] = js.undefined) {

  def apply() = {
    val props = JSMacro[MuiDatePicker](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.DatePicker)
    f(props).asInstanceOf[ReactComponentU_]
  }

}


class MuiDatePickerMode(val value: String) extends AnyVal

object MuiDatePickerMode {

  val PROTRAIT = new MuiDatePickerMode("portrait")

  val LANDSCAPE = new MuiDatePickerMode("landscape")

  def newMode(mode: String) = new MuiDatePickerMode(mode)

}


@js.native
trait MuiDatePickerM extends js.Object {

  def getDate(): JDate = js.native

  def setDate(d: JDate): Unit = js.native
}