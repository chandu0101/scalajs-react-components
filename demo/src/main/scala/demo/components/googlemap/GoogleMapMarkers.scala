package demo
package components
package googlemap

import chandu0101.scalajs.react.components.GoogleMap
import chandu0101.scalajs.react.components.fascades.{LatLng, Marker}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object GoogleMapMarkers {

  val code =
    """
      |
      |  val latlng = LatLng(-33.9 ,151.2)
      |
      |  val markers = List(
      |   Marker( position = LatLng(-33.890542,151.274856) ,title = "Bondi Beach" ),
      |   Marker( position = LatLng(-33.923036,151.259052) ,title = "Coogee Beach" ),
      |   Marker( position = LatLng(-34.028249,151.157507) ,title = "Cronulla Beach" ),
      |   Marker( position = LatLng(-33.80010128657071,151.28747820854187) ,title = "Manly Beach" )
      |  )
      |  GoogleMap(center = latlng ,markers = markers ,zoom = 10)
      |
    """.stripMargin
  val component = ScalaComponent.builder[Unit]("mapmarkers")
    .render(P => {
   <.div(
     <.h2(^.cls := "mui-font-style-headline")("Markers"),
      CodeExample(code, "GoogleMapMarkers")(
       GoogleMap(center = latlng ,markers = markers ,zoom = 10)
      )
    )
  }).build

  val latlng = LatLng(-33.9 ,151.2)

  val markers = List(
   Marker( position = LatLng(-33.890542,151.274856) ,title = "Bondi Beach" ),
   Marker( position = LatLng(-33.923036,151.259052) ,title = "Coogee Beach" ),
   Marker( position = LatLng(-34.028249,151.157507) ,title = "Cronulla Beach" ),
   Marker( position = LatLng(-33.80010128657071,151.28747820854187) ,title = "Manly Beach" )
  )
  def apply() = component()
}
