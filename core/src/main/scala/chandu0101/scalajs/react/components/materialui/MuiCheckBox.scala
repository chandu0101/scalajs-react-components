package chandu0101.scalajs.react.components
package materialui

import japgolly.scalajs.react._
import scala.scalajs.js

case class MuiCheckBox(name: U[String] = uNone,
                       style: U[js.Any] = uNone,
                       iconStyle: U[js.Any] = uNone,
                       labelPosition: U[MuiSwitchLabelPosition] = uNone,
                       label: U[String] = uNone,
                       onCheck: U[(ReactEventI, Boolean) => Callback] = uNone,
                       ref: U[String] = uNone,
                       key: U[String] = uNone,
                       unCheckedIcon: U[ReactElement] = uNone,
                       checkedIcon: U[ReactElement] = uNone,
                       disabled: U[Boolean] = uNone,
                       defaultChecked: U[Boolean] = uNone,
                       value: U[String] = uNone) {

  def apply() = {
    val props = JSMacro[MuiCheckBox](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Checkbox)
    f(props).asInstanceOf[ReactComponentU_]
  }

}
