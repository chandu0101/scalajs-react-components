package chandu0101.scalajs.react.components
package elementalui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

case class FormInput(autofocus: js.UndefOr[Boolean] = js.undefined,
                     className: js.UndefOr[String] = js.undefined,
                     label: js.UndefOr[String] = js.undefined,
                     ref: js.UndefOr[String] = js.undefined,
                     disabled: js.UndefOr[Boolean] = js.undefined,
                     required: js.UndefOr[Boolean] = js.undefined,
                     href: js.UndefOr[String] = js.undefined,
                     placeholder: js.UndefOr[String] = js.undefined,
                     id: js.UndefOr[String] = js.undefined,
                     multiline: js.UndefOr[Boolean] = js.undefined,
                     name: js.UndefOr[String] = js.undefined,
                     pattern: js.UndefOr[String] = js.undefined,
                     noedit: js.UndefOr[Boolean] = js.undefined,
                     onChange: js.UndefOr[ReactEventI => Callback] = js.undefined,
                     size: js.UndefOr[FormInputSize] = js.undefined,
                     `type`: js.UndefOr[String] = js.undefined,
                     value: js.UndefOr[String | Int] = js.undefined) {

  def apply() = {
    val props = JSMacro[FormInput](this)
    val f     = React.asInstanceOf[js.Dynamic].createFactory(Eui.FormInput)
    f(props).asInstanceOf[ReactComponentU_]
  }
}

case class FormInputSize private (val value: String) extends AnyVal

object FormInputSize {
  val LG = FormInputSize("lg")
  val SM = FormInputSize("sm")
  val XS = FormInputSize("xs")
}
