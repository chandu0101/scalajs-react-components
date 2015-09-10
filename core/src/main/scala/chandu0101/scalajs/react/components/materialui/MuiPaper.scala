package chandu0101.scalajs.react.components
package materialui

import japgolly.scalajs.react._
import scala.scalajs.js

case class MuiPaper(circle: js.UndefOr[Boolean] = js.undefined,
                    style: js.UndefOr[js.Any] = js.undefined,
                    rounded: js.UndefOr[Boolean] = js.undefined,
                    ref: js.UndefOr[String] = js.undefined,
                    transitionEnabled: js.UndefOr[Boolean] = js.undefined,
                    zDepth: js.UndefOr[Int] = js.undefined,
                    key: js.UndefOr[String] = js.undefined) {

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiPaper](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Paper)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
