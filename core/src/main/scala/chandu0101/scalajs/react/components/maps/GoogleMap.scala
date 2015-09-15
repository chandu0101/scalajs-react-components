package chandu0101.scalajs.react.components.maps

import chandu0101.scalajs.react.components.fascades._
import chandu0101.scalajs.react.components.util.CommonUtils
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import org.scalajs.dom.{Event, document, html}

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{global => g, literal => json, newInstance => jsnew}

object GoogleMap {

  case class State(mapObjects: Option[(GMap,GInfoWindow)] = Option.empty,
                   markers: List[GMarker] = List())

  class Backend(t: BackendScope[Props, State]) {


    def loadScript() = {
      if (js.isUndefined(g.google) || (!js.isUndefined(g.google) && js.isUndefined(g.google.maps))) {
        val script = document.createElement("script").asInstanceOf[html.Script]
        script.`type` = "text/javascript"
        script.src = CommonUtils.parameterizeUrl(t.props.url,Map("callback" -> "gmapinit"))
        document.body.appendChild(script)
        g.gmapinit = initialize _
      } else initialize()
    }

    def initialize(): Unit = {
      val map = new GMap(t.getDOMNode(), MapOptions(t.props.center, t.props.zoom).toGMapOptions)
      t.modState(_.copy(mapObjects = Option(map, new GInfoWindow())))
      updateMap(t.props)
    }

    def updateMap(P:Props): Unit = {
      t.state.mapObjects.foreach { case (gmap, infoWindow) =>
        gmap.setCenter(P.center.toGlatlng)
        t.state.markers.foreach(_.setMap(null))
        val newMarkers = P.markers.map(prepareMarker(infoWindow, gmap)).toList
        t.modState(_.copy(markers = newMarkers))
      }
    }

    private def prepareMarker(infowindow: GInfoWindow, map:GMap)(m:Marker) = {
      val marker = new GMarker(m.toGMarker(map))
      if (!m.content.isEmpty) {
        new GAddListener(marker, "click", (e: Event) => {
          infowindow.setContent(m.content)
          infowindow.open(map, marker)
        })
      }
      marker
    }
  }

  case class Props(width : String , height : String,center: LatLng, zoom: Int, markers: Seq[Marker],url :String)

  val component = ReactComponentB[Props]("googleMap")
    .initialState(State())
    .backend(new Backend(_))
    .render((P, S, B) => {
     <.div(^.height := P.height, ^.width := P.width)
    })
    .componentWillReceiveProps((scope, newProps) => {
      scope.backend.updateMap(newProps)
    })
    .componentDidMount(scope => {
      scope.backend.loadScript()
    })
    .componentWillUnmount(scope => {
      scope.state.markers.foreach(new GClearInstanceListeners(_))
    })
    .build

  /**
   *
   * @param width width of map
   * @param height height of map
   * @param center  center position(lat,lng) for map
   * @param zoom  zoom value
   * @param markers   markers for the map
   * @param url   url to get googlemap api ,by default it uses https://maps.googleapis.com/maps/api/js
   *              you can override if you want .
   * @return
   */
  def apply(width : String = "500px" , height : String = "500px", center: LatLng, zoom: Int = 4, markers: List[Marker] = Nil,url : String = "https://maps.googleapis.com/maps/api/js") = component(Props(width,height,center, zoom, markers,url))

}
