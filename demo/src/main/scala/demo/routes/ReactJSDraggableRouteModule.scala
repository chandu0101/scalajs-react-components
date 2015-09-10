package demo
package routes

import demo.components.reactpopover.ReactPopoverInfo
import demo.components.reacttable.ReactTableBasic
import demo.pages.ReactJSDraggablePage
import japgolly.scalajs.react.extra.router2.RouterConfigDsl

object ReactJSDraggableRouteModule {

  case object Info extends LeftRoute("Info", "info", () => ReactPopoverInfo())

  case object Demo extends LeftRoute("Demo", "demo", () => ReactTableBasic())

  val menu : List[LeftRoute] = List(Info,Demo)

  val routes = RouterConfigDsl[LeftRoute].buildRule { dsl =>

    import dsl._

    menu.map(i =>
      staticRoute(i.route, i) ~> renderR(r => ReactJSDraggablePage(i, r))
    ).reduce(_ | _)

  }
}
