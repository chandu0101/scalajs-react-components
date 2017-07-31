package chandu0101.scalajs.react.components
package elementalui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

case class Alert(className: js.UndefOr[String] = js.undefined,
                 `type`: js.UndefOr[AlertType] = js.undefined) {

  def apply(children: ReactNode*) = {
    val props = JSMacro[Alert](this)
    val f     = React.asInstanceOf[js.Dynamic].createFactory(Eui.Alert)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}

case class AlertType private (val value: String) extends AnyVal
object AlertType {
  val INFO    = AlertType("info")
  val PRIMARY = AlertType("primary")
  val SUCCESS = AlertType("success")
  val WARNING = AlertType("warning")
  val DANGER  = AlertType("danger")
}
