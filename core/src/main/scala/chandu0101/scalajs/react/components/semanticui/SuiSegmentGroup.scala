

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
     

case class SuiSegmentGroup(
     horizontal: js.UndefOr[Boolean] = js.undefined,
ref: js.UndefOr[String] = js.undefined,
compact: js.UndefOr[Boolean] = js.undefined,
key: js.UndefOr[String] = js.undefined,
stacked: js.UndefOr[Boolean] = js.undefined,
className: js.UndefOr[String] = js.undefined,
size: js.UndefOr[SemanticSIZES] = js.undefined,
raised: js.UndefOr[Boolean] = js.undefined,
piled: js.UndefOr[Boolean] = js.undefined,
as: js.UndefOr[String | js.Function] = js.undefined
){
  def apply(children: VdomNode*) = {
    val props = JSMacro[SuiSegmentGroup](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Sui.SegmentGroup)
    component(props)(children: _*)
   }
}
     