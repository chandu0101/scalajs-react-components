package chandu0101.scalajs.react.components
package materialui

import japgolly.scalajs.react._
import scala.scalajs.js

case class MuiIconButton(iconClassName: U[String] = uNone,
                         onBlur: U[ReactEvent => Callback] = uNone,
                         touch: U[Boolean] = uNone,
                         style: U[js.Any] = uNone,
                         iconStyle: U[js.Any] = uNone,
                         ref: U[String] = uNone,
                         key: U[String] = uNone,
                         className: U[String] = uNone,
                         onFocus: U[ReactEvent => Callback] = uNone,
                         disabled: U[Boolean] = uNone,
                         tooltip: U[String] = uNone) {

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiIconButton](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.IconButton)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
