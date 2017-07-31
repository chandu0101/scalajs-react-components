package chandu0101.scalajs.react.components
package elementalui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

case class Row(key: js.UndefOr[String] = js.undefined,
               className: js.UndefOr[String] = js.undefined,
               gutter: js.UndefOr[Int] = js.undefined,
               style: js.UndefOr[String] = js.undefined) {

  def apply(children: ReactNode*) = {
    val props = JSMacro[Row](this)
    val f     = React.asInstanceOf[js.Dynamic].createFactory(Eui.Row)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }

}
