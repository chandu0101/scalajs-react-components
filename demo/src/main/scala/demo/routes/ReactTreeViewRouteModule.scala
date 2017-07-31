package demo
package routes

import demo.components.{ReactTreeViewDemo, ReactTreeViewInfo}
import demo.pages.ReactTreeViewPage
import japgolly.scalajs.react.extra.router.RouterConfigDsl
import japgolly.scalajs.react.vdom.html_<^._

object ReactTreeViewRouteModule {

  case object Info extends LeftRoute("Info", "info", () => ReactTreeViewInfo())

  case object Demo extends LeftRoute("Demo", "demo", () => ReactTreeViewDemo())

  val menu: List[LeftRoute] = List(Info, Demo)

  val routes = RouterConfigDsl[LeftRoute].buildRule { dsl =>
    import dsl._

    menu.map(i => staticRoute(i.route, i) ~> renderR(r => ReactTreeViewPage(i, r))).reduce(_ | _)

  }
}
