package chandu0101.scalajs.react.components
package elementalui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.React

import scala.scalajs.js
import scala.scalajs.js.`|`

//		className: React.PropTypes.string,
//		color: React.PropTypes.oneOf(['danger', 'default', 'muted', 'primary', 'success', 'warning']),
//		fill: React.PropTypes.oneOf(['danger', 'default', 'muted', 'primary', 'success', 'warning']),
//		icon: React.PropTypes.string,
//		isLoading: React.PropTypes.bool,
//		type: React.PropTypes.string
case class FormIcon(className: js.UndefOr[String] = js.undefined,
                    color: js.UndefOr[IconColorVariant] = js.undefined,
                    fill: js.UndefOr[IconColorVariant] = js.undefined,
                    icon: js.UndefOr[Octicons] = js.undefined,
                    isloading: js.UndefOr[Boolean] = js.undefined,
                    `type`: js.UndefOr[String]) {

  def apply() = {
    val props     = JSMacro[FormIcon](this)
    val component = JsComponent[js.Object, Children.None, Null](Eui.FormIcon)
    component(props)
  }
}
