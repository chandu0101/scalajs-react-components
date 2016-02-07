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
  key:                         js.UndefOr[String]                       = js.undefined,
  ref:                         js.UndefOr[String]                       = js.undefined,
  /* The current active step index which passed by parent component.*/
  activeStepIndex:             js.UndefOr[Double]                       = js.undefined,
  /* Override inline-style of the content container.*/
  containerStyle:              js.UndefOr[CssProperties]                = js.undefined,
  /* Function used to create suitable icon for step base on state of the step.
  @returns {node} - which will be shown in the left avatar.*/
  createIcon:                  js.UndefOr[js.Function]                  = js.undefined,
  /* If true, it will be horizontal stepper.*/
  horizontal:                  js.UndefOr[Boolean]                      = js.undefined,
  /* Callback function that is fired when the header of step is touched.*/
  onStepHeaderTouch:           js.UndefOr[(Int, js.Any) => Callback]    = js.undefined,
  /* Overrie inline-style of the step header wrapper.*/
  stepHeadersWrapperStyle:     js.UndefOr[CssProperties]                = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:                       js.UndefOr[CssProperties]                = js.undefined,
  /* Callback function that is fired when re-render to update the background of left avatar.
  If not passed, it will use default theme
  @returns {string} the background color of avatar*/
  updateAvatarBackgroundColor: js.UndefOr[js.Function]                  = js.undefined,
  /* Callback function that is fired  when re-render to update complete status of Step.
  @returns {boolean} `true` if the step is completed.*/
  updateCompletedStatusOfStep: js.UndefOr[(Int, ReactNode) => Callback] = js.undefined){
  /**
   * @param children Children should be Step type.
   */
  def apply(children: ReactNode*) = {
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
