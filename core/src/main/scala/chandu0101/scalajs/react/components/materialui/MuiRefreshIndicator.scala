
package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
  
case class MuiRefreshIndicator(
	key:          js.UndefOr[String]                      = js.undefined,
	ref:          js.UndefOr[String]                      = js.undefined,
	/* required: The absolute left position of the indicator in pixels.*/
	left:         Int,
	/* default: 0: The confirmation progress to fetch data. Max value is 100*/
	percentage:   js.UndefOr[Double]                      = js.undefined,
	/* default: 40: Size in pixels.*/
	size:         js.UndefOr[Int]                         = js.undefined,
	/* default: hide: The display status of the indicator. If the status is "ready", the indicator will display the ready state arrow. If the status is "loading", it will display the loading progress indicator. If the status is "hide", the indicator will be hidden.*/
	status:       js.UndefOr[MuiRefreshIndicatorStatus]   = js.undefined,
	/*  Override the inline-styles of the indicator's root element.*/
	style:        js.UndefOr[CssProperties]               = js.undefined,
	/* required: The absolute right position of the indicator in pixels.*/
	top:          Int,
	color:        js.UndefOr[MuiColor]                    = js.undefined,
	loadingColor: js.UndefOr[MuiColor]                    = js.undefined)
{

  def apply() = {
    val props = JSMacro[MuiRefreshIndicator](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.RefreshIndicator)
    f(props).asInstanceOf[ReactComponentU_]
  }
}
    


class MuiRefreshIndicatorStatus(val value: String) extends AnyVal
object MuiRefreshIndicatorStatus{
	val READY = new MuiRefreshIndicatorStatus("ready")
	val LOADING = new MuiRefreshIndicatorStatus("loading")
	val HIDE = new MuiRefreshIndicatorStatus("hide")
	val values = List(READY, LOADING, HIDE)
}
