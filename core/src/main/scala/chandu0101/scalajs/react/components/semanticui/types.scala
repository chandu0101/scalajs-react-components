package chandu0101.scalajs.react.components.semanticui

case class ButtonAnimatedType private (value: String) extends AnyVal
object ButtonAnimatedType {
  val fade     = ButtonAnimatedType("fade")
  val vertical = ButtonAnimatedType("vertical")
  val values   = List(fade, vertical)
}

case class SuiIconType(value: String) extends AnyVal

case class SuiCountry(value: String) extends AnyVal
