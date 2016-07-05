package chandu0101.scalajs.react.components
package materialui
import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
/**
 * This file is generated - submit issues instead of PR against it
 */
case class MuiStepLabel(
  key:       js.UndefOr[String]                         = js.undefined,
  ref:       js.UndefOr[MuiStepLabelM => Unit]          = js.undefined,
  /* Sets active styling. Overrides disabled coloring.*/
  active:    js.UndefOr[Boolean]                        = js.undefined,
  /* Sets completed styling. Overrides disabled coloring.*/
  completed: js.UndefOr[Boolean]                        = js.undefined,
  /* Sets disabled styling.*/
  disabled:  js.UndefOr[Boolean]                        = js.undefined,
  /* The icon displayed by the step label.*/
  icon:      js.UndefOr[ReactElement | String | Double] = js.undefined,
  /* Override the inline-style of the root element.*/
  style:     js.UndefOr[CssProperties]                  = js.undefined){
  /**
   * @param children The label text node
   */
  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiStepLabel](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.StepLabel)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}


@js.native
class MuiStepLabelM extends js.Object {
  def renderIcon(completed: js.Any, icon: js.Any, styles: js.Any): js.Any = js.native
}
