package demo
package pages

import demo.components.LeftNavPage
import demo.routes.{LeftRoute, ReactJSDraggableRouteModule}
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.extra.router2.RouterCtl

object ReactJSDraggablePage {

  val component = ReactComponentB[Props]("ReactJSDraggablePage")
    .render((P) => {
    LeftNavPage(ReactJSDraggableRouteModule.menu, P.selectedPage, P.ctrl)
  })
    .build

  case class Props(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute])

  def apply(selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute]) = component(Props(selectedPage, ctrl))

}
