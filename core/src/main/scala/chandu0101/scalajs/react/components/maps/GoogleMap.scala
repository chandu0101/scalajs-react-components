package chandu0101.scalajs.react.components
package maps

import chandu0101.scalajs.react.components.fascades._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import org.scalajs.dom.{Event, document, html}
import scala.scalajs.js
import scala.scalajs.js.Dynamic.{global => g}

object GoogleMap {

  def parameterizeUrl(url: String, parameters: Map[String, Any]): String = {
    require(url != null, "Missing argument 'url'.")
    require(parameters != null, "Missing argument 'parameters'.")

    parameters.foldLeft(url)((base, kv) =>
      base ++ {
        if (base.contains("?")) "&" else "?"
      } ++ kv._1 ++ "=" + kv._2)
  }

  case class State(mapObjects: Option[(GMap, GInfoWindow)], markers: List[GMarker])

  class Backend(t: BackendScope[Props, State]) {
    def loadScript(P: Props): Callback =
      if (js.isUndefined(g.google) || js.isUndefined(g.google.maps))
        Callback {
          val script = document.createElement("script").asInstanceOf[html.Script]
          script.`type` = "text/javascript"
          script.src = parameterizeUrl(P.url, Map("callback" -> "gmapinit"))
          document.body.appendChild(script)
          g.gmapinit = initialize(P).toJsFn
        } else initialize(P)

    def initialize(P: Props): Callback =
      t.modState(
        _.copy(mapObjects = Some((new GMap(t.getDOMNode(), MapOptions(P.center, P.zoom).toGMapOptions), new GInfoWindow))),
        cb = updateMap(P)
      )

    def updateMap(P: Props): Callback =
      t.modState(
        S =>
          S.mapObjects.fold(S) {
            case (gmap, infoWindow) =>
              gmap.setCenter(P.center.toGlatlng)
              S.markers.foreach(_.setMap(null))
              val newMarkers = P.markers.map(prepareMarker(infoWindow, gmap)).toList
              S.copy(markers = newMarkers)
          }
      )

    private def prepareMarker(infowindow: GInfoWindow, map: GMap)(m: Marker) = {
      val marker = new GMarker(m.toGMarker(map))
      if (!m.content.isEmpty) {
        new GAddListener(
          marker, "click", (e: Event) => {
            infowindow.setContent(m.content)
            infowindow.open(map, marker)
          }
        )
      }
      marker
    }

    def render(P: Props) = <.div(^.height := P.height, ^.width := P.width)
  }

  case class Props(width: String, height: String, center: LatLng, zoom: Int, markers: Seq[Marker], url: String)

  val component = ReactComponentB[Props]("googleMap")
    .initialState(State(None, Nil))
    .renderBackend[Backend]
    .componentWillReceiveProps{
      case ComponentWillReceiveProps(_$, nextProps) => _$.backend.updateMap(nextProps)
    }
    .componentDidMount($ => $.backend.loadScript($.props))
    .componentWillUnmount($ => Callback($.state.markers.foreach(new GClearInstanceListeners(_))))
    .build

  /**
   *
   * @param width width of map
   * @param height height of map
   * @param center center position(lat,lng) for map
   * @param zoom zoom value
   * @param markers markers for the map
   * @param url url to get googlemap api, by default it uses https://maps.googleapis.com/maps/api/js you can override if you want.
   * @return
   */
  def apply(width: String = "500px",
            height: String = "500px",
            center: LatLng,
            zoom: Int = 4,
            markers: List[Marker] = Nil,
            url: String = "https://maps.googleapis.com/maps/api/js") =
    component(Props(width, height, center, zoom, markers, url))

}
