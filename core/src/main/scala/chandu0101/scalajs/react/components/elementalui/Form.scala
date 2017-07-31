package chandu0101.scalajs.react.components
package elementalui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

case class Form(key: js.UndefOr[String] = js.undefined,
                className: js.UndefOr[String] = js.undefined,
                style: js.UndefOr[String] = js.undefined,
                `type`: js.UndefOr[FormType] = js.undefined) {

  def apply(children: ReactNode*) = {
    val props = JSMacro[Form](this)
    val f     = React.asInstanceOf[js.Dynamic].createFactory(Eui.Form)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }

}

case class FormType private (val value: String) extends AnyVal

object FormType {
  val BASIC      = FormType("basic")
  val HORIZONTAL = FormType("horizontal")
  val INLINE     = FormType("inline")
}
