package chandu0101.scalajs.react.components
package materialui

import japgolly.scalajs.react._
import scala.scalajs.js

case class MuiMenu(onToggle: U[(ReactEvent, Int, Boolean) => Callback] = uNone,
                   menuItems: js.Array[MuiMenuItem],
                   visible: U[Boolean] = uNone,
                   style: U[js.Any] = uNone,
                   ref: U[String] = uNone,
                   onItemTap: U[(ReactEvent, Int, js.Object) => Callback] = uNone,
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
