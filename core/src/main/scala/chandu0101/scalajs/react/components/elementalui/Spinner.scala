package chandu0101.scalajs.react.components
package elementalui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.React
import japgolly.scalajs.react.vdom.VdomNode

import scala.scalajs.js

case class Spinner(
    className: js.UndefOr[String] = js.undefined,
    size: js.UndefOr[SpinnerSize] = js.undefined,
    `type`: js.UndefOr[SpinnerType] = js.undefined) {

  def apply(children: VdomNode*) = {
    val props = JSMacro[Spinner](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Eui.Spinner)
    component(props)(children: _*)
  }
}

case class SpinnerSize private (value: String) extends AnyVal
object SpinnerSize {
  val SM = SpinnerSize("sm")
  val MD = SpinnerSize("md")
  val LG = SpinnerSize("lg")
}
case class SpinnerType private (value: String) extends AnyVal
object SpinnerType {
  val DEFAULT = SpinnerType("default")
  val PRIMARY = SpinnerType("primary")
  val INVERTED = SpinnerType("inverted")
}
