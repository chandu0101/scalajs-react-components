package chandu0101.scalajs.react.components.materialui

import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.materialui.svgicons.{MuiToggleCheckBoxChecked, MuiToggleCheckBoxOutlineBlank}
import chandu0101.scalajs.react.components.util.CommonUtils
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import org.scalajs.dom.html

import scala.scalajs.js

/**
 * Created by chandrasekharkode .
 */
object MuiCheckbox {


  val theEnhancedSwitchRef = Ref.to(MuiEnhancedSwitch.component, "TheEnhancedRich")
  val theCheck = Ref[html.Input]("theCheck")
  val component = ReactComponentB[Props]("checkBox")
    .stateless
    .backend(new Backend(_))
    .render((P, S, B) => {
    val classes = CommonUtils.cssMap1M("mui-checkbox", P.clsNames)
    val checkBoxElement = div(MuiToggleCheckBoxOutlineBlank(cls := "mui-checkbox-box"), MuiToggleCheckBoxChecked(cls := "mui-checkbox-check"))
    MuiEnhancedSwitch(ref = theEnhancedSwitchRef,
      inputType = "checkbox",
      switchElement = checkBoxElement,
      clsNames = classes,
      iconClassName = "mui-checkbox-icon",
      onSwitch = B.handleCheck,
      label = P.label,
      name = P.name,
      defaultSwitched = P.defaultChecked,
      disabled = P.disabled,
      labelPosition = P.labelPosition)
  })
    .build


  case class State(checked: Boolean)

  class Backend(t: BackendScope[Props, _]) {

    def isChecked = theEnhancedSwitchRef(t).get.backend.isSwitched

    def setChecked(newCheckedValue: Boolean) = theEnhancedSwitchRef(t).get.backend.setSwitched(newCheckedValue)

    def handleCheck(e: ReactEventI, isINputChecked: Boolean) = {
      if (t.props.onCheck != null) t.props.onCheck(e, isINputChecked)
    }

  }


  case class Props(disabled: Boolean, labelPosition: String, clsNames: Map[String, Boolean], label: String, name: String, onCheck: REventIBooleanUnit, value: String, defaultChecked: Boolean)

  def apply(disabled: Boolean = false, labelPosition: String = "right", clsNames: Map[String, Boolean] = Map(), label: String = "", name: String = "", onCheck: REventIBooleanUnit = null, value: String = "", defaultChecked: Boolean = false, ref: js.UndefOr[String] = "", key: js.Any = {}) =
    component.set(key = key, ref = ref)(Props(disabled, labelPosition, clsNames, label, name, onCheck, value, defaultChecked))

}
