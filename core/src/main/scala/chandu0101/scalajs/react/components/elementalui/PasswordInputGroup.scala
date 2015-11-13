package chandu0101.scalajs.react.components
package elementalui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

case class PasswordInputGroup(className: js.UndefOr[String] = js.undefined,
    alwaysValidate: js.UndefOr[Boolean] = js.undefined,
    validatePassword: js.UndefOr[String ⇒ Boolean] = js.undefined,
    invalidMessage: js.UndefOr[String] = js.undefined,
    label: js.UndefOr[String] = js.undefined,
    onChange: js.UndefOr[ReactEventI ⇒ Callback] = js.undefined,
    required: js.UndefOr[Boolean] = js.undefined,
    requiredMessage: js.UndefOr[String] = js.undefined,
    value: js.UndefOr[String] = js.undefined) {

  def apply() = {
    val props = JSMacro[PasswordInputGroup](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Eui.PasswordInputGroup)
    f(props).asInstanceOf[ReactComponentU_]
  }
}
