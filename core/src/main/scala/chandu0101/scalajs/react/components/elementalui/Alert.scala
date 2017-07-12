package chandu0101.scalajs.react.components
package elementalui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.React
import japgolly.scalajs.react.vdom.VdomNode

import scala.scalajs.js
import scala.scalajs.js.`|`

case class Alert(
    className: js.UndefOr[String] = js.undefined,
    `type`: js.UndefOr[AlertType] = js.undefined) {

  def apply(children: VdomNode*) = {
    val props = JSMacro[Alert](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Eui.Alert)
    component(props)(children: _*)
  }
}

case class AlertType private (value: String) extends AnyVal
object AlertType {
  val INFO = AlertType("info")
  val PRIMARY = AlertType("primary")
  val SUCCESS = AlertType("success")
  val WARNING = AlertType("warning")
  val DANGER = AlertType("danger")
}
