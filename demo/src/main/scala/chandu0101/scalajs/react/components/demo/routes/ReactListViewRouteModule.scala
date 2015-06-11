package chandu0101.scalajs.react.components.demo.routes

import chandu0101.scalajs.react.components.demo.components.reactlistview.{ReactListViewDemo, ReactListViewInfo}
import chandu0101.scalajs.react.components.demo.pages.ReactListViewPage
import japgolly.scalajs.react.extra.router2.RouterConfigDsl

object ReactListViewRouteModule {

  case object Info extends LeftRoute("Info", "info", () => ReactListViewInfo())

  case object Demo extends LeftRoute("Demo", "demo", () => ReactListViewDemo())

  val menu : List[LeftRoute] = List(Info,Demo)

  val routes = RouterConfigDsl[LeftRoute].buildRule { dsl =>

    import dsl._

    menu.map(i =>
      staticRoute(i.route, i) ~> renderR(r => ReactListViewPage(i, r))
    ).reduce(_ | _)

  }
}
