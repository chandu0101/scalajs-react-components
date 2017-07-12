

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
     

case class SuiFormButton(
     onMouseOver: js.UndefOr[ReactMouseEventB => Callback] = js.undefined,
color: js.UndefOr[SemanticCOLORS|SemanticSOCIAL] = js.undefined,
fluid: js.UndefOr[Boolean] = js.undefined,
toggle: js.UndefOr[Boolean] = js.undefined,
ref: js.UndefOr[String] = js.undefined,
labelPosition: js.UndefOr[SemanticButtonLABELPOSITIONS] = js.undefined,
onMouseDown: js.UndefOr[ReactMouseEventB => Callback] = js.undefined,
negative: js.UndefOr[Boolean] = js.undefined,
disabled: js.UndefOr[Boolean] = js.undefined,
primary: js.UndefOr[Boolean] = js.undefined,
onDragLeave: js.UndefOr[ReactDragEventB => Callback] = js.undefined,
onDragStart: js.UndefOr[ReactDragEventB => Callback] = js.undefined,
compact: js.UndefOr[Boolean] = js.undefined,
basic: js.UndefOr[Boolean] = js.undefined,
onMouseUp: js.UndefOr[ReactMouseEventB => Callback] = js.undefined,
animated: js.UndefOr[SemanticButtonANIMATED] = js.undefined,
attached: js.UndefOr[SemanticButtonATTACHED] = js.undefined,
active: js.UndefOr[Boolean] = js.undefined,
floated: js.UndefOr[SemanticFLOATS] = js.undefined,
content: js.UndefOr[VdomNode] = js.undefined,
onDoubleClick: js.UndefOr[ReactMouseEventB => Callback] = js.undefined,
onMouseEnter: js.UndefOr[ReactMouseEventB => Callback] = js.undefined,
key: js.UndefOr[String] = js.undefined,
width: Double,
`type`: js.UndefOr[String] = js.undefined,
className: js.UndefOr[String] = js.undefined,
onDragEnter: js.UndefOr[ReactDragEventB => Callback] = js.undefined,
size: js.UndefOr[SemanticSIZES] = js.undefined,
secondary: js.UndefOr[Boolean] = js.undefined,
onMouseOut: js.UndefOr[ReactMouseEventB => Callback] = js.undefined,
onClick: js.UndefOr[ReactMouseEventB => Callback] = js.undefined,
onContextMenu: js.UndefOr[ReactMouseEventB => Callback] = js.undefined,
loading: js.UndefOr[Boolean] = js.undefined,
onMouseMove: js.UndefOr[ReactMouseEventB => Callback] = js.undefined,
inverted: js.UndefOr[Boolean] = js.undefined,
onMouseLeave: js.UndefOr[ReactMouseEventB => Callback] = js.undefined,
positive: js.UndefOr[Boolean] = js.undefined,
circular: js.UndefOr[Boolean] = js.undefined,
icon: js.UndefOr[String | js.Object | VdomElement] = js.undefined,
onDragExit: js.UndefOr[ReactDragEventB => Callback] = js.undefined,
label: js.UndefOr[String | js.Object | VdomElement] = js.undefined,
onDragEnd: js.UndefOr[ReactDragEventB => Callback] = js.undefined,
onDrop: js.UndefOr[ReactDragEventB => Callback] = js.undefined,
onDragOver: js.UndefOr[ReactDragEventB => Callback] = js.undefined,
onDrag: js.UndefOr[ReactDragEventB => Callback] = js.undefined,
as: js.UndefOr[String | js.Function] = js.undefined
){
  def apply(children: VdomNode*) = {
    val props = JSMacro[SuiFormButton](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Sui.FormButton)
    component(props)(children: _*)
   }
}
     