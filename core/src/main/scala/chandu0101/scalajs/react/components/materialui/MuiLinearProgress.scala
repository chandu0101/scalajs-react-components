package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.React
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiLinearProgress(
  key:   js.UndefOr[String]                     = js.undefined,
  ref:   js.UndefOr[MuiLinearProgressM => Unit] = js.undefined,
  /* The color of the progress bar, defaults to
     primary color of theme. */
  color: js.UndefOr[MuiColor]                   = js.undefined,
  /* The max value of progress, only works in determinate mode. */
  max:   js.UndefOr[Double]                     = js.undefined,
  /* The min value of progress, only works in determinate mode. */
  min:   js.UndefOr[Double]                     = js.undefined,
  /* The mode of show your progress, indeterminate for when
     there is no value for progress. */
  mode:  js.UndefOr[DeterminateIndeterminate]   = js.undefined,
  /* Override the inline-styles of the root element. */
  style: js.UndefOr[CssProperties]              = js.undefined,
  /* The value of progress, only works in determinate mode. */
  value: js.UndefOr[Double]                     = js.undefined){

  def apply() = {
    
    val props = JSMacro[MuiLinearProgress](this)
    val component = JsComponent[js.Object, Children.None, Null](Mui.LinearProgress)
    component(props)
  }
}
        


@js.native
class MuiLinearProgressM extends js.Object {
  def barUpdate(id: js.Any, step: js.Any, barElement: js.Any, stepValues: js.Any): js.Dynamic = js.native
}
