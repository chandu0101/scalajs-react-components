package demo
package pages

import demo.components.LeftNavPage
import demo.routes.{LeftRoute, ReactPopoverRouteModule}
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.router.RouterCtl

object ReactPopoverPage {
  case class Backend($ : BackendScope[Props, Unit]) {
    def render(P: Props) = {
      LeftNavPage(ReactPopoverRouteModule.menu, P.selectedPage, P.ctrl)
    }
  }

  val component = ScalaComponent
    .builder[Props]("ReactPopOverPage")
    .renderBackend[Backend]
    .build

  case class Props(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute])

  def apply(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute]) =
    component(Props(selectedPage, ctrl))

}
