package chandu0101.scalajs.react.components.maps

import chandu0101.scalajs.react.components.fascades._
import chandu0101.scalajs.react.components.util.CommonUtils
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import org.scalajs.dom.{Event, document, html}

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{global => g, literal => json, newInstance => jsnew}


/**
 * Created by chandrasekharkode .
 */
object GoogleMap {

  case class State(loaded: Boolean)

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

    val gmarkers = List[GMarker]()

    private def initialize(): Unit = {
      val map = new GMap(t.getDOMNode(), MapOptions(t.props.center, t.props.zoom).toGMapOptions)
      val infowindow = new GInfoWindow()
      if (t.props.markers.nonEmpty) {
        t.props.markers.foreach(m => {
          val marker = new GMarker(m.toGMarker(map))
          if (!m.content.isEmpty) {
            gmarkers.+:(marker)
            new GAddListener(marker, "click", (e: Event) => {
              infowindow.setContent(m.content)
              infowindow.open(map, marker)
            })
          }
        })
      }
    }

  }

  case class Props(width : Int , height : Int,center: LatLng, zoom: Int, markers: Seq[Marker],url :String)

  val component = ReactComponentB[Props]("googleMap")
    .initialState(State(loaded = false))
    .backend(new Backend(_))
    .render((P, S, B) => {
      div(height := s"${P.height}px", width := s"${P.width}px")
    })
    .componentDidMount(scope => {
      scope.backend.loadScript
    })
    .componentWillUnmount(scope => {
      scope.backend.gmarkers.foreach(new GClearInstanceListeners(_))
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
  def apply(width : Int = 500 , height : Int = 500, center: LatLng, zoom: Int = 4, markers: List[Marker] = Nil,url : String = "https://maps.googleapis.com/maps/api/js") = component(Props(width,height,center, zoom, markers,url))

}
