package chandu0101.scalajs.react.components
package elementalui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

case class ModalHeader(
    className: js.UndefOr[String] = js.undefined,
    showCloseButton: js.UndefOr[Boolean] = js.undefined,
    text: js.UndefOr[String] = js.undefined,
    onClose: js.UndefOr[ReactEventH => Callback] = js.undefined) {

  def apply(children: ReactNode*) = {
    val props = JSMacro[ModalHeader](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Eui.ModalHeader)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
