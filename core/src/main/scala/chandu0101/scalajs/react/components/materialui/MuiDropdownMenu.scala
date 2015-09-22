package chandu0101.scalajs.react.components
package materialui

import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.{Array => JArray}

case class MuiDropdownMenu(menuItems: JArray[MuiDropdownMenuItem],
                           style: U[js.Any] = uNone,
                           onChange: U[(ReactEvent, Int, js.Object) => Callback] = uNone,
                           ref: U[String] = uNone,
                           menuItemStyle: U[js.Any] = uNone,
                           key: U[String] = uNone,
                           autoWidth: U[Boolean] = uNone,
                           className: U[String] = uNone,
                           selectedIndex: U[Int] = uNone) {

  def apply() = {
    val props = JSMacro[MuiDropdownMenu](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.DropDownMenu)
    f(props).asInstanceOf[ReactComponentU_]
  }

}

case class MuiDropdownMenuItem(payload: String, text: String) {
  val toJS = JSMacro[MuiDropdownMenuItem](this)
}

object MuiDropdownMenuItem {

  def fromJson(obj: js.Dynamic) = MuiDropdownMenuItem(text = obj.text.toString, payload = obj.payload.toString)
}

