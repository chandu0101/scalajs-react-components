package demo.pages

import demo.components.LeftNavPage
import demo.routes.{LeftRoute, SuiRouteModule}
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.router.RouterCtl

object SuiPage {

  case class Props(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute])

  case class Backend($ : BackendScope[Props, Unit]) {
    def render(P: Props) =
      LeftNavPage(SuiRouteModule.menu, P.selectedPage, P.ctrl)
  }

  val component = ScalaComponent
    .builder[Props]("SuiPage")
    .renderBackend[Backend]
    .build

  def apply(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute]) =
    component(Props(selectedPage, ctrl))
}
