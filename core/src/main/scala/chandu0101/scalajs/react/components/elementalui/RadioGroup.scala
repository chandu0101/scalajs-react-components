package chandu0101.scalajs.react.components
package elementalui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

case class RadioGroup(className: js.UndefOr[String] = js.undefined,
                      name: js.UndefOr[String] = js.undefined,
                      alwaysValidate: js.UndefOr[Boolean] = js.undefined,
                      `inline`: js.UndefOr[Boolean] = js.undefined,
                      label: js.UndefOr[String] = js.undefined,
                      onChange: js.UndefOr[String => Callback] = js.undefined,
                      options: js.Array[SelectOption] = js.Array(),
                      required: js.UndefOr[Boolean] = js.undefined,
                      requiredMessage: js.UndefOr[String] = js.undefined,
                      value: js.UndefOr[String] = js.undefined) {

  def apply() = {
    val props = JSMacro[RadioGroup](this)
    val f     = React.asInstanceOf[js.Dynamic].createFactory(Eui.RadioGroup)
    f(props).asInstanceOf[ReactComponentU_]
  }
}
