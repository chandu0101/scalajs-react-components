package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.React
import japgolly.scalajs.react.vdom.VdomNode
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.`|`

/**
  * This file is generated - submit issues instead of PR against it
  */
case class MuiStep(key: js.UndefOr[String] = js.undefined,
                   ref: js.UndefOr[String] = js.undefined,
                   /* Sets the step as active. Is passed to child components. */
                   active: js.UndefOr[Boolean] = js.undefined,
                   /* Mark the step as completed. Is passed to child components. */
                   completed: js.UndefOr[Boolean] = js.undefined,
                   /* Mark the step as disabled, will also disable the button if
     `StepButton` is a child of `Step`. Is passed to child components. */
                   disabled: js.UndefOr[Boolean] = js.undefined,
                   /* Used internally for numbering. */
                   index: js.UndefOr[Double] = js.undefined,
                   last: js.UndefOr[Boolean] = js.undefined,
                   /* Override the inline-style of the root element. */
                   style: js.UndefOr[CssProperties] = js.undefined) {

  /**
    * @param children Should be `Step` sub-components such as `StepLabel`.
    */
  def apply(children: VdomNode*) = {

    val props     = JSMacro[MuiStep](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Mui.Step)
    component(props)(children: _*)
  }
}
