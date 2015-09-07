package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import materialui.Mui

import scala.scalajs.js


case class MuiIconButton(iconClassName: js.UndefOr[String] = js.undefined,
                         onBlur: js.UndefOr[ReactEvent => Unit] = js.undefined,
                         touch: js.UndefOr[Boolean] = js.undefined,
                         style: js.UndefOr[js.Any] = js.undefined,
                         iconStyle: js.UndefOr[js.Any] = js.undefined,
                         ref: js.UndefOr[String] = js.undefined,
                         key: js.UndefOr[String] = js.undefined,
                         className: js.UndefOr[String] = js.undefined,
                         onFocus: js.UndefOr[ReactEvent => Unit] = js.undefined,
                         disabled: js.UndefOr[Boolean] = js.undefined,
                         tooltip: js.UndefOr[String] = js.undefined) {


  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiIconButton](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.IconButton)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
