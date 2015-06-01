package chandu0101.scalajs.react.components.materialui.svgicons


import chandu0101.scalajs.react.components.all._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._



/**
 * Created by chandrasekharkode .
 */
object MuiDropDownArrow {


  val component = ReactComponentB[Props]("DropDownArrow")
    .render(P => {
    MuiSvgIcon(P.props)(
      polygon(^.key := "arrow", points := "7,9.5 12,14.5 17,9.5")
    )
  }).build


  case class Props(props: TagMod*)

  def apply(props: TagMod*) = component(Props(props))
}
