package demo
package components
package materialui.svgicons

import chandu0101.scalajs.react.components.materialui.MuiSvgIcon
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

object FileFolder {

  val component = ReactComponentB[Unit]("FileFolder")
    .render(P => {
      MuiSvgIcon()(
        <.svg.path(^.key := "acg", ^.svg.d := "M10 4H4c-1.1 0-1.99.9-1.99 2L2 18c0 1.1.9 2 2 2h16c1.1 0 2-.9 2-2V8c0-1.1-.9-2-2-2h-8l-2-2z")
      )
    }).buildU

  def apply() = component()
}
