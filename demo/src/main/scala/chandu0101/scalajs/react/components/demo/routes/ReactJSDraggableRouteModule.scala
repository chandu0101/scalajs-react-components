package chandu0101.scalajs.react.components.demo.routes

import chandu0101.scalajs.react.components.demo.components.reactpopover.ReactPopoverInfo
import chandu0101.scalajs.react.components.demo.components.reacttable.{ReactTableBasic, ReactTableCustomCell, ReactTableSorting}
import chandu0101.scalajs.react.components.demo.pages.{ReactJSDraggablePage, ReactTablePage}
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
