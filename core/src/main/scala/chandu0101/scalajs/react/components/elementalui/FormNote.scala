package chandu0101.scalajs.react.components
package elementalui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

case class FormNote(note: js.UndefOr[String] = js.undefined,
                    className: js.UndefOr[String] = js.undefined,
                    `type`: js.UndefOr[NoteType] = js.undefined) {
  def apply(children: ReactNode*) = {
    val props = JSMacro[FormNote](this)
    val f     = React.asInstanceOf[js.Dynamic].createFactory(Eui.FormNote)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}

case class NoteType private (val value: String) extends AnyVal
object NoteType {
  val DEFAULT = NoteType("default")
  val PRIMARY = NoteType("primary")
  val SUCCESS = NoteType("success")
  val WARNING = NoteType("warning")
}
