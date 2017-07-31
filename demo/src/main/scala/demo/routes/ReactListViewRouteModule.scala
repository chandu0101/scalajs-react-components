package demo
package routes

import demo.components.{ReactListViewDemo, ReactListViewInfo}
import demo.pages.ReactListViewPage
import japgolly.scalajs.react.extra.router.RouterConfigDsl
import japgolly.scalajs.react.vdom.html_<^._

object ReactListViewRouteModule {

  case object Info extends LeftRoute("Info", "info", () => ReactListViewInfo())

  case object Demo extends LeftRoute("Demo", "demo", () => ReactListViewDemo())

  val menu: List[LeftRoute] = List(Info, Demo)

  val routes = RouterConfigDsl[LeftRoute].buildRule { dsl =>
    import dsl._
    menu.map(i => staticRoute(i.route, i) ~> renderR(r => ReactListViewPage(i, r))).reduce(_ | _)

  }
}
