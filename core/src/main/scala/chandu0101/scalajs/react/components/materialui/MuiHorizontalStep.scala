package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiHorizontalStep(
  key:                    js.UndefOr[String]                    = js.undefined,
  ref:                    js.UndefOr[String]                    = js.undefined,
  /* The width of step header, unit is % which passed from Stepper.*/
  @deprecated("Internal API")
  headerWidth:            js.UndefOr[String]                    = js.undefined,
  /* If true, the step is active.*/
  @deprecated("Internal API")
  isActive:               js.UndefOr[Boolean]                   = js.undefined,
  /* If true, the step is completed.*/
  @deprecated("Internal API")
  isCompleted:            js.UndefOr[Boolean]                   = js.undefined,
  /* If true, the step is the first step.*/
  @deprecated("Internal API")
  isFirstStep:            js.UndefOr[Boolean]                   = js.undefined,
  /* If true, the step is the last step.*/
  @deprecated("Internal API")
  isLastStep:             js.UndefOr[Boolean]                   = js.undefined,
  /* If true, the step header is hovered.*/
  @deprecated("Internal API")
  isStepHeaderHovered:    js.UndefOr[Boolean]                   = js.undefined,
  /* Callback function will be called when step header is hovered.*/
  @deprecated("Internal API")
  onStepHeaderHover:      js.UndefOr[Int => Callback]           = js.undefined,
  /* Call back function will be called when step header is touched.*/
  @deprecated("Internal API")
  onStepHeaderTouch:      js.UndefOr[(Int, js.Any) => Callback] = js.undefined,
  /* Override inline-style of step header wrapper.*/
  stepHeaderWrapperStyle: js.UndefOr[CssProperties]             = js.undefined,
  /* The index of step in array of Steps.*/
  @deprecated("Internal API")
  stepIndex:              js.UndefOr[Double]                    = js.undefined,
  /* The label of step which be shown in step header.*/
  stepLabel:              js.UndefOr[ReactNode]                 = js.undefined){

  def apply() = {
    val props = JSMacro[MuiHorizontalStep](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.HorizontalStep)
    f(props).asInstanceOf[ReactComponentU_]
  }
}
        
