package chandu0101.scalajs.react.components.materialui


import chandu0101.scalajs.react.components.all._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import org.scalajs.dom.html

import scala.scalajs.js


/**
 * Created by chandrasekharkode .
 *  // TODO work on valueLink
 */
object MuiEnhancedTextArea {

  case class State(heightS: Int)

  class Backend(t: BackendScope[Props, State]) {

    def getInputNode =  theInputRef(t).get.getDOMNode()

    def _syncHeightWithShadow(newValue : String, e : ReactEventI) = {
      
      val shadow = theShadowRef(t).get.getDOMNode()
      val currentHeight = t.state.heightS
      if(newValue != null) shadow.value = newValue
      val newHeight = shadow.scrollHeight
      if(currentHeight != newHeight) {
        t.modState(_.copy(heightS = newHeight))
        if(t.props.onHeightChange != null) t.props.onHeightChange(e,newHeight)
      }
    }
    
    def handleChange(e: ReactEventI) = {
      _syncHeightWithShadow(e.target.value,e)
      if(t.props.onChange != null) t.props.onChange(e)
    }
    
    def handleInputFocus(e: ReactEventI) = {
      if(t.props.onFocus != null) t.props.onFocus(e)
    }
    
    def handleInputBlur(e: ReactEventI) = {
      if(t.props.onBlur != null) t.props.onBlur(e)
    }
  }

  val theInputRef = Ref[html.Input]("theINputRef")

  val theShadowRef = Ref[html.Input]("theShadowRef")


  val component = ReactComponentB[Props]("MuiEnhancedTextArea")
    .initialStateP(p => State(p.rows * 24))
    .backend(new Backend(_))
    .render((P, S, B) => {
      val classes = classSet1M("mui-enhanced-textarea",P.clsNames)
      val style = Seq(height := s"${S.heightS}px")
      val textareaClassName = s"mui-enhanced-textarea-input ${P.textareaClassName}"
      div(classes)(
       textarea(ref := theShadowRef , cls := "mui-enhanced-textarea-shadow",rows := P.rows ,tabIndex := "-1" ),
       textarea(ref := theInputRef ,cls := textareaClassName , rows := P.rows, style,onChange ==> B.handleChange ,onFocus ==> B.handleInputFocus,onBlur ==> B.handleInputBlur,id := P.id)
      )
    })
    .build

  case class Props(onChange: REventIAny, onHeightChange: REventIIntUnit, clsNames: CssClassType, ref: js.UndefOr[String], key: js.Any, textareaClassName: String, rows: Int,onFocus : REventIAny,onBlur : REventIAny,id : String)


  def apply(onChange: REventIAny = null, onHeightChange: REventIIntUnit = null, clsNames: CssClassType = Map(), ref: js.UndefOr[String] = "", key: js.Any = {}, textareaClassName: String = "", rows: Int = 1,onFocus : REventIAny = null ,onBlur : REventIAny = null ,id : String = "") =
    component.set(key, ref)(Props(onChange, onHeightChange, clsNames, ref, key, textareaClassName, rows,onFocus,onBlur,id))
}
