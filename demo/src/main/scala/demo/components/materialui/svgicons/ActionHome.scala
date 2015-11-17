package demo
package components
package materialui.svgicons

import chandu0101.scalajs.react.components.materialui.MuiSvgIcon
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

object ActionHome {

  val component = ReactComponentB[Unit]("ActionHome")
    .render(P => {
      MuiSvgIcon()(
        <.svg.path(^.key := "acg", ^.svg.d := "M10 20v-6h4v6h5v-8h3L12 3 2 12h3v8z")
      )
    }).buildU

  def apply() = component()
}
