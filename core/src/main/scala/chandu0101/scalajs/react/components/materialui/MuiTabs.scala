package chandu0101.scalajs.react.components
package materialui

import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.{UndefOr, undefined}

case class MuiTabs(style: UndefOr[js.Any] = undefined,
                   onChange: UndefOr[(Int, ReactElement) => Unit] = undefined,
                   ref: UndefOr[String] = undefined,
                   key: UndefOr[String] = undefined,
                   tabWidth: UndefOr[Int] = undefined,
                   initialSelectedIndex: UndefOr[Int] = undefined) {

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiTabs](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Tabs)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
