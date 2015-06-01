package chandu0101.scalajs.react.components.materialui.svgicons


import chandu0101.scalajs.react.components.all._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._



/**
 * Created by chandrasekharkode .
 */
object MuiNavigationChevronLeft {

  val component = ReactComponentB[Props]("MuiNavigationChevronLeft")
    .render(P => {
    MuiSvgIcon(props = P.props)(
      path(dsvg := "M15.41 7.41L14 6l-6 6 6 6 1.41-1.41L10.83 12z" , ^.key := "navleft")
    )
  }).build

  def apply(props: TagMod*) = component(Props(props))

  case class Props(props: TagMod*)


}
