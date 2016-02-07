package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._

import scala.scalajs.js

case class MuiDivider(
  key: js.UndefOr[String]   = js.undefined,
  ref: js.UndefOr[String]   = js.undefined,
  /**
   * CSS class that will be added to the divider's root element
   */
  className: js.UndefOr[String] = js.undefined,

  /**
   * If true, the divider will be indented 72px
   */
  inset: js.UndefOr[Boolean] = js.undefined,
  /**
   * Override the inline-styles of the list divider's root element
   */
  style: js.UndefOr[CssProperties] = js.undefined)
{

  def apply() = {
    val props = JSMacro[MuiDivider](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Divider)
    f(props).asInstanceOf[ReactComponentU_]
  }
}
    
