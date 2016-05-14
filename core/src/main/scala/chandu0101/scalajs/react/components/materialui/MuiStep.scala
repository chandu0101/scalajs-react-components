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
  key:       js.UndefOr[String]        = js.undefined,
  ref:       js.UndefOr[String]        = js.undefined,
  /* Sets the step as active. Is passed to child components.*/
  active:    js.UndefOr[Boolean]       = js.undefined,
  /* Mark the step as completed. Is passed to child components.*/
  completed: js.UndefOr[Boolean]       = js.undefined,
  /* Mark the step as disabled, will also disable the button if
  `StepButton` is a child of `Step`. Is passed to child components.*/
  disabled:  js.UndefOr[Boolean]       = js.undefined,
  /* Used internally for numbering.*/
  @deprecated("Internal API")
  index:     js.UndefOr[Double]        = js.undefined,
  /* */
  @deprecated("Internal API")
  last:      js.UndefOr[Boolean]       = js.undefined,
  /* Override the inline-style of the root element.*/
  style:     js.UndefOr[CssProperties] = js.undefined){
  /**
   * @param children Should be `Step` sub-components such as `StepLabel`.
   */
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
