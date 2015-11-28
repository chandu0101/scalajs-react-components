package demo
package pages

import demo.components.LeftNavPage
import demo.routes.{LeftRoute, ReactTableRouteModule}
import japgolly.scalajs.react.{BackendScope, ReactComponentB}
import japgolly.scalajs.react.extra.router.RouterCtl

object ReactTablePage {
  case class Backend($: BackendScope[Props, _]){
    def render(P: Props) =
      LeftNavPage(ReactTableRouteModule.menu, P.selectedPage, P.ctrl)
  }

  val component = ReactComponentB[Props]("ReactTablePage")
    .renderBackend[Backend]
    .build

  case class Props(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute])

  def apply(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute]) = component(Props(selectedPage, ctrl))

}