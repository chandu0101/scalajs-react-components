package chandu0101.scalajs.react.components.materialui


import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.materialui.styles.MaterialUICss._
import chandu0101.scalajs.react.components.util.CommonUtils
import chandu0101.scalajs.react.components.util.InputTypes._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import org.scalajs.dom.html

import scala.scalajs.js



/**
 * Created by chandrasekharkode on 12/5/14.
 *  js props
 *  multiline: React.PropTypes.bool,
    required: React.PropTypes.bool,
    inlinePlaceholder: React.PropTypes.bool,
    rows: React.PropTypes.number,
    inputStyle: React.PropTypes.string,
    error: React.PropTypes.string,
    description: React.PropTypes.string,
    placeholder: React.PropTypes.string,
    type: React.PropTypes.string,
    name: React.PropTypes.string.isRequired,
    onChange: React.PropTypes.func

 */
object MuiInput {


  case class Props(defaultValue: String, name: String, multiline: Boolean, step: Long, description: String, onChange: REventIStringAny, min: Long, inputStyle: String, placeholder: String, valueLink: Boolean, max: Long, error: String, tpe: String, required: Boolean, classNames: CssClassType,inlinePlaceHolder : Boolean,disabled : Boolean,onFocus : REventIUnit,onTouchTap : REventIUnit ,rows : Int)

  case class State(value: String, rows: Long, error: String)

  class Backend(t: BackendScope[Props, State]) {

    def setError(error: String) = t.modState(_.copy(error = error))

    def removeError() = t.modState(_.copy(error = ""))

    def setValue(value: String) = t.modState(_.copy(value = value,error =""))

    def getValue = t.state.value

    def getCustomValue : js.Any = t.props.tpe match {
      case NUMBER => getValue.toDouble
      case _ => getValue
    }

    def clearValue() = setValue("")

    def onPlaceholderClick() = {
      theInputRef(t).tryFocus()
    }

    def onTextAreaChange(e: ReactEventI) = {
      onInputChange(e)
      onLineBreak(e)
    }

    def onInputChange(e: ReactEventI) = {
      val value = e.target.value
      setValue(value)
      if (t.props.onChange != null) t.props.onChange(e, value)
    }

    def onLineBreak(e: ReactEventI) = t.modState(s => State(s.value, s.rows + 1, s.error))

    def onInputFocus(e: ReactEventI) = {
      if(t.props.onFocus != null) t.props.onFocus(e)
    }

    def onInputTouchTap(e: ReactEventI) = {
      if(t.props.onTouchTap != null) t.props.onTouchTap(e)

    }
  }

  val theInputRef = Ref[html.Input]("theinput")

 def getInputElement(props:Props,backend : Backend,state : State) = {
   val placeHolderText = if(props.inlinePlaceHolder) props.placeholder else ""
   val textClasses = classSet(mui_is_not_empty -> !state.value.isEmpty)
   val textAreaClasses = classSet1(mui_input_textarea,mui_is_not_empty -> !state.value.isEmpty)
   if (props.multiline) {
     if (props.valueLink) textarea(textAreaClasses, placeholder := placeHolderText, rows := state.rows ,required := props.required,`type` := props.tpe , name := props.name ,disabled := props.disabled)
     else textarea(textAreaClasses, placeholder := placeHolderText, rows := state.rows, value := state.value, onChange ==> backend.onTextAreaChange,required := props.required,`type` := props.tpe , name := props.name,disabled := props.disabled)
   } else {
     if (props.valueLink) input(textClasses)(ref := theInputRef, placeholder := placeHolderText,required := props.required,`type` := props.tpe , name := props.name,disabled := props.disabled ,onFocus ==> backend.onInputFocus ,onClick ==> backend.onInputTouchTap)
     else input(textClasses)(ref := theInputRef, placeholder := placeHolderText, value := state.value, onChange ==> backend.onInputChange,required := props.required,`type` := props.tpe , name := props.name,disabled := props.disabled ,onFocus ==> backend.onInputFocus ,onClick ==> backend.onInputTouchTap)
   }
 }


  val component = ReactComponentB[Props]("input")
    .initialStateP(p => State(p.defaultValue, p.rows, p.error))
    .backend(new Backend(_))
    .render((P, S, B) => {
    val classes = CommonUtils.cssMapM(P.classNames, mui_input -> true,
      mui_floating -> (P.inputStyle == "floating"),
      mui_text -> (P.tpe != "textarea"),
      mui_error -> (!S.error.isEmpty),
      mui_disabled -> P.disabled)
      div(classSetM(classes))(
        getInputElement(P,B,S),
       if(P.inlinePlaceHolder) "" else  span(cls := mui_input_placeholder ,onClick --> B.onPlaceholderClick)(P.placeholder),
       span(cls := mui_input_highlight),
       span(cls := mui_input_bar),
       span(cls := mui_input_description)(P.description),
       span(cls := mui_input_error)(S.error)
      )
    })
    .build

  def apply(defaultValue: String = "", name: String, multiline: Boolean = false, step: Long = 0, description: String = "", onChange: REventIStringAny = null, min: Long = 0, inputStyle: String = "", placeholder: String = "", valueLink: Boolean = false, max: Long = 0, error: String = "", tpe: String = "text", required: Boolean = false, classNames: CssClassType = Map(),inlinePlaceholder :Boolean = false, disabled : Boolean = false,ref: js.UndefOr[String] = "", key: js.Any = {} ,onFocus : REventIUnit = null ,onTouchTap : REventIUnit = null ,rows : Int = 1) = {
    component.set(key,ref)(Props(defaultValue, name, multiline, step, description, onChange, min, inputStyle, placeholder, valueLink, max, error, tpe, required, classNames,inlinePlaceholder,disabled,onFocus,onTouchTap,rows))
  }


}
