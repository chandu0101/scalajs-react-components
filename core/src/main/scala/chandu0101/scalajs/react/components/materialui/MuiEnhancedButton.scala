package chandu0101.scalajs.react.components.materialui

import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.materialui.ripples.{FocusRipple, TouchRipple}
import chandu0101.scalajs.react.components.materialui.styles.MaterialUICss._
import chandu0101.scalajs.react.components.mixins.WindowListeners
import chandu0101.scalajs.react.components.util.{CommonUtils, Events}
import japgolly.scalajs.react.vdom.all._
import japgolly.scalajs.react.{BackendScope, ReactComponentB, ReactEventI, _}
import org.scalajs.dom
import org.scalajs.dom.ext.KeyCode
import org.scalajs.dom.{Event, KeyboardEvent}

import scala.scalajs.js
import scala.scalajs.js.Function1


/**
 * Created by chandrasekharkode on 12/2/14.
 *
 * clsNames: React.PropTypes.css,
key: React.PropTypes.key,
ref: React.PropTypes.ref,
   centerRipple: React.PropTypes.bool,
    className: React.PropTypes.string,
    disabled: React.PropTypes.bool,
    disableFocusRipple: React.PropTypes.bool,
    disableTouchRipple: React.PropTypes.bool,
    linkButton: React.PropTypes.bool,
    onBlur: React.PropTypes.func,
    onFocus: React.PropTypes.func,
    onTouchTap: React.PropTypes.func,
    url : React.PropTypes.string,
    onMouseDown: React.PropTypes.func,
    onMouseUp: React.PropTypes.func,
 onMouseOver: React.PropTypes.func,
    onMouseOut: React.PropTypes.func,
    onTouchEnd: React.PropTypes.func,
    onTouchStart: React.PropTypes.func,

 */

object MuiEnhancedButton {


  val theTouchRippleRef = Ref.to(TouchRipple.component, "theTouchRippleRefEnhancedButton")
  val component = ReactComponentB[Props]("MuiEnhancedButton")
    .initialState(State(isKeyboardFocused = false))
    .backend(new Backend(_))
    .render((P, C, S, B) => {
    val styles = CommonUtils.cssMapM(P.clsNames, mui_enhanced_button -> true,
      mui_is_disabled -> P.disabled, mui_is_link_button -> P.linkButton, mui_is_keyboard_focused -> S.isKeyboardFocused)
    val touchRipple: ReactNode = if (P.disabled || P.disableTouchRipple) "" else TouchRipple(ref = theTouchRippleRef, centerRipple = P.centerRipple, key = "toucr")
    val focusRipple: ReactNode = if (P.disabled || P.disableFocusRipple) "" else FocusRipple(show = S.isKeyboardFocused, key = "focusr")
    if (P.linkButton) {
      if (P.disabled) span(classSetM(styles), disabled := P.disabled)(
        C
      )
      else {
        a(classSetM(styles), disabled := P.disabled, onBlur ==> B.handleBlur, onFocus ==> B.handleFocus, onClick ==> B.handleTouchTap, href := P.url)(
          C,
          touchRipple,
          focusRipple
        )
      }
    } else {
      button(classSetM(styles), onClick ==> B.handleTouchTap, onBlur ==> B.handleBlur, onFocus ==> B.handleFocus, onMouseOver ==> B.handleMouseOver, onMouseOut ==> B.handleMouseOut)(
        C,
        touchRipple,
        focusRipple
      )
    }

  })
    .configure(WindowListeners.mixin)
    .build

  case class State(isKeyboardFocused: Boolean)

  class Backend(t: BackendScope[Props, State]) extends WindowListeners {
    lazy val handleWindowKeydown: js.Function1[Event, _] = (e: Event) => {
      val kevent = e.asInstanceOf[KeyboardEvent]
      if (kevent.keyCode == KeyCode.tab) tabPressed = true
      if (kevent.keyCode == KeyCode.enter && t.state.isKeyboardFocused) {
        handleTouchTap(e.asInstanceOf[ReactEventI])
      }
    }
    lazy val handleWindowKeyUp: js.Function1[Event, _] = (e: Event) => {
      val kevent = e.asInstanceOf[KeyboardEvent]
      if (kevent.keyCode == 32 && t.state.isKeyboardFocused) handleTouchTap(e.asInstanceOf[ReactEventI])

    }
    override val listeners: List[(String, Function1[Event, _])] = List(
      (Events.KEYDOWN, handleWindowKeydown),
      (Events.KEYUP, handleWindowKeyUp)
    )
    var tabPressed = false

    def handleTouchTap(e: ReactEventI) = {
      tabPressed = false
      t.modState(_.copy(isKeyboardFocused = false))
      if (t.props.onTouchTap != null) t.props.onTouchTap(e)
    }

    def handleBlur(e: ReactEventI) = {
      t.modState(_.copy(isKeyboardFocused = false))
      if (t.props.onBlur != null) t.props.onBlur(e)
    }

    def handleFocus(e: ReactEventI) = {
      dom.setTimeout(() => {
        if (tabPressed) t.modState(_.copy(isKeyboardFocused = true))
      }, 150)
      if (t.props.onFocus != null) t.props.onFocus(e)
    }

    def handleMouseOut(e: ReactEventI) = if (t.props.onMouseOut != null) t.props.onMouseOut(e)

    def handleMouseOver(e: ReactEventI) = if (t.props.onMouseOver != null) t.props.onMouseOver(e)
  }



  case class Props( onBlur : REventIAny ,onTouchStart : REventIAny ,disableTouchRipple : Boolean ,url : String ,clsNames : CssClassType ,ref :  js.UndefOr[String] ,onMouseUp : REventIAny ,onTouchEnd : REventIAny ,key : js.Any ,disableFocusRipple : Boolean ,onMouseOver : REventIAny ,linkButton : Boolean ,onTouchTap : REventIAny ,className : String ,onMouseOut : REventIAny ,onFocus : REventIAny ,disabled : Boolean ,centerRipple : Boolean ,onMouseDown : REventIAny  )

  def apply( onBlur : REventIAny = null ,onTouchStart : REventIAny = null ,disableTouchRipple : Boolean = false,url : String = "" ,clsNames : CssClassType = Map(),ref :  js.UndefOr[String] = "",onMouseUp : REventIAny = null ,onTouchEnd : REventIAny = null ,key : js.Any = {},disableFocusRipple : Boolean = false,onMouseOver : REventIAny = null ,linkButton : Boolean = false,onTouchTap : REventIAny = null ,className : String = "" ,onMouseOut : REventIAny = null ,onFocus : REventIAny = null ,disabled : Boolean = false,centerRipple : Boolean = false,onMouseDown : REventIAny = null)(children : ReactNode*) =
    component.set(key,ref)(Props(onBlur,onTouchStart,disableTouchRipple,url,clsNames,ref,onMouseUp,onTouchEnd,key,disableFocusRipple,onMouseOver,linkButton,onTouchTap,className,onMouseOut,onFocus,disabled,centerRipple,onMouseDown),children)


}
