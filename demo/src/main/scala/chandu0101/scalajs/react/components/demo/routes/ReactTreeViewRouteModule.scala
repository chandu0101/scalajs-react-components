package chandu0101.scalajs.react.components.demo.routes

import chandu0101.scalajs.react.components.demo.components.reactlistview.{ReactListViewDemo, ReactListViewInfo}
import chandu0101.scalajs.react.components.demo.components.reacttreeview.{ReactTreeViewDemo, ReactTreeViewInfo}
import chandu0101.scalajs.react.components.demo.pages.{ReactTreeViewPage, ReactListViewPage}
import japgolly.scalajs.react.extra.router2.RouterConfigDsl

object ReactTreeViewRouteModule {

  case object Info extends LeftRoute("Info", "info", () => ReactTreeViewInfo())

  case object Demo extends LeftRoute("Demo", "demo", () => ReactTreeViewDemo())

  val menu : List[LeftRoute] = List(Info,Demo)

  val routes = RouterConfigDsl[LeftRoute].buildRule { dsl =>

    import dsl._

    menu.map(i =>
      staticRoute(i.route, i) ~> renderR(r => ReactTreeViewPage(i, r))
    ).reduce(_ | _)

  }
}
