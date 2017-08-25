package demo.routes

import demo.components.reactsplitpane._
import demo.pages.ReactSplitPanePage
import japgolly.scalajs.react.extra.router.RouterConfigDsl
import japgolly.scalajs.react.vdom.html_<^._

object ReactSplitPaneRouteModule {

  case object Info extends LeftRoute("Info", "info", () => ReactSplitPaneInfo())

  case object SimpleVertical extends LeftRoute("Simple Vertical", "simplevertical", () => ReactSplitPaneSimpleVertical())

  case object SimpleHorizontal extends LeftRoute("Simple Horizontal", "simplehorizontal", () => ReactSplitPaneSimpleHorizontal())

  case object SimpleNested extends LeftRoute("Simple Nested", "simplenested", () => ReactSplitPaneSimpleNested())

  val menu: List[LeftRoute] = List(Info, SimpleVertical, SimpleHorizontal, SimpleNested)

  val routes = RouterConfigDsl[LeftRoute].buildRule { dsl =>
    import dsl._
    menu.map(i =>
      staticRoute(i.route, i) ~> renderR(r => ReactSplitPanePage(i, r))
    ).reduce(_ | _)

  }
}
