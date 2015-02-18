package chandu0101.scalajs.react.components.materialui


import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.materialui.styles.MaterialUICss._
import chandu0101.scalajs.react.components.util.CommonUtils
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import org.scalajs.dom.html

import scala.scalajs.js



/**
 * Created by chandrasekharkode on 12/21/14.
 *
 *   className: React.PropTypes.string,
    label: React.PropTypes.string.isRequired,
    show: React.PropTypes.bool,
    touch: React.PropTypes.bool
 */
object MuiTooltip {


  class Backend(t: BackendScope[Props, _]) {

    def setRippleSize() = {
      val ripple = toolRipple(t).get.getDOMNode()
      val tooltipSize = t.getDOMNode().offsetWidth
      val ripplePadding = if(t.props.touch) 45 else 20
      val rippleSize = s"${tooltipSize + ripplePadding}px"
      if(t.props.show) {
        ripple.style.height = rippleSize
        ripple.style.width = rippleSize
      } else {
        ripple.style.height = "0px"
        ripple.style.width = "0px"
      }
    }

  }

  val toolRipple = Ref[html.Element]("toolRipple")

  lazy val component = ReactComponentB[Props]("MuiTooltip")
    .stateless
    .backend(new Backend(_))
    .render((P, S, B) => {
      val classes = CommonUtils.cssMap1M(mui_tooltip,P.clsNames, mui_is_shown -> P.show, mui_is_touch -> P.touch)
      div(classSetM(classes))(
        div( ref := toolRipple , cls := mui_tooltip_ripple),
          span(cls := mui_tooltip_label)(P.label)
      )
    })
    .componentDidMount(s => s.backend.setRippleSize)
    .componentDidUpdate((s,_,_) => s.backend.setRippleSize)
    .build

  case class Props(show: Boolean, touch: Boolean, clsNames: CssClassType, label: String)

  def apply(show: Boolean = false, touch: Boolean = false, clsNames: CssClassType = Map(), label: String, ref: js.UndefOr[String] = "", key: js.Any = {}) = component.set(key, ref)(Props(show, touch, clsNames, label))
}
