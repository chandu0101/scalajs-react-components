package chandu0101.scalajs.react.components
package elementalui

import japgolly.scalajs.react._
import scala.scalajs.js

object InputGroup {
  case class Section(
      className: U[String] = uNone,
      `type`: U[String] = uNone,
      grow: U[Boolean] = uNone
      ) {
    def apply(children: ReactNode*) = {
      val props = JSMacro[Section](this)
      val f = React.asInstanceOf[js.Dynamic].createFactory(Eui.InputGroupSection)
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
    }
  }
}

case class InputGroup(
    className: U[String] = uNone,
    contiguous: U[Boolean] = uNone) {
  def apply(children: ReactNode*) = {
    val props = JSMacro[InputGroup](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Eui.InputGroup)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }

}
