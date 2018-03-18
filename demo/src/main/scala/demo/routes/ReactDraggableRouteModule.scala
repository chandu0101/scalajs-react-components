package demo
package routes

import demo.components.{ReactDraggableDemo, ReactDraggableInfo}
import demo.pages.ReactDraggablePage
import japgolly.scalajs.react.extra.router.RouterConfigDsl
import japgolly.scalajs.react.vdom.html_<^._

object ReactDraggableRouteModule {

  case object Info extends LeftRoute("Info", "info", () => ReactDraggableInfo())

  case object Demo extends LeftRoute("Demo", "demo", () => ReactDraggableDemo())

  val menu: List[LeftRoute] = List(Info, Demo)

  val routes = RouterConfigDsl[LeftRoute].buildRule { dsl =>
    import dsl._

    menu
      .map(i => staticRoute(i.route, i) ~> renderR(r => ReactDraggablePage(i, r)))
      .reduce(_ | _)

  }
}
