package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.React
import japgolly.scalajs.react.vdom.{VdomElement, VdomNode}

import scala.scalajs.js

/**
  * This file is generated - submit issues instead of PR against it
  */
case class MuiStepper(key: js.UndefOr[String] = js.undefined,
                      ref: js.UndefOr[MuiStepperM => Unit] = js.undefined,
                      /* Set the active step (zero based index). This will enable `Step` control helpers. */
                      activeStep: js.UndefOr[Double] = js.undefined,
                      /* A component to be placed between each step. */
                      connector: js.UndefOr[VdomNode] = js.undefined,
                      /* If set to `true`, the `Stepper` will assist in controlling steps for linear flow */
                      linear: js.UndefOr[Boolean] = js.undefined,
                      /* The stepper orientation (layout flow direction) */
                      orientation: js.UndefOr[HorizontalVertical] = js.undefined,
                      /* Override the inline-style of the root element. */
                      style: js.UndefOr[CssProperties] = js.undefined) {

  /**
    * @param children Should be two or more `<Step />` components
    */
  def apply(children: VdomElement*) = {

    val props     = JSMacro[MuiStepper](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Mui.Stepper)
    component(props)(children: _*)
  }
}
@js.native
class MuiStepperM extends js.Object {
  def getChildContext(): js.Dynamic = js.native
}
