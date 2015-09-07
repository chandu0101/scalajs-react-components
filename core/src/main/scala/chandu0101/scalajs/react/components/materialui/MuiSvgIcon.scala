package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import materialui.Mui

import scala.scalajs.js


case class MuiSvgIcon(key: js.UndefOr[String] = js.undefined,
                      style: js.UndefOr[js.Any] = js.undefined,
                      ref: js.UndefOr[String] = js.undefined,
                      viewBox: js.UndefOr[String] = js.undefined) {

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiSvgIcon](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.SvgIcon)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
