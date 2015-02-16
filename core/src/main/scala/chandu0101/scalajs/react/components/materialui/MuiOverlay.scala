package chandu0101.scalajs.react.components.materialui

import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.materialui.styles.MaterialUICss._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._

import scala.scalajs.js


/**
 * Created by chandrasekharkode .
 */
object MuiOverlay {

  val component = ReactComponentB[Props]("Muioverlay")
    .render((P) => {
      div(classSet1(mui_overlay, mui_is_shown -> P.show) , onClick --> P.onTouchTap())
    })
    .build

  case class Props(clsNames: CssClassType, key: js.Any, ref: js.UndefOr[String], show: Boolean ,onTouchTap : EmptyFunc)

  def apply(clsNames: CssClassType = Map(), key: js.Any = {}, ref: js.UndefOr[String] = "", show: Boolean = false, onTouchTap : EmptyFunc  = null) =
    component.set(key, ref)(Props(clsNames, key, ref, show,onTouchTap))

}
