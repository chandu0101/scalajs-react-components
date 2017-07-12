

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
     

case class SuiLabelGroup(
     ref: js.UndefOr[String] = js.undefined,
circular: Boolean,
key: js.UndefOr[String] = js.undefined,
className: js.UndefOr[String] = js.undefined,
size: js.UndefOr[SemanticSIZES] = js.undefined,
tag: js.UndefOr[Boolean] = js.undefined,
color: js.UndefOr[SemanticCOLORS] = js.undefined,
as: js.UndefOr[String | js.Function] = js.undefined
){
  def apply(children: VdomNode*) = {
    val props = JSMacro[SuiLabelGroup](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Sui.LabelGroup)
    component(props)(children: _*)
   }
}
     