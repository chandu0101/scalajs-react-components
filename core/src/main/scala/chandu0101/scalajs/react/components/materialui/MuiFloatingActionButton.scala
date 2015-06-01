package chandu0101.scalajs.react.components.materialui

import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.materialui.styles.MaterialUICss._
import chandu0101.scalajs.react.components.util.{CommonUtils, DomUtil}
import japgolly.scalajs.react._

import scala.scalajs.js


/**
 * Created by chandrasekharkode .
 *
 *
 * clsNames: React.PropTypes.css,
key: React.PropTypes.key,
ref: React.PropTypes.ref,
     className: React.PropTypes.string,
    iconClassName: React.PropTypes.string,
    mini: React.PropTypes.bool,
    onMouseDown: React.PropTypes.func,
    onMouseUp: React.PropTypes.func,
    onMouseOut: React.PropTypes.func,
    onTouchEnd: React.PropTypes.func,
    onTouchStart: React.PropTypes.func,
    secondary: React.PropTypes.bool,
   disabled: React.PropTypes.bool,
    linkButton: React.PropTypes.bool,
    url: React.PropTypes.string,
onTouchTap:React.PropTypes.func,
disableFocusRipple :React.PropTypes.bool,
disableTouchRipple :React.PropTypes.bool,
 */
object MuiFloatingActionButton {



  case class State(initialZDepth: Int, zDepth: Int)

  class Backend(t: BackendScope[Props, State]) {

    def onTouchTap(e: ReactEventI) = {
      if (t.props.onTouchTap != null) t.props.onTouchTap(e)
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

  }

  val component = ReactComponentB[Props]("MuiFloatingActionButton")
    .initialStateP(p => {
     val zDepth = if (p.disabled) 0 else 2
    State(zDepth, zDepth)
    })
    .backend(new Backend(_))
    .render((P, C, S, B) => {
      val classes = CommonUtils.cssMap1M(mui_floating_action_button,
        P.clsNames,
        mui_is_mini -> P.mini,
        mui_is_secondary -> P.secondary)
      MuiPaper(clsNames = classes, zDepth = S.zDepth, circle = true)(
        MuiEnhancedButton(clsNames = Map(mui_floating_action_button_container -> true),
          onTouchTap = B.onTouchTap,
          disabled = P.disabled ,
          onMouseDown = B.handleMouseDown,
          onMouseUp = B.handleMouseUp,
          key = "floatinge" ,
          disableFocusRipple = P.disableFocusRipple,
          disableTouchRipple = P.disableTouchRipple,
          linkButton = P.linkButton,
          url = P.url )(
          if(P.iconClassName.nonEmpty) MuiFontIcon(className = s"mui-floating-action-button-icon ${P.iconClassName}") else "",
          C
        )
      )
    })
    .build



  case class Props( iconClassName : String ,onTouchStart : REventIUnit ,mini : Boolean ,disableTouchRipple : Boolean ,url : String ,clsNames : CssClassType ,ref :  js.UndefOr[String] ,secondary : Boolean ,onMouseUp : REventIUnit ,onTouchEnd : REventIUnit ,key : js.Any ,disableFocusRipple : Boolean ,linkButton : Boolean ,onTouchTap : REventIUnit ,className : String ,onMouseOut : REventIUnit ,disabled : Boolean ,onMouseDown : REventIUnit  )

  def withChildren( iconClassName : String = "" ,onTouchStart : REventIUnit = null ,mini : Boolean = false,disableTouchRipple : Boolean = false,url : String = "" ,clsNames : CssClassType = Map(),ref :  js.UndefOr[String] = "",secondary : Boolean = false,onMouseUp : REventIUnit = null ,onTouchEnd : REventIUnit = null ,key : js.Any = {},disableFocusRipple : Boolean = true,linkButton : Boolean = false,onTouchTap : REventIUnit = null ,className : String = "" ,onMouseOut : REventIUnit = null ,disabled : Boolean = false,onMouseDown : REventIUnit = null )(children : ReactNode*) =
    component.set(key,ref)(Props(iconClassName,onTouchStart,mini,disableTouchRipple,url,clsNames,ref,secondary,onMouseUp,onTouchEnd,key,disableFocusRipple,linkButton,onTouchTap,className,onMouseOut,disabled,onMouseDown),children)

  def apply( iconClassName : String = "" ,onTouchStart : REventIUnit = null ,mini : Boolean = false,disableTouchRipple : Boolean = false,url : String = "" ,clsNames : CssClassType = Map(),ref :  js.UndefOr[String] = "",secondary : Boolean = false,onMouseUp : REventIUnit = null ,onTouchEnd : REventIUnit = null ,key : js.Any = {},disableFocusRipple : Boolean = true,linkButton : Boolean = false,onTouchTap : REventIUnit = null ,className : String = "" ,onMouseOut : REventIUnit = null ,disabled : Boolean = false,onMouseDown : REventIUnit = null  ) =
    component.set(key,ref)(Props(iconClassName,onTouchStart,mini,disableTouchRipple,url,clsNames,ref,secondary,onMouseUp,onTouchEnd,key,disableFocusRipple,linkButton,onTouchTap,className,onMouseOut,disabled,onMouseDown))

}
