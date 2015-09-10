package demo
package components
package googlemap

import chandu0101.scalajs.react.components.fascades.LatLng
import chandu0101.scalajs.react.components.maps.GoogleMap
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

object GoogleMapBasic {

  val code =
    """
      |  val latlng = LatLng(16.3008,80.4428)
      |  GoogleMap(width = 600 ,height = 500 ,center = latlng, zoom = 8)
      |
    """.stripMargin
  val component = ReactComponentB[Unit]("BasicMap")
    .render(P => {
   <.div(
     <.h2(^.cls := "mui-font-style-headline")("Basic Map"),
      CodeExample(code)(
        GoogleMap(width = "600px" ,height = "500px" ,center = latlng ,zoom = 8)
      )
    )
  }).buildU

  lazy val latlng = LatLng(16.3008,80.4428)

  def apply() = component()
}
