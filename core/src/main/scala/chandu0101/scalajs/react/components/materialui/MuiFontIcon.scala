package chandu0101.scalajs.react.components
package materialui

import japgolly.scalajs.react._
import scala.scalajs.js

case class MuiFontIcon(style: U[js.Any] = uNone,
                       ref: U[String] = uNone,
                       key: U[String] = uNone,
                       className: U[String] = uNone,
                       hoverColor: U[String] = uNone) {

  def apply() = {
    val props = JSMacro[MuiFontIcon](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.FontIcon)
    f(props).asInstanceOf[ReactComponentU_]
  }

}
