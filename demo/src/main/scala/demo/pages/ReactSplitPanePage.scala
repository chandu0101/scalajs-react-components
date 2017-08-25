package demo.pages

import chandu0101.scalajs.react.components.WithAsyncScript
import demo.components.LeftNavPage
import demo.routes.{LeftRoute, ReactSplitPaneRouteModule}
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.router.RouterCtl
import japgolly.scalajs.react.vdom.html_<^._

object ReactSplitPanePage {

  case class Backend($: BackendScope[_, _]){
    def render(P: Props): VdomElement =
      WithAsyncScript("assets/react_split_pane-bundle.js")(
        LeftNavPage(ReactSplitPaneRouteModule.menu, P.selectedPage, P.ctrl)
      )
  }

  val component = ScalaComponent.builder[Props]("ReactSplitPanePage")
    .renderBackend[Backend]
    .build

  case class Props(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute])

  def apply(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute]) = component(Props(selectedPage, ctrl))
}
