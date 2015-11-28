package demo
package components
package googlemap

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.fascades._
import chandu0101.scalajs.react.components.maps.GoogleMap
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

object GoogleMapCustomMarkerIcon {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  val latlng = LatLng(-33.9 ,151.2)

  /*
     url = image location
     size = This marker is 20 pixels wide by 32 pixels tall.
     origin = The origin for this image is 0,0.
     anchor = The anchor for this image is the base of the flagpole at 0,32.
   */
  val image = Icon(
    url = "http://www.bookyourparis.com/images-site/beachflag.png",
    size = Size(20,32),
    origin = Point(0,0),
    anchor = Point(0,32)
  )

  /*
     Shapes define the clickable region of the icon.
     The type defines an HTML &lt;area&gt; element 'poly' which
     traces out a polygon as a series of X,Y points. The final
     coordinate closes the poly by connecting to the first
     coordinate.
   */
  val shape = Shape(
    coords = List(1, 1, 1, 20, 18, 20, 18, 1),
    tpe = "poly"
  )

  val markers = List(
    Marker( position = LatLng(-33.890542,151.274856) ,title = "Bondi Beach", icon = image),
    Marker( position = LatLng(-33.923036,151.259052) ,title = "Coogee Beach" ,icon = image),
    Marker( position = LatLng(-34.028249,151.157507) ,title = "Cronulla Beach",icon = image),
    Marker( position = LatLng(-33.80010128657071,151.28747820854187) ,title = "Manly Beach",icon = image)
  )

  val component = ReactComponentB[Unit]("plain")
    .render(P => {
   <.div(
     <.h2(^.cls := "mui-font-style-headline")("Custom Marker Icon"),
      CodeExample(code, "GoogleMapCustomMarkerIcon")(
        GoogleMap(center = latlng, markers = markers, zoom = 10)
      )
    )
  }).buildU


  // EXAMPLE:END

  def apply() = component()
}
