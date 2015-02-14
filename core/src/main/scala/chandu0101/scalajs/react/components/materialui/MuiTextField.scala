package chandu0101.scalajs.react.components.materialui


import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.util.CommonUtils
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import org.scalajs.dom.html

import scala.scalajs.js



/**
 * Created by chandrasekharkode .
 * //TODO valueLink
 *  clsNames: React.PropTypes.css,
    key: React.PropTypes.key,
    ref: React.PropTypes.ref,
    errorText: React.PropTypes.string,
    floatingLabelText: React.PropTypes.string,
    hintText: React.PropTypes.string,
    id: React.PropTypes.string,
    multiLine: React.PropTypes.bool,
    onBlur: React.PropTypes.func,
    onChange: React.PropTypes.func,
    onFocus: React.PropTypes.func,
    tpe: React.PropTypes.string,
    value:React.PropTypes.string,
    defaultValue:React.PropTypes.string,
    disabled:React.PropTypes.bool,
    onTouchTap:React.PropTypes.func,
    name:React.PropTypes.string,* *
 */
object MuiTextField {


  case class State(errorText: String, hasValue: Boolean = false, isFocused: Boolean = false)

  class Backend(t: BackendScope[Props, State]) {


    def blur = if (t.isMounted()) getInputNode.blur()

    def clearValue = setValue("")

    def setValue(newValue: Any) = {
      if (t.isMounted()) {
        getInputNode.value = newValue.toString
        t.modState(_.copy(hasValue = true))
      }
    }

    def focus = if (t.isMounted()) getInputNode.focus()

    def getInputNode = if (t.props.multiLine) theMultiInputRef(t).get.backend.getInputNode else theInputRef(t).get.getDOMNode()

    def getValue = if (t.isMounted()) getInputNode.value else ""

    def setErrorText(newErrorText: String) = if (t.isMounted()) t.modState(_.copy(errorText = newErrorText))

    def handleInputBlur(e: ReactEventI) = {
      t.modState(_.copy(isFocused = false))
      if (t.props.onBlur != null) t.props.onBlur(e)
    }

    def handleInputFocus(e: ReactEventI) = {
      t.modState(_.copy(isFocused = true))
      if (t.props.onFocus != null) t.props.onFocus(e)
    }

    def handleInputChange(e : ReactEventI) = {
      t.modState(_.copy(hasValue = e.target.value.nonEmpty))
      if(t.props.onChange != null) t.props.onChange(e)
    }
    def handleTextAreaHeightChange(e: ReactEventI, height: Int) = {
      var newHeight = height + 24
      if (t.props.floatingLabelText.nonEmpty) newHeight += 24
      t.getDOMNode().style.height = s"${newHeight}px"
    }

  }

  val theMultiInputRef = Ref.to(MuiEnhancedTextArea.component, "theMultiINputRef")
  val theInputRef = Ref[html.Input]("theInputRef")
  val component = ReactComponentB[Props]("MuiTextField")
    .initialStateP(p => State(p.errorText, p.value != null || p.defaultValue != null))
    .backend(new Backend(_))
    .render((P, S, B) => {
    val classes = CommonUtils.cssMap1M("mui-text-field", P.clsNames,
      "mui-has-error" -> P.errorText.nonEmpty,
      "mui-has-floating-labels" -> P.floatingLabelText.nonEmpty,
      "mui-has-value" -> S.hasValue,
      "mui-is-disabled" -> P.disabled,
      "mui-is-focused" -> S.isFocused,
      "mui-is-multiLine" -> P.multiLine
    )
    val inputId = if (P.id.nonEmpty) P.id else "thenewcooltextfield"
    val errorTextElement = S.errorText.nonEmpty ?= div(cls := "mui-text-field-error")(S.errorText)
    val hintTextElement = P.hintText.nonEmpty ?= div(cls := "mui-text-field-hint")(P.hintText)
    val floatingTextElement = P.floatingLabelText.nonEmpty ?= label(cls := "mui-text-field-floating-label", htmlFor := inputId)(P.floatingLabelText)
    val inputElement: TagMod = if (P.multiLine) 
    MuiEnhancedTextArea(ref = theMultiInputRef, 
      clsNames = Map("mui-text-field-input" -> true),
      onHeightChange = B.handleTextAreaHeightChange, 
      onChange = B.handleInputChange,
      textareaClassName = "mui-text-field-textarea",
      id = inputId,
      onBlur = B.handleInputBlur,
        onFocus = B.handleInputFocus)
    else input(id := inputId,
      onBlur ==> B.handleInputBlur,
      onFocus ==> B.handleInputFocus,
      ref := theInputRef,
      P.name!= null ?= (name := P.name),
      tpe := P.tpe,
      onChange ==> B.handleInputChange,
      P.defaultValue!= null ?= (defaultValue := P.defaultValue),
      P.value != null ?= (value := P.value),
      P.onTouchTap != null ?= onClick ==> P.onTouchTap,
      cls := "mui-text-field-input")
    div(classSetM(classes))(
      floatingTextElement,
      hintTextElement,
      inputElement,
      hr(cls := "mui-text-field-underline"),
      hr(cls := "mui-text-field-focus-underline"),
      errorTextElement
    )
  })
    .componentWillReceiveProps((scope, nextProps) => {
    if (nextProps.value != null) scope.modState(_.copy(errorText = nextProps.errorText, hasValue = true))
    else if (nextProps.defaultValue != null) scope.modState(_.copy(errorText = nextProps.errorText, hasValue = true))
  })
    .build


  case class Props( onBlur : REventIAny ,tpe : String ,name : String ,multiLine : Boolean ,onChange : REventIAny ,clsNames : CssClassType ,ref :  js.UndefOr[String] ,hintText : String ,key : js.Any ,id : String ,errorText : String ,onTouchTap : REventIUnit ,onFocus : REventIAny ,disabled : Boolean ,floatingLabelText : String ,defaultValue : String ,value : String  )

  def apply( onBlur : REventIAny = null ,tpe : String = "text" ,name : String = null ,multiLine : Boolean = false,onChange : REventIAny = null ,clsNames : CssClassType = Map(),ref :  js.UndefOr[String] = "",hintText : String = "" ,key : js.Any = {},id : String = "" ,errorText : String = "" ,onTouchTap : REventIUnit = null ,onFocus : REventIAny = null ,disabled : Boolean = false,floatingLabelText : String = "" ,defaultValue : String = null ,value : String = null  ) =
    component.set(key,ref)(Props(onBlur,tpe,name,multiLine,onChange,clsNames,ref,hintText,key,id,errorText,onTouchTap,onFocus,disabled,floatingLabelText,defaultValue,value))


}
