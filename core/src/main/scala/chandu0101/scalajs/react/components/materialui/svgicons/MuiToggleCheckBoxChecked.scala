package chandu0101.scalajs.react.components.materialui.svgicons

import chandu0101.scalajs.react.components.all._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.TagMod
import japgolly.scalajs.react.vdom.all._


/**
 * Created by chandrasekharkode .
 */
object MuiToggleCheckBoxChecked {


  val component = ReactComponentB[Props]("MuiToggleCheckBoxChecked")
    .render(P => {
    MuiSvgIcon(P.props)(
      path( key := "MuiToggleCheckBoxChecked" , dsvg := "M19,3H5C3.9,3,3,3.9,3,5v14c0,1.1,0.9,2,2,2h14c1.1,0,2-0.9,2-2V5C21,3.9,20.1,3,19,3z M10,17l-5-5l1.4-1.4 l3.6,3.6l7.6-7.6L19,8L10,17z")
    )
  }).build


  case class Props(props: TagMod*)

  def apply(props: TagMod*) = component(Props(props))

}
