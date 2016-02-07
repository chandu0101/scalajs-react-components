package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiStep(
  key:                             js.UndefOr[String]                    = js.undefined,
  ref:                             js.UndefOr[String]                    = js.undefined,
  /* Override the inline-styles of div which contains all the children include control button groups.*/
  childrenWrapperStyle:            js.UndefOr[CssProperties]             = js.undefined,
  /* Override the inline-styles of connector line.*/
  connectorLineStyle:              js.UndefOr[CssProperties]             = js.undefined,
  /* An array of node for handling moving or canceling steps.*/
  controlButtonsGroup:             js.UndefOr[js.Array[ReactNode]]       = js.undefined,
  /* Override the inline-styles of div wrapper which contains control buttons group.*/
  controlButtonsGroupWrapperStyle: js.UndefOr[CssProperties]             = js.undefined,
  /* If true, the step is active.*/
  @deprecated("Internal API")
  isActive:                        js.UndefOr[Boolean]                   = js.undefined,
  /* If true, the step is completed.*/
  @deprecated("Internal API")
  isCompleted:                     js.UndefOr[Boolean]                   = js.undefined,
  /* If true, the step is the last one.*/
  @deprecated("Internal API")
  isLastStep:                      js.UndefOr[Boolean]                   = js.undefined,
  /* If true, the header of step is hovered.*/
  @deprecated("Internal API")
  isStepHeaderHovered:             js.UndefOr[Boolean]                   = js.undefined,
  /* Callback function that is fired when the header of step is hovered.*/
  @deprecated("Internal API")
  onStepHeaderHover:               js.UndefOr[Int => Callback]           = js.undefined,
  /* Callback function that is fired when the header of step is touched.*/
  @deprecated("Internal API")
  onStepHeaderTouch:               js.UndefOr[(Int, js.Any) => Callback] = js.undefined,
  /* The index of the furthest optional step.*/
  @deprecated("Internal API")
  previousStepOptionalIndex:       js.UndefOr[Double]                    = js.undefined,
  /* Override the inline-styles of step container which contains connector line and children.*/
  stepContainerStyle:              js.UndefOr[CssProperties]             = js.undefined,
  /* Override the inline-styles of step header view (not include left avatar).*/
  stepHeaderStyle:                 js.UndefOr[CssProperties]             = js.undefined,
  /* Override the inline-styles of step header wrapper (include left avatar).*/
  stepHeaderWrapperStyle:          js.UndefOr[CssProperties]             = js.undefined,
  /* The index of step in array of Steps.*/
  @deprecated("Internal API")
  stepIndex:                       js.UndefOr[Double]                    = js.undefined,
  /* Customize the step label view.*/
  stepLabel:                       js.UndefOr[ReactNode]                 = js.undefined){

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiStep](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Step)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
