package chandu0101.scalajs.react.components.materialui

import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.materialui.styles.MaterialUICss._
import chandu0101.scalajs.react.components.util.CommonUtils
import japgolly.scalajs.react.vdom.all._
import japgolly.scalajs.react.{BackendScope, ReactComponentB, ReactEventI, _}
import org.scalajs.dom

import scala.scalajs.js


/**
 * Created by chandrasekharkode .
 */
object MuiRaisedButton {

  case class Props(clsNames: CssClassType, label: String, onTouchTap: REventIAny, primary: Boolean, disabled: Boolean,linkButton : Boolean,seocndary:Boolean,url : String )

  case class State(initialZDepth: Int, zDepth: Int)

  class Backend(t: BackendScope[Props, State]) {

    def animateButtonClick(e: ReactEventI) = {
      // animate zDepth change
      t.modState(s => State(s.initialZDepth, s.initialZDepth + 1))

      dom.window.setTimeout(() => {
        t.modState(s => State(s.initialZDepth, s.initialZDepth))
      }, 450)

    }

    def onTouchTap(e: ReactEventI) = {
      if (!t.props.disabled) animateButtonClick(e)
      if (t.props.onTouchTap != null) t.props.onTouchTap(e)
    }
  }

  val component = ReactComponentB[Props]("raisedButton")
    .initialStateP(p => {
      val zDepth = if (p.disabled) 0 else 1
    State(zDepth, zDepth)
    })
    .backend(new Backend(_))
    .render((P, C, S, B) => {
      val classes = CommonUtils.cssMapM(P.clsNames,(mui_raised_button,true),(mui_is_primary,P.primary),(mui_is_secondary, !P.primary && P.seocndary))
      MuiPaper(clsNames = classes, zDepth = S.zDepth)(
        MuiEnhancedButton(clsNames =  Map(mui_raised_button_container -> true), onTouchTap = B.onTouchTap, disabled = P.disabled ,key = "enhanced" ,linkButton = P.linkButton ,url = P.url)(
            span(cls := mui_raised_button_label ,key := "span")(P.label)
          )
        )
    })
    .build


  def apply(clsNames: CssClassType = Map(), label: String, onTouchTap: REventIAny = null, primary: Boolean = false, disabled: Boolean = false,linkButton : Boolean = false ,secondary : Boolean = false,key : js.Any = {},ref :  js.UndefOr[String] = "",url : String = "") =
    component.set(key,ref)(Props(clsNames, label, onTouchTap, primary, disabled,linkButton,secondary,url))

}
