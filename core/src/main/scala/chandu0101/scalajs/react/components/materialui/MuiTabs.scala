package chandu0101.scalajs.react.components
package materialui

import japgolly.scalajs.react._
import scala.scalajs.js

case class MuiTabs(style: U[js.Any] = uNone,
                   onChange: U[(Int, ReactElement) => Callback] = uNone,
                   ref: U[String] = uNone,
                   key: U[String] = uNone,
                   tabWidth: U[Int] = uNone,
                   initialSelectedIndex: U[Int] = uNone) {

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiTabs](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Tabs)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
