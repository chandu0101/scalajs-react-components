package chandu0101.scalajs.react.components
package elementalui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.React
import japgolly.scalajs.react.vdom.VdomNode

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

  def apply(children: VdomNode*) = {
    val props = JSMacro[Col](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Eui.Col)
    component(props)(children: _*)
  }

}

case class ColBasis private (value: String) extends AnyVal

object ColBasis {
  val number = ColBasis("number")
  val string = ColBasis("string")
}
