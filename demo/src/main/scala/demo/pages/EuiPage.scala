package demo
package pages

import chandu0101.scalajs.react.components._
import demo.components.LeftNavPage
import demo.routes.{EuiRouteModule, LeftRoute}
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.router.RouterCtl
import japgolly.scalajs.react.vdom.prefix_<^._

object EuiPage {
  case class Backend($: BackendScope[Props, _]) {
    def render(P: Props) =
      <.div(
        WithAsyncScript(("assets/elemental_ui-bundle.js"))(
          LeftNavPage(EuiRouteModule.menu, P.selectedPage, P.ctrl)
        )
      )
  }

  val component = ReactComponentB[Props]("EuiPage")
    .renderBackend[Backend]
    .build

  case class Props(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute])

  def apply(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute]) = component(Props(selectedPage, ctrl))

}
