package chandu0101.scalajs.react.components
package materialui

import japgolly.scalajs.react._
import scala.scalajs.js

case class MuiLeftNav(menuItems: js.Array[MuiMenuItem],
                      style: U[js.Any] = uNone,
                      onChange: U[(ReactEvent, Int, js.Object) => Callback] = uNone,
                      ref: U[MuiLeftNavM => Unit] = uNone,
                      onNavClose: U[Callback] = uNone,
                      onNavOpen: U[Callback] = uNone,
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

  def open(): Unit = js.native

  def close(): Unit = js.native

  def toggle(): Unit = js.native
}
