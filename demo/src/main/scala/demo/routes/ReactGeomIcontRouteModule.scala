package demo
package routes

import demo.components.{ReactGeomIconDemo, ReactGeomIconInfo}
import demo.pages.ReactGeomIconPage
import japgolly.scalajs.react.extra.router.RouterConfigDsl
import japgolly.scalajs.react.vdom.html_<^._

object ReactGeomIcontRouteModule {

  case object Info extends LeftRoute("Info", "info", () => ReactGeomIconInfo())

  case object Demo extends LeftRoute("Demo", "demo", () => ReactGeomIconDemo())

  val menu: List[LeftRoute] = List(Info, Demo)

  val routes = RouterConfigDsl[LeftRoute].buildRule { dsl =>
    import dsl._
    menu.map(i => staticRoute(i.route, i) ~> renderR(r => ReactGeomIconPage(i, r))).reduce(_ | _)

  }
}
