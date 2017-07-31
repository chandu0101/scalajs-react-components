package demo
package components

import demo.routes.LeftRoute
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.router.RouterCtl
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js
import scala.scalajs.js.UndefOr
import scalacss.Defaults._
import scalacss.ScalaCssReact._

object LeftNav {

  object Style extends StyleSheet.Inline {

    import dsl._

    val container = style(display.flex, flexDirection.column, listStyle := "none", padding.`0`)

    val menuItem = styleF.bool(
      selected =>
        styleS(
          lineHeight(48.px),
          padding :=! "0 25px",
          cursor.pointer,
          textDecoration := "none",
          mixinIfElse(selected)(color.red, fontWeight._500)(
            color.black,
            &.hover(color(c"#555555"), backgroundColor(c"#ecf0f1")))
      ))
  }

  case class Props(menus: List[LeftRoute], selectedPage: LeftRoute, ctrl: RouterCtl[LeftRoute])

  case class Backend($ : BackendScope[Props, _]) {
    def render(P: Props) = {
      <.ul(Style.container)(
        P.menus.map(
          item =>
            <.li(^.key := item.name,
                 Style.menuItem(item == P.selectedPage),
                 item.name,
                 P.ctrl setOnClick item))
      )
    }
  }
  val component = ReactComponentB[Props]("LeftNav")
    .renderBackend[Backend]
    .build

  def apply(menus: List[LeftRoute],
            selectedPage: LeftRoute,
            ctrl: RouterCtl[LeftRoute],
            ref: UndefOr[String] = "",
            key: js.Any = {}) =
    component.set(key, ref)(Props(menus, selectedPage, ctrl))
}
