

package chandu0101.scalajs.react.components
package semanticui
import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.{VdomElement, VdomNode}

import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
     

case class SuiHeader(
     textAlign: js.UndefOr[SemanticTEXTALIGNMENTS] = js.undefined,
subheader: js.UndefOr[js.Any] = js.undefined,
dividing: js.UndefOr[Boolean] = js.undefined,
ref: js.UndefOr[String] = js.undefined,
block: js.UndefOr[Boolean] = js.undefined,
disabled: js.UndefOr[Boolean] = js.undefined,
sub: js.UndefOr[Boolean] = js.undefined,
floated: js.UndefOr[SemanticFLOATS] = js.undefined,
content: js.UndefOr[VdomNode] = js.undefined,
image: js.UndefOr[String | VdomElement] = js.undefined,
key: js.UndefOr[String] = js.undefined,
attached: js.UndefOr[SemanticHeaderATTACHED] = js.undefined,
className: js.UndefOr[String] = js.undefined,
size: js.UndefOr[SemanticSIZES] = js.undefined,
inverted: js.UndefOr[Boolean] = js.undefined,
icon: js.UndefOr[String | js.Object | VdomElement] = js.undefined,
color: js.UndefOr[SemanticCOLORS] = js.undefined,
as: js.UndefOr[String | js.Function] = js.undefined
){
  def apply(children: VdomNode*) = {
    val props = JSMacro[SuiHeader](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Sui.Header)
    component(props)(children: _*)
  }
}
     