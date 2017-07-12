package demo
package routes

import demo.components.{ReactInfiniteInfo, ReactInfiniteDemo}
import demo.pages.ReactInfinitePage
import japgolly.scalajs.react.extra.router.RouterConfigDsl
import japgolly.scalajs.react.vdom.html_<^._

object ReactInfiniteRouteModule {

  case object Info extends LeftRoute("Info", "info", () => ReactInfiniteInfo())

  case object Demo extends LeftRoute("Demo", "demo", () => ReactInfiniteDemo())

  val menu: List[LeftRoute] = List(Info,Demo)

  val routes = RouterConfigDsl[LeftRoute].buildRule { dsl =>
    import dsl._
    menu.map(i =>
      staticRoute(i.route, i) ~> renderR(r => ReactInfinitePage(i, r))
    ).reduce(_ | _)

  }
}
