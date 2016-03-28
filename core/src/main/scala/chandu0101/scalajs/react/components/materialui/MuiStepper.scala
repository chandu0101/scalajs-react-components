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
  key:                         js.UndefOr[String]                                  = js.undefined,
  ref:                         js.UndefOr[String]                                  = js.undefined,
  /* Set the active step.*/
  activeStep:                  js.UndefOr[Double]                                  = js.undefined,
  /* Override the inline-style of the content container.*/
  containerStyle:              js.UndefOr[CssProperties]                           = js.undefined,
  /* Function used to set a suitable icon for the step, based on the current state of the step.
  @returns {node} - Icon that will be shown for the step.*/
  createIcon:                  js.UndefOr[js.Function]                             = js.undefined,
  /* If true, it will be horizontal stepper. Should match the step type used for `children`.*/
  horizontal:                  js.UndefOr[Boolean]                                 = js.undefined,
  /* Callback function fired when the step header is touched.*/
  onStepHeaderTouch:           js.UndefOr[(Int, js.Any) => Callback]               = js.undefined,
  /* Override the inline-style of the step header wrapper.*/
  stepHeadersWrapperStyle:     js.UndefOr[CssProperties]                           = js.undefined,
  /* Override the inline-style of the root element.*/
  style:                       js.UndefOr[CssProperties]                           = js.undefined,
  /* Callback function fired on re-render to set the background color of the icon.
  If not passed, it will use the default theme.
  @returns {string} The background color of the icon.*/
  updateAvatarBackgroundColor: js.UndefOr[js.Function]                             = js.undefined,
  /* Callback function fired on re-render to update the completed status of the step.
  @returns {boolean} `true` if the step is completed.*/
  updateCompletedStatus:       js.UndefOr[(Int, ReactNode) => CallbackTo[Boolean]] = js.undefined){
  /**
   * @param children Should be two or more `HorizontalStep` or `VerticalStep`.
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
