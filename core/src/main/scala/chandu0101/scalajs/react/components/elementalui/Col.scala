package chandu0101.scalajs.react.components
package elementalui

import japgolly.scalajs.react._
import scala.scalajs.js

case class Col(
    key: U[String] = uNone,
    className: U[String] = uNone,
    basis: U[ColBasis] = uNone,
    gutter: U[Int] = uNone,
    style: U[String] = uNone,
    lg: U[String] = uNone,
    md: U[String] = uNone,
    sm: U[String] = uNone,
    xs: U[String] = uNone) {

  def apply(children: ReactNode*) = {
    val props = JSMacro[Col](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Eui.Col)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }

}

case class ColBasis private (val value: String) extends AnyVal

object ColBasis {
  val number = ColBasis("number")
  val string = ColBasis("string")
}
