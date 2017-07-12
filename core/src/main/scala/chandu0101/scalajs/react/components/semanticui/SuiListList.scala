

package chandu0101.scalajs.react.components
package semanticui
import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.VdomNode

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.JSName

/**
 * This file is generated - submit issues instead of PR against it
 */
     

case class SuiListList(
     as: js.UndefOr[String | js.Function] = js.undefined,
className: js.UndefOr[String] = js.undefined,
key: js.UndefOr[String] = js.undefined,
ref: js.UndefOr[String] = js.undefined
){
  def apply(children: VdomNode*) = {
    val props = JSMacro[SuiListList](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Sui.ListList)
    component(props)(children: _*)
   }
}
     