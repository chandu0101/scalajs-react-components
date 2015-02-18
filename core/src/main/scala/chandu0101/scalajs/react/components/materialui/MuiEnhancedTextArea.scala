package chandu0101.scalajs.react.components.materialui


import chandu0101.scalajs.react.components.all._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import org.scalajs.dom.html

import scala.scalajs.js


/**
 * Created by chandrasekharkode .
 *  // TODO work on valueLink
 *
clsNames: React.PropTypes.css,
key: React.PropTypes.key,
ref: React.PropTypes.ref,
    onChange: React.PropTypes.func,
    onHeightChange: React.PropTypes.func,
    textareaClassName: React.PropTypes.string,
    rows: React.PropTypes.number,
onBlur:React.PropTypes.func,
onFocus:React.PropTypes.func,
id:React.PropTypes.string

 *
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
    
    def handleChange(e: ReactEventI) : Unit = {
      _syncHeightWithShadow(e.target.value,e)
      if(t.props.onChange != null) t.props.onChange(e)
    }
    
    def handleInputFocus(e: ReactEventI) : Unit = {
      if(t.props.onFocus != null) t.props.onFocus(e)
    }
    
    def handleInputBlur(e: ReactEventI) : Unit = {
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


  case class Props( onBlur : REventIUnit ,onChange : REventIUnit ,onHeightChange : REventIIntUnit ,clsNames : CssClassType ,ref :  js.UndefOr[String] ,key : js.Any ,id : String ,onFocus : REventIUnit ,textareaClassName : String ,rows : Int  )

  def apply( onBlur : REventIUnit = null ,onChange : REventIUnit = null ,onHeightChange : REventIIntUnit = null ,clsNames : CssClassType = Map(),ref :  js.UndefOr[String] = "",key : js.Any = {},id : String = "" ,onFocus : REventIUnit = null ,textareaClassName : String = "" ,rows : Int = 1 ) =
    component.set(key,ref)(Props(onBlur,onChange,onHeightChange,clsNames,ref,key,id,onFocus,textareaClassName,rows))

}
