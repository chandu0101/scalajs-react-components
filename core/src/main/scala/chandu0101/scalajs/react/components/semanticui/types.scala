package chandu0101.scalajs.react.components.semanticui

import chandu0101.macros.tojs.JSMacro
import scala.scalajs.js

case class ButtonAnimatedType private (value: String) extends AnyVal
object ButtonAnimatedType {
  val fade     = ButtonAnimatedType("fade")
  val vertical = ButtonAnimatedType("vertical")
  val values   = List(fade, vertical)
}

case class PointingDirection private (value: String) extends AnyVal
object PointingDirection {
  val left = PointingDirection("left")
  val right = PointingDirection("right")
  val top = PointingDirection("top")
  val top_left = PointingDirection("top left")
  val top_right = PointingDirection("top right")
  val bottom = PointingDirection("bottom")
  val bottom_left = PointingDirection("bottom left")
  val bottom_right = PointingDirection("bottom right")
}

case class SuiIconType(value: String) extends AnyVal

case class SuiCountry(value: String) extends AnyVal

@js.native
trait SuiRateObject extends js.Object {
  def rating: Int = js.native
  def maxRating: Int = js.native
}

@js.native
trait PaginationEventData extends js.Object {
  def activePage: Int = js.native
}

@js.native
trait SuiDropDownOption extends js.Object {
  def key: String = js.native
  def text: String = js.native
  def value: String = js.native
}

@js.native
trait SuiDropdownChangeObject extends js.Object {
  def value: String = js.native
}

object SuiDropDownOption {
  def apply(key: String, text: String, value: String): SuiDropDownOption = {
    js.Dynamic.literal(key = key, text = text, value = value).asInstanceOf[SuiDropDownOption]
  }
  def apply(str: String): SuiDropDownOption = {
    js.Dynamic.literal(key = str, text = str, value = str).asInstanceOf[SuiDropDownOption]
  }
}

class SuiHorizontallyOrVertically(val value: String) extends AnyVal
object SuiHorizontallyOrVertically {
  val horizontally = new Left("horizontally")
  val vertically = new Left("vertically")
  val values = List(horizontally, vertically)
}

class SuiFormFieldControlType(val value: String) extends AnyVal
object SuiFormFieldControlType {
  val button = new Left("button")
  val input = new Left("input")
  val select = new Left("select")
  val textarea = new Left("textarea")
  val values = List(button, input, select, textarea)
}

class SuiModalDimmer(val value: String) extends AnyVal
object SuiModalDimmer {
  val inverted = new Left("inverted")
  val blurring = new Left("blurring")
  val values = List(inverted, blurring)
}

class SuiFourDirections(val value: String) extends AnyVal
object SuiFourDirections {
  val left = new Left("left")
  val right = new Left("right")
  val bottom = new Left("bottom")
  val top = new Left("top")
  val values = List(left, right, bottom, top)
}
