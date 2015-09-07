package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import materialui.Mui

import scala.scalajs.js


case class MuiFontIcon(style: js.UndefOr[js.Any] = js.undefined,
                       ref: js.UndefOr[String] = js.undefined,
                       key: js.UndefOr[String] = js.undefined,
                       className: js.UndefOr[String] = js.undefined,
                       hoverColor: js.UndefOr[String] = js.undefined) {

  def apply() = {
    val props = JSMacro[MuiFontIcon](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.FontIcon)
    f(props).asInstanceOf[ReactComponentU_]
  }

}
