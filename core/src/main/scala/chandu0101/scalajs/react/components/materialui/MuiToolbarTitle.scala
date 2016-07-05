package chandu0101.scalajs.react.components
package materialui
import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
/**
 * This file is generated - submit issues instead of PR against it
 */
case class MuiToolbarTitle(
  key:       js.UndefOr[String]        = js.undefined,
  ref:       js.UndefOr[String]        = js.undefined,
  /* The css class name of the root element.*/
  className: js.UndefOr[String]        = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:     js.UndefOr[CssProperties] = js.undefined,
  /* The text to be displayed.*/
  text:      js.UndefOr[String]        = js.undefined){
  def apply() = {
    val props = JSMacro[MuiToolbarTitle](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.ToolbarTitle)
    f(props).asInstanceOf[ReactComponentU_]
  }
}
