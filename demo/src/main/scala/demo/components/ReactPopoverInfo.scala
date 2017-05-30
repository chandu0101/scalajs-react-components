package demo.components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object ReactPopoverInfo {

  val component = ScalaComponent
    .builder[Unit]("ReactPopoverInfo")
    .render(P => {
      InfoTemplate(componentFilePath = "popovers/ReactPopOver.scala")(
        <.h3("React Popover :"),
        <.p(" Simple popover component with following options: "),
        <.ul(^.paddingLeft := "15px")(
          <.li("left"),
          <.li("right"),
          <.li("top"),
          <.li("bottom")
        )
      )
    })
    .build

  def apply() = component()
}
