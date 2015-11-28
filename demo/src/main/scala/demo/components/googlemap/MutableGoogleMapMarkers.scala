package demo.components
package googlemap

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.fascades.{Marker, LatLng}
import chandu0101.scalajs.react.components.GoogleMap
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

object MutableGoogleMapMarkers {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  val markers = List(
   Marker( position = LatLng(52.2,21), title = "Warsaw" ),
   Marker( position = LatLng(51.23,22.5), title = "Lublin" )
  )

  case class State(lat:Double, lng:Double, markers: List[Marker])

  class Backend(t: BackendScope[Unit, State]) {

    def changeLat(event: ReactEventI): Callback = {
      t.modState(_.copy(lat = event.target.value.toDouble))
    }

    def changeLng(event: ReactEventI): Callback = {
      t.modState(_.copy(lng = event.target.value.toDouble))
    }

    val addMarker: Callback =
      t.modState(s => s.copy(markers = s.markers :+ Marker(LatLng(s.lat, s.lng), s"Marker ${s.markers.size}")))

    def render(S: State) =
      <.div(
        <.h2(^.cls := "mui-font-style-headline")("Mutable markers"), CodeExample(code, "MutableGoogleMapMarkers")(
          <.div(
            <.input(^.`type` := "text", ^.value := S.lat.toString, ^.onChange ==> changeLat),
            <.input(^.`type` := "text", ^.value := S.lng.toString, ^.onChange ==> changeLng),
            <.button(^.onClick --> addMarker, "Add marker")
          ), GoogleMap(center = LatLng(S.lat, S.lng), markers = S.markers, zoom = 10)
        )
      )
  }

  val component = ReactComponentB[Unit]("mapmarkers")
    .initialState(State(52.2, 21, markers))
    .renderBackend[Backend]
    .buildU

  // EXAMPLE:END

  def apply() = component()

}
