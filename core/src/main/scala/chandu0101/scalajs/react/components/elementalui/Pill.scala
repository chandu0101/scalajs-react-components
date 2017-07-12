package chandu0101.scalajs.react.components
package elementalui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.React

import scala.scalajs.js
import scala.scalajs.js.`|`

//label: React.PropTypes.string.isRequired,
//		onClear: React.PropTypes.func,
//		onClick: React.PropTypes.func,
//		type: React.PropTypes.oneOf(ALERT_TYPES)

case class Pill(className: js.UndefOr[String] = js.undefined,
                label: js.UndefOr[String] = js.undefined,
                onClear: js.UndefOr[ReactEvent => Callback] = js.undefined,
                onClick: js.UndefOr[ReactEvent => Callback] = js.undefined,
                `type`: js.UndefOr[PillType] = js.undefined) {

  def apply() = {
    val props     = JSMacro[Pill](this)
    val component = JsComponent[js.Object, Children.None, Null](Eui.Pill)
    component(props)
  }
}

case class PillType private (value: String) extends AnyVal
object PillType {
  val danger           = PillType("danger")
  val default          = PillType("default")
  val info             = PillType("info")
  val primary          = PillType("primary")
  val success          = PillType("success")
  val warning          = PillType("warning")
  val danger_inverted  = PillType("danger-inverted")
  val default_inverted = PillType("default-inverted")
  val info_inverted    = PillType("info-inverted")
  val primary_inverted = PillType("primary-inverted")
  val success_inverted = PillType("success-inverted")
  val warning_inverted = PillType("warning-inverted")
}
