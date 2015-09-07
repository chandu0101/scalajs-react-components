package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import materialui.Mui

import scala.scalajs.js
import scala.scalajs.js.{UndefOr, undefined}

case class MuiTab(style: UndefOr[js.Any] = undefined,
                  label: UndefOr[String] = undefined,
                  onActive: UndefOr[ReactElement => Unit] = undefined,
                  ref: UndefOr[String] = undefined,
                  key: UndefOr[String] = undefined,
                  route: UndefOr[String] = undefined) {

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiTab](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Tab)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
