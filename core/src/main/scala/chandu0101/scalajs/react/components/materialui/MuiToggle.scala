package chandu0101.scalajs.react.components.materialui

import chandu0101.scalajs.react.components.all._
import japgolly.scalajs.react.vdom.prefix_<^._
import japgolly.scalajs.react.{BackendScope, ReactComponentB, ReactEventI, _}

import scala.scalajs.js




/**
 * Created by chandrasekharkode on 12/3/14.

clsNames: React.PropTypes.css,
key: React.PropTypes.key,
ref: React.PropTypes.ref,
  onToggle: React.PropTypes.func,
    toggled: React.PropTypes.bool,
    disabled: React.PropTypes.bool,
    defaultToggled: React.PropTypes.bool,
value:React.PropTypes.string,
label:React.PropTypes.string,
labelPosition:React.PropTypes.string,
onToggle:React.PropTypes.funcbu,
name:React.PropTypes.string,


 */
object MuiToggle {


  case class State(toggle: Boolean)

  class Backend(t: BackendScope[Props, State]) {

    def isToggled = theEnhancedSwitchRef(t).get.backend.isSwitched

    def setToggled(newToggleValue : Boolean) = theEnhancedSwitchRef(t).get.backend.setSwitched(newToggleValue)

    def handleToggle(e : ReactEventI , isInputChecked : Boolean) = {
       println(s"handle toggle called $isInputChecked ")
      if(t.props.onToggle != null) t.props.onToggle(e,isInputChecked)
    }

  }

  val theEnhancedSwitchRef = Ref.to(MuiEnhancedSwitch.component,"theEnhancedSwitchRefToggle")

  val component = ReactComponentB[Props]("MuiToggle")
    .initialState(State(toggle = false))
    .backend(new Backend(_))
    .render((P, S, B) => {
    val toggleElement = <.div(<.div(^.cls := "mui-toggle-track"),
      MuiPaper(clsNames = Map("mui-toggle-thumb" -> true),zDepth = 1)())

     MuiEnhancedSwitch(ref = theEnhancedSwitchRef ,
       value = P.value,
       label = P.label,
       disabled = P.disabled,
       checked = P.toggled,
       inputType = "checkbox",
       name = P.name,
       switchElement = toggleElement,
      clsNames = Map("mui-toggle" -> true),
       iconClassName = "mui-toggle-icon",
      onSwitch = B.handleToggle,
      defaultSwitched = P.defaultToggled,
      labelPosition = P.labelPosition)
    })
    .build



  case class Props( onToggle : REventIBooleanUnit ,name : String ,defaultToggled : Boolean ,labelPosition : String ,clsNames : CssClassType ,label : String ,ref :  js.UndefOr[String] ,key : js.Any ,disabled : Boolean ,value : String ,toggled : Boolean  )

  def apply( onToggle : REventIBooleanUnit = null ,name : String = "" ,defaultToggled : Boolean = false,labelPosition : String = "left" ,clsNames : CssClassType = Map(),label : String = "" ,ref :  js.UndefOr[String] = "",key : js.Any = {},disabled : Boolean = false,value : String = "" ,toggled : Boolean = false ) =
    component.set(key,ref)(Props(onToggle,name,defaultToggled,labelPosition,clsNames,label,ref,key,disabled,value,toggled))


}
