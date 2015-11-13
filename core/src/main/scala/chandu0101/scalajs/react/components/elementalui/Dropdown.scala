package chandu0101.scalajs.react.components
package elementalui

import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.{ Array ⇒ JArray }

case class Dropdown(
    alignRight: U[Boolean] = uNone,
    buttonHasDisclosureArrow: U[Boolean] = uNone,
    buttonLabel: U[String] = uNone,
    buttonType: U[ButtonType] = uNone,
    className: U[String] = uNone,
    isOpen: U[Boolean] = uNone,
    children: U[Boolean] = uNone,
    items: JArray[DropdownMenuItem],
    onSelect: U[ReactEventH ⇒ Callback] = uNone) {

  def apply(children: ReactNode*) = {
    val props = JSMacro[Dropdown](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Eui.Dropdown)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }

}

case class DropdownMenuItemType private (value: String) extends AnyVal

object DropdownMenuItemType {
  val DIVIDER = DropdownMenuItemType("divider")
  val HEADER = DropdownMenuItemType("header")
  val DEFAULT = DropdownMenuItemType("")

  def fromString(str: String): DropdownMenuItemType = str match {
    case "divider" ⇒ DIVIDER
    case "header"  ⇒ HEADER
    case _         ⇒ DEFAULT
  }

}

case class DropdownMenuItem(label: String = "", `type`: DropdownMenuItemType = DropdownMenuItemType.DEFAULT) {
  val toJS = JSMacro[DropdownMenuItem](this)
}

object DropdownMenuItem {
  def fromJson(obj: js.Dynamic) = DropdownMenuItem(label = obj.label.toString, `type` = DropdownMenuItemType.fromString(obj.`type`.toString))
}
