package chandu0101.scalajs.react.components
package elementalui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.React
import japgolly.scalajs.react.vdom.VdomNode

import scala.scalajs.js
import scala.scalajs.js.`|`

case class FormNote(
    note: js.UndefOr[String] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    `type`: js.UndefOr[NoteType] = js.undefined) {
  def apply(children: VdomNode*) = {
    val props = JSMacro[FormNote](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Eui.FormNote)
    component(props)(children: _*)
  }
}

case class NoteType private (value: String) extends AnyVal
object NoteType {
  val DEFAULT = NoteType("default")
  val PRIMARY = NoteType("primary")
  val SUCCESS = NoteType("success")
  val WARNING = NoteType("warning")
}
