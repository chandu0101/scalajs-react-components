package demo
package pages

import demo.components.LeftNavPage
import demo.routes.{LeftRoute, ReactTableRouteModule}
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.router.RouterCtl

object ReactTablePage {
  case class Backend($ : BackendScope[Props, Unit]) {
    def render(P: Props) =
      LeftNavPage(ReactTableRouteModule.menu, P.selectedPage, P.ctrl)
  }

  val component = ScalaComponent
    .builder[Props]("ReactTablePage")
    .renderBackend[Backend]
    .build

  case class Props(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute])

  def apply(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute]) =
    component(Props(selectedPage, ctrl))

}
