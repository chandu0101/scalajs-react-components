package demo
package routes

import demo.components.materialui._
import demo.pages.MuiPage
import japgolly.scalajs.react.extra.router.RouterConfigDsl

object MuiRouteModule {

  case object Info extends LeftRoute("Info", "info", () => MuiInfo())

  case object AppBar extends LeftRoute("AppBar", "appbar", () => MuiAppBarDemo())

  case object AutoComplete extends LeftRoute("AutoComplete", "autocomplete", () => MuiAutoCompleteDemo())

  case object Avatar extends LeftRoute("Avatar", "avatar", () => MuiAvatarDemo())

  case object Tabs extends LeftRoute("Tabs", "tabs", () => MuiTabsDemo())

  case object Buttons extends LeftRoute("Buttons", "buttons", () => MuiButtonsDemo())

  case object DatePicker extends LeftRoute("Date Picker", "datepicker", () => MuiDatePickerDemo())

  case object Dialog extends LeftRoute("Dialog", "dialog", () => MuiDialogDemo())

  case object DropDownMenu extends LeftRoute("DropDown Menu", "dropdownmenu", () => MuiDropDownMenuDemo())

  case object Paper extends LeftRoute("Paper", "paper", () => MuiPaperDemo())

  case object Popover extends LeftRoute("Popover", "popover", () => MuiPopoverDemo())

  case object TextField extends LeftRoute("Text Field", "textfield", () => MuiTextFieldDemo())

  case object Progress extends LeftRoute("Progress Bars", "progress", () => MuiProgressDemo())

  case object SelectField extends LeftRoute("Select Field", "selectfield", () => MuiSelectFieldDemo())

  case object SnackBar extends LeftRoute("SnackBar", "snackbar", () => MuiSnackbarDemo())

  case object Slider extends LeftRoute("Slider", "slider", () => MuiSliderDemo())

  case object SvgIcon extends LeftRoute("Svg icons", "svgicon", () => MuiSvgIconDemo())

  case object TimePicker extends LeftRoute("Time Picker", "timepicker", () => MuiTimePickerDemo())

  case object Switches extends LeftRoute("Switches", "switches", () => MuiSwitchesDemo())

  case object Toolbar extends LeftRoute("Toolbar", "toolbar", () => MuiToolbarDemo())

  case object Drawer extends LeftRoute("Drawer", "drawer", () => MuiDrawerDemo())

  case object Menu extends LeftRoute("Menus", "menus", () => MuiMenuDemo())

  case object MList extends LeftRoute("List", "list", () => MuiListDemo())

  case object Table extends LeftRoute("Table", "table", () => MuiTableDemo())

  val menu: List[LeftRoute] = List(Info,
//    Updates,
    AppBar,
    AutoComplete,
    Avatar,
    Buttons,
    DatePicker,
    Dialog,
    DropDownMenu,
    Drawer,
    MList,
    Menu,
    Paper,
    Popover,
    Progress,
    SelectField,
    Switches,
    Slider,
    SvgIcon,
    SnackBar,
    TextField,
    TimePicker,
    Table,
    Tabs,
    Toolbar)

  val routes = RouterConfigDsl[LeftRoute].buildRule { dsl =>

    import dsl._

    menu.map(i =>
      staticRoute(i.route, i) ~> renderR(r => MuiPage(i, r))
    ).reduce(_ | _)

  }
}
