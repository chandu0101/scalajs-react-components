package chandu0101.scalajs.react.components
package materialui

import japgolly.scalajs.react._
import scala.scalajs.js

case class MuiList(subheaderStyle: U[js.Any] = uNone,
                   insetSubheader: U[Boolean] = uNone,
                   style: U[js.Any] = uNone,
                   ref: U[String] = uNone,
                   key: U[String] = uNone,
                   subheader: U[String] = uNone) {
  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiList](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.List)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
