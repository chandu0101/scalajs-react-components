package chandu0101.scalajs.react.components.demo.pages.components.reactpopover

import chandu0101.scalajs.react.components.demo.pages.util.InfoTemplate
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.all._

/**
 * Created by chandrasekharkode .
 */
object ReactPopoverInfo {

  val component = ReactComponentB[Unit]("ReactPopoverInfo")
    .render(P => {
       InfoTemplate(componentFilePath = "popovers/ReactPopover.scala")(
         h3("React Popover :"),
         p(" Simple popover component with following options : "),
         ul( paddingLeft := "15px")(
           li("left"),
           li("right"),
           li("top"),
           li("bottom")
         )
       )
    }).buildU

  def apply() = component()
}
