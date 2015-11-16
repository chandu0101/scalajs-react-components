package chandu0101.scalajs.react.components
package elementalui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

case class SegmentedControl(
    equalWidthSegments: js.UndefOr[String] = js.undefined,
    onChange: js.UndefOr[String] = js.undefined,
    options: js.Array[SelectOption] = js.Array(),
    `type`: js.UndefOr[GlyphType] = js.undefined,
    value: js.UndefOr[String] = js.undefined) {

  def apply() = {
    val props = JSMacro[SegmentedControl](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Eui.SegmentedControl)
    f(props).asInstanceOf[ReactComponentU_]
  }
}
