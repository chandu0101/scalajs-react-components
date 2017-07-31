package chandu0101.scalajs.react.components
package elementalui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

case class Dropdown(alignRight: js.UndefOr[Boolean] = js.undefined,
                    buttonHasDisclosureArrow: js.UndefOr[Boolean] = js.undefined,
                    buttonLabel: js.UndefOr[String] = js.undefined,
                    buttonType: js.UndefOr[ButtonType] = js.undefined,
                    className: js.UndefOr[String] = js.undefined,
                    isOpen: js.UndefOr[Boolean] = js.undefined,
                    children: js.UndefOr[Boolean] = js.undefined,
                    items: js.Array[DropdownMenuItem],
                    onSelect: js.UndefOr[ReactEventH => Callback] = js.undefined) {

  def apply(children: ReactNode*) = {
    val props = JSMacro[Dropdown](this)
    val f     = React.asInstanceOf[js.Dynamic].createFactory(Eui.Dropdown)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }

}

case class DropdownMenuItemType private (value: String) extends AnyVal

object DropdownMenuItemType {
  val DIVIDER = DropdownMenuItemType("divider")
  val HEADER  = DropdownMenuItemType("header")
  val DEFAULT = DropdownMenuItemType("")

  def fromString(str: String): DropdownMenuItemType = str match {
    case "divider" => DIVIDER
    case "header"  => HEADER
    case _         => DEFAULT
  }

}

case class DropdownMenuItem(label: String = "",
                            `type`: DropdownMenuItemType = DropdownMenuItemType.DEFAULT) {
  val toJS = JSMacro[DropdownMenuItem](this)
}

object DropdownMenuItem {
  def fromJson(obj: js.Dynamic) =
    DropdownMenuItem(label = obj.label.toString,
                     `type` = DropdownMenuItemType.fromString(obj.`type`.toString))
}
