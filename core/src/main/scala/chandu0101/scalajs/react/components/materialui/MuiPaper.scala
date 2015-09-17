package chandu0101.scalajs.react.components
package materialui

import japgolly.scalajs.react._
import scala.scalajs.js

case class MuiPaper(circle: U[Boolean] = uNone,
                    style: U[js.Any] = uNone,
                    rounded: U[Boolean] = uNone,
                    ref: U[String] = uNone,
                    transitionEnabled: U[Boolean] = uNone,
                    zDepth: U[Int] = uNone,
                    key: U[String] = uNone) {

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiPaper](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Paper)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
