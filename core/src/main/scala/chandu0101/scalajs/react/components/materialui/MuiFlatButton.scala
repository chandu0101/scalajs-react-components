package chandu0101.scalajs.react.components.materialui

import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.materialui.styles.MaterialUICss._
import chandu0101.scalajs.react.components.util.CommonUtils
import japgolly.scalajs.react.vdom.all._
import japgolly.scalajs.react.{BackendScope, ReactEventI, _}

import scala.scalajs.js


/**
 * Created by chandrasekharkode .
 */
object MuiFlatButton {


  class Backend(t: BackendScope[Props, _]) {
    def onTouchTap(e: ReactEventI) = {
      if (t.props.onTouchTap != null) t.props.onTouchTap(e)
    }
  }

  val component = ReactComponentB[Props]("MuiFlatButton")
    .stateless
    .backend(new Backend(_))
    .render((P,C, S, B) => {
      val classes = CommonUtils.cssMap1M(mui_flat_button,
        P.clsNames,
        mui_is_primary -> P.primary,
        mui_is_secondary -> (!P.primary && P.secondary))
      MuiEnhancedButton(clsNames = classes ,
        disabled = P.disabled, 
        onTouchTap = B.onTouchTap,
        disableFocusRipple = P.disableFocusRipple,
        disableTouchRipple = P.disableTouchRipple,
        linkButton = P.linkButton,
        url = P.url)(
       if(P.label.nonEmpty) span( key := "label" ,cls := mui_flat_button_label , P.label)
       else C
      )
    }).build

  case class Props(disableFocusRipple : Boolean, disableTouchRipple : Boolean, clsNames: CssClassType, label: String, onTouchTap: REventIUnit, primary: Boolean, disabled: Boolean,linkButton:Boolean,secondary : Boolean,url : String )

  def withChildren(disableFocusRipple : Boolean = true, disableTouchRipple : Boolean = false,clsNames: CssClassType = Map(), label: String = "", onTouchTap: REventIUnit = null, primary: Boolean = false, disabled: Boolean = false ,linkButton : Boolean = false,secondary : Boolean = false, key : js.Any = {},ref :  js.UndefOr[String] = "",url : String = "")(children : ReactNode*) = {
    component.set(key,ref)(Props(disableFocusRipple,disableTouchRipple,clsNames, label, onTouchTap, primary, disabled,linkButton,secondary,url),children)
  }
  
  def apply(disableFocusRipple : Boolean = true, disableTouchRipple : Boolean = false,clsNames: CssClassType = Map(), label: String, onTouchTap: REventIUnit = null, primary: Boolean = false, disabled: Boolean = false ,linkButton : Boolean = false,secondary : Boolean = false, key : js.Any = {},ref :  js.UndefOr[String] = "",url : String = "") = {
    component.set(key,ref)(Props(disableFocusRipple,disableTouchRipple,clsNames, label, onTouchTap, primary, disabled,linkButton,secondary,url))
  }

}
