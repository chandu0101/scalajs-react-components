package chandu0101.scalajs.react.components
package materialui

import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.{Array => JArray}


case class MuiLeftNav(menuItems: JArray[MuiMenuItem],
                      style: js.UndefOr[js.Any] = js.undefined,
                      onChange: js.UndefOr[(ReactEvent, Int, js.Object) => Unit] = js.undefined,
                      ref: js.UndefOr[String] = js.undefined,
                      onNavClose: js.UndefOr[() => Unit] = js.undefined,
                      onNavOpen: js.UndefOr[() => Unit] = js.undefined,
                      key: js.UndefOr[String] = js.undefined,
                      className: js.UndefOr[String] = js.undefined,
                      docked: js.UndefOr[Boolean] = js.undefined,
                      header: js.UndefOr[ReactElement] = js.undefined,
                      selectedIndex: js.UndefOr[Int] = js.undefined,
                      openRight: js.UndefOr[Boolean] = js.undefined) {

  def apply() = {
    val props = JSMacro[MuiLeftNav](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.LeftNav)
    f(props).asInstanceOf[ReactComponentU_]
  }

}

@js.native
trait MuiLeftNavM extends js.Object {

  def close(): Unit = js.native

  def toggle(): Unit = js.native
}


case class MuiMenu(onToggle: js.UndefOr[(ReactEvent, Int, Boolean) => Unit] = js.undefined,
                   menuItems: JArray[MuiMenuItem],
                   visible: js.UndefOr[Boolean] = js.undefined,
                   style: js.UndefOr[js.Any] = js.undefined,
                   ref: js.UndefOr[String] = js.undefined,
                   onItemTap: js.UndefOr[(ReactEvent, Int, js.Object) => Unit] = js.undefined,
                   menuItemStyleLink: js.UndefOr[js.Any] = js.undefined,
                   zDepth: js.UndefOr[Int] = js.undefined,
                   menuItemStyle: js.UndefOr[js.Any] = js.undefined,
                   key: js.UndefOr[String] = js.undefined,
                   autoWidth: js.UndefOr[Boolean] = js.undefined,
                   menuItemClassNameSubheader: js.UndefOr[String] = js.undefined,
                   menuItemStyleSubheader: js.UndefOr[js.Any] = js.undefined,
                   hideable: js.UndefOr[Boolean] = js.undefined,
                   menuItemClassNameLink: js.UndefOr[String] = js.undefined,
                   menuItemClassName: js.UndefOr[String] = js.undefined,
                   selectedIndex: js.UndefOr[Int] = js.undefined) {

  def apply() = {
    val props = JSMacro[MuiMenu](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Menu)
    f(props).asInstanceOf[ReactComponentU_]
  }

}


case class MuiMenuItem(payload: js.UndefOr[String] = js.undefined,
                       text: js.UndefOr[String] = js.undefined,
                       id: js.UndefOr[String] = js.undefined,
                       number: js.UndefOr[String] = js.undefined,
                       data: js.UndefOr[String] = js.undefined,
                       iconClassName: js.UndefOr[String] = js.undefined,
                       toggle: js.UndefOr[Boolean] = js.undefined,
                       disabled: js.UndefOr[Boolean] = js.undefined,
                       defaultToggled: js.UndefOr[Boolean] = js.undefined,
                       route: js.UndefOr[String] = js.undefined,
                       `type`: js.UndefOr[MuiMenuItemType] = js.undefined,
                       className: js.UndefOr[String] = js.undefined,
                       selected: js.UndefOr[Boolean] = js.undefined,
                       style: js.UndefOr[js.Any] = js.undefined) {

  val toJS = JSMacro[MuiMenuItem](this)
}

object MuiMenuItem {

  def fromJson(obj: js.Dynamic) =
    MuiMenuItem(
      defaultToggled = if (js.isUndefined(obj.defaultToggled)) js.undefined else obj.defaultToggled.asInstanceOf[Boolean],
      text = if (js.isUndefined(obj.text)) js.undefined else obj.text.asInstanceOf[String],
      data = if (js.isUndefined(obj.data)) js.undefined else obj.text.asInstanceOf[String],
      number = if (js.isUndefined(obj.number)) js.undefined else obj.number.asInstanceOf[String],
      iconClassName = if (js.isUndefined(obj.iconClassName)) js.undefined else obj.iconClassName.asInstanceOf[String],
      route = if (js.isUndefined(obj.route)) js.undefined else obj.route.asInstanceOf[String],
      disabled = if (js.isUndefined(obj.disabled)) js.undefined else obj.disabled.asInstanceOf[Boolean],
      payload = if (js.isUndefined(obj.payload)) js.undefined else obj.payload.asInstanceOf[String],
      toggle = if (js.isUndefined(obj.toggle)) js.undefined else obj.toggle.asInstanceOf[Boolean],
      id = if (js.isUndefined(obj.id)) js.undefined else obj.id.asInstanceOf[String],
      className = if (js.isUndefined(obj.className)) js.undefined else obj.className.asInstanceOf[String],
      style = if (js.isUndefined(obj.style)) js.undefined else obj.style.asInstanceOf[js.Any],
      selected = if (js.isUndefined(obj.selected)) js.undefined else obj.selected.asInstanceOf[Boolean]
    )
}

class MuiMenuItemType private(val value: String) extends AnyVal

object MuiMenuItemType {

  val SUBHEADER = new MuiMenuItemType("SUBHEADER")
  val LINK = new MuiMenuItemType("LINK")
  val NESTED = new MuiMenuItemType("NESTED")

  def newType(name: String) = new MuiMenuItemType(name)

}