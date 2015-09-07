package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import materialui.Mui

import scala.scalajs.js


case class MuiCheckBox(name: js.UndefOr[String] = js.undefined,
                       style: js.UndefOr[js.Any] = js.undefined,
                       iconStyle: js.UndefOr[js.Any] = js.undefined,
                       labelPosition: js.UndefOr[MuiSwitchLabelPosition] = js.undefined,
                       label: js.UndefOr[String] = js.undefined,
                       onCheck: js.UndefOr[(ReactEventI, Boolean) => Unit] = js.undefined,
                       ref: js.UndefOr[String] = js.undefined,
                       key: js.UndefOr[String] = js.undefined,
                       unCheckedIcon: js.UndefOr[ReactElement] = js.undefined,
                       checkedIcon: js.UndefOr[ReactElement] = js.undefined,
                       disabled: js.UndefOr[Boolean] = js.undefined,
                       defaultChecked: js.UndefOr[Boolean] = js.undefined,
                       value: js.UndefOr[String] = js.undefined) {

  def apply() = {
    val props = JSMacro[MuiCheckBox](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Checkbox)
    f(props).asInstanceOf[ReactComponentU_]
  }

}


case class MuiRadioButton(style: js.UndefOr[js.Any] = js.undefined,
                          iconStyle: js.UndefOr[js.Any] = js.undefined,
                          labelPosition: js.UndefOr[MuiSwitchLabelPosition] = js.undefined,
                          label: js.UndefOr[String] = js.undefined,
                          ref: js.UndefOr[String] = js.undefined,
                          key: js.UndefOr[String] = js.undefined,
                          disabled: js.UndefOr[Boolean] = js.undefined,
                          defaultChecked: js.UndefOr[Boolean] = js.undefined,
                          value: js.UndefOr[String] = js.undefined) {

  def apply() = {
    val props = JSMacro[MuiRadioButton](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.RadioButton)
    f(props).asInstanceOf[ReactComponentU_]
  }

}


case class MuiRadioButtonGroup(name: String,
                               style: js.UndefOr[js.Any] = js.undefined,
                               onChange: js.UndefOr[(ReactEventI, String) => Unit] = js.undefined,
                               labelPosition: js.UndefOr[MuiSwitchLabelPosition] = js.undefined,
                               ref: js.UndefOr[String] = js.undefined,
                               key: js.UndefOr[String] = js.undefined,
                               defaultSelected: js.UndefOr[String] = js.undefined,
                               valueSelected: js.UndefOr[String] = js.undefined) {

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


case class MuiToggle(onToggle: js.UndefOr[(ReactEvent, Boolean) => Unit] = js.undefined,
                     name: js.UndefOr[String] = js.undefined,
                     elementStyle: js.UndefOr[js.Any] = js.undefined,
                     style: js.UndefOr[js.Any] = js.undefined,
                     defaultToggled: js.UndefOr[Boolean] = js.undefined,
                     labelPosition: js.UndefOr[MuiSwitchLabelPosition] = js.undefined,
                     label: js.UndefOr[String] = js.undefined,
                     ref: js.UndefOr[String] = js.undefined,
                     key: js.UndefOr[String] = js.undefined,
                     disabled: js.UndefOr[Boolean] = js.undefined,
                     value: js.UndefOr[String] = js.undefined,
                     toggled: js.UndefOr[Boolean] = js.undefined) {

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
