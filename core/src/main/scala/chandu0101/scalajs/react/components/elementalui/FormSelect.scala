package chandu0101.scalajs.react.components
package elementalui

import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.{ Array ⇒ JArray }

object FormSelect {
  case class Option(label: String, value: String) {
    val toJS = JSMacro[Option](this)
  }
  object Option {
    def fromJson(obj: js.Dynamic) = Option(label = obj.text.toString, value = obj.payload.toString)
  }
}

case class FormSelect(
    className: U[String] = uNone,
    alwaysValidate: U[Boolean] = uNone,
    disabled: U[Boolean] = uNone,
    firstOption: U[String] = uNone,
    htmFor: U[String] = uNone,
    id: U[String] = uNone,
    lable: U[String] = uNone,
    options: JArray[FormSelect.Option] = JArray(),
    prependEmptyOption: U[Boolean] = uNone,
    onChange: U[ReactEventI ⇒ Callback] = uNone,
    required: U[Boolean] = uNone,
    requiredMessage: U[String] = uNone,
    value: U[String] = uNone) {
  def apply(children: ReactNode*) = {
    val props = JSMacro[FormSelect](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Eui.FormSelect)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
