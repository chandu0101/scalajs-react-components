package chandu0101.scalajs.react.components
package materialui

import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.{Date => JDate}

case class MuiDatePicker(defaultDate: U[JDate] = uNone,
                         onDismiss: U[() => Unit] = uNone,
                         onShow: U[() => Unit] = uNone,
                         style: U[js.Any] = uNone,
                         onChange: U[(JDate, JDate) => Unit] = uNone,
                         autoOk: U[Boolean] = uNone,
                         ref: U[String] = uNone,
                         maxDate: U[JDate] = uNone,
                         hintText: U[String] = uNone,
                         shouldDisableDate: U[js.Function] = uNone,
                         key: U[String] = uNone,
                         hideToolbarYearChange: U[Boolean] = uNone,
                         minDate: U[JDate] = uNone,
                         onTouchTap: U[ReactEventI => Unit] = uNone,
                         formatDate: U[JDate => String] = uNone,
                         onFocus: U[ReactEventI => Unit] = uNone,
                         mode: U[MuiDatePickerMode] = uNone,
                         showYearSelector: U[Boolean] = uNone) {

  def apply() = {
    val props = JSMacro[MuiDatePicker](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.DatePicker)
    f(props).asInstanceOf[ReactComponentU_]
  }

}

class MuiDatePickerMode(val value: String) extends AnyVal

object MuiDatePickerMode {

  val PORTRAIT = new MuiDatePickerMode("portrait")

  val LANDSCAPE = new MuiDatePickerMode("landscape")

  def newMode(mode: String) = new MuiDatePickerMode(mode)

}

@js.native
trait MuiDatePickerM extends js.Object {

  def getDate(): JDate = js.native

  def setDate(d: JDate): Unit = js.native
}