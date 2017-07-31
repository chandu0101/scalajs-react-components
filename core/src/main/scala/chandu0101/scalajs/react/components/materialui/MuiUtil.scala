package chandu0101.scalajs.react.components.materialui

import scala.scalajs.js

@js.native
trait MuiUtil extends js.Object {
  val CssEvent: js.Dynamic               = js.native
  val Dom: js.Dynamic                    = js.native
  val Events: js.Dynamic                 = js.native
  val KeyCode: js.Dynamic                = js.native
  val KeyLine: js.Dynamic                = js.native
  val ColorManipulator: ColorManipulator = js.native
  val Extend: js.Dynamic                 = js.native
  val UniqueId: js.Dynamic               = js.native
}

@js.native
trait ColorManipulator extends js.Object {
  def fade(color: MuiColor, amount: Double): MuiColor    = js.native
  def lighten(color: MuiColor, amount: Double): MuiColor = js.native
  def darken(color: MuiColor, amount: Double): MuiColor  = js.native
  def contrastRatio(background: MuiColor, foreground: MuiColor): Double =
    js.native
  def contrastRatioLevel(background: MuiColor, foreground: MuiColor): String =
    js.native
}
