package demo.pages

import demo.components.LeftNavPage
import demo.routes.{LeftRoute, ReactSlickRouteModule}
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.router.RouterCtl

object SlickPage {

  class Backend(t: BackendScope[Props, Unit]) {
    def render(P: Props) =
      LeftNavPage(ReactSlickRouteModule.menu, P.selectedPage, P.ctrl)
  }

  val component = ScalaComponent
    .builder[Props]("SlickPage")
    .stateless
    .renderBackend[Backend]
    .build

  case class Props(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute])

  def apply(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute]) =
    component(Props(selectedPage, ctrl))

}
