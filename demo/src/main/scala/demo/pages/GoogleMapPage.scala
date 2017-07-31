package demo
package pages

import demo.components.LeftNavPage
import demo.routes.{GoogleMapRouteModule, LeftRoute}
import japgolly.scalajs.react.extra.router.RouterCtl
import japgolly.scalajs.react.{BackendScope, ReactComponentB}

object GoogleMapPage {
  case class Backend($ : BackendScope[Props, _]) {
    def render(P: Props) = {
      LeftNavPage(GoogleMapRouteModule.menu, P.selectedPage, P.ctrl)
    }
  }

  val component = ReactComponentB[Props]("GoogleMapPage")
    .renderBackend[Backend]
    .build

  case class Props(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute])

  def apply(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute]) =
    component(Props(selectedPage, ctrl))

}
