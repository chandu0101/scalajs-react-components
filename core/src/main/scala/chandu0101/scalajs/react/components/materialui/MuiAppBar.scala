package chandu0101.scalajs.react.components
package materialui

import japgolly.scalajs.react._
import scala.scalajs.js

case class MuiAppBar(iconStyleRight: U[js.Object] = uNone,
                  ref: U[String] = uNone,
                  iconClassNameRight: U[String] = uNone,
                  iconClassNameLeft: U[String] = uNone,
                  zDepth: U[Int] = uNone,
                  key: U[String] = uNone,
                  iconElementLeft: U[ReactElement] = uNone,
                  showMenuIconButton: U[Boolean] = uNone,
                  title: U[String] = uNone,
                  onLeftIconButtonTouchTap: U[ReactEventH => Callback] = uNone,
                  iconElementRight: U[ReactElement] = uNone,
                  onRightIconButtonTouchTap: U[ReactEventH => Callback] = uNone) {

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiAppBar](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.AppBar)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}

