package demo.pages

import demo.components.LeftNavPage
import demo.routes.{LeftRoute, ReactSplitPaneRouteModule}
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.router.RouterCtl
import japgolly.scalajs.react.vdom.html_<^._

object ReactSplitPanePage {
  case class Backend($ : BackendScope[_, _]) {
    def render(P: Props): VdomElement =
      LeftNavPage(ReactSplitPaneRouteModule.menu, P.selectedPage, P.ctrl)
  }

  val component = ScalaComponent
    .builder[Props]("ReactSplitPanePage")
    .renderBackend[Backend]
    .build

  case class Props(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute])

  def apply(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute]) =
    component(Props(selectedPage, ctrl))
}
