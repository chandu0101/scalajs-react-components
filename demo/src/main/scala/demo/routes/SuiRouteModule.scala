package demo.routes

import demo.pages.SuiPage
import demo.components.semanticui._
import japgolly.scalajs.react.extra.router.RouterConfigDsl
import japgolly.scalajs.react.vdom.html_<^._

object SuiRouteModule {
  case object Info extends LeftRoute("Info", "info", () => SuiInfo())

  case object Button extends LeftRoute("Button", "button", () => SuiButtonDemo())

  case object Container extends LeftRoute("Container", "container", () => SuiContainerDemo())

  case object Divider extends LeftRoute("Divider", "divider", () => SuiDividerDemo())

  case object Flag extends LeftRoute("Flag", "flag", () => SuiFlagDemo())

  case object Header extends LeftRoute("Header", "header", () => SuiHeaderDemo())

  case object Icon extends LeftRoute("Icon", "icon", () => SuiIconDemo())

  case object Input extends LeftRoute("Input", "input", () => SuiInputDemo())

  case object SuiList extends LeftRoute("List", "list", () => SuiListDemo())

  case object Grid extends LeftRoute("Grid", "grid", () => SuiGridDemo())

  val menu: List[LeftRoute] = List(
    Info,
    Button,
    Container,
    Divider,
    Flag,
    Header,
    Icon,
    Input,
    SuiList,
    Grid
  )

  val routes = RouterConfigDsl[LeftRoute].buildRule { dsl =>
    import dsl._
    menu
      .map(i => staticRoute(i.route, i) ~> renderR(r => SuiPage(i, r)))
      .reduce(_ | _)
  }
}