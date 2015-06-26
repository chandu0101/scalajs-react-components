package chandu0101.scalajs.react.components.optionselectors

import japgolly.scalajs.react._

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{literal => json}
import scala.scalajs.js.{Array => JArray}


/**
 * key: PropTypes.string,
ref: PropTypes.String,
allowCreate: React.PropTypes.bool,
		asyncOptions: React.PropTypes.func,
		autoload: React.PropTypes.bool,
		className: React.PropTypes.string,
		clearable: React.PropTypes.bool,
		clearAllText: React.PropTypes.string,
		clearValueText: React.PropTypes.string,
		delimiter: React.PropTypes.string,
		disabled: React.PropTypes.bool,
		filterOption: React.PropTypes.(SelectOption,String) => Boolean,
		filterOptions: React.PropTypes.(JArray[SelectOption],String) => JArray[String],
		ignoreCase: React.PropTypes.bool,
		inputProps: React.PropTypes.object,
		matchPos: React.PropTypes.string,
		matchProp: React.PropTypes.string,
		multi: React.PropTypes.bool,
		name: React.PropTypes.string,
		noResultsText: React.PropTypes.string,
		onBlur: React.PropTypes.ReactEvent => Unit,
		onChange: React.PropTypes.String => Unit,
		onFocus: React.PropTypes.ReactEvent => Unit,
		onOptionLabelClick: React.PropTypes.(String,ReactEvent) => Unit,
		optionRenderer: React.PropTypes.SelectOption => ReactElement,
		options: React.PropTypes.JArray[SelectOption],
		placeholder: React.PropTypes.string,
		searchable: React.PropTypes.bool,
		searchPromptText: React.PropTypes.string,
		value: React.PropTypes.string,
		valueRenderer: React.PropTypes.SelectOption => ReactElement

 */


object ReactSelect {

  def apply[T <: SelectOption](inputProps: js.UndefOr[js.Object] = js.undefined,
            onBlur: js.UndefOr[ReactEvent => Unit] = js.undefined,
            name: js.UndefOr[String] = js.undefined,
            clearable: js.UndefOr[Boolean] = js.undefined,
            clearAllText: js.UndefOr[String] = js.undefined,
            filterOptions: js.UndefOr[(JArray[js.Object], String) => JArray[String]] = js.undefined,
            asyncOptions: js.UndefOr[js.Function] = js.undefined,
            onChange: js.UndefOr[String => Unit] = js.undefined,
            valueRenderer: js.UndefOr[js.Object => ReactElement] = js.undefined,
            clearValueText: js.UndefOr[String] = js.undefined,
            matchPos: js.UndefOr[String] = js.undefined,
            matchProp: js.UndefOr[String] = js.undefined,
            ref: js.UndefOr[String] = js.undefined,
            allowCreate: js.UndefOr[Boolean] = js.undefined,
            placeholder: js.UndefOr[String] = js.undefined,
            filterOption: js.UndefOr[(js.Object, String) => Boolean] = js.undefined,
            key: js.UndefOr[String] = js.undefined,
            searchable: js.UndefOr[Boolean] = js.undefined,
            noResultsText: js.UndefOr[String] = js.undefined,
            options: js.UndefOr[JArray[T]] = js.undefined,
            onOptionLabelClick: js.UndefOr[(String, ReactEvent) => Unit] = js.undefined,
            optionRenderer: js.UndefOr[js.Object => ReactElement] = js.undefined,
            className: js.UndefOr[String] = js.undefined,
            onFocus: js.UndefOr[ReactEvent => Unit] = js.undefined,
            ignoreCase: js.UndefOr[Boolean] = js.undefined,
            disabled: js.UndefOr[Boolean] = js.undefined,
            autoload: js.UndefOr[Boolean] = js.undefined,
            value: js.UndefOr[String] = js.undefined,
            multi: js.UndefOr[Boolean] = js.undefined,
            searchPromptText: js.UndefOr[String] = js.undefined,
            delimiter: js.UndefOr[String] = js.undefined) = {

    val p = js.Dynamic.literal()
    inputProps.foreach(v => p.updateDynamic("inputProps")(v))
    onBlur.foreach(v => p.updateDynamic("onBlur")(v))
    name.foreach(v => p.updateDynamic("name")(v))
    clearable.foreach(v => p.updateDynamic("clearable")(v))
    clearAllText.foreach(v => p.updateDynamic("clearAllText")(v))
    filterOptions.foreach(v => p.updateDynamic("filterOptions")(v))
    asyncOptions.foreach(v => p.updateDynamic("asyncOptions")(v))
    onChange.foreach(v => p.updateDynamic("onChange")(v))
    valueRenderer.foreach(v => p.updateDynamic("valueRenderer")(v))
    clearValueText.foreach(v => p.updateDynamic("clearValueText")(v))
    matchPos.foreach(v => p.updateDynamic("matchPos")(v))
    matchProp.foreach(v => p.updateDynamic("matchProp")(v))
    ref.foreach(v => p.updateDynamic("ref")(v))
    allowCreate.foreach(v => p.updateDynamic("allowCreate")(v))
    placeholder.foreach(v => p.updateDynamic("placeholder")(v))
    filterOption.foreach(v => p.updateDynamic("filterOption")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    searchable.foreach(v => p.updateDynamic("searchable")(v))
    noResultsText.foreach(v => p.updateDynamic("noResultsText")(v))
    options.foreach(v => p.updateDynamic("options")(v.map(_.toJson)))
    onOptionLabelClick.foreach(v => p.updateDynamic("onOptionLabelClick")(v))
    optionRenderer.foreach(v => p.updateDynamic("optionRenderer")(v))
    className.foreach(v => p.updateDynamic("className")(v))
    onFocus.foreach(v => p.updateDynamic("onFocus")(v))
    ignoreCase.foreach(v => p.updateDynamic("ignoreCase")(v))
    disabled.foreach(v => p.updateDynamic("disabled")(v))
    autoload.foreach(v => p.updateDynamic("autoload")(v))
    value.foreach(v => p.updateDynamic("value")(v))
    multi.foreach(v => p.updateDynamic("multi")(v))
    searchPromptText.foreach(v => p.updateDynamic("searchPromptText")(v))
    delimiter.foreach(v => p.updateDynamic("delimiter")(v))

    val f = React.asInstanceOf[js.Dynamic].createFactory(js.Dynamic.global.ReactSelect)
    f(p).asInstanceOf[ReactComponentU_]
  }

}


trait SelectOption {
  def toJson:js.Dynamic
}