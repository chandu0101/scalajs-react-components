package demo.routes

import demo.components.{ReactSlickDemo, ReactSlickInfo}
import demo.pages.SlickPage
import japgolly.scalajs.react.extra.router.RouterConfigDsl
import japgolly.scalajs.react.vdom.html_<^._

object ReactSlickRouteModule {

  case object Info extends LeftRoute("Info", "info", () => ReactSlickInfo())

  case object Demo extends LeftRoute("Demo", "demo", () => ReactSlickDemo())

  val menu: List[LeftRoute] = List(Info, Demo)

  val routes = RouterConfigDsl[LeftRoute].buildRule { dsl =>
    import dsl._
    menu.map(i => staticRoute(i.route, i) ~> renderR(r => SlickPage(i, r))).reduce(_ | _)

  }
}
