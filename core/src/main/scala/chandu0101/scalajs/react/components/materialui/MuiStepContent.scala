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
case class MuiStepContent(key: js.UndefOr[String] = js.undefined,
                          ref: js.UndefOr[String] = js.undefined,
                          /* Expands the content */
                          active: js.UndefOr[Boolean] = js.undefined,
                          completed: js.UndefOr[Boolean] = js.undefined,
                          last: js.UndefOr[Boolean] = js.undefined,
                          /* Override the inline-style of the root element. */
                          style: js.UndefOr[CssProperties] = js.undefined,
                          /* ReactTransitionGroup component. */
                          transition: js.UndefOr[js.Any] = js.undefined,
                          /* Adjust the duration of the content expand transition. Passed as a prop to the transition component. */
                          transitionDuration: js.UndefOr[Double] = js.undefined) {

  /**
    * @param children Step content
    */
  def apply(children: VdomNode*) = {

    val props     = JSMacro[MuiStepContent](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Mui.StepContent)
    component(props)(children: _*)
  }
}
