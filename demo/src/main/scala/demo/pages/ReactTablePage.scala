package demo
package pages

import demo.components.LeftNavPage
import demo.routes.{LeftRoute, ReactTableRouteModule}
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.extra.router2.RouterCtl

object ReactTablePage {

  val component = ReactComponentB[Props]("ReactTablePage")
    .render((P) => {
    LeftNavPage(ReactTableRouteModule.menu, P.selectedPage, P.ctrl)
  })
    .build

  case class Props(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute])

  def apply(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute]) = component(Props(selectedPage, ctrl))

}