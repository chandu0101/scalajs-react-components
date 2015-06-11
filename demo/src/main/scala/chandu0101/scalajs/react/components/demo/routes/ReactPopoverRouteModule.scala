package chandu0101.scalajs.react.components.demo.routes

import chandu0101.scalajs.react.components.demo.components.reactpopover.{ReactPopoverDemo, ReactPopoverInfo}
import chandu0101.scalajs.react.components.demo.components.reacttreeview.{ReactTreeViewDemo, ReactTreeViewInfo}
import chandu0101.scalajs.react.components.demo.pages.{ReactPopoverPage, ReactTreeViewPage}
import japgolly.scalajs.react.extra.router2.RouterConfigDsl

object ReactPopoverRouteModule {

  case object Info extends LeftRoute("Info", "info", () => ReactPopoverInfo())

  case object Demo extends LeftRoute("Demo", "demo", () => ReactPopoverDemo())

  val menu : List[LeftRoute] = List(Info,Demo)

  val routes = RouterConfigDsl[LeftRoute].buildRule { dsl =>

    import dsl._

    menu.map(i =>
      staticRoute(i.route, i) ~> renderR(r => ReactPopoverPage(i, r))
    ).reduce(_ | _)

  }
}
