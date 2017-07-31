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
case class SuiHeaderContent(
    as: js.UndefOr[String | js.Function] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    ref: js.UndefOr[String] = js.undefined
) {
  def apply(children: ReactNode*) = {
    val props = JSMacro[SuiHeaderContent](this)
    ReactJS.createElement(Sui.HeaderContent, props, children: _*)
  }
}
