package chandu0101.scalajs.react.components.materialui.svgicons


import chandu0101.scalajs.react.components.all._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._



/**
 * Created by chandrasekharkode .
 */
object MuiToggleCheckBoxOutlineBlank {


  val component = ReactComponentB[Props]("MuiToggleCheckBoxOutlineBlank")
    .render(P => {
    MuiSvgIcon(P.props)(
      path(^.key := "MuiToggleCheckBoxOutlineBlank",dsvg := "M19,5v14H5V5H19 M19,3H5C3.9,3,3,3.9,3,5v14c0,1.1,0.9,2,2,2h14c1.1,0,2-0.9,2-2V5C21,3.9,20.1,3,19,3z")
    )
  }).build


  case class Props(props: TagMod*)

  def apply(props: TagMod*) = component(Props(props))

}
