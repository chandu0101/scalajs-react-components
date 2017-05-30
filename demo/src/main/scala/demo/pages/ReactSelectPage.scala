package demo
package pages

import demo.components.LeftNavPage
import demo.routes.{LeftRoute, ReactSelectRouteModule}
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.router.RouterCtl

object ReactSelectPage {

  class Backend(t: BackendScope[Props, Unit]) {
    def render(P: Props) =
      LeftNavPage(ReactSelectRouteModule.menu, P.selectedPage, P.ctrl)
  }

  val component = ScalaComponent
    .builder[Props]("ReactSelectPage")
    .stateless
    .renderBackend[Backend]
    .build

  case class Props(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute])

  def apply(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute]) =
    component(Props(selectedPage, ctrl))

}
