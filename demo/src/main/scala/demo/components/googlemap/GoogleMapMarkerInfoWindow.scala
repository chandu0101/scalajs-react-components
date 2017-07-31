package demo
package components
package googlemap

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.GoogleMap
import chandu0101.scalajs.react.components.fascades.{LatLng, Marker}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object GoogleMapMarkerInfoWindow {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START
  val latlng = LatLng(-33.9, 151.2)

  // to add info window on click of marker just specify content field
  val markers = List(
    Marker(position = LatLng(-33.890542, 151.274856),
           title = "Bondi Beach",
           content = "<h3>This is Bondi Beach </h3>"),
    Marker(position = LatLng(-33.923036, 151.259052),
           title = "Coogee Beach",
           content = "<h3>This is Coogee Beach </h3>"),
    Marker(position = LatLng(-34.028249, 151.157507),
           title = "Cronulla Beach",
           content = "<h3>This is Cronulla Beach </h3>"),
    Marker(position = LatLng(-33.80010128657071, 151.28747820854187),
           title = "Manly Beach",
           content = "<h3>This is Manly Beach </h3>")
  )

  val component = ScalaComponent
    .builder[Unit]("infowindow")
    .render(P =>
      <.div(
        <.h2(^.cls := "mui-font-style-headline")("Marker InfoWindow"),
        CodeExample(code, "GoogleMapMarkerInfoWindow")(
          GoogleMap(center = latlng, markers = markers, zoom = 10)
        )
    ))
    .build

  // EXAMPLE:END

  def apply() = component()
}
