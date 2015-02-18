package chandu0101.scalajs.react.components.materialui.ripples


import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.materialui.styles.MaterialUICss._
import chandu0101.scalajs.react.components.util.CommonUtils
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import org.scalajs.dom

import scala.scalajs.js


/**
 * Created by chandrasekharkode .
 */
object FocusRipple {


  class Backend(t: BackendScope[Props, _]) {
    
    def setRippleSize() = {
      val el = t.getDOMNode()
      val height = el.offsetHeight
      val width = el.offsetWidth
      val size = Math.max(height, width)
      el.style.height = s"${size}px"
      el.style.top = ((size / 2 * -1) + (height / 2)).toString + "px"
    }
  }

  val component = ReactComponentB[Props]("FocusRipple")
    .stateless
    .backend(new Backend(_))
    .render((P, S, B) => {
       val classes = CommonUtils.cssMap1M(mui_focus_ripple,
         P.clsNames,
         mui_is_shown -> P.show)
       div(classSetM(classes))(
         div( cls := mui_focus_ripple_inner)
       )
    })
    .componentDidMount(scope => scope.backend.setRippleSize)
    .build

  case class Props(clsNames: CssClassType, key: js.Any, ref: js.UndefOr[String], show: Boolean)

  def apply(clsNames: CssClassType = Map(), key: js.Any = {}, ref: js.UndefOr[String] = "", show: Boolean = false) = component.set(key, ref)(Props(clsNames, key, ref, show))


}
