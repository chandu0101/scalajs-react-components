package chandu0101.scalajs.react.components
package materialui

import japgolly.scalajs.react._
import scala.scalajs.js

case class MuiTab(style: U[js.Any] = uNone,
                  label: U[String] = uNone,
                  onActive: U[ReactElement => Unit] = uNone,
                  ref: U[String] = uNone,
                  key: U[String] = uNone,
                  route: U[String] = uNone) {

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiTab](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Tab)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
