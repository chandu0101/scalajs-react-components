package demo
package pages

import chandu0101.scalajs.react.components.WithAsyncScript
import chandu0101.scalajs.react.components.materialui._
import demo.components.LeftNavPage
import demo.routes.{LeftRoute, MuiRouteModule}
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.router.RouterCtl
import japgolly.scalajs.react.vdom.html_<^._

object MuiPage {
  case class Backend($ : BackendScope[Props, _]) {
    def render(P: Props) =
      WithAsyncScript("assets/material_ui-bundle.js") {
        MuiMuiThemeProvider()(
          MuiPaper()(LeftNavPage(MuiRouteModule.menu, P.selectedPage, P.ctrl))
        )
      }
  }

  private val component = ScalaComponent
    .builder[Props]("MuiPage")
    .renderBackend[Backend]
    .build

  case class Props(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute])

  def apply(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute]) =
    component(Props(selectedPage, ctrl))
}
