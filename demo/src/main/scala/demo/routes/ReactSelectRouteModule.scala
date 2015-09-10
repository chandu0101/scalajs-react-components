package demo
package routes

import demo.components.reactselect.{ReactSelectDemo, ReactSelectInfo}
import demo.pages.ReactSelectPage
import japgolly.scalajs.react.extra.router2.RouterConfigDsl

object ReactSelectRouteModule {

  case object Info extends LeftRoute("Info", "info", () => ReactSelectInfo())

  case object Demo extends LeftRoute("Demo", "demo", () => ReactSelectDemo())

  val menu : List[LeftRoute] = List(Info,Demo)

  val routes = RouterConfigDsl[LeftRoute].buildRule { dsl =>
    import dsl._
    menu.map(i =>
      staticRoute(i.route, i) ~> renderR(r => ReactSelectPage(i, r))
    ).reduce(_ | _)

  }
}
