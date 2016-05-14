package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiCircularProgress(
  key:        js.UndefOr[String]                    = js.undefined,
  ref:        js.UndefOr[CircularProgressM => Unit] = js.undefined,
  /* Override the progress's color.*/
  color:      js.UndefOr[MuiColor]                  = js.undefined,
  /* Style for inner wrapper div.*/
  innerStyle: js.UndefOr[CssProperties]             = js.undefined,
  /* The max value of progress, only works in determinate mode.*/
  max:        js.UndefOr[Double]                    = js.undefined,
  /* The min value of progress, only works in determinate mode.*/
  min:        js.UndefOr[Double]                    = js.undefined,
  /* The mode of show your progress, indeterminate
  for when there is no value for progress.*/
  mode:       js.UndefOr[DeterminateIndeterminate]  = js.undefined,
  /* The size of the progress.*/
  size:       js.UndefOr[Double]                    = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:      js.UndefOr[CssProperties]             = js.undefined,
  /* The value of progress, only works in determinate mode.*/
  value:      js.UndefOr[Double]                    = js.undefined){

  def apply() = {
    val props = JSMacro[MuiCircularProgress](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.CircularProgress)
    f(props).asInstanceOf[ReactComponentU_]
  }
}
        


@js.native
class CircularProgressM extends js.Object {
  def rotateWrapper(wrapper: js.Any): js.Any = js.native

  def scalePath(path: js.Any, step: js.Any): js.Any = js.native
}
