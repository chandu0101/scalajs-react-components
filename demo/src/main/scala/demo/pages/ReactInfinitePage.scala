package demo
package pages

import demo.components.LeftNavPage
import demo.routes.{LeftRoute, ReactInfiniteRouteModule}
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.router.RouterCtl
import japgolly.scalajs.react.vdom.html_<^._

object ReactInfinitePage {

  class Backend(t: BackendScope[Props, Unit]) {
    def render(P: Props): VdomElement =
      LeftNavPage(ReactInfiniteRouteModule.menu, P.selectedPage, P.ctrl)
  }

  val component = ScalaComponent
    .builder[Props]("ReactInfinitePage")
    .stateless
    .renderBackend[Backend]
    .build

  case class Props(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute])

  def apply(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute]) =
    component(Props(selectedPage, ctrl))

}
