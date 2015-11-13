package chandu0101.scalajs.react.components
package elementalui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

object FormSelect {
  case class Option(label: String, value: String) {
    val toJS = JSMacro[Option](this)
  }
  object Option {
    def fromJson(obj: js.Dynamic) = Option(label = obj.text.toString, value = obj.payload.toString)
  }
}

case class FormSelect(
    className: js.UndefOr[String] = js.undefined,
    alwaysValidate: js.UndefOr[Boolean] = js.undefined,
    disabled: js.UndefOr[Boolean] = js.undefined,
    firstOption: js.UndefOr[String] = js.undefined,
    htmFor: js.UndefOr[String] = js.undefined,
    id: js.UndefOr[String] = js.undefined,
    lable: js.UndefOr[String] = js.undefined,
    options: js.Array[FormSelect.Option] = js.Array(),
    prependEmptyOption: js.UndefOr[Boolean] = js.undefined,
    onChange: js.UndefOr[ReactEventI ⇒ Callback] = js.undefined,
    required: js.UndefOr[Boolean] = js.undefined,
    requiredMessage: js.UndefOr[String] = js.undefined,
    value: js.UndefOr[String] = js.undefined) {
  def apply(children: ReactNode*) = {
    val props = JSMacro[FormSelect](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Eui.FormSelect)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
