package chandu0101.scalajs.react.components.demo.routes

import chandu0101.scalajs.react.components.demo.components.materialui._
import chandu0101.scalajs.react.components.demo.pages.MuiPage
import japgolly.scalajs.react.extra.router2.RouterConfigDsl

object MuiRouteModule {

  case object Info extends LeftRoute("Info", "info", () => MuiInfo())

  case object AppBar extends LeftRoute("AppBar", "appbar", () => MuiAppBarDemo())

  case object Tabs extends LeftRoute("Tabs", "tabs", () => MuiTabsDemo())

  case object Buttons extends LeftRoute("Buttons", "buttons", () => MuiButtonsDemo())

  case object DatePicker extends LeftRoute("Date Picker", "datepicker", () => MuiDatePickerDemo())

  case object Dialog extends LeftRoute("Dialog", "dialog", () => MuiDialogDemo())
  case object DropDownMenu extends LeftRoute("DropDown Menu", "dropdownmenu", () => MuiDropDownMenuDemo())

  val menu: List[LeftRoute] = List(Info, AppBar, Buttons, DatePicker, Dialog,DropDownMenu, Tabs)

  val routes = RouterConfigDsl[LeftRoute].buildRule { dsl =>

    import dsl._

    menu.map(i =>
      staticRoute(i.route, i) ~> renderR(r => MuiPage(i, r))
    ).reduce(_ | _)

  }
}
