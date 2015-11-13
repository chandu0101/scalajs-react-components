package chandu0101.scalajs.react.components
package elementalui

import japgolly.scalajs.react._
import scala.scalajs.js

case class Glyph(
    icon: U[Octicons],
    key: U[String] = uNone,
    className: U[String] = uNone,
    `type`: U[GlyphType] = uNone) {
  def apply(children: ReactNode*) = {
    val props = JSMacro[Glyph](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Eui.Glyph)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}

case class GlyphType private (val value: String) extends AnyVal

object GlyphType {
  val DEFAULT = GlyphType("default")
  val DANGER = GlyphType("danger")
  val MUTED = GlyphType("muted")
  val PRIMARY = GlyphType("primary")
  val SUCCESS = GlyphType("success")
  val WARNING = GlyphType("warning")

  val values = List(DEFAULT, DANGER, MUTED, PRIMARY, SUCCESS, WARNING)
}
