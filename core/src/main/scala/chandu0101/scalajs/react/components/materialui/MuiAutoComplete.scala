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
  key:                  js.UndefOr[String]                                               = js.undefined,
  ref:                  js.UndefOr[String]                                               = js.undefined,
  anchorOrigin:         js.UndefOr[Origin]                                               = js.undefined,
  animated:             js.UndefOr[Boolean]                                              = js.undefined,
  /* Array of type string or type object that populate the auto complete list.*/
  dataSource:           js.UndefOr[js.Array[js.Any]]                                     = js.undefined,
  disableFocusRipple:   js.UndefOr[Boolean]                                              = js.undefined,
  errorStyle:           js.UndefOr[CssProperties]                                        = js.undefined,
  /* The error content to display.*/
  errorText:            js.UndefOr[String]                                               = js.undefined,
  filter:               js.UndefOr[(String, String, js.UndefOr[js.Any]) => Callback]     = js.undefined,
  /* The content to use for adding floating label element.*/
  floatingLabelText:    js.UndefOr[String]                                               = js.undefined,
  /* If true, the field receives the property width 100%.*/
  fullWidth:            js.UndefOr[Boolean]                                              = js.undefined,
  /* The hint content to display.*/
  hintText:             js.UndefOr[String]                                               = js.undefined,
  listStyle:            js.UndefOr[CssProperties]                                        = js.undefined,
  menuCloseDelay:       js.UndefOr[Double]                                               = js.undefined,
  menuProps:            js.UndefOr[js.Any]                                               = js.undefined,
  menuStyle:            js.UndefOr[CssProperties]                                        = js.undefined,
  /* Gets called when list item is clicked or pressed enter*/
  onNewRequest:         js.UndefOr[(js.Any, Int, js.Array[js.Any] | js.Any) => Callback] = js.undefined,
  /* Gets called each time the user updates the text field*/
  onUpdateInput:        js.UndefOr[(String, js.Array[js.Any] | js.Any) => Callback]      = js.undefined,
  open:                 js.UndefOr[Boolean]                                              = js.undefined,
  searchText:           js.UndefOr[String]                                               = js.undefined,
  /* If true, the item list will not be filtered and will show when the control is focused (works like a drop down list).*/
  @deprecated("showAllItems is deprecated, use noFilter instead")
  showAllItems:         js.UndefOr[Boolean]                                              = js.undefined,
  style:                js.UndefOr[CssProperties]                                        = js.undefined,
  targetOrigin:         js.UndefOr[Origin]                                               = js.undefined,
  touchTapCloseDelay:   js.UndefOr[Int]                                                  = js.undefined,
  triggerUpdateOnFocus: js.UndefOr[Boolean]                                              = js.undefined,
  @deprecated("updateWhenFocused has been renamed to triggerUpdateOnFocus")
  updateWhenFocused:    js.UndefOr[Boolean]                                              = js.undefined){

  def apply() = {
    val props = JSMacro[MuiAutoComplete](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.AutoComplete)
    f(props).asInstanceOf[ReactComponentU_]
  }
}
        
