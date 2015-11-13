package chandu0101.scalajs.react.components
package elementalui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

case class FormIconField(
    className: js.UndefOr[String] = js.undefined,
    iconColor: js.UndefOr[IconColorVariant] = js.undefined,
    iconFill: js.UndefOr[IconColorVariant] = js.undefined,
    iconIsLoading: js.UndefOr[Boolean] = js.undefined,
    iconKey: js.UndefOr[Octicons] = js.undefined,
    iconPosition: js.UndefOr[FormIconFieldPosition] = js.undefined,
    htmlFor: js.UndefOr[String] = js.undefined,
    id: js.UndefOr[String] = js.undefined,
    label: js.UndefOr[String] = js.undefined,
    offsetAbsentLabel: js.UndefOr[Boolean] = js.undefined,
    width: js.UndefOr[FormFieldWidth] = js.undefined) {

  def apply(children: ReactNode*) = {
    val props = JSMacro[FormIconField](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Eui.FormIconField)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}

case class IconColorVariant private (val value: String) extends AnyVal
object IconColorVariant {
  val DANGER = IconColorVariant("danger")
  val DEFAULT = IconColorVariant("default")
  val PRIMARY = IconColorVariant("primary")
  val SUCCESS = IconColorVariant("success")
  val WARNING = IconColorVariant("warning")
}

case class FormIconFieldPosition private (val value: String) extends AnyVal
object FormIconFieldPosition {
  val LEFT = FormIconFieldPosition("left")
  val RIGHT = FormIconFieldPosition("right")
}
