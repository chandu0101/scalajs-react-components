package chandu0101.scalajs.react.components
package elementalui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.React
import japgolly.scalajs.react.vdom.VdomNode

import scala.scalajs.js

case class Glyph(icon: js.UndefOr[Octicons],
                 key: js.UndefOr[String] = js.undefined,
                 className: js.UndefOr[String] = js.undefined,
                 `type`: js.UndefOr[GlyphType] = js.undefined) {
  def apply(children: VdomNode*) = {
    val props     = JSMacro[Glyph](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Eui.Glyph)
    component(props)(children: _*)
  }
}

case class GlyphType private (value: String) extends AnyVal

object GlyphType {
  val DEFAULT = GlyphType("default")
  val DANGER  = GlyphType("danger")
  val MUTED   = GlyphType("muted")
  val PRIMARY = GlyphType("primary")
  val SUCCESS = GlyphType("success")
  val WARNING = GlyphType("warning")

  val values = List(DEFAULT, DANGER, MUTED, PRIMARY, SUCCESS, WARNING)
}
