package chandu0101.scalajs.react.components.demo.components.reactpopover

import chandu0101.scalajs.react.components.demo.components.InfoTemplate
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.prefix_<^._


/**
 * Created by chandrasekharkode .
 */
object ReactPopoverInfo {

  val component = ReactComponentB[Unit]("ReactPopoverInfo")
    .render(P => {
       InfoTemplate(componentFilePath = "popovers/ReactPopOver.scala")(
        <.h3("React Popover :"),
         <.p(" Simple popover component with following options : "),
         <.ul( ^.paddingLeft := "15px")(
           <.li("left"),
           <.li("right"),
           <.li("top"),
           <.li("bottom")
         )
       )
    }).buildU

  def apply() = component()
}
