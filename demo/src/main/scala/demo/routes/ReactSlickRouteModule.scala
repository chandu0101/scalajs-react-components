package demo.routes

import demo.components.{ReactSlickInfo, ReactSlickDemo}
import demo.pages.SlickPage
import japgolly.scalajs.react.extra.router.RouterConfigDsl

object ReactSlickRouteModule {

  case object Info extends LeftRoute("Info", "info", () => ReactSlickInfo())

  case object Demo extends LeftRoute("Demo", "demo", () => ReactSlickDemo())

  val menu: List[LeftRoute] = List(Info,Demo)

  val routes = RouterConfigDsl[LeftRoute].buildRule { dsl =>
    import dsl._
    menu.map(i =>
      staticRoute(i.route, i) ~> renderR(r => SlickPage(i, r))
    ).reduce(_ | _)

  }
}
