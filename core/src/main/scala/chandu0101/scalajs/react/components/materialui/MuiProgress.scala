package chandu0101.scalajs.react.components
package materialui

import japgolly.scalajs.react._
import scala.scalajs.js

case class MuiCircularProgress(size: U[Double] = uNone,
                               style: U[js.Any] = uNone,
                               min: U[Int] = uNone,
                               ref: U[String] = uNone,
                               key: U[String] = uNone,
                               max: U[Int] = uNone,
                               mode: U[MuiProgressMode] = uNone,
                               value: U[Int] = uNone) {

  def apply() = {
    val props = JSMacro[MuiCircularProgress](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.CircularProgress)
    f(props).asInstanceOf[ReactComponentU_]
  }

}

case class MuiLinearProgress(size: U[Double] = uNone,
                             style: U[js.Any] = uNone,
                             min: U[Int] = uNone,
                             ref: U[String] = uNone,
                             key: U[String] = uNone,
                             max: U[Int] = uNone,
                             mode: U[MuiProgressMode] = uNone,
                             value: U[Int] = uNone) {

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