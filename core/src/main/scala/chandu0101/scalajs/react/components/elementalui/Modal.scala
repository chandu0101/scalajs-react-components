package chandu0101.scalajs.react.components.elementalui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

case class Modal(
    className: js.UndefOr[String] = js.undefined,
    backdropClosesModal: js.UndefOr[Boolean] = js.undefined,
    isOpen: js.UndefOr[Boolean] = js.undefined,
    onCancel: js.UndefOr[ReactEventH => Callback] = js.undefined,
    width: js.UndefOr[String | Int] = js.undefined) {

  def apply(children: ReactNode*) = {
    val props = JSMacro[Modal](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Eui.Modal)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}

case class ModalWidth private (val value: String) extends AnyVal

object ModalWidth {
  val SMALL = ModalWidth("small")
  val MEDIUM = ModalWidth("medium")
  val LARGE = ModalWidth("large")
}
