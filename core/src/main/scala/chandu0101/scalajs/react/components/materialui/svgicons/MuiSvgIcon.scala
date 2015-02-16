package chandu0101.scalajs.react.components.materialui.svgicons

import chandu0101.scalajs.react.components.all._
import japgolly.scalajs.react.{ReactNode, _}
import japgolly.scalajs.react.vdom.TagMod
import japgolly.scalajs.react.vdom.all._


/**
 * Created by chandrasekharkode .
 */
object MuiSvgIcon {

  val component = ReactComponentB[Props]("SvgIcon")
    .render((P, C) => {
       svgtag(P.props,cls := "mui-svg-icon",key := "svgicon")(C)
     })
    .build

  case class Props(props: TagMod*)

  def apply(props: TagMod*)(children: ReactNode*) = component(Props(props), children)

}
