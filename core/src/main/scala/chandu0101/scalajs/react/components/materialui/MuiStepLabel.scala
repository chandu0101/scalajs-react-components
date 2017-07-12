package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.React
import japgolly.scalajs.react.vdom.{VdomElement, VdomNode}

import scala.scalajs.js
import scala.scalajs.js.`|`

/**
  * This file is generated - submit issues instead of PR against it
  */
case class MuiStepLabel(key: js.UndefOr[String] = js.undefined,
                        ref: js.UndefOr[String] = js.undefined,
                        /* Sets active styling. Overrides disabled coloring. */
                        active: js.UndefOr[Boolean] = js.undefined,
                        /* Sets completed styling. Overrides disabled coloring. */
                        completed: js.UndefOr[Boolean] = js.undefined,
                        /* Sets disabled styling. */
                        disabled: js.UndefOr[Boolean] = js.undefined,
                        /* The icon displayed by the step label. */
                        icon: js.UndefOr[String | Double | VdomElement] = js.undefined,
                        /* Override the inline-styles of the icon container element. */
                        iconContainerStyle: js.UndefOr[CssProperties] = js.undefined,
                        last: js.UndefOr[Boolean] = js.undefined,
                        /* Override the inline-style of the root element. */
                        style: js.UndefOr[CssProperties] = js.undefined) {

  /**
    * @param children The label text node
    */
  def apply(children: VdomNode*) = {

    val props     = JSMacro[MuiStepLabel](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Mui.StepLabel)
    component(props)(children: _*)
  }
}
