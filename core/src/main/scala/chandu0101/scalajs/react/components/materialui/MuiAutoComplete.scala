
package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
  
case class MuiAutoComplete(
	key:                js.UndefOr[String]                                                 = js.undefined,
	ref:                js.UndefOr[String]                                                 = js.undefined,
	onNewRequest:       js.UndefOr[(js.Any, Int, js.Array[js.Any] | js.Any) => Callback]   = js.undefined,
	updateWhenFocused:  js.UndefOr[Boolean]                                                = js.undefined,
	animated:           js.UndefOr[Boolean]                                                = js.undefined,
	listStyle:          js.UndefOr[CssProperties]                                          = js.undefined,
	fullWidth:          js.UndefOr[Boolean]                                                = js.undefined,
	touchTapCloseDelay: js.UndefOr[Double]                                                 = js.undefined,
	dataSource:         js.UndefOr[js.Object]                                              = js.undefined,
	open:               js.UndefOr[Boolean]                                                = js.undefined,
	hintText:           js.UndefOr[String]                                                 = js.undefined,
	onUpdateInput:      js.UndefOr[(String, js.Array[js.Any] | js.Any) => Callback]        = js.undefined,
	disableFocusRipple: js.UndefOr[Boolean]                                                = js.undefined,
	filter:             js.UndefOr[(String, String, js.UndefOr[js.Any]) => Callback]       = js.undefined,
	errorText:          js.UndefOr[String]                                                 = js.undefined,
	menuProps:          js.UndefOr[js.Object]                                              = js.undefined,
	menuStyle:          js.UndefOr[CssProperties]                                          = js.undefined,
	errorStyle:         js.UndefOr[CssProperties]                                          = js.undefined,
	menuCloseDelay:     js.UndefOr[Double]                                                 = js.undefined,
	floatingLabelText:  js.UndefOr[String]                                                 = js.undefined,
	showAllItems:       js.UndefOr[Boolean]                                                = js.undefined,
	searchText:         js.UndefOr[String]                                                 = js.undefined)
{

  def apply() = {
    val props = JSMacro[MuiAutoComplete](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.AutoComplete)
    f(props).asInstanceOf[ReactComponentU_]
  }
}
    
