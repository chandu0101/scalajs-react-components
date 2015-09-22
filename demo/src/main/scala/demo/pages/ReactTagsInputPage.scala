package demo
package pages

import chandu0101.scalajs.react.components.mixins.AsyncLoad
import demo.components.LeftNavPage
import demo.routes.{LeftRoute, ReactTagsInputRouteModule}
import japgolly.scalajs.react.extra.router.RouterCtl
import japgolly.scalajs.react.{BackendScope, ReactComponentB}

object ReactTagsInputPage {

  class Backend(t: BackendScope[Props, _]) extends AsyncLoad {
    override val jsResources: Vector[String] = Vector("assets/reacttagpage-bundle.js")
    def render(P: Props) = {
      LeftNavPage(ReactTagsInputRouteModule.menu, P.selectedPage, P.ctrl)
    }
  }

  val component = ReactComponentB[Props]("ReactTagsInputPage")
    .stateless
    .renderBackend[Backend]
    .configure(AsyncLoad.mixin)
    .build

  case class Props(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute])

  def apply(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute]) = component(Props(selectedPage, ctrl))

}
