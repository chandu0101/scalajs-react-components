package chandu0101.scalajs.react.components
package elementalui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

case class FormLabel(className: js.UndefOr[String] = js.undefined,
                     htmlFor: js.UndefOr[String] = js.undefined,
                     id: js.UndefOr[String] = js.undefined,
                     verticalAlign: js.UndefOr[VerticalAlignment] = js.undefined) {

  def apply() = {
    val props = JSMacro[FormLabel](this)
    val f     = React.asInstanceOf[js.Dynamic].createFactory(Eui.FormLabel)
    f(props).asInstanceOf[ReactComponentU_]
  }
}

case class VerticalAlignment private (val value: String) extends AnyVal
object VerticalAlignment {
  val baseline    = VerticalAlignment("baseline")
  val bottom      = VerticalAlignment("bottom")
  val inherit     = VerticalAlignment("inherit")
  val initial     = VerticalAlignment("initial")
  val middle      = VerticalAlignment("middle")
  val sub         = VerticalAlignment("sub")
  val `super`     = VerticalAlignment("super")
  val text_bottom = VerticalAlignment("text-bottom")
  val text_top    = VerticalAlignment("text-top")
  val top         = VerticalAlignment("top'")
}
