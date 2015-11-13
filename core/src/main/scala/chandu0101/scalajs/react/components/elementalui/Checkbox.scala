package chandu0101.scalajs.react.components
package elementalui

import japgolly.scalajs.react._
import scala.scalajs.js

case class CheckBox(
    className: U[String] = uNone,
    disabled: U[Boolean] = uNone,
    autofocus: U[Boolean] = uNone,
    indeterminate: U[Boolean] = uNone,
    inline: U[Boolean] = uNone,
    label: U[String] = uNone,
    style: U[String] = uNone,
    title: U[String] = uNone,
    onclick: U[ReactEventH ⇒ Callback] = uNone,
    ondblclick: U[ReactEventH ⇒ Callback] = uNone) {

  def apply() = {
    val props = JSMacro[CheckBox](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Eui.Checkbox)
    f(props).asInstanceOf[ReactComponentU_]
  }

}
