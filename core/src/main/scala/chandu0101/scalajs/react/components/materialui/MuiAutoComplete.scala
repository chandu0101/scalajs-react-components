package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import org.scalajs.dom
import scala.scalajs.js
import scala.scalajs.js.`|`

/**
  * This file is generated - submit issues instead of PR against it
  */
case class MuiAutoComplete(
    key: js.UndefOr[String] = js.undefined,
    ref: js.UndefOr[MuiAutoCompleteM => Unit] = js.undefined,
    /* Location of the anchor for the auto complete. */
    anchorOrigin: js.UndefOr[Origin] = js.undefined,
    /* If true, the auto complete is animated as it is toggled. */
    animated: js.UndefOr[Boolean] = js.undefined,
    /* Override the default animation component used. */
    animation: js.UndefOr[js.Function] = js.undefined,
    /* Array of strings or nodes used to populate the list. */
    dataSource: js.Array[String],
    /* Config for objects list dataSource.
     @typedef {Object} dataSourceConfig
     @property {string} text `dataSource` element key used to find a string to be matched for search
     and shown as a `TextField` input value after choosing the result.
     @property {string} value `dataSource` element key used to find a string to be shown in search results. */
    dataSourceConfig: js.UndefOr[js.Object] = js.undefined,
    /* Disables focus ripple when true. */
    disableFocusRipple: js.UndefOr[Boolean] = js.undefined,
    /* Override style prop for error. */
    errorStyle: js.UndefOr[CssProperties] = js.undefined,
    /* The error content to display. */
    errorText: js.UndefOr[ReactNode] = js.undefined,
    /* Callback function used to filter the auto complete.
     @param {string} searchText The text to search for within `dataSource`.
     @param {string} key `dataSource` element, or `text` property on that element if it's not a string.
     @returns {boolean} `true` indicates the auto complete list will include `key` when the input is `searchText`. */
    filter: js.UndefOr[(String, String, String) => Boolean] = js.undefined,
    /* The content to use for adding floating label element. */
    floatingLabelText: js.UndefOr[ReactNode] = js.undefined,
    /* If true, the field receives the property `width: 100%`. */
    fullWidth: js.UndefOr[Boolean] = js.undefined,
    /* The hint content to display. */
    hintText: js.UndefOr[ReactNode] = js.undefined,
    /* Override style for list. */
    listStyle: js.UndefOr[CssProperties] = js.undefined,
    /* The max number of search results to be shown.
     By default it shows all the items which matches filter. */
    maxSearchResults: js.UndefOr[Double] = js.undefined,
    /* Delay for closing time of the menu. */
    menuCloseDelay: js.UndefOr[Double] = js.undefined,
    /* Props to be passed to menu. */
    menuProps: js.UndefOr[js.Object] = js.undefined,
    /* Override style for menu. */
    menuStyle: js.UndefOr[CssProperties] = js.undefined,
    onBlur: js.UndefOr[ReactFocusEventI => Callback] = js.undefined,
    /* Callback function fired when the menu is closed. */
    onClose: js.UndefOr[Callback] = js.undefined,
    onFocus: js.UndefOr[ReactFocusEventI => Callback] = js.undefined,
    onKeyDown: js.UndefOr[ReactKeyboardEvent => Callback] = js.undefined,
    /* Callback function that is fired when a list item is selected, or enter is pressed in the `TextField`.
     @param {string} chosenRequest Either the `TextField` input value, if enter is pressed in the `TextField`,
     or the text value of the corresponding list item that was selected.
     @param {number} index The index in `dataSource` of the list item selected, or `-1` if enter is pressed in the
     `TextField`. */
    onNewRequest: js.UndefOr[(String, Int) => Callback] = js.undefined,
    /* Callback function that is fired when the user updates the `TextField`.
     @param {string} searchText The auto-complete's `searchText` value.
     @param {array} dataSource The auto-complete's `dataSource` array.
     @param {object} params Additional information linked the update. */
    onUpdateInput: js.UndefOr[(String, js.Array[String], js.Object) => Callback] = js.undefined,
    /* Auto complete menu is open if true. */
    open: js.UndefOr[Boolean] = js.undefined,
    /* If true, the list item is showed when a focus event triggers. */
    openOnFocus: js.UndefOr[Boolean] = js.undefined,
    /* Props to be passed to popover. */
    popoverProps: js.UndefOr[js.Any] = js.undefined,
    /* Text being input to auto complete. */
    searchText: js.UndefOr[String] = js.undefined,
    /* Override the inline-styles of the root element. */
    style: js.UndefOr[CssProperties] = js.undefined,
    /* Origin for location of target. */
    targetOrigin: js.UndefOr[Origin] = js.undefined,
    /* Override the inline-styles of AutoComplete's TextField element. */
    textFieldStyle: js.UndefOr[CssProperties] = js.undefined,
    /* The css class name of the root element.
     (Passed on to TextField) */
    className: js.UndefOr[String] = js.undefined,
    /* The text string to use for the default value.
     (Passed on to TextField) */
    defaultValue: js.UndefOr[String] = js.undefined,
    /* Disables the text field if set to true.
     (Passed on to TextField) */
    disabled: js.UndefOr[Boolean] = js.undefined,
    /* If true, the floating label will float even when there is no value.
     (Passed on to TextField) */
    floatingLabelFixed: js.UndefOr[Boolean] = js.undefined,
    /* The style object to use to override floating label styles when focused.
     (Passed on to TextField) */
    floatingLabelFocusStyle: js.UndefOr[CssProperties] = js.undefined,
    /* The style object to use to override floating label styles when shrunk.
     (Passed on to TextField) */
    floatingLabelShrinkStyle: js.UndefOr[CssProperties] = js.undefined,
    /* The style object to use to override floating label styles.
     (Passed on to TextField) */
    floatingLabelStyle: js.UndefOr[CssProperties] = js.undefined,
    /* Override the inline-styles of the TextField's hint text element.
     (Passed on to TextField) */
    hintStyle: js.UndefOr[CssProperties] = js.undefined,
    /* The id prop for the text field.
     (Passed on to TextField) */
    id: js.UndefOr[String] = js.undefined,
    /* Override the inline-styles of the TextField's input element.
     When multiLine is false: define the style of the input element.
     When multiLine is true: define the style of the container of the textarea.
     (Passed on to TextField) */
    inputStyle: js.UndefOr[CssProperties] = js.undefined,
    /* If true, a textarea element will be rendered.
     The textarea also grows and shrinks according to the number of lines.
     (Passed on to TextField) */
    multiLine: js.UndefOr[Boolean] = js.undefined,
    /* Name applied to the input.
     (Passed on to TextField) */
    name: js.UndefOr[String] = js.undefined,
    /* Callback function that is fired when the textfield's value changes.
     (Passed on to TextField)
     @param {object} event Change event targeting the text field.
     @param {string} newValue The new value of the text field. */
    onChange: js.UndefOr[(ReactEventI, String) => Callback] = js.undefined,
    /* Number of rows to display when multiLine option is set to true.
     (Passed on to TextField) */
    rows: js.UndefOr[Int] = js.undefined,
    /* Maximum number of rows to display when
     multiLine option is set to true.
     (Passed on to TextField) */
    rowsMax: js.UndefOr[Int] = js.undefined,
    /* Override the inline-styles of the TextField's textarea element.
     The TextField use either a textarea or an input,
     this property has effects only when multiLine is true.
     (Passed on to TextField) */
    textareaStyle: js.UndefOr[CssProperties] = js.undefined,
    /* Specifies the type of input to display
     such as "password" or "text".
     (Passed on to TextField) */
    `type`: js.UndefOr[String] = js.undefined,
    /* Override the inline-styles of the
     TextField's underline element when disabled.
     (Passed on to TextField) */
    underlineDisabledStyle: js.UndefOr[CssProperties] = js.undefined,
    /* Override the inline-styles of the TextField's
     underline element when focussed.
     (Passed on to TextField) */
    underlineFocusStyle: js.UndefOr[CssProperties] = js.undefined,
    /* If true, shows the underline for the text field.
     (Passed on to TextField) */
    underlineShow: js.UndefOr[Boolean] = js.undefined,
    /* Override the inline-styles of the TextField's underline element.
     (Passed on to TextField) */
    underlineStyle: js.UndefOr[CssProperties] = js.undefined,
    /* The value of the text field.
     (Passed on to TextField) */
    value: js.UndefOr[String] = js.undefined) {

  def apply(children: ReactNode*) = {

    val props = JSMacro[MuiAutoComplete](this)
    val f     = React.asInstanceOf[js.Dynamic].createFactory(Mui.AutoComplete)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
@js.native
class MuiAutoCompleteM extends js.Object {
  def blur(): js.Dynamic = js.native

  def close(): js.Dynamic = js.native

  def focus(): js.Dynamic = js.native
}
