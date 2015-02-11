package chandu0101.scalajs.react.components.materialui

import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.materialui.styles.MaterialUICss._
import chandu0101.scalajs.react.components.util.{DomUtil, CommonUtils}
import japgolly.scalajs.react._
import org.scalajs.dom

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
 */
object MuiFloatingActionButton {



  case class State(initialZDepth: Int, zDepth: Int)

  class Backend(t: BackendScope[Props, State]) {

    def animateButtonClick(e: ReactEventI) = {
      // animate zDepth change
      t.modState(s => State(s.initialZDepth, s.initialZDepth + 1))
      dom.window.setTimeout(() => {
        t.modState(s => State(s.initialZDepth, s.initialZDepth))
      }, 450)

    }

    def handleMouseDown( e: ReactEventI) = {
      if(DomUtil.isLeftClick(e.nativeEvent)) t.modState(s => State(s.initialZDepth + 1  ,s.initialZDepth))
      if(t.props.onMouseDown != null) t.props.onMouseDown(e)
    }

    def handleMouseUp( e: ReactEventI) = {
      t.modState(s => State(s.initialZDepth  ,s.initialZDepth))
      if(t.props.onMouseOut != null) t.props.onMouseOut(e)
    }

    def onTouchTap(e: ReactEventI) = {
      if (!t.props.disabled) animateButtonClick(e)
      if (t.props.onTouchTap != null) t.props.onTouchTap(e)
    }



  }

  val component = ReactComponentB[Props]("MuiFloatingActionButton")
    .initialStateP(p => {
     val zDepth = if (p.disabled) 0 else 2
    State(zDepth, zDepth)
    })
    .backend(new Backend(_))
    .render((P, C, S, B) => {
      val classes = CommonUtils.cssMapM(P.clsNames,mui_floating_action_button -> true,mui_open -> true, mui_is_mini -> P.mini,mui_is_secondary -> P.secondary)
      MuiPaper(clsNames = classes, zDepth = S.zDepth, circle = true)(
        MuiEnhancedButton(clsNames = Map(mui_floating_action_button_container -> true),
          onTouchTap = B.onTouchTap,
          disabled = P.disabled ,
          onMouseDown = B.handleMouseDown,
          onMouseUp = B.handleMouseUp,
          key = "floatinge" ,
          linkButton = P.linkButton,
          url = P.url )(
          if(P.iconClassName.nonEmpty) MuiFontIcon(className = s"mui-floating-action-button-icon ${P.iconClassName}") else "",
          C
        )
      )
    })
    .build




  case class Props( iconClassName : String ,onTouchStart : REventIAny ,mini : Boolean ,url : String ,clsNames : CssClassType ,ref :  js.UndefOr[String] ,secondary : Boolean ,onMouseUp : REventIAny ,onTouchEnd : REventIAny ,key : js.Any ,linkButton : Boolean ,onTouchTap : REventIAny ,className : String ,onMouseOut : REventIAny ,disabled : Boolean ,onMouseDown : REventIAny  )


  def withChildren(iconClassName : String = "" ,onTouchStart : REventIAny = null ,mini : Boolean = false,url : String = "" ,clsNames : CssClassType = Map(),ref :  js.UndefOr[String] = "",secondary : Boolean = false,onMouseUp : REventIAny = null ,onTouchEnd : REventIAny = null ,key : js.Any = {},linkButton : Boolean = false,onTouchTap : REventIAny = null ,className : String = "" ,onMouseOut : REventIAny = null ,disabled : Boolean = false,onMouseDown : REventIAny = null )(children : ReactNode) =
    component.set(key,ref)(Props(iconClassName,onTouchStart,mini,url,clsNames,ref,secondary,onMouseUp,onTouchEnd,key,linkButton,onTouchTap,className,onMouseOut,disabled,onMouseDown),children)

  def apply( iconClassName : String = "" ,onTouchStart : REventIAny = null ,mini : Boolean = false,url : String = "" ,clsNames : CssClassType = Map(),ref :  js.UndefOr[String] = "",secondary : Boolean = false,onMouseUp : REventIAny = null ,onTouchEnd : REventIAny = null ,key : js.Any = {},linkButton : Boolean = false,onTouchTap : REventIAny = null ,className : String = "" ,onMouseOut : REventIAny = null ,disabled : Boolean = false,onMouseDown : REventIAny = null  ) =
    component.set(key,ref)(Props(iconClassName,onTouchStart,mini,url,clsNames,ref,secondary,onMouseUp,onTouchEnd,key,linkButton,onTouchTap,className,onMouseOut,disabled,onMouseDown))

}
