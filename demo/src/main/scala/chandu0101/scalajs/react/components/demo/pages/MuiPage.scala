package chandu0101.scalajs.react.components.demo.pages

import chandu0101.scalajs.react.components.demo.components.LeftNavPage
import chandu0101.scalajs.react.components.demo.routes.{LeftRoute, MuiRouteModule}
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.router2.RouterCtl

import scala.scalajs.js.Dynamic.{global => g, literal => json}

object MuiPage {

  val component = ReactComponentB[Props]("MuiPage")
    .render((P) => {
    LeftNavPage(MuiRouteModule.menu, P.selectedPage, P.ctrl)
  })
    .configureSpec(materialui.installMuiContext)
    .build

  case class Props(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute])

  def apply(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute]) = component(Props(selectedPage, ctrl))


}
