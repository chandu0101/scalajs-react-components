package demo
package pages

import demo.components.LeftNavPage
import demo.routes.{LeftRoute, ReactListViewRouteModule}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import japgolly.scalajs.react.extra.router.RouterCtl

object ReactListViewPage {
  case class Backend($ : BackendScope[Props, _]) {
    def render(P: Props): VdomElement =
      LeftNavPage(ReactListViewRouteModule.menu, P.selectedPage, P.ctrl)
  }

  val component = ScalaComponent
    .builder[Props]("ReactListViewPage")
    .renderBackend[Backend]
    .build

  case class Props(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute])

  def apply(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute]) =
    component(Props(selectedPage, ctrl))

}
