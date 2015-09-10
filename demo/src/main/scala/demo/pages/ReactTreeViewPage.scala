package demo
package pages

import demo.components.LeftNavPage
import demo.routes.{LeftRoute, ReactTreeViewRouteModule}
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.extra.router2.RouterCtl

/**
 * Created by chandrasekharkode .
 */
object ReactTreeViewPage {
  val component = ReactComponentB[Props]("ReactTreeViewPage")
    .render((P) => {
    LeftNavPage(ReactTreeViewRouteModule.menu, P.selectedPage, P.ctrl)
  })
    .build

  case class Props(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute])

  def apply(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute]) = component(Props(selectedPage, ctrl))

}
