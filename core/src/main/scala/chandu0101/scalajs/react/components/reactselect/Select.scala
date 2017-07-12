package chandu0101.scalajs.react.components
package reactselect

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._

import scala.scalajs.js
import japgolly.scalajs.react.raw.React
import japgolly.scalajs.react.vdom.VdomNode

case class Select[T](
    /* placeholder displayed when you want to add a label on a multi-value input */
    addLabelText: js.UndefOr[String] = js.undefined,
    /* whether to allow creation of new entries */
    allowCreate: js.UndefOr[Boolean] = js.undefined,
    /* autofocus the component on mount */
    autofocus: js.UndefOr[Boolean] = js.undefined,
    /* whether backspace removes an item if there is no text input */
    backspaceRemoves: js.UndefOr[Boolean] = js.undefined,
    /* className for the outer element */
    className: js.UndefOr[String] = js.undefined,
    /* title for the "clear" control when multi: true */
    clearAllText: js.UndefOr[VdomNode] = js.undefined,
    /* title for the "clear" control */
    clearValueText: js.UndefOr[VdomNode] = js.undefined,
    /* should it be possible to reset value */
    clearable: js.UndefOr[Boolean] = js.undefined,
    /* delimiter to use to join multiple values for the hidden field value */
    delimiter: js.UndefOr[String] = js.undefined,
    /* whether the Select is disabled or not */
    disabled: js.UndefOr[Boolean] = js.undefined,
    /* whether escape clears the value when the menu is closed */
    escapeClearsValue: js.UndefOr[Boolean] = js.undefined,
    /* method to filter a single option (option, filterString) */
    filterOption: js.UndefOr[Callback] = js.undefined,
    /* boolean to enable default filtering or function to filter the options array ([options], filterString, [values]) */
    filterOptions: js.UndefOr[js.Any] = js.undefined,
    /* whether to strip diacritics when filtering */
    ignoreAccents: js.UndefOr[Boolean] = js.undefined,
    /* whether to perform case-insensitive filtering */
    ignoreCase: js.UndefOr[Boolean] = js.undefined,
    /* custom attributes for the Input */
    inputProps: js.UndefOr[js.Any] = js.undefined,
    /* whether the Select is loading externally or not (such as options being loaded) */
    isLoading: js.UndefOr[Boolean] = js.undefined,
    /* path of the label value in option objects */
    labelKey: js.UndefOr[String] = js.undefined,
    /* (any|start) match the start or entire string when filtering */
    matchPos: js.UndefOr[String] = js.undefined,
    /* (any|label|value) which option property to filter on */
    matchProp: js.UndefOr[String] = js.undefined,
    /* boolean to enable the viewport to shift so that the full menu fully visible when engaged */
    scrollMenuIntoView: js.UndefOr[Boolean] = js.undefined,
    /* optional buffer (in px) between the bottom of the viewport and the bottom of the menu */
    menuBuffer: js.UndefOr[Int] = js.undefined,
    /* optional style to apply to the menu */
    menuStyle: js.UndefOr[CssProperties] = js.undefined,
    /* optional style to apply to the menu container */
    menuContainerStyle: js.UndefOr[CssProperties] = js.undefined,
    /* multi-value input */
    multi: js.UndefOr[Boolean] = js.undefined,
    /* generates a hidden <input /> tag with this field name for html forms */
    name: js.UndefOr[String] = js.undefined,
    /* factory to create new options when allowCreate set */
    newOptionCreator: js.UndefOr[Callback] = js.undefined,
    /* placeholder displayed when there are no matching search results */
    noResultsText: js.UndefOr[VdomNode] = js.undefined,
    /* onBlur handler: function (event) {} */
    onBlur: js.UndefOr[ReactEvent => Callback] = js.undefined,
    /* onChange handler: function (newValue) {} */
    onChange: js.UndefOr[T => Callback] = js.undefined,
    /* onFocus handler: function (event) {} */
    onFocus: js.UndefOr[ReactEvent => Callback] = js.undefined,
    /* onInputChange handler: function (inputValue) {} */
    onInputChange: js.UndefOr[String => Callback] = js.undefined,
    /* onClick handler for value labels: function (value, event) {} */
    onValueClick: js.UndefOr[(ValueOption[T], ReactEvent) => Callback] = js.undefined,
    /* fires when the menu is scrolled to the bottom; can be used to paginate options */
    onMenuScrollToBottom: js.UndefOr[Callback] = js.undefined,
    /* option component to render in dropdown */
    optionComponent: js.UndefOr[JsFnComponent.Unmounted[OptionProps[T]]] = js.undefined,
    /* optionRenderer: function (option) {} */
    optionRenderer: js.UndefOr[ValueProps[T] => VdomNode] = js.undefined,
    /* array of options */
    options: js.Array[ValueOption[T]],
    /* field placeholder, displayed when there's no value */
    placeholder: js.UndefOr[VdomNode] = js.undefined,
    /* whether to enable searching feature or not */
    searchable: js.UndefOr[Boolean] = js.undefined,
    /* pass the value to onChange as a simple value (legacy pre 1.0 mode), defaults to false */
    simpleValue: js.UndefOr[Boolean] = js.undefined,
    /* optional style to apply to the control */
    style: js.UndefOr[CssProperties] = js.undefined,
    /* optional tab index of the control */
    tabIndex: js.UndefOr[String] = js.undefined,
    /* initial field value */
    value: JsCollection[T] = js.undefined.asInstanceOf[JsCollection[T]],
    /* value component to render */
    valueComponent: js.UndefOr[JsFnComponent.Unmounted[ValueProps[T]]] = js.undefined,
    /* path of the label value in option objects */
    valueKey: js.UndefOr[String] = js.undefined,
    /* valueRenderer: function (option) {} */
    valueRenderer: js.UndefOr[ValueOption[T] => VdomNode] = js.undefined,
    /* optional style to apply to the component wrapper */
    wrapperStyle: js.UndefOr[CssProperties] = js.undefined) {

  def apply(): JsComponent.Unmounted[_, _] = {
//    implicit val hackEvidence: T => js.Any = _.asInstanceOf[js.Any]

    val props     = JSMacro[Select[T]](this)
    val component = JsComponent[js.Object, Children.None, Null](js.Dynamic.global.ReactSelect)
    component(props)
  }
}
