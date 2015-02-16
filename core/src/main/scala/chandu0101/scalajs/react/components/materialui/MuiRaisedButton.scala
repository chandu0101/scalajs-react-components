package chandu0101.scalajs.react.components.materialui

import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.materialui.styles.MaterialUICss._
import chandu0101.scalajs.react.components.util.{DomUtil, CommonUtils}
import japgolly.scalajs.react.vdom.all._
import japgolly.scalajs.react.{BackendScope, ReactComponentB, ReactEventI, _}
import org.scalajs.dom

import scala.scalajs.js


/**
 * Created by chandrasekharkode .
 *
clsNames: React.PropTypes.css,
key: React.PropTypes.key,
ref: React.PropTypes.ref,
    onMouseDown: React.PropTypes.func,
    onMouseUp: React.PropTypes.func,
    onMouseOut: React.PropTypes.func,
    onTouchEnd: React.PropTypes.func,
    onTouchStart: React.PropTypes.func,
    primary: React.PropTypes.bool,
    secondary: React.PropTypes.bool,
disabled: React.PropTypes.bool,
label:React.PropTypes.string,
onTouchTap:React.PropTypes.func,
linkButton:React.PropTypes.bool,
url:React.PropTypes.string,
 disableFocusRipple :React.PropTypes.bool,
disableTouchRipple :React.PropTypes.bool,
 *
 */
object MuiRaisedButton {


  case class State(initialZDepth: Int, zDepth: Int)

  class Backend(t: BackendScope[Props, State]) {

    def animateButtonClick(e: ReactEventI) = {
      // animate zDepth change
      t.modState(s => State(s.initialZDepth, s.initialZDepth + 1))

      dom.window.setTimeout(() => {
        t.modState(s => State(s.initialZDepth, s.initialZDepth))
      }, 450)

    }
    
    def handleMouseDown(e : ReactEventI) : Unit = {
      if(DomUtil.isLeftClick(e.nativeEvent))  t.modState(s => s.copy(zDepth = s.initialZDepth + 1))
      if(t.props.onMouseDown != null) t.props.onMouseDown(e)
    }

    def handleMouseUp(e : ReactEventI) : Unit = {
      t.modState(s => s.copy(zDepth = s.initialZDepth))
      if(t.props.onMouseUp != null) t.props.onMouseUp(e)
    }
    
    
    
    def handleTouchStart( e: ReactEventI) : Unit =  {
      t.modState(s => s.copy(zDepth = s.initialZDepth + 1))
      if(t.props.onTouchStart != null) t.props.onTouchStart(e)
    }

    def handleTouchEnd(e : ReactEventI) : Unit = {
      t.modState(s => s.copy(zDepth = s.initialZDepth))
      if(t.props.onTouchEnd != null) t.props.onTouchEnd(e)
    }
    
    def onTouchTap(e: ReactEventI) = {
      if (t.props.onTouchTap != null) t.props.onTouchTap(e)
    }
  }

  val component = ReactComponentB[Props]("MuiRaisedButton")
    .initialStateP(p => {
      val zDepth = if (p.disabled) 0 else 1
    State(zDepth, zDepth)
    })
    .backend(new Backend(_))
    .render((P, C, S, B) => {
      val classes = CommonUtils.cssMap1M(mui_raised_button,
        P.clsNames,
        mui_is_primary -> P.primary,
        mui_is_secondary -> (!P.primary && P.secondary))
      MuiPaper(clsNames = classes, zDepth = S.zDepth)(
        MuiEnhancedButton(clsNames =  Map(mui_raised_button_container -> true), 
          onTouchTap = B.onTouchTap,
          onMouseUp = B.handleMouseUp,
          onMouseDown = B.handleMouseDown,
          onTouchStart = B.handleTouchStart,
          onTouchEnd = B.handleTouchEnd,
          disabled = P.disabled ,
          key = "enhanced" ,
          disableFocusRipple = P.disableFocusRipple,
          disableTouchRipple = P.disableTouchRipple,
          linkButton = P.linkButton ,
          url = P.url
          )(
          if(P.label.nonEmpty)  span(cls := mui_raised_button_label ,key := "span" ,P.label)
           else C
          )
        )
    })
    .componentWillReceiveProps((scope,nextProps) => {
     val zDepth = if (nextProps.disabled) 0 else 1
      scope.modState(_.copy(zDepth = zDepth,initialZDepth = zDepth))
    })
    .build

  case class Props( onTouchStart : REventIUnit ,disableTouchRipple : Boolean ,url : String ,clsNames : CssClassType ,label : String ,ref :  js.UndefOr[String] ,secondary : Boolean ,onMouseUp : REventIUnit ,onTouchEnd : REventIUnit ,key : js.Any ,disableFocusRipple : Boolean ,linkButton : Boolean ,onTouchTap : REventIUnit ,onMouseOut : REventIUnit ,disabled : Boolean ,primary : Boolean ,onMouseDown : REventIUnit  )

  def withChildrenapply( onTouchStart : REventIUnit = null ,disableTouchRipple : Boolean = false,url : String = "" ,clsNames : CssClassType = Map(),label : String = "" ,ref :  js.UndefOr[String] = "",secondary : Boolean = false,onMouseUp : REventIUnit = null ,onTouchEnd : REventIUnit = null ,key : js.Any = {},disableFocusRipple : Boolean = true,linkButton : Boolean = false,onTouchTap : REventIUnit = null ,onMouseOut : REventIUnit = null ,disabled : Boolean = false,primary : Boolean = false,onMouseDown : REventIUnit = null  )(children : ReactNode*) =
    component.set(key,ref)(Props(onTouchStart,disableTouchRipple,url,clsNames,label,ref,secondary,onMouseUp,onTouchEnd,key,disableFocusRipple,linkButton,onTouchTap,onMouseOut,disabled,primary,onMouseDown),children)

  def apply( onTouchStart : REventIUnit = null ,disableTouchRipple : Boolean = false,url : String = "" ,clsNames : CssClassType = Map(),label : String = "" ,ref :  js.UndefOr[String] = "",secondary : Boolean = false,onMouseUp : REventIUnit = null ,onTouchEnd : REventIUnit = null ,key : js.Any = {},disableFocusRipple : Boolean = true,linkButton : Boolean = false,onTouchTap : REventIUnit = null ,onMouseOut : REventIUnit = null ,disabled : Boolean = false,primary : Boolean = false,onMouseDown : REventIUnit = null  ) =
    component.set(key,ref)(Props(onTouchStart,disableTouchRipple,url,clsNames,label,ref,secondary,onMouseUp,onTouchEnd,key,disableFocusRipple,linkButton,onTouchTap,onMouseOut,disabled,primary,onMouseDown))

}
