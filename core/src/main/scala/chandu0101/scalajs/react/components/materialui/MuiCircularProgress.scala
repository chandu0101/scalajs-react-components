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
