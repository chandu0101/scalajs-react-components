
package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
  
case class MuiCircularProgress(
	key:   js.UndefOr[String]                    = js.undefined,
	ref:   js.UndefOr[String]                    = js.undefined,
	/* default: 100: The max value of progress, only works in determinate mode. */
	max:   js.UndefOr[Double]                    = js.undefined,
	/* default: 0: The min value of progress, only works in determinate mode. */
	min:   js.UndefOr[Double]                    = js.undefined,
	/* default: indeterminate: The mode of show your progress, indeterminate for when there is no value for progress. */
	mode:  js.UndefOr[MuiCircularProgressMode]   = js.undefined,
	/* default: 1: The size of the progress.*/
	size:  js.UndefOr[Double]                    = js.undefined,
	/*  Override the inline-styles of the progress's root element.*/
	style: js.UndefOr[CssProperties]             = js.undefined,
	/* default: 0: The value of progress, only works in determinate mode. */
	value: js.UndefOr[Double]                    = js.undefined)
{

  def apply() = {
    val props = JSMacro[MuiCircularProgress](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.CircularProgress)
    f(props).asInstanceOf[ReactComponentU_]
  }
}
    


class MuiCircularProgressMode(val value: String) extends AnyVal
object MuiCircularProgressMode{
	val DETERMINATE = new MuiCircularProgressMode("determinate")
	val INDETERMINATE = new MuiCircularProgressMode("indeterminate")
}
