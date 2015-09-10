package chandu0101.scalajs.react.components
package materialui

import japgolly.scalajs.react._
import scala.scalajs.js

case class MuiAvatar(backgroundColor: U[String] = uNone,
            style: U[js.Any] = uNone,
            icon: U[ReactElement] = uNone,
            ref: U[String] = uNone,
            color: U[String] = uNone,
            key: U[String] = uNone,
            src: U[String] = uNone) {

  def apply() = {
   val props = JSMacro[MuiAvatar](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Avatar)
    f(props).asInstanceOf[ReactComponentU_]
  }

}
