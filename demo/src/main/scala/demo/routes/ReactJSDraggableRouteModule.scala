package demo
package routes

import demo.components.{ReactDraggableInfo, ReactDraggableDemo}
import demo.pages.ReactJSDraggablePage
import japgolly.scalajs.react.extra.router.RouterConfigDsl

object ReactJSDraggableRouteModule {

  case object Info extends LeftRoute("Info", "info", () => ReactDraggableInfo())

  case object Demo extends LeftRoute("Demo", "demo", () => ReactDraggableDemo())

  val menu: List[LeftRoute] = List(Info,Demo)

  val routes = RouterConfigDsl[LeftRoute].buildRule { dsl =>

    import dsl._

    menu.map(i =>
      staticRoute(i.route, i) ~> renderR(r => ReactJSDraggablePage(i, r))
    ).reduce(_ | _)

  }
}
