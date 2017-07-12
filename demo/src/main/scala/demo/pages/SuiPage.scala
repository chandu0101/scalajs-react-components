package demo.pages

import chandu0101.scalajs.react.components.WithAsyncScript
import demo.components.LeftNavPage
import demo.routes.LeftRoute
import demo.routes.SuiRouteModule
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import japgolly.scalajs.react.extra.router.RouterCtl

object SuiPage {

  case class Props(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute])

  case class Backend($ : BackendScope[Props, _]) {
    def render(P: Props) =
      WithAsyncScript("assets/semantic_ui-bundle.js") {
        LeftNavPage(SuiRouteModule.menu, P.selectedPage, P.ctrl)
      }
  }

  val component = ScalaComponent
    .builder[Props]("SuiPage")
    .renderBackend[Backend]
    .build

  def apply(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute]) =
    component(Props(selectedPage, ctrl))
}
