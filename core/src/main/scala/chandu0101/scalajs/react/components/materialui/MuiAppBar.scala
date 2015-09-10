package chandu0101.scalajs.react.components
package materialui


import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.{UndefOr, undefined}


case class MuiAppBar(iconStyleRight: UndefOr[js.Object] = undefined,
                  ref: UndefOr[String] = undefined,
                  iconClassNameRight: UndefOr[String] = undefined,
                  iconClassNameLeft: UndefOr[String] = undefined,
                  zDepth: UndefOr[Int] = undefined,
                  key: UndefOr[String] = undefined,
                  iconElementLeft: UndefOr[ReactElement] = undefined,
                  showMenuIconButton: UndefOr[Boolean] = undefined,
                  title: UndefOr[String] = undefined,
                  onLeftIconButtonTouchTap: UndefOr[ReactEventH => Unit] = undefined,
                  iconElementRight: UndefOr[ReactElement] = undefined,
                  onRightIconButtonTouchTap: UndefOr[ReactEventH => Unit] = undefined) {

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiAppBar](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.AppBar)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}

