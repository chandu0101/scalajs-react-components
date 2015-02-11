package chandu0101.scalajs.react.components.materialui.transiotiongroups


import chandu0101.scalajs.react.components.all._
import japgolly.scalajs.react._

import scala.scalajs.js


/**
 * Created by chandrasekharkode .
 */
object MuiSliderIn {


  case class State(checked: Boolean)

  class Backend(t: BackendScope[_, State]) {


  }


  val component2 = ReactComponentB[Props]("MuiSliderIn")
    .initialState(State(checked = false))
    .backend(new Backend(_))
    .render((P, C, S, B) => {
    val classes = s"${P.className} mui-transition-slide-in mui-is-${P.direction}"
    ReactCssTransitionGroup(name = "mui-transition-slide-in", className = classes, component = "div")(
      C
    )
  })
    .build

  val childCss = "mui-transition-slide-in-child"

  case class Props(clsNames: CssClassType, direction: String, className: String)

  def apply(clsNames: CssClassType = Map(), key: js.Any = {}, ref: js.UndefOr[String] = "", direction: String = "left", className: String = "")(children: ReactNode*) = component2(Props(clsNames, direction, className), children)

}
