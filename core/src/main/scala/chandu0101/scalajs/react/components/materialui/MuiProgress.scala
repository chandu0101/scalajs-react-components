package chandu0101.scalajs.react.components
package materialui

import japgolly.scalajs.react._
import scala.scalajs.js

case class MuiCircularProgress(size: js.UndefOr[Double] = js.undefined,
                               style: js.UndefOr[js.Any] = js.undefined,
                               min: js.UndefOr[Int] = js.undefined,
                               ref: js.UndefOr[String] = js.undefined,
                               key: js.UndefOr[String] = js.undefined,
                               max: js.UndefOr[Int] = js.undefined,
                               mode: js.UndefOr[MuiProgressMode] = js.undefined,
                               value: js.UndefOr[Int] = js.undefined) {

  def apply() = {
    val props = JSMacro[MuiCircularProgress](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.CircularProgress)
    f(props).asInstanceOf[ReactComponentU_]
  }

}

case class MuiLinearProgress(size: js.UndefOr[Double] = js.undefined,
                             style: js.UndefOr[js.Any] = js.undefined,
                             min: js.UndefOr[Int] = js.undefined,
                             ref: js.UndefOr[String] = js.undefined,
                             key: js.UndefOr[String] = js.undefined,
                             max: js.UndefOr[Int] = js.undefined,
                             mode: js.UndefOr[MuiProgressMode] = js.undefined,
                             value: js.UndefOr[Int] = js.undefined) {

  def apply() = {
    val props = JSMacro[MuiLinearProgress](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.LinearProgress)
    f(props).asInstanceOf[ReactComponentU_]
  }

}

class MuiProgressMode private(val value: String) extends AnyVal

object MuiProgressMode {

  val DETERMINATE = new MuiProgressMode("determinate")

  val INDETERMINATE = new MuiProgressMode("indeterminate")

  def newMode(mode: String) = new MuiProgressMode(mode)

}