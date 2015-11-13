package chandu0101.scalajs.react.components
package elementalui

import japgolly.scalajs.react._
import scala.scalajs.js

case class FormInput(
    autofocus: U[Boolean] = uNone,
    className: U[String] = uNone,
    disabled: U[Boolean] = uNone,
    href: U[String] = uNone,
    placeholder: U[String] = uNone,
    id: U[String] = uNone,
    multiline: U[Boolean] = uNone,
    name: U[String] = uNone,
    noedit: U[Boolean] = uNone,
    onChange: U[ReactEventH ⇒ Callback] = uNone,
    size: U[FormInputSize] = uNone,
    `type`: U[String] = uNone,
    value: U[String] = uNone) {

  def apply() = {
    val props = JSMacro[FormInput](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Eui.FormInput)
    f(props).asInstanceOf[ReactComponentU_]
  }
}

case class FormInputSize private (val value: String) extends AnyVal

object FormInputSize {
  val LG = FormInputSize("lg")
  val SM = FormInputSize("sm")
  val XS = FormInputSize("xs")
}
