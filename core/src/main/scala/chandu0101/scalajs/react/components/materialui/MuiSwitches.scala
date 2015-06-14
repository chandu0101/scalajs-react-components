package chandu0101.scalajs.react.components.materialui

import japgolly.scalajs.react._
import materialui.Mui

import scala.scalajs.js


/**
 *
 * key: PropTypes.string,
style: PropTypes.js.Any,
ref: PropTypes.String,
name:PropTypes.String,
defaultChecked:PropTypes.bool,
disabled:PropTypes.bool,
label:PropTypes.String,
labelPosition:PropTypes.MuiSwitchLabelPosition,
value:PropTypes.String,
  iconStyle: React.PropTypes.js.Any,
    onCheck: React.PropTypes.(ReactEventI,Boolean)=>Unit,

 */

object MuiCheckBox {

  def apply(name: js.UndefOr[String] = js.undefined,
            style: js.UndefOr[js.Any] = js.undefined,
            iconStyle: js.UndefOr[js.Any] = js.undefined,
            labelPosition: js.UndefOr[MuiSwitchLabelPosition] = js.undefined,
            label: js.UndefOr[String] = js.undefined,
            onCheck: js.UndefOr[(ReactEventI, Boolean) => Unit] = js.undefined,
            ref: js.UndefOr[String] = js.undefined,
            key: js.UndefOr[String] = js.undefined,
            disabled: js.UndefOr[Boolean] = js.undefined,
            defaultChecked: js.UndefOr[Boolean] = js.undefined,
            value: js.UndefOr[String] = js.undefined) = {

    val p = js.Dynamic.literal()
    name.foreach(v => p.updateDynamic("name")(v))
    style.foreach(v => p.updateDynamic("style")(v))
    iconStyle.foreach(v => p.updateDynamic("iconStyle")(v))
    labelPosition.foreach(v => p.updateDynamic("labelPosition")(v.position))
    label.foreach(v => p.updateDynamic("label")(v))
    onCheck.foreach(v => p.updateDynamic("onCheck")(v))
    ref.foreach(v => p.updateDynamic("ref")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    disabled.foreach(v => p.updateDynamic("disabled")(v))
    defaultChecked.foreach(v => p.updateDynamic("defaultChecked")(v))
    value.foreach(v => p.updateDynamic("value")(v))

    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Checkbox)
    f(p).asInstanceOf[ReactComponentU_]
  }

}

/**
 * key: PropTypes.string,
style: PropTypes.js.Any,
ref: PropTypes.String,
defaultChecked:PropTypes.bool,
disabled:PropTypes.bool,
label:PropTypes.String,
labelPosition:PropTypes.MuiSwitchLabelPosition,
value:PropTypes.String,
  iconStyle: React.PropTypes.js.Any,

 */

object MuiRadioButton {

  def apply(style: js.UndefOr[js.Any] = js.undefined,
            iconStyle: js.UndefOr[js.Any] = js.undefined,
            labelPosition: js.UndefOr[MuiSwitchLabelPosition] = js.undefined,
            label: js.UndefOr[String] = js.undefined,
            ref: js.UndefOr[String] = js.undefined,
            key: js.UndefOr[String] = js.undefined,
            disabled: js.UndefOr[Boolean] = js.undefined,
            defaultChecked: js.UndefOr[Boolean] = js.undefined,
            value: js.UndefOr[String] = js.undefined) = {

    val p = js.Dynamic.literal()
    style.foreach(v => p.updateDynamic("style")(v))
    iconStyle.foreach(v => p.updateDynamic("iconStyle")(v))
    labelPosition.foreach(v => p.updateDynamic("labelPosition")(v.position))
    label.foreach(v => p.updateDynamic("label")(v))
    ref.foreach(v => p.updateDynamic("ref")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    disabled.foreach(v => p.updateDynamic("disabled")(v))
    defaultChecked.foreach(v => p.updateDynamic("defaultChecked")(v))
    value.foreach(v => p.updateDynamic("value")(v))

    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.RadioButton)
    f(p).asInstanceOf[ReactComponentU_]
  }

}

/**
 * key: PropTypes.string,
style: PropTypes.js.Any,
ref: PropTypes.String,
name: React.PropTypes.string.isRequired,
    valueSelected: React.PropTypes.string,
    defaultSelected: React.PropTypes.string,
    labelPosition: React.PropTypes.MuiSwitchLabelPosition,
		onChange: React.PropTypes.(ReactEventI,Boolean) => Unit

 */
case class MuiRadioButtonGroup(name: String,
                               style: js.UndefOr[js.Any] = js.undefined,
                               onChange: js.UndefOr[(ReactEventI, Boolean) => Unit] = js.undefined,
                               labelPosition: js.UndefOr[MuiSwitchLabelPosition] = js.undefined,
                               ref: js.UndefOr[String] = js.undefined,
                               key: js.UndefOr[String] = js.undefined,
                               defaultSelected: js.UndefOr[String] = js.undefined,
                               valueSelected: js.UndefOr[String] = js.undefined) {
  def toJS = {
    val p = js.Dynamic.literal()
    p.updateDynamic("name")(name)
    style.foreach(v => p.updateDynamic("style")(v))
    onChange.foreach(v => p.updateDynamic("onChange")(v))
    labelPosition.foreach(v => p.updateDynamic("labelPosition")(v.position))
    ref.foreach(v => p.updateDynamic("ref")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    defaultSelected.foreach(v => p.updateDynamic("defaultSelected")(v))
    valueSelected.foreach(v => p.updateDynamic("valueSelected")(v))
    p
  }

  def apply(children: ReactNode*) = {
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.RadioButtonGroup)
    f(toJS, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}

trait MuiRadioButtonGroupM extends js.Object {

  def getSelectedValue(): String = js.native

  def setSelectedValue(value: String): Unit = js.native

  def clearValue(): Unit = js.native


}

/**
 * key: PropTypes.string,
style: PropTypes.js.Any,
ref: PropTypes.String,
name: React.PropTypes.string,
label: React.PropTypes.string,
name: React.PropTypes.string,
    labelPosition: React.PropTypes.MuiSwitchLabelPosition,
elementStyle: React.PropTypes.js.Any,
    onToggle: React.PropTypes.(ReactEvent,Boolean) => Unit,
    toggled: React.PropTypes.bool,
    defaultToggled: React.PropTypes.bool,
    disabled: React.PropTypes.bool

 */

object MuiToggle {

  def apply(onToggle : js.UndefOr[(ReactEvent,Boolean) => Unit] = js.undefined,
            name : js.UndefOr[String] = js.undefined,
            elementStyle : js.UndefOr[js.Any] = js.undefined,
            style : js.UndefOr[js.Any] = js.undefined,
            defaultToggled : js.UndefOr[Boolean]=js.undefined,
            labelPosition : js.UndefOr[MuiSwitchLabelPosition] = js.undefined,
            label : js.UndefOr[String] = js.undefined,
            ref : js.UndefOr[String] = js.undefined,
            key : js.UndefOr[String] = js.undefined,
            disabled : js.UndefOr[Boolean]=js.undefined,
            value : js.UndefOr[String] = js.undefined,
            toggled : js.UndefOr[Boolean]=js.undefined) = {

    val p = js.Dynamic.literal()
    onToggle.foreach(v => p.updateDynamic("onToggle")(v))
    name.foreach(v => p.updateDynamic("name")(v))
    elementStyle.foreach(v => p.updateDynamic("elementStyle")(v))
    style.foreach(v => p.updateDynamic("style")(v))
    defaultToggled.foreach(v => p.updateDynamic("defaultToggled")(v))
    labelPosition.foreach(v => p.updateDynamic("labelPosition")(v.position))
    label.foreach(v => p.updateDynamic("label")(v))
    ref.foreach(v => p.updateDynamic("ref")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    disabled.foreach(v => p.updateDynamic("disabled")(v))
    value.foreach(v => p.updateDynamic("value")(v))
    toggled.foreach(v => p.updateDynamic("toggled")(v))

    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Toggle)
    f(p).asInstanceOf[ReactComponentU_]
  }

}


trait MuiToggleM extends js.Object {

  def isToggled(): Boolean = js.native

  def setToggled(newToggledValue: Boolean): Unit = js.native

}

class MuiSwitchLabelPosition private(val position: String) extends AnyVal

object MuiSwitchLabelPosition {

  val LEFT = new MuiSwitchLabelPosition("left")
  val RIGHT = new MuiSwitchLabelPosition("right")
}
