package demo
package pages

import demo.components.LeftNavPage
import demo.routes.{LeftRoute, ReactJSDraggableRouteModule}
import japgolly.scalajs.react.{BackendScope, ReactComponentB}
import japgolly.scalajs.react.extra.router.RouterCtl

object ReactJSDraggablePage {
  case class Backend($ : BackendScope[Props, _]) {
    def render(P: Props) =
      LeftNavPage(ReactJSDraggableRouteModule.menu, P.selectedPage, P.ctrl)
  }

  val component = ReactComponentB[Props]("ReactJSDraggablePage")
    .renderBackend[Backend]
    .build

  case class Props(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute])

  def apply(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute]) =
    component(Props(selectedPage, ctrl))

}
