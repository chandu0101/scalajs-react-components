package chandu0101.scalajs.react.components.demo.routes

import chandu0101.scalajs.react.components.demo.components.reactinfinite.{ReactInfiniteDemo, ReactInfiniteInfo}
import chandu0101.scalajs.react.components.demo.components.reactselect.{ReactSelectDemo, ReactSelectInfo}
import chandu0101.scalajs.react.components.demo.pages.{ReactInfinitePage, ReactSelectPage}
import japgolly.scalajs.react.extra.router2.RouterConfigDsl

object ReactInfiniteRouteModule {

  case object Info extends LeftRoute("Info", "info", () => ReactInfiniteInfo())

  case object Demo extends LeftRoute("Demo", "demo", () => ReactInfiniteDemo())

  val menu : List[LeftRoute] = List(Info,Demo)

  val routes = RouterConfigDsl[LeftRoute].buildRule { dsl =>
    import dsl._
    menu.map(i =>
      staticRoute(i.route, i) ~> renderR(r => ReactInfinitePage(i, r))
    ).reduce(_ | _)

  }
}
