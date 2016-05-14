package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiStepper(
  key:         js.UndefOr[String]                 = js.undefined,
  ref:         js.UndefOr[String]                 = js.undefined,
  /* Set the active step (zero based index). This will enable `Step` control helpers.*/
  activeStep:  js.UndefOr[Double]                 = js.undefined,
  /* If set to `true`, the `Stepper` will assist in controlling steps for linear flow*/
  linear:      js.UndefOr[Boolean]                = js.undefined,
  /* The stepper orientation (layout flow direction)*/
  orientation: js.UndefOr[HorizontalVertical]     = js.undefined,
  /* Override the inline-style of the root element.*/
  style:       js.UndefOr[CssProperties]          = js.undefined){
  /**
   * @param children Should be two or more `<Step />` components
   */
  def apply(children: js.Array[ReactElement]*) = {
    val props = JSMacro[MuiStepper](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Stepper)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
