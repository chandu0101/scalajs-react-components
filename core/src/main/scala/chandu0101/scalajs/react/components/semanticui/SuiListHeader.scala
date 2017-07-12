

package chandu0101.scalajs.react.components
package semanticui
import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react.vdom.VdomNode
import japgolly.scalajs.react._

import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
     

case class SuiListHeader(
     ref: js.UndefOr[String] = js.undefined,
content: js.UndefOr[VdomNode] = js.undefined,
key: js.UndefOr[String] = js.undefined,
className: js.UndefOr[String] = js.undefined,
as: js.UndefOr[String | js.Function] = js.undefined
){
  def apply(children: VdomNode*) = {
    val props = JSMacro[SuiListHeader](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Sui.ListHeader)
    component(props)(children: _*)
   }
}
     