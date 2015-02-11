package chandu0101.scalajs.react.components.materialui

import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.materialui.styles.MaterialUICss._
import japgolly.scalajs.react.vdom.all._
import japgolly.scalajs.react.{BackendScope, ReactEventI, _}

import scala.scalajs.js


/**
 * Created by chandrasekharkode .
 */
object MuiFlatButton {

  case class Props(clsNames: CssClassType, label: String, onTouchTap: REventIAny, primary: Boolean, disabled: Boolean,linkButton:Boolean,secondary : Boolean,url : String )

  class Backend(t: BackendScope[Props, _]) {
    def onTouchTap(e: ReactEventI) = {
      if (t.props.onTouchTap != null) t.props.onTouchTap(e)
    }
  }


  val component = ReactComponentB[Props]("flatButton")
    .initialState("")
    .backend(new Backend(_))
    .render((P, S, B) => {
      val classes = P.clsNames.++(Map(mui_flat_button -> true, mui_is_primary -> P.primary,mui_is_secondary -> (!P.primary && P.secondary)))
      MuiEnhancedButton(clsNames = classes , disabled = P.disabled, onTouchTap = B.onTouchTap,linkButton = P.linkButton, url = P.url)(
       span( key := "label" ,cls := mui_flat_button_label)( P.label)
      )
    }).build

  def apply(clsNames: CssClassType = Map(), label: String, onTouchTap: REventIAny = null, primary: Boolean = false, disabled: Boolean = false ,linkButton : Boolean = false,secondary : Boolean = false, key : js.Any = {},ref :  js.UndefOr[String] = "",url : String = "") = {
    component.set(key,ref)(Props(clsNames, label, onTouchTap, primary, disabled,linkButton,secondary,url))
  }

}
