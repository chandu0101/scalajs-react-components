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
case class SuiDivider(
    hidden: js.UndefOr[Boolean] = js.undefined,
    section: js.UndefOr[Boolean] = js.undefined,
    horizontal: js.UndefOr[Boolean] = js.undefined,
    vertical: js.UndefOr[Boolean] = js.undefined,
    ref: js.UndefOr[String] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    fitted: js.UndefOr[Boolean] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    inverted: js.UndefOr[Boolean] = js.undefined,
    clearing: js.UndefOr[Boolean] = js.undefined,
    as: js.UndefOr[String | js.Function] = js.undefined
) {
  def apply(children: ReactNode*) = {
    val props = JSMacro[SuiDivider](this)
    ReactJS.createElement(Sui.Divider, props, children: _*)
  }
}
