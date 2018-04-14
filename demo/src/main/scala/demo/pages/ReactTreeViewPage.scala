package demo
package pages

import demo.components.LeftNavPage
import demo.routes.{LeftRoute, ReactTreeViewRouteModule}
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.router.RouterCtl

object ReactTreeViewPage {
  val component = ScalaComponent
    .builder[Props]("ReactTreeViewPage")
    .renderBackend[Backend]
    .build

  class Backend(t: BackendScope[Props, Unit]) {
    def render(P: Props) =
      LeftNavPage(ReactTreeViewRouteModule.menu, P.selectedPage, P.ctrl)
  }

  case class Props(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute])

  def apply(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute]) =
    component(Props(selectedPage, ctrl))

}
