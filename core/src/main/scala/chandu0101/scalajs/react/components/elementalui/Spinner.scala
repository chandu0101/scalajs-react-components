package chandu0101.scalajs.react.components
package elementalui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

case class Spinner(className: js.UndefOr[String] = js.undefined,
                   size: js.UndefOr[SpinnerSize] = js.undefined,
                   `type`: js.UndefOr[SpinnerType] = js.undefined) {

  def apply(children: ReactNode*) = {
    val props = JSMacro[Spinner](this)
    val f     = React.asInstanceOf[js.Dynamic].createFactory(Eui.Spinner)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}

case class SpinnerSize private (val value: String) extends AnyVal
object SpinnerSize {
  val SM = SpinnerSize("sm")
  val MD = SpinnerSize("md")
  val LG = SpinnerSize("lg")
}
case class SpinnerType private (val value: String) extends AnyVal
object SpinnerType {
  val DEFAULT  = SpinnerType("default")
  val PRIMARY  = SpinnerType("primary")
  val INVERTED = SpinnerType("inverted")
}
