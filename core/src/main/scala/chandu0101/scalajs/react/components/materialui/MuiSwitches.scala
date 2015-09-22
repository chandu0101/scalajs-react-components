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

case class MuiRadioButtonGroup(name: String,
                               style: U[js.Any] = uNone,
                               onChange: U[(ReactEventI, String) => Callback] = uNone,
                               labelPosition: U[MuiSwitchLabelPosition] = uNone,
                               ref: U[String] = uNone,
                               key: U[String] = uNone,
                               defaultSelected: U[String] = uNone,
                               valueSelected: U[String] = uNone) {

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiRadioButtonGroup](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.RadioButtonGroup)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}

@js.native
trait MuiRadioButtonGroupM extends js.Object {

  def getSelectedValue(): String = js.native

  def setSelectedValue(value: String): Unit = js.native

  def clearValue(): Unit = js.native

}

case class MuiToggle(onToggle: U[(ReactEvent, Boolean) => Callback] = uNone,
                     name: U[String] = uNone,
                     elementStyle: U[js.Any] = uNone,
                     style: U[js.Any] = uNone,
                     defaultToggled: U[Boolean] = uNone,
                     labelPosition: U[MuiSwitchLabelPosition] = uNone,
                     label: U[String] = uNone,
                     ref: U[String] = uNone,
                     key: U[String] = uNone,
                     disabled: U[Boolean] = uNone,
                     value: U[String] = uNone,
                     toggled: U[Boolean] = uNone) {

  def apply() = {
    val props = JSMacro[MuiToggle](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Toggle)
    f(props).asInstanceOf[ReactComponentU_]
  }

}

@js.native
trait MuiToggleM extends js.Object {

  def isToggled(): Boolean = js.native

  def setToggled(newToggledValue: Boolean): Unit = js.native

}

class MuiSwitchLabelPosition private(val value: String) extends AnyVal

object MuiSwitchLabelPosition {

  val LEFT = new MuiSwitchLabelPosition("left")
  val RIGHT = new MuiSwitchLabelPosition("right")

}
