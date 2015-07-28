package chandu0101.scalajs.react.components.demo.routes

import chandu0101.scalajs.react.components.demo.components.reacttagsinput.{ReactTagsInputDemo, ReactTagsInputInfo}
import chandu0101.scalajs.react.components.demo.components.spinner.{SpinnerDemo, SpinnerInfo}
import chandu0101.scalajs.react.components.demo.pages.{SpinnerPage, ReactTagsInputPage}
import japgolly.scalajs.react.extra.router2.RouterConfigDsl

object SpinnerRouteModule {

  case object Info extends LeftRoute("Info", "info", () => SpinnerInfo())

  case object Demo extends LeftRoute("Demo", "demo", () => SpinnerDemo())

  val menu : List[LeftRoute] = List(Info,Demo)

  val routes = RouterConfigDsl[LeftRoute].buildRule { dsl =>
    import dsl._
    menu.map(i =>
      staticRoute(i.route, i) ~> renderR(r => SpinnerPage(i, r))
    ).reduce(_ | _)

  }
}
