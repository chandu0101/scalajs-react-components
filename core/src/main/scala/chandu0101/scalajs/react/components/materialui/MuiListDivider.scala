package chandu0101.scalajs.react.components
package materialui

import japgolly.scalajs.react._
import scala.scalajs.js

case class MuiListDivider(key: U[String] = uNone,
                          style: U[js.Any] = uNone,
                          ref: U[String] = uNone,
                          inset: U[Boolean] = uNone) {

  def apply() = {
    val props = JSMacro[MuiListDivider](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.ListDivider)
    f(props).asInstanceOf[ReactComponentU_]
  }

}
