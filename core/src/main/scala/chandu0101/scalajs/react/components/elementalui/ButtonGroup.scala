package chandu0101.scalajs.react.components
package elementalui

import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.{ Array ⇒ JArray }

case class ButtonGroup(
    className: U[String] = uNone) {

  def apply(children: ReactNode*) = {
    val props = JSMacro[ButtonGroup](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Eui.ButtonGroup)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }

}
