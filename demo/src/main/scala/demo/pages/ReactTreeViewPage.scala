package demo
package pages

import demo.components.LeftNavPage
import demo.routes.{LeftRoute, ReactTreeViewRouteModule}
import japgolly.scalajs.react.{BackendScope, ReactComponentB}
import japgolly.scalajs.react.extra.router.RouterCtl

object ReactTreeViewPage {
  val component = ReactComponentB[Props]("ReactTreeViewPage")
    .renderBackend[Backend]
    .build

  class Backend(t: BackendScope[Props, _]) {
    def render(P: Props) =
      LeftNavPage(ReactTreeViewRouteModule.menu, P.selectedPage, P.ctrl)
  }

  case class Props(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute])

  def apply(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute]) =
    component(Props(selectedPage, ctrl))

}
