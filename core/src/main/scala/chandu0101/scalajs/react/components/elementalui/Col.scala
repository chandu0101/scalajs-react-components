package chandu0101.scalajs.react.components
package elementalui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

case class Col(
    key: js.UndefOr[String] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    basis: js.UndefOr[ColBasis] = js.undefined,
    gutter: js.UndefOr[Int] = js.undefined,
    style: js.UndefOr[String] = js.undefined,
    lg: js.UndefOr[String] = js.undefined,
    md: js.UndefOr[String] = js.undefined,
    sm: js.UndefOr[String] = js.undefined,
    xs: js.UndefOr[String] = js.undefined) {

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
