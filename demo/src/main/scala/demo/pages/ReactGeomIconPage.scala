package demo
package pages

import chandu0101.scalajs.react.components.WithAsyncScript
import demo.components.LeftNavPage
import demo.routes.{LeftRoute, ReactGeomIcontRouteModule}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import japgolly.scalajs.react.extra.router.RouterCtl

object ReactGeomIconPage {

  class Backend(t: BackendScope[_, _]) {
    def render(P: Props) =
      WithAsyncScript("assets/react_geom_icons-bundle.js")(
        LeftNavPage(ReactGeomIcontRouteModule.menu, P.selectedPage, P.ctrl)
      )
  }

  val component = ScalaComponent.builder[Props]("ReactGeomIconPage")
    .stateless
    .renderBackend[Backend]
    .build

  case class Props(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute])

  def apply(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute]) = component(Props(selectedPage, ctrl))

}
