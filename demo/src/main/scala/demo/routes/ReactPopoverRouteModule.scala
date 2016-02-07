package demo
package routes

import demo.components.{ReactPopoverInfo, ReactPopoverDemo}
import demo.pages.ReactPopoverPage
import japgolly.scalajs.react.extra.router.RouterConfigDsl

object ReactPopoverRouteModule {

  case object Info extends LeftRoute("Info", "info", () => ReactPopoverInfo())

  case object Demo extends LeftRoute("Demo", "demo", () => ReactPopoverDemo())

  val menu: List[LeftRoute] = List(Info,Demo)

  val routes = RouterConfigDsl[LeftRoute].buildRule { dsl =>

    import dsl._

    menu.map(i =>
      staticRoute(i.route, i) ~> renderR(r => ReactPopoverPage(i, r))
    ).reduce(_ | _)

  }
}
