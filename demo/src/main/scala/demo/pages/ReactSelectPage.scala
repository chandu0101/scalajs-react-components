package demo
package pages

import chandu0101.scalajs.react.components.WithAsyncScript
import demo.components.LeftNavPage
import demo.routes.{LeftRoute, ReactSelectRouteModule}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import japgolly.scalajs.react.extra.router.RouterCtl

object ReactSelectPage {

  class Backend(t: BackendScope[_, _]) {
    def render(P: Props) =
      WithAsyncScript("assets/react_select-bundle.js")(
        LeftNavPage(ReactSelectRouteModule.menu, P.selectedPage, P.ctrl)
      )
  }

  val component = ScalaComponent.builder[Props]("ReactSelectPage")
    .stateless
    .renderBackend[Backend]
    .build

  case class Props(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute])

  def apply(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute]) = component(Props(selectedPage, ctrl))

}
