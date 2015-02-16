package chandu0101.scalajs.react.components.materialui


import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.materialui.ripples.{FocusRipple, TouchRipple}
import chandu0101.scalajs.react.components.mixins.WindowListeners
import chandu0101.scalajs.react.components.util._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import org.scalajs.dom
import org.scalajs.dom.ext.KeyCode
import org.scalajs.dom.{Event, KeyboardEvent, html}

import scala.scalajs.js


/**
 * Created by chandrasekharkode .
 *  //TODO valuelink
 *
clsNames: React.PropTypes.css,
key: React.PropTypes.key,
ref: React.PropTypes.ref,
    id: React.PropTypes.string,
      inputType: React.PropTypes.string.isRequired,
      switchElement: React.PropTypes.element.isRequired,
      iconClassName: React.PropTypes.string.isRequired,
      name: React.PropTypes.string,
	    value: React.PropTypes.string,
	    label: React.PropTypes.string,
	    onSwitch: React.PropTypes.funcbu,
	    required: React.PropTypes.bool,
	    disabled: React.PropTypes.bool,
toggled:React.PropTypes.bool,
checked:React.PropTypes.bool,
	    defaultSwitched: React.PropTypes.bool,
      labelPosition: React.PropTypes.string,
      disableFocusRipple: React.PropTypes.bool,
      disableTouchRipple: React.PropTypes.bool

 * *
 */
object MuiEnhancedSwitch {


  case class State(switched: Boolean, isKeyBoardFocusedS: Boolean = false)

  class Backend(t: BackendScope[Props, State]) extends WindowListeners {

    var tabPressed = false

    def isSwitched = theCheckBoxRef(t).get.getDOMNode().checked

    def setSwitched(newSwitchedValue: Boolean) = {
      if (!t.props.checked) {
        t.modState(_.copy(switched = newSwitchedValue))
        theCheckBoxRef(t).get.getDOMNode().checked = newSwitchedValue
      } else {
        dom.console.log("Cannot call set method while checked is defined as a property.")
      }
    }

    def getValue = theCheckBoxRef(t).get.getDOMNode().value

    def isKeyboardFocused = t.state.isKeyBoardFocusedS

    def handleChange(e: ReactEventI) : Unit = {
      tabPressed = false;
      t.modState(_.copy(isKeyBoardFocusedS = false))
      val isINputChecked = theCheckBoxRef(t).get.getDOMNode().checked
      if (!t.props.checked) t.modState(_.copy(switched = isINputChecked))
      if (t.props.onSwitch != null) t.props.onSwitch(e, isINputChecked)
    }

    /**
     * Because both the ripples and the checkbox input cannot share pointer
     * events, the checkbox input takes control of pointer events and calls
     * ripple animations manually.
     */

    // Checkbox inputs only use SPACE to change their state. Using ENTER will
    // update the ui but not the input.
    lazy val handleWindowKeyDown: js.Function1[Event, _] = (e: Event) => {
      val keyEvent = e.asInstanceOf[KeyboardEvent]
      if (keyEvent.keyCode == KeyCode.tab) tabPressed = true
       else if (keyEvent.keyCode == 32 && t.state.isKeyBoardFocusedS) handleChange(e.asInstanceOf[ReactEventI])
    }

    lazy val handleWindowKeyUp: js.Function1[Event, _] = (e: Event) => {
      val keyEvent = e.asInstanceOf[KeyboardEvent]
      if (keyEvent.keyCode == 32 && t.state.isKeyBoardFocusedS) handleChange(e.asInstanceOf[ReactEventI])
    }

    def handleMouseDown(e: ReactEventI) : Unit = if (DomUtil.isLeftClick(e.nativeEvent)) theTouchRippleRef(t).get.backend.start(e)

    def handleMouseUp(e: ReactEventI) : Unit = theTouchRippleRef(t).get.backend.end

    def handleMouseOut(e: ReactEventI) : Unit = theTouchRippleRef(t).get.backend.end

    def handleTouchStart(e: ReactEventI) : Unit = theTouchRippleRef(t).get.backend.start(e)

    def handleTouchEnd(e: ReactEventI) : Unit = theTouchRippleRef(t).get.backend.end

    def handleBlur(e: ReactEventI) : Unit = {
      t.modState(_.copy(isKeyBoardFocusedS = false))
    }

    def handleFocus(e: ReactEventI) : Unit  = {
      //setTimeout is needed becuase the focus event fires first
      //Wait so that we can capture if this was a keyboard focus
      //or touch focus
      dom.setTimeout(() => {
        if (tabPressed && t.isMounted()) {
          t.modState(_.copy(isKeyBoardFocusedS = true))
        }
      }, 150)
    }

    override def listeners: List[(String, js.Function1[Event, _])] = List(Events.KEYUP -> handleWindowKeyUp, Events.KEYDOWN -> handleWindowKeyDown)
  }

  val theCheckBoxRef = Ref[html.Input]("theCheckBoxRef")

  val theTouchRippleRef = Ref.to(TouchRipple.component, "theTouchRippleRef")

  val component = ReactComponentB[Props]("MuiEnhancedSwitch")
    .initialStateP(p => State(p.defaultSwitched))
    .backend(new Backend(_))
    .render((P, S, B) => {
    val classes = CommonUtils.cssMap1M("mui-enhanced-switch",
      P.clsNames, "mui-is-switched" -> S.switched,
      "mui-is-disabled" -> P.disabled,
      "mui-is-required" -> P.required)
    val inputId = if (P.id.nonEmpty) P.id else "domid$$$$" // TODO replace hard coded strin with domid util
    val labelElement = P.label.nonEmpty ?= label(cls := "mui-switch-label", htmlFor := inputId)(P.label)
    val inputElement = input(tpe := P.inputType,
      P.name != null ?= (name := P.name),
      P.value != null ?= (value := P.value),
      defaultChecked := P.defaultSwitched,
      onBlur ==> B.handleBlur,
      id := inputId,
      onFocus ==> B.handleFocus,
      onMouseUp ==> B.handleMouseUp,
      ref := theCheckBoxRef,
      onMouseDown ==> B.handleMouseDown,
      onMouseOut ==> B.handleMouseOut,
      onTouchStart ==> B.handleTouchStart,
      onTouchEnd ==> B.handleTouchEnd,
      disabled := P.disabled,
      onChange ==> B.handleChange,
      cls := "mui-enhanced-switch-input")
    val touchRipple: ReactNode = if (!P.disabled && !P.disableTouchRipple) TouchRipple(ref = theTouchRippleRef, key = "thetouchripple", centerRipple = true) else ""
    val focusRipple: ReactNode = if (!P.disabled && !P.disableFocusRipple) FocusRipple(key = "focusripple", show = S.isKeyBoardFocusedS) else ""

    val iconClassName = s"${P.iconClassName} mui-enhanced-switch-wrap"

    val switchElement : TagMod = if (iconClassName.indexOf("toggle") == -1) div(cls := iconClassName)(P.switchElement, touchRipple, focusRipple)
    else div(cls := iconClassName)(div(cls := "mui-toggle-track"), MuiPaper(clsNames = Map("mui-toggle-thumb" -> true), zDepth = 1)(touchRipple, focusRipple))

    val elementsOrder = if (P.labelPosition.toLowerCase == "right") div(switchElement, labelElement) else div(labelElement, switchElement)
    div(classSetM(classes))(
      inputElement,
      elementsOrder
    )
  })
    .componentDidMount(scope => {
    val inputNode = theCheckBoxRef(scope).get.getDOMNode()
    scope.modState(_.copy(switched = inputNode.checked))
  })
    .componentWillReceiveProps((scope, nextProps) => {

//    if (nextProps.valueLink) scope.modState(s => State(switched = true))
     if (nextProps.toggled) scope.modState(s => State(switched = true))
    else if (nextProps.checked) scope.modState(s => State(switched = true))
  })
    .configure(WindowListeners.mixin)
    .build



  case class Props( iconClassName : String ,name : String ,switchElement : ReactElement,onSwitch : REventIBooleanUnit ,disableTouchRipple : Boolean ,checked : Boolean ,labelPosition : String ,clsNames : CssClassType ,label : String ,ref :  js.UndefOr[String] ,defaultSwitched : Boolean ,key : js.Any ,disableFocusRipple : Boolean ,id : String ,disabled : Boolean ,required : Boolean ,inputType : String ,value : String ,toggled : Boolean  )

  def apply( iconClassName : String ,name : String = "" ,switchElement : ReactElement,onSwitch : REventIBooleanUnit = null ,disableTouchRipple : Boolean = false,checked : Boolean = false,labelPosition : String = "" ,clsNames : CssClassType = Map(),label : String = "" ,ref :  js.UndefOr[String] = "",defaultSwitched : Boolean = false,key : js.Any = {},disableFocusRipple : Boolean = false,id : String = "" ,disabled : Boolean = false,required : Boolean = false,inputType : String ,value : String = "" ,toggled : Boolean = false ) =
    component.set(key,ref)(Props(iconClassName,name,switchElement,onSwitch,disableTouchRipple,checked,labelPosition,clsNames,label,ref,defaultSwitched,key,disableFocusRipple,id,disabled,required,inputType,value,toggled))

}
