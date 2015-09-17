package chandu0101.scalajs.react.components
package materialui

import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.{Array => JArray}

case class MuiLeftNav(menuItems: JArray[MuiMenuItem],
                      style: U[js.Any] = uNone,
                      onChange: U[(ReactEvent, Int, js.Object) => Unit] = uNone,
                      ref: U[String] = uNone,
                      onNavClose: U[() => Unit] = uNone,
                      onNavOpen: U[() => Unit] = uNone,
                      key: U[String] = uNone,
                      className: U[String] = uNone,
                      docked: U[Boolean] = uNone,
                      header: U[ReactElement] = uNone,
                      selectedIndex: U[Int] = uNone,
                      openRight: U[Boolean] = uNone) {

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

case class MuiMenu(onToggle: U[(ReactEvent, Int, Boolean) => Unit] = uNone,
                   menuItems: JArray[MuiMenuItem],
                   visible: U[Boolean] = uNone,
                   style: U[js.Any] = uNone,
                   ref: U[String] = uNone,
                   onItemTap: U[(ReactEvent, Int, js.Object) => Unit] = uNone,
                   menuItemStyleLink: U[js.Any] = uNone,
                   zDepth: U[Int] = uNone,
                   menuItemStyle: U[js.Any] = uNone,
                   key: U[String] = uNone,
                   autoWidth: U[Boolean] = uNone,
                   menuItemClassNameSubheader: U[String] = uNone,
                   menuItemStyleSubheader: U[js.Any] = uNone,
                   hideable: U[Boolean] = uNone,
                   menuItemClassNameLink: U[String] = uNone,
                   menuItemClassName: U[String] = uNone,
                   selectedIndex: U[Int] = uNone) {

  def apply() = {
    val props = JSMacro[MuiMenu](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Menu)
    f(props).asInstanceOf[ReactComponentU_]
  }

}

case class MuiMenuItem(payload: U[String] = uNone,
                       text: U[String] = uNone,
                       id: U[String] = uNone,
                       number: U[String] = uNone,
                       data: U[String] = uNone,
                       iconClassName: U[String] = uNone,
                       toggle: U[Boolean] = uNone,
                       disabled: U[Boolean] = uNone,
                       defaultToggled: U[Boolean] = uNone,
                       route: U[String] = uNone,
                       `type`: U[MuiMenuItemType] = uNone,
                       className: U[String] = uNone,
                       selected: U[Boolean] = uNone,
                       style: U[js.Any] = uNone) {

  val toJS = JSMacro[MuiMenuItem](this)
}

object MuiMenuItem {

  def fromJson(obj: js.Dynamic) =
    MuiMenuItem(
      defaultToggled = if (js.isUndefined(obj.defaultToggled)) uNone else obj.defaultToggled.asInstanceOf[Boolean],
      text = if (js.isUndefined(obj.text)) uNone else obj.text.asInstanceOf[String],
      data = if (js.isUndefined(obj.data)) uNone else obj.text.asInstanceOf[String],
      number = if (js.isUndefined(obj.number)) uNone else obj.number.asInstanceOf[String],
      iconClassName = if (js.isUndefined(obj.iconClassName)) uNone else obj.iconClassName.asInstanceOf[String],
      route = if (js.isUndefined(obj.route)) uNone else obj.route.asInstanceOf[String],
      disabled = if (js.isUndefined(obj.disabled)) uNone else obj.disabled.asInstanceOf[Boolean],
      payload = if (js.isUndefined(obj.payload)) uNone else obj.payload.asInstanceOf[String],
      toggle = if (js.isUndefined(obj.toggle)) uNone else obj.toggle.asInstanceOf[Boolean],
      id = if (js.isUndefined(obj.id)) uNone else obj.id.asInstanceOf[String],
      className = if (js.isUndefined(obj.className)) uNone else obj.className.asInstanceOf[String],
      style = if (js.isUndefined(obj.style)) uNone else obj.style.asInstanceOf[js.Any],
      selected = if (js.isUndefined(obj.selected)) uNone else obj.selected.asInstanceOf[Boolean]
    )
}

class MuiMenuItemType private(val value: String) extends AnyVal

object MuiMenuItemType {

  val SUBHEADER = new MuiMenuItemType("SUBHEADER")
  val LINK = new MuiMenuItemType("LINK")
  val NESTED = new MuiMenuItemType("NESTED")

  def newType(name: String) = new MuiMenuItemType(name)

}