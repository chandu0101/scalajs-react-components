package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiAutoComplete(
  key:                js.UndefOr[String]                                               = js.undefined,
  ref:                js.UndefOr[String]                                               = js.undefined,
  anchorOrigin:       js.UndefOr[Origin]                                               = js.undefined,
  animated:           js.UndefOr[Boolean]                                              = js.undefined,
  dataSource:         js.UndefOr[js.Array[js.Any]]                                     = js.undefined,
  disableFocusRipple: js.UndefOr[Boolean]                                              = js.undefined,
  errorStyle:         js.UndefOr[CssProperties]                                        = js.undefined,
  errorText:          js.UndefOr[String]                                               = js.undefined,
  filter:             js.UndefOr[(String, String, js.UndefOr[js.Any]) => Callback]     = js.undefined,
  floatingLabelText:  js.UndefOr[String]                                               = js.undefined,
  fullWidth:          js.UndefOr[Boolean]                                              = js.undefined,
  hintText:           js.UndefOr[String]                                               = js.undefined,
  listStyle:          js.UndefOr[CssProperties]                                        = js.undefined,
  menuCloseDelay:     js.UndefOr[Double]                                               = js.undefined,
  menuProps:          js.UndefOr[js.Any]                                               = js.undefined,
  menuStyle:          js.UndefOr[CssProperties]                                        = js.undefined,
  onNewRequest:       js.UndefOr[(js.Any, Int, js.Array[js.Any] | js.Any) => Callback] = js.undefined,
  onUpdateInput:      js.UndefOr[(String, js.Array[js.Any] | js.Any) => Callback]      = js.undefined,
  open:               js.UndefOr[Boolean]                                              = js.undefined,
  searchText:         js.UndefOr[String]                                               = js.undefined,
  showAllItems:       js.UndefOr[Boolean]                                              = js.undefined,
  style:              js.UndefOr[CssProperties]                                        = js.undefined,
  targetOrigin:       js.UndefOr[Origin]                                               = js.undefined,
  touchTapCloseDelay: js.UndefOr[Int]                                                  = js.undefined,
  updateWhenFocused:  js.UndefOr[Boolean]                                              = js.undefined){

  def apply() = {
    val props = JSMacro[MuiAutoComplete](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.AutoComplete)
    f(props).asInstanceOf[ReactComponentU_]
  }
}
        
