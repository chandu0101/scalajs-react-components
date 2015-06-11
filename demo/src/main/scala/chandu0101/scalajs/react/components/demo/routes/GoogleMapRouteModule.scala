package chandu0101.scalajs.react.components.demo.routes

import chandu0101.scalajs.react.components.demo.components.googlemap._
import chandu0101.scalajs.react.components.demo.pages.{GoogleMapPage, ReactTreeViewPage}
import japgolly.scalajs.react.extra.router2.RouterConfigDsl

object GoogleMapRouteModule {

  case object Info extends LeftRoute("Info", "info", () => GoogleMapInfo())

  case object Basic extends LeftRoute("Basic Map", "basic", () => GoogleMapBasic())

  case object Marker extends LeftRoute("Map With Markers", "markers", () => GoogleMapMarkers())

  case object MarkerIcon extends LeftRoute("Custom Marker Icon", "markericon", () => GoogleMapCustomMarkerIcon())

  case object MarkerInfoWindow extends LeftRoute("Marker Info Window", "markerinfowindow", () => GoogleMapMarkerInfoWindow())

  val menu: List[LeftRoute] = List(Info, Basic, Marker, MarkerIcon, MarkerInfoWindow)

  val routes = RouterConfigDsl[LeftRoute].buildRule { dsl =>

    import dsl._

    menu.map(i =>
      staticRoute(i.route, i) ~> renderR(r => GoogleMapPage(i, r))
    ).reduce(_ | _)

  }
}
