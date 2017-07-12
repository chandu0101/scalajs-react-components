package chandu0101.scalajs.react.components
package elementalui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.React

import scala.scalajs.js
import scala.scalajs.js.`|`

//		className: React.PropTypes.string,
//		label: React.PropTypes.string,
//		labelActive: React.PropTypes.string,
//		onDrop: React.PropTypes.func.isRequired
case class FileDragAndDrop(
    className: js.UndefOr[String] = js.undefined,
    label: js.UndefOr[String] = js.undefined,
    labelActive: js.UndefOr[String] = js.undefined,
    files: js.Array[File] = js.Array(),
    onDrop: js.UndefOr[js.Array[File] => Callback] = js.undefined) {

  def apply() = {
    val props = JSMacro[FileDragAndDrop](this)
    val component = JsComponent[js.Object, Children.None, Null](Eui.FileDragAndDrop)
    component(props)
  }
}
