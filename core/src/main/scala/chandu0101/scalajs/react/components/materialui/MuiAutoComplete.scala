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
  key:                  js.UndefOr[String]                                                = js.undefined,
  ref:                  js.UndefOr[String]                                                = js.undefined,
  /* Location of the anchor for the auto complete.*/
  anchorOrigin:         js.UndefOr[Origin]                                                = js.undefined,
  /* If true, the auto complete is animated as it is toggled.*/
  animated:             js.UndefOr[Boolean]                                               = js.undefined,
  /* Array of strings or nodes used to populate the list.*/
  dataSource:           js.Array[Value],
  /* Disables focus ripple when true.*/
  disableFocusRipple:   js.UndefOr[Boolean]                                               = js.undefined,
  /* Override style prop for error.*/
  errorStyle:           js.UndefOr[CssProperties]                                         = js.undefined,
  /* The error content to display.*/
  errorText:            js.UndefOr[ReactNode]                                             = js.undefined,
  /* Callback function used to filter the auto complete.
  @returns {boolean} `true` indicates the auto complete list will include `key` when the input is `searchText`.*/
  filter:               js.UndefOr[AutoCompleteFilter]                                    = js.undefined,
  /* The content to use for adding floating label element.*/
  floatingLabelText:    js.UndefOr[ReactNode]                                             = js.undefined,
  /* If true, the field receives the property `width: 100%`.*/
  fullWidth:            js.UndefOr[Boolean]                                               = js.undefined,
  /* The hint content to display.*/
  hintText:             js.UndefOr[ReactNode]                                             = js.undefined,
  /* Override style for list.*/
  listStyle:            js.UndefOr[CssProperties]                                         = js.undefined,
  /* The max number of search results to be shown.
  By default it shows all the items which matches filter.*/
  maxSearchResults:     js.UndefOr[Double]                                                = js.undefined,
  /* Delay for closing time of the menu.*/
  menuCloseDelay:       js.UndefOr[Double]                                                = js.undefined,
  /* Props to be passed to menu.*/
  menuProps:            js.UndefOr[js.Object]                                             = js.undefined,
  /* Override style for menu.*/
  menuStyle:            js.UndefOr[CssProperties]                                         = js.undefined,
  /* Callback function that is fired when the `TextField` loses focus.*/
  onBlur:               js.UndefOr[ReactEventH => Callback]                               = js.undefined,
  /* Callback function that is fired when the `TextField` gains focus.*/
  onFocus:              js.UndefOr[ReactFocusEventH => Callback]                          = js.undefined,
  /* Callback function that is fired when the `TextField` receives a keydown event.*/
  onKeyDown:            js.UndefOr[ReactKeyboardEventH => Callback]                       = js.undefined,
  /* Callback function that is fired when a list item is selected, or enter is pressed in the `TextField`.
  or the text value of the corresponding list item that was selected.
  `TextField`.*/
  onNewRequest:         js.UndefOr[(Value, js.UndefOr[Int], js.Array[Value]) => Callback] = js.undefined,
  /* Callback function that is fired when the user updates the `TextField`.*/
  onUpdateInput:        js.UndefOr[(SearchText, js.Array[Value]) => Callback]             = js.undefined,
  /* Auto complete menu is open if true.*/
  open:                 js.UndefOr[Boolean]                                               = js.undefined,
  /* If true, the list item is showed when a focus event triggers.*/
  openOnFocus:          js.UndefOr[Boolean]                                               = js.undefined,
  /* Text being input to auto complete.*/
  searchText:           js.UndefOr[SearchText]                                            = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:                js.UndefOr[CssProperties]                                         = js.undefined,
  /* Origin for location of target.*/
  targetOrigin:         js.UndefOr[Origin]                                                = js.undefined,
  /* If true, will update when focus event triggers.*/
  @deprecated("Instead, use openOnFocus")
  triggerUpdateOnFocus: js.UndefOr[Boolean]                                               = js.undefined){

  def apply() = {
    val props = JSMacro[MuiAutoComplete](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.AutoComplete)
    f(props).asInstanceOf[ReactComponentU_]
  }
}
        
