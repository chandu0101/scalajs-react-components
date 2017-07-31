package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro

import scala.scalajs.js

class Vertical(val value: String) extends AnyVal
object Vertical {
  val top    = new Vertical("top")
  val center = new Vertical("center")
  val bottom = new Vertical("bottom")
  val values = List(top, center, bottom)
}

class Horizontal(val value: String) extends AnyVal
object Horizontal {
  val left   = new Horizontal("left")
  val middle = new Horizontal("middle")
  val right  = new Horizontal("right")
  val values = List(left, middle, right)
}

case class Origin(vertical: Vertical, horizontal: Horizontal) {
  val toJS = JSMacro[Origin](this)
}

class ZDepth(val value: Int) extends AnyVal
object ZDepth {
  val _0 = new ZDepth(0)
  val _1 = new ZDepth(1)
  val _2 = new ZDepth(2)
  val _3 = new ZDepth(3)
  val _4 = new ZDepth(4)
  val _5 = new ZDepth(5)
}

class Corners(val value: String) extends AnyVal
object Corners {
  val bottom_left  = new Corners("bottom-left")
  val bottom_right = new Corners("bottom-right")
  val top_left     = new Corners("top-left")
  val top_right    = new Corners("top-right")
  val values       = List(bottom_left, bottom_right, top_left, top_right)
}

class CornersAndCenter(val value: String) extends AnyVal
object CornersAndCenter {
  val bottom_center = new CornersAndCenter("bottom-center")
  val bottom_left   = new CornersAndCenter("bottom-left")
  val bottom_right  = new CornersAndCenter("bottom-right")
  val top_center    = new CornersAndCenter("top-center")
  val top_left      = new CornersAndCenter("top-left")
  val top_right     = new CornersAndCenter("top-right")
  val values        = List(bottom_center, bottom_left, bottom_right, top_center, top_left, top_right)
}

@js.native
trait HasValue[T] extends js.Object {
  def value: js.UndefOr[T] = js.native
}
