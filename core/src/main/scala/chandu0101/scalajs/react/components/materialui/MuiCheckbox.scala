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
 * 
 * clsNames: React.PropTypes.css,
   key: React.PropTypes.key,
   ref: React.PropTypes.ref,
   disabled:React.PropTypes.bool,
   onCheck:React.PropTypes.funcbu,
   value:React.PropTypes.string,
   label:React.PropTypes.string,
   name:React.PropTypes.string,
   defaultChecked:React.PropTypes.bool,
   labelPosition:React.PropTypes.string,* *
 */
object MuiCheckbox {
  

  case class State(checked: Boolean)

  class Backend(t: BackendScope[Props, _]) {

    def isChecked = theEnhancedSwitchRef(t).get.backend.isSwitched

    def setChecked(newCheckedValue: Boolean) = theEnhancedSwitchRef(t).get.backend.setSwitched(newCheckedValue)

    def handleCheck(e: ReactEventI, isInputChecked: Boolean) = {
      if (t.props.onCheck != null) t.props.onCheck(e, isInputChecked)
    }

  }


  val theEnhancedSwitchRef = Ref.to(MuiEnhancedSwitch.component, "TheEnhancedRich")
  val theCheck = Ref[html.Input]("theCheck")
  val component = ReactComponentB[Props]("MuiCheckbox")
    .stateless
    .backend(new Backend(_))
    .render((P, S, B) => {
    val classes = CommonUtils.cssMap1M("mui-checkbox", P.clsNames)
    val checkBoxElement = div(
      MuiToggleCheckBoxOutlineBlank(cls := "mui-checkbox-box"), 
      MuiToggleCheckBoxChecked(cls := "mui-checkbox-check"))
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

  
  case class Props( name : String ,labelPosition : String ,clsNames : CssClassType ,label : String ,onCheck : REventIBooleanUnit ,ref :  js.UndefOr[String] ,key : js.Any ,disabled : Boolean ,defaultChecked : Boolean ,value : String  )

  def apply( name : String = "" ,labelPosition : String = "right" ,clsNames : CssClassType = Map(),label : String = "" ,onCheck : REventIBooleanUnit = null ,ref :  js.UndefOr[String] = "",key : js.Any = {},disabled : Boolean = false,defaultChecked : Boolean = false,value : String = ""  ) =
    component.set(key,ref)(Props(name,labelPosition,clsNames,label,onCheck,ref,key,disabled,defaultChecked,value))

}
