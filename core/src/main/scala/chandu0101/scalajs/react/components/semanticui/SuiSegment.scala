package chandu0101.scalajs.react.components
package semanticui
import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.JSName

/**
  * This file is generated - submit issues instead of PR against it
  */
case class SuiSegment(
    textAlign: js.UndefOr[SemanticTEXTALIGNMENTS] = js.undefined,
    color: js.UndefOr[SemanticCOLORS | SemanticSOCIAL] = js.undefined,
    padded: js.UndefOr[Boolean] = js.undefined,
    ref: js.UndefOr[String] = js.undefined,
    disabled: js.UndefOr[Boolean] = js.undefined,
    compact: js.UndefOr[Boolean] = js.undefined,
    basic: js.UndefOr[Boolean] = js.undefined,
    attached: js.UndefOr[js.Any] = js.undefined,
    floated: js.UndefOr[SemanticFLOATS] = js.undefined,
    tertiary: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    stacked: js.UndefOr[Boolean] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    size: js.UndefOr[SemanticSIZES] = js.undefined,
    raised: js.UndefOr[Boolean] = js.undefined,
    secondary: js.UndefOr[Boolean] = js.undefined,
    loading: js.UndefOr[Boolean] = js.undefined,
    inverted: js.UndefOr[Boolean] = js.undefined,
    vertical: js.UndefOr[SemanticVERTICALALIGNMENTS] = js.undefined,
    circular: js.UndefOr[Boolean] = js.undefined,
    clearing: js.UndefOr[Boolean] = js.undefined,
    piled: js.UndefOr[Boolean] = js.undefined,
    as: js.UndefOr[String | js.Function] = js.undefined
) {
  def apply(children: ReactNode*) = {
    val props = JSMacro[SuiSegment](this)
    ReactJS.createElement(Sui.Segment, props, children: _*)
  }
}
