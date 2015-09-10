package chandu0101.scalajs.react.components
package materialui

import japgolly.scalajs.react._
import scala.scalajs.js

case class MuiAvatar(backgroundColor: js.UndefOr[String] = js.undefined,
            style: js.UndefOr[js.Any] = js.undefined,
            icon: js.UndefOr[ReactElement] = js.undefined,
            ref: js.UndefOr[String] = js.undefined,
            color: js.UndefOr[String] = js.undefined,
            key: js.UndefOr[String] = js.undefined,
            src: js.UndefOr[String] = js.undefined) {

  def apply() = {
   val props = JSMacro[MuiAvatar](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Avatar)
    f(props).asInstanceOf[ReactComponentU_]
  }

}
