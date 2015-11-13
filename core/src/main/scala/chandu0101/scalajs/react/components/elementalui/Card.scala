package chandu0101.scalajs.react.components
package elementalui

import japgolly.scalajs.react._
import scala.scalajs.js

case class Card(
    key: U[String] = uNone,
    className: U[String] = uNone,
    style: U[String] = uNone) {

  def apply(children: ReactNode*) = {
    val props = JSMacro[Card](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Eui.Card)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }

}
