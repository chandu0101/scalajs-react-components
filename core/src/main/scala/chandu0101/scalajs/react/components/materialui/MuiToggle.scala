package chandu0101.scalajs.react.components.materialui

import chandu0101.scalajs.react.components.all._
import japgolly.scalajs.react.vdom.all._
import japgolly.scalajs.react.{BackendScope, ReactComponentB, ReactEventI, _}

import scala.scalajs.js




/**
 * Created by chandrasekharkode on 12/3/14.
 * onToggle: React.PropTypes.func,
    toggled: React.PropTypes.bool
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
    val toggleElement = div(div(cls := "mui-toggle-track"),MuiPaper(clsNames = Map("mui-toggle-thumb" -> true),zDepth = 1)())

     MuiEnhancedSwitch(ref = theEnhancedSwitchRef ,
       value = P.value,
       label = P.label,
       disabled = P.disabled,
       checked = P.toggled,
       inputType = "checkbox",
       switchElement = toggleElement,
      clsNames = Map("mui-toggle" -> true),
       iconClassName = "mui-toggle-icon",
      onSwitch = B.handleToggle,
      defaultSwitched = P.defaultToggled,
      labelPosition = P.labelPosition)
    })
    .build

  case class Props(disabled : Boolean,name : String ,value : String , label : String,labelPosition : String,defaultToggled : Boolean,toggled : Boolean ,classNames: CssClassType, onToggle: REventIBooleanUnit)

  def apply(disabled : Boolean = false ,name : String = "",value : String = "", label : String = "", labelPosition : String = "left" ,defaultToggled : Boolean = false,toggled : Boolean = false,classNames: CssClassType = Map(), onToggle: REventIBooleanUnit = null,ref: js.UndefOr[String] = "", key: js.Any = {}) = {
    component.set(key,ref)(Props(disabled,name,value,label,labelPosition,defaultToggled,toggled,classNames,onToggle))
  }

}
