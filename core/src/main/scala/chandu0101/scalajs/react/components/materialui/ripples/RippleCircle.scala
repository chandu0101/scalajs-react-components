package chandu0101.scalajs.react.components.materialui.ripples


import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.materialui.styles.MaterialUICss._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._

import scala.scalajs.js


/**
 * Created by chandrasekharkode on 1/2/15.
 *
 *   started: React.PropTypes.bool,
 *   ending: React.PropTypes.bool

 */
object RippleCircle {


  val component = ReactComponentB[Props]("RippleCircle")
    .render(P => {
      val classes = classSet1(mui_ripple_circle,
        mui_is_started -> P.started,
        mui_is_ending -> P.started)
      div(P.otherProps,classes)(
       div(cls := mui_ripple_circle_inner)
      )
    }).build


  case class Props(clsNames: CssClassType, ref: js.UndefOr[String], key: js.Any, ending: Boolean, started: Boolean,otherProps : TagMod*)

  def apply(clsNames: CssClassType = Map(), ref: js.UndefOr[String] = "", key: js.Any = {}, ending: Boolean = false, started: Boolean = false )(otherProps : TagMod*) = component.set(key, ref)(Props(clsNames, ref, key, ending, started,otherProps))

}
