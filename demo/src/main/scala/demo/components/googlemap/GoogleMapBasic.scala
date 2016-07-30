package demo
package components
package googlemap

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.GoogleMap
import chandu0101.scalajs.react.components.fascades.LatLng
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

object GoogleMapBasic {

  val code = GhPagesMacros.exampleSource
  // EXAMPLE:START

  val latlng = LatLng(16.3008, 80.4428)

  val component = ReactComponentB[Unit]("BasicMap")
    .render(P =>
      <.div(
        <.h2(^.cls := "mui-font-style-headline")("Basic Map"),
        CodeExample(code, "GoogleMapBasic")(
          GoogleMap(width = "600px", height = "500px", center = latlng, zoom = 8)
        )
      )
    ).build


  // EXAMPLE:END

  def apply() = component()
}
