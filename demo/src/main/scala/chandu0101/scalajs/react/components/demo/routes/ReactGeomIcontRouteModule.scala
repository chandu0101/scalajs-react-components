package chandu0101.scalajs.react.components.demo.routes

import chandu0101.scalajs.react.components.demo.components.reactgeomicons.{ReactGeomIconDemo, ReactGeomIconInfo}
import chandu0101.scalajs.react.components.demo.pages.ReactGeomIconPage
import japgolly.scalajs.react.extra.router2.RouterConfigDsl

object ReactGeomIcontRouteModule {

  case object Info extends LeftRoute("Info", "info", () => ReactGeomIconInfo())

  case object Demo extends LeftRoute("Demo", "demo", () => ReactGeomIconDemo())

  val menu: List[LeftRoute] = List(Info, Demo)

  val routes = RouterConfigDsl[LeftRoute].buildRule { dsl =>
    import dsl._
    menu.map(i =>
      staticRoute(i.route, i) ~> renderR(r => ReactGeomIconPage(i, r))
    ).reduce(_ | _)

  }
}
