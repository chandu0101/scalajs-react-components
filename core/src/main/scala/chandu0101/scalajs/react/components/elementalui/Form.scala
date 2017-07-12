package chandu0101.scalajs.react.components
package elementalui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.React
import japgolly.scalajs.react.vdom.VdomNode

import scala.scalajs.js

case class Form(
    key: js.UndefOr[String] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    style: js.UndefOr[String] = js.undefined,
    `type`: js.UndefOr[FormType] = js.undefined) {

  def apply(children: VdomNode*) = {
    val props = JSMacro[Form](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Eui.Form)
    component(props)(children: _*)
  }

}

case class FormType private (value: String) extends AnyVal

object FormType {
  val BASIC = FormType("basic")
  val HORIZONTAL = FormType("horizontal")
  val INLINE = FormType("inline")
}
