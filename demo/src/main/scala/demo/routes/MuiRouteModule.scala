package demo
package routes

import demo.components.materialui._
import demo.pages.MuiPage
import japgolly.scalajs.react.extra.router2.RouterConfigDsl

object MuiRouteModule {

  case object Info extends LeftRoute("Info", "info", () => MuiInfo())

  case object Updates extends LeftRoute("Updating Inputs", "updating", () => MuiUpdatingComponentsDemo())

  case object AppBar extends LeftRoute("AppBar", "appbar", () => MuiAppBarDemo())

  case object Tabs extends LeftRoute("Tabs", "tabs", () => MuiTabsDemo())

  case object Buttons extends LeftRoute("Buttons", "buttons", () => MuiButtonsDemo())

  case object DatePicker extends LeftRoute("Date Picker", "datepicker", () => MuiDatePickerDemo())

  case object Dialog extends LeftRoute("Dialog", "dialog", () => MuiDialogDemo())

  case object DropDownMenu extends LeftRoute("DropDown Menu", "dropdownmenu", () => MuiDropDownMenuDemo())

  case object Paper extends LeftRoute("Paper", "paper", () => MuiPaperDemo())

  case object TextField extends LeftRoute("Text Field", "textfield", () => MuiTextFieldDemo())

  case object Progress extends LeftRoute("Progress Bars", "progress", () => MuiProgressDemo())

  case object SnackBar extends LeftRoute("SnackBar", "snackbar", () => MuiSnackBarDemo())

  case object Slider extends LeftRoute("Slider", "slider", () => MuiSliderDemo())

  case object TimePicker extends LeftRoute("Time Picker", "timepicker", () => MuiTimePickerDemo())

  case object Switches extends LeftRoute("Switches", "switches", () => MuiSwitchesDemo())

  case object Toolbar extends LeftRoute("Toolbar", "toolbar", () => MuiToolbarDemo())

  case object LeftNav extends LeftRoute("LeftNav", "leftnav", () => MuiLeftNavDemo())

  case object Menu extends LeftRoute("Menus", "menus", () => MuiMenuDemo())

  case object MList extends LeftRoute("List", "list", () => MuiListDemo())

  val menu: List[LeftRoute] = List(Info,
    Updates,
    AppBar,
    Buttons,
    DatePicker,
    Dialog,
    DropDownMenu,
    LeftNav,
    MList,
    Menu,
    Paper,
    Progress,
    Switches,
    Slider,
    SnackBar,
    TextField,
    TimePicker,
    Tabs,
    Toolbar)

  val routes = RouterConfigDsl[LeftRoute].buildRule { dsl =>

    import dsl._

    menu.map(i =>
      staticRoute(i.route, i) ~> renderR(r => MuiPage(i, r))
    ).reduce(_ | _)

  }
}
