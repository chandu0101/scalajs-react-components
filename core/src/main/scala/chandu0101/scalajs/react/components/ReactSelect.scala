package chandu0101.scalajs.react.components

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._

import scala.scalajs.js
import scala.scalajs.js.{Array => JArray}

case class ReactSelect(inputProps: js.UndefOr[js.Object] = js.undefined,
                       onBlur: js.UndefOr[ReactEvent => Callback] = js.undefined,
                       name: js.UndefOr[String] = js.undefined,
                       clearable: js.UndefOr[Boolean] = js.undefined,
                       clearAllText: js.UndefOr[String] = js.undefined,
                       filterOptions: js.UndefOr[(JArray[js.Object], String) => JArray[String]] = js.undefined,
                       asyncOptions: js.UndefOr[js.Function] = js.undefined,
                       onChange: js.UndefOr[String => Callback] = js.undefined,
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
                       options: js.UndefOr[JArray[js.Object]] = js.undefined,
                       onOptionLabelClick: js.UndefOr[(String, ReactEvent) => Callback] = js.undefined,
                       optionRenderer: js.UndefOr[js.Object => ReactElement] = js.undefined,
                       className: js.UndefOr[String] = js.undefined,
                       onFocus: js.UndefOr[ReactEvent => Callback] = js.undefined,
                       ignoreCase: js.UndefOr[Boolean] = js.undefined,
                       disabled: js.UndefOr[Boolean] = js.undefined,
                       autoload: js.UndefOr[Boolean] = js.undefined,
                       value: js.UndefOr[String] = js.undefined,
                       multi: js.UndefOr[Boolean] = js.undefined,
                       searchPromptText: js.UndefOr[String] = js.undefined,
                       delimiter: js.UndefOr[String] = js.undefined) {

  def apply() = {
    val props = JSMacro[ReactSelect](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(js.Dynamic.global.ReactSelect)
    f(props).asInstanceOf[ReactComponentU_]
  }

}

