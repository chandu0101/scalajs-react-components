package chandu0101.scalajs.react.components
package materialui

import japgolly.scalajs.react._
import scala.scalajs.js

case class MuiRadioButtonGroup(name: String,
                               style: U[js.Any] = uNone,
                               onChange: U[(ReactEventI, String) => Callback] = uNone,
                               labelPosition: U[MuiSwitchLabelPosition] = uNone,
                               ref: U[MuiRadioButtonGroupM => Unit] = uNone,
                               key: U[String] = uNone,
                               defaultSelected: U[String] = uNone,
                               valueSelected: U[String] = uNone) {

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiRadioButtonGroup](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.RadioButtonGroup)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}

@js.native
trait MuiRadioButtonGroupM extends js.Object {

  def getSelectedValue(): String = js.native

  def setSelectedValue(value: String): Unit = js.native

  def clearValue(): Unit = js.native

}
