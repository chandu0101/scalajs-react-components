package chandu0101.scalajs.react.components
package elementalui

import japgolly.scalajs.react._
import scala.scalajs.js

case class Row(
    key: U[String] = uNone,
    className: U[String] = uNone,
    gutter: U[Int] = uNone,
    style: U[String] = uNone) {

  def apply(children: ReactNode*) = {
    val props = JSMacro[Row](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Eui.Row)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }

}
