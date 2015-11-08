package chandu0101.scalajs.react.components
package materialui

import japgolly.scalajs.react._
import scala.scalajs.js

case class MuiToggle(onToggle: U[(ReactEvent, Boolean) => Callback] = uNone,
                     name: U[String] = uNone,
                     elementStyle: U[js.Any] = uNone,
                     style: U[js.Any] = uNone,
                     defaultToggled: U[Boolean] = uNone,
                     labelPosition: U[MuiSwitchLabelPosition] = uNone,
                     label: U[String] = uNone,
                     ref: U[MuiToggleM => Callback] = uNone,
                     key: U[String] = uNone,
                     disabled: U[Boolean] = uNone,
                     value: U[String] = uNone,
                     toggled: U[Boolean] = uNone) {

  def apply() = {
    val props = JSMacro[MuiToggle](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Toggle)
    f(props).asInstanceOf[ReactComponentU_]
  }

}

@js.native
trait MuiToggleM extends js.Object {

  def isToggled(): Boolean = js.native

  def setToggled(newToggledValue: Boolean): Unit = js.native

}

