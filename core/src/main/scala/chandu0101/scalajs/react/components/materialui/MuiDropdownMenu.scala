package chandu0101.scalajs.react.components
package materialui


import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.{Array => JArray}

case class MuiDropdownMenu(menuItems: JArray[MuiDropdownMenuItem],
                           style: js.UndefOr[js.Any] = js.undefined,
                           onChange: js.UndefOr[(ReactEvent, Int, js.Object) => Unit] = js.undefined,
                           ref: js.UndefOr[String] = js.undefined,
                           menuItemStyle: js.UndefOr[js.Any] = js.undefined,
                           key: js.UndefOr[String] = js.undefined,
                           autoWidth: js.UndefOr[Boolean] = js.undefined,
                           className: js.UndefOr[String] = js.undefined,
                           selectedIndex: js.UndefOr[Int] = js.undefined) {

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

