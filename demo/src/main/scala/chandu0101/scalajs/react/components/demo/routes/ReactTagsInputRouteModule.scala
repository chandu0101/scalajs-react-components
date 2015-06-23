package chandu0101.scalajs.react.components.demo.routes

import chandu0101.scalajs.react.components.demo.components.reactlistview.{ReactListViewDemo, ReactListViewInfo}
import chandu0101.scalajs.react.components.demo.components.reacttagsinput.{ReactTagsInputDemo, ReactTagsInputInfo}
import chandu0101.scalajs.react.components.demo.pages.{ReactTagsInputPage, ReactListViewPage}
import japgolly.scalajs.react.extra.router2.RouterConfigDsl

object ReactTagsInputRouteModule {

  case object Info extends LeftRoute("Info", "info", () => ReactTagsInputInfo())

  case object Demo extends LeftRoute("Demo", "demo", () => ReactTagsInputDemo())

  val menu : List[LeftRoute] = List(Info,Demo)

  val routes = RouterConfigDsl[LeftRoute].buildRule { dsl =>
    import dsl._
    menu.map(i =>
      staticRoute(i.route, i) ~> renderR(r => ReactTagsInputPage(i, r))
    ).reduce(_ | _)

  }
}
