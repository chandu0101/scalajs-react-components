package chandu0101.scalajs.react.components.materialui


import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.util.CommonUtils
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import org.scalajs.dom.html

import scala.scalajs.js



/**
 * Created by chandrasekharkode .
 */
object MuiTextField {


  val theMultiInputRef = Ref.to(MuiEnhancedTextArea.component, "theMultiINputRef")
  val theInputRef = Ref[html.Input]("theInputRef")
  val component = ReactComponentB[Props]("MuiTextField")
    .initialStateP(p => State(p.errorText, p.value.nonEmpty || p.defaultValue.nonEmpty))
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
      MuiEnhancedTextArea.withDynamicProps(ref = theMultiInputRef, clsNames = Map("mui-text-field-input" -> true), onHeightChange = B.handleTextAreaHeightChange, textareaClassName = "mui-text-field-textarea")(id := inputId, onBlur ==> B.handleInputBlur, onFocus ==> B.handleInpitFocus)
    else input(id := inputId,
      onBlur ==> B.handleInputBlur,
      onFocus ==> B.handleInpitFocus,
      ref := theInputRef,
      name := P.name,
      placeholder := P.placeholder,
      defaultValue := P.defaultValue,
      value := P.value,
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
    if (nextProps.value.nonEmpty) scope.modState(_.copy(errorText = nextProps.errorText, hasValue = true))
    else if (nextProps.defaultValue != scope.props.defaultValue) scope.modState(_.copy(errorText = nextProps.errorText, hasValue = true))
  })
    .build

  def isValueDefined(p: Props) = {
    //    p.dynamicProps.view.exists(item => {
    //      val attrPair = if(p.tpe == "number") item.asInstanceOf[AttrPair[Double]]
    //                      else item.asInstanceOf[AttrPair[String]]
    //      ( attrPair.a == defaultValue || attrPair.a == value)
    //    })
    false
  }

  def apply(onTouchTap: REventIUnit = null, name: String = "", disabled: Boolean = false, value: String = "", defaultValue: String = "", onBlur: REventIAny = null, tpe: String = "text", multiLine: Boolean = false, onChange: REventIAny = null, clsNames: CssClassType = Map(), ref: js.UndefOr[String] = "", hintText: String = "", key: js.Any = {}, id: String = "", errorText: String = "", onFocus: REventIAny = null, floatingLabelText: String = "", placeholder: String = "") =
    component.set(key, ref)(Props(onTouchTap, name, disabled, value, defaultValue, onBlur, tpe, multiLine, onChange, clsNames, ref, hintText, key, id, errorText, onFocus, floatingLabelText, placeholder))

  case class State(errorText: String, hasValue: Boolean = false, isFocused: Boolean = false)

  class Backend(t: BackendScope[Props, State]) {


    def blur = if (t.isMounted()) getInputNode.blur()

    def clearValue = setValue("")

    def setValue(newValue: Any) = {
      if (t.isMounted()) getInputNode.value = newValue.toString
    }

    def focus = if (t.isMounted()) getInputNode.focus()

    def getInputNode = if (t.props.multiLine) theMultiInputRef(t).get.backend.getInputNode else theInputRef(t).get.getDOMNode()

    def getValue = if (t.isMounted()) getInputNode.value else ""

    def setErrorText(newErrorText: String) = if (t.isMounted()) t.modState(_.copy(errorText = newErrorText))

    def handleInputBlur(e: ReactEventI) = {
      t.modState(_.copy(isFocused = false))
      if (t.props.onBlur != null) t.props.onBlur(e)
    }

    def handleInpitFocus(e: ReactEventI) = {
      t.modState(_.copy(isFocused = true))
      if (t.props.onFocus != null) t.props.onFocus(e)
    }

    def handleTextAreaHeightChange(e: ReactEventI, height: Int) = {
      var newHeight = height + 24
      if (t.props.floatingLabelText.nonEmpty) newHeight += 24
      t.getDOMNode().style.height = s"${newHeight}px"
    }

  }

  case class Props(onTouchTap: REventIUnit, name: String, disabled: Boolean, value: String, defaultValue: String, onBlur: REventIAny, tpe: String, multiLine: Boolean, onChange: REventIAny, clsNames: CssClassType, ref: js.UndefOr[String], hintText: String, key: js.Any, id: String, errorText: String, onFocus: REventIAny, floatingLabelText: String, placeholder: String)


}
