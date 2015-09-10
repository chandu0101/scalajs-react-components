package chandu0101.scalajs.react.components
package materialui

import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.{Date => JDate}

case class MuiTimePicker(format: js.UndefOr[MuiTimePickerFormat] = js.undefined,
                         onDismiss: js.UndefOr[() => Unit] = js.undefined,
                         onShow: js.UndefOr[() => Unit] = js.undefined,
                         style: js.UndefOr[js.Any] = js.undefined,
                         onChange: js.UndefOr[(JDate, JDate) => Unit] = js.undefined,
                         ref: js.UndefOr[String] = js.undefined,
                         hintText: js.UndefOr[String] = js.undefined,
                         key: js.UndefOr[String] = js.undefined,
                         defaultTime: js.UndefOr[JDate] = js.undefined,
                         onTouchTap: js.UndefOr[ReactEventI => Unit] = js.undefined,
                         onFocus: js.UndefOr[ReactEventI => Unit] = js.undefined) {

  def apply() = {
    val props = JSMacro[MuiTimePicker](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.TimePicker)
    f(props).asInstanceOf[ReactComponentU_]
  }

}

case class MuiTimePickerFormat(val value: String) extends AnyVal

object MuiTimePickerFormat {

  val AM_PM = new MuiTimePickerFormat("ampm")

  val TWENTY_FOUR_HOUR = new MuiTimePickerFormat("24hr")

  def newFormat(format: String) = new MuiTimePickerFormat(format)
}