package demo
package pages

import demo.components.LeftNavPage
import demo.routes.{LeftRoute, ReactPopoverRouteModule}
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.extra.router2.RouterCtl

/**
 * Created by chandrasekharkode .
 */
object ReactPopoverPage {

  val component = ReactComponentB[Props]("ReactPopOverPage")
    .render((P) => {
    LeftNavPage(ReactPopoverRouteModule.menu, P.selectedPage, P.ctrl)
  })
    .build

  case class Props(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute])

  def apply(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute]) = component(Props(selectedPage, ctrl))

}
