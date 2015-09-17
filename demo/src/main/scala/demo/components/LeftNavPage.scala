package demo
package components

import demo.routes.LeftRoute
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.router2.RouterCtl
import japgolly.scalajs.react.vdom.prefix_<^._
import scala.scalajs.js
import scalacss.Defaults._
import scalacss.ScalaCssReact._

object LeftNavPage {

  object Style extends StyleSheet.Inline {
    import dsl._
    val container = style(
    display.flex,
      minHeight(600.px),
     paddingTop(64 px))

    val nav = style(width(190.px))

    val content = style(padding(30.px),
      borderLeft :=! "1px solid rgb(223, 220, 220)",
     flex := "1")
  }

  val component = ReactComponentB[Props]("LeftNavPage")
    .render(P => {
    <.div(Style.container,
      <.div(Style.nav, LeftNav(P.menu,P.selectedPage,P.ctrl)),
      <.div(Style.content, P.selectedPage.render())
    )
  })
    .build

  case class Props(menu: List[LeftRoute], selectedPage: LeftRoute,ctrl: RouterCtl[LeftRoute])

  def apply(menu: List[LeftRoute], selectedPage: LeftRoute,ctrl: RouterCtl[LeftRoute],ref: js.UndefOr[String] = "", key: js.Any = {}) = component.set(key, ref)(Props(menu,selectedPage,ctrl))
}
