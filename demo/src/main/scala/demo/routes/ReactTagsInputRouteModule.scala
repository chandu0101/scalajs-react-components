package demo
package routes

import demo.components.{ReactTagsInputDemo, ReactTagsInputInfo}
import demo.pages.ReactTagsInputPage
import japgolly.scalajs.react.extra.router.RouterConfigDsl
import japgolly.scalajs.react.vdom.html_<^._

object ReactTagsInputRouteModule {

  case object Info extends LeftRoute("Info", "info", () => ReactTagsInputInfo())

  case object Demo extends LeftRoute("Demo", "demo", () => ReactTagsInputDemo())

  val menu: List[LeftRoute] = List(Info, Demo)

  val routes = RouterConfigDsl[LeftRoute].buildRule { dsl =>
    import dsl._
    menu.map(i => staticRoute(i.route, i) ~> renderR(r => ReactTagsInputPage(i, r))).reduce(_ | _)

  }
}
