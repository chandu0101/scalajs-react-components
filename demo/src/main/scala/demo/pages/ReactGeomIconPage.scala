package demo
package pages

import chandu0101.scalajs.react.components.WithAsyncScript
import demo.components.LeftNavPage
import demo.routes.{LeftRoute, ReactGeomIcontRouteModule}
import japgolly.scalajs.react.extra.router.RouterCtl
import japgolly.scalajs.react.{BackendScope, ReactComponentB}

object ReactGeomIconPage {

  class Backend(t: BackendScope[_, _]) {
    def render(P: Props) =
      WithAsyncScript("assets/react_geom_icons-bundle.js")(
        LeftNavPage(ReactGeomIcontRouteModule.menu, P.selectedPage, P.ctrl)
      )
  }

  val component = ReactComponentB[Props]("ReactGeomIconPage").stateless
    .renderBackend[Backend]
    .build

  case class Props(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute])

  def apply(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute]) =
    component(Props(selectedPage, ctrl))

}
