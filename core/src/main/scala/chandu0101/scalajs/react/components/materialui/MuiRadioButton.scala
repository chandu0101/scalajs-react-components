package chandu0101.scalajs.react.components.materialui

import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.materialui.svgicons.{MuiToggleRadioButtonOff, MuiToggleRadioButtonOn}
import japgolly.scalajs.react.vdom.all._
import japgolly.scalajs.react.{BackendScope, ReactComponentB, ReactEventI, _}
import org.scalajs.dom.html

import scala.scalajs.js


/**
 * Created by chandrasekharkode .
 */
object MuiRadioButton {


  case class State(checked: Boolean)

  // if checked attr used on radio then facebook react throwing warning ... so workaround
  val theRadio = Ref[html.Input]("theRadio")

  class Backend(t: BackendScope[Props, State]) {

    // Only called when selected, not when unselected.
    def handleCheck(e: ReactEventI, newValue: Boolean) = if (t.props.onCheck != null) t.props.onCheck(e, t.props.value)

    def isChecked = theEnhancedSwitchRef(t).get.backend.isSwitched

    def getValue = theEnhancedSwitchRef(t).get.backend.getValue

    def setChecked(newCheckedValue: Boolean) = {
      theEnhancedSwitchRef(t).get.backend.setSwitched(newCheckedValue)
    }

  }

  val theEnhancedSwitchRef = Ref.to(MuiEnhancedSwitch.component, "theEnhancedSwitchRefRadioButton")
  val component = ReactComponentB[Props]("MuiRadioButton")
    .initialStateP(p => State(p.defaultChecked))
    .backend(new Backend(_))
    .render((P, S, B) => {
    val radiotButtonElement = div(MuiToggleRadioButtonOff(cls := "mui-radio-button-target"), MuiToggleRadioButtonOn(cls := "mui-radio-button-fill"))
    MuiEnhancedSwitch(ref = theEnhancedSwitchRef,
      inputType = "radio",
      switchElement = radiotButtonElement,
      clsNames = Map("mui-radio-button" -> true),
      onSwitch = B.handleCheck,
      iconClassName = "mui-radio-button-icon",
      label = P.label,
      name = P.name,
      defaultSwitched = P.defaultChecked,
      disabled = P.disabled,
      labelPosition = P.labelPosition)
  })
    .build

  case class Props(disabled: Boolean, labelPosition: String, classNames: Map[String, Boolean], label: String, name: String, onCheck: REventIStringUnit, value: String, defaultChecked: Boolean)

  def apply(disabled: Boolean = false, labelPosition: String = "right", classNames: Map[String, Boolean] = Map(), label: String = "", name: String = "", onCheck: REventIStringUnit = null, value: String = "", defaultChecked: Boolean = false, ref: js.UndefOr[String] = "", key: js.Any = {}) = {
    component.set(key = key, ref = ref)(Props(disabled, labelPosition, classNames, label, name, onCheck, value, defaultChecked))
  }
}
