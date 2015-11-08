package chandu0101.scalajs.react.components
package materialui

import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.{Array => JArray}



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