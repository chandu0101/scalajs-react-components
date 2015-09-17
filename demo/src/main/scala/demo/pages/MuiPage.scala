package demo
package pages

import chandu0101.scalajs.react.components._
import demo.components.LeftNavPage
import demo.routes.{LeftRoute, MuiRouteModule}
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.router2.RouterCtl

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
