package chandu0101.scalajs.react.components
package materialui

import japgolly.scalajs.react._
import scala.scalajs.js

case class MuiSvgIcon(key: U[String] = uNone,
                      style: U[js.Any] = uNone,
                      ref: U[String] = uNone,
                      viewBox: U[String] = uNone) {

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiSvgIcon](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.SvgIcon)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
