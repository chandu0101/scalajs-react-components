package chandu0101.scalajs.react.components.demo.routes

import chandu0101.scalajs.react.components.demo.components.reactpopover.{ReactPopoverDemo, ReactPopoverInfo}
import chandu0101.scalajs.react.components.demo.components.reacttable.{ReactTableCustomCell, ReactTableSorting, ReactTableBasic}
import chandu0101.scalajs.react.components.demo.pages.{ReactTablePage, ReactPopoverPage}
import japgolly.scalajs.react.extra.router2.RouterConfigDsl

object ReactTableRouteModule {

  case object Info extends LeftRoute("Info", "info", () => ReactPopoverInfo())

  case object Basic extends LeftRoute("Search ,Pagination", "basic", () => ReactTableBasic())
  case object Sorting extends LeftRoute("Sorting", "sort", () => ReactTableSorting())
  case object CustomCell extends LeftRoute("Custom Cell", "customcell", () => ReactTableCustomCell())

  val menu : List[LeftRoute] = List(Info,Basic,Sorting,CustomCell)

  val routes = RouterConfigDsl[LeftRoute].buildRule { dsl =>
    import dsl._
    menu.map(i =>
      staticRoute(i.route, i) ~> renderR(r => ReactTablePage(i, r))
    ).reduce(_ | _)

  }
}
