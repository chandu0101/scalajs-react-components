package chandu0101.scalajs.react.components
package materialui

import japgolly.scalajs.react._
import scala.scalajs.js

case class MuiRadioButton(style: U[js.Any] = uNone,
                          iconStyle: U[js.Any] = uNone,
                          labelPosition: U[MuiSwitchLabelPosition] = uNone,
                          label: U[String] = uNone,
                          ref: U[String] = uNone,
                          key: U[String] = uNone,
                          disabled: U[Boolean] = uNone,
                          defaultChecked: U[Boolean] = uNone,
                          value: U[String] = uNone) {

  def apply() = {
    val props = JSMacro[MuiRadioButton](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.RadioButton)
    f(props).asInstanceOf[ReactComponentU_]
  }

}
