package chandu0101.scalajs.react.components
package materialui
import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
/**
 * This file is generated - submit issues instead of PR against it
 */
case class MuiStepContent(
  key:      js.UndefOr[String]        = js.undefined,
  ref:      js.UndefOr[String]        = js.undefined,
  /* Expands the content*/
  active:   js.UndefOr[Boolean]       = js.undefined,
  /* */
  @deprecated("Internal API")
  last:     js.UndefOr[Boolean]       = js.undefined,
  /* Override the inline-style of the root element.*/
  style:    js.UndefOr[CssProperties] = js.undefined){
  /**
   * @param children Step content
   */
  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiStepContent](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.StepContent)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
