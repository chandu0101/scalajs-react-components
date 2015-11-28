package chandu0101.scalajs.react.components
package elementalui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

case class Pagination(
    className: js.UndefOr[String] = js.undefined,
    currentPage: js.UndefOr[Int] = js.undefined,
    onPageSelect: js.UndefOr[Int => Callback] = js.undefined,
    pageSize: js.UndefOr[Int] = js.undefined,
    plural: js.UndefOr[String] = js.undefined,
    singular: js.UndefOr[String] = js.undefined,
    total: js.UndefOr[Int] = js.undefined,
    limit: js.UndefOr[Int] = js.undefined) {

  def apply() = {
    val props = JSMacro[Pagination](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Eui.Pagination)
    f(props).asInstanceOf[ReactComponentU_]
  }
}
