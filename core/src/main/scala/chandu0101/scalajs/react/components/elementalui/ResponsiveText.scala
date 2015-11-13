package chandu0101.scalajs.react.components
package elementalui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

case class XXXResponsiveText(
    className: js.UndefOr[String] = js.undefined) {

  def apply() = {
    val props = JSMacro[XXXResponsiveText](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Eui.ResponsiveText)
    f(props).asInstanceOf[ReactComponentU_]
  }
}
