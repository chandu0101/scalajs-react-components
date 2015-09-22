package chandu0101.scalajs.react.components
package optionselectors

import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.{Array => JArray}

case class ReactSelect(inputProps: U[js.Object] = uNone,
                       onBlur: U[ReactEvent => Callback] = uNone,
                       name: U[String] = uNone,
                       clearable: U[Boolean] = uNone,
                       clearAllText: U[String] = uNone,
                       filterOptions: U[(JArray[js.Object], String) => JArray[String]] = uNone,
                       asyncOptions: U[js.Function] = uNone,
                       onChange: U[String => Callback] = uNone,
                       valueRenderer: U[js.Object => ReactElement] = uNone,
                       clearValueText: U[String] = uNone,
                       matchPos: U[String] = uNone,
                       matchProp: U[String] = uNone,
                       ref: U[String] = uNone,
                       allowCreate: U[Boolean] = uNone,
                       placeholder: U[String] = uNone,
                       filterOption: U[(js.Object, String) => Boolean] = uNone,
                       key: U[String] = uNone,
                       searchable: U[Boolean] = uNone,
                       noResultsText: U[String] = uNone,
                       options: U[JArray[js.Object]] = uNone,
                       onOptionLabelClick: U[(String, ReactEvent) => Callback] = uNone,
                       optionRenderer: U[js.Object => ReactElement] = uNone,
                       className: U[String] = uNone,
                       onFocus: U[ReactEvent => Callback] = uNone,
                       ignoreCase: U[Boolean] = uNone,
                       disabled: U[Boolean] = uNone,
                       autoload: U[Boolean] = uNone,
                       value: U[String] = uNone,
                       multi: U[Boolean] = uNone,
                       searchPromptText: U[String] = uNone,
                       delimiter: U[String] = uNone) {

  def apply() = {
    val props = JSMacro[ReactSelect](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(js.Dynamic.global.ReactSelect)
    f(props).asInstanceOf[ReactComponentU_]
  }

}

