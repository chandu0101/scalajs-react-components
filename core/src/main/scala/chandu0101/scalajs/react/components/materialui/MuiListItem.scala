package chandu0101.scalajs.react.components
package materialui

import japgolly.scalajs.react._
import scala.scalajs.js


case class MuiListItem(secondaryText: U[ReactElement] = uNone,
                       style: U[js.Any] = uNone,
                       disableTouchTap: U[Boolean] = uNone,
                       insetChildren: U[Boolean] = uNone,
                       ref: U[String] = uNone,
                       rightAvatar: U[ReactElement] = uNone,
                       leftAvatar: U[ReactElement] = uNone,
                       key: U[String] = uNone,
                       onMouseOver: U[ReactEvent => Callback] = uNone,
                       onMouseOut: U[ReactEvent => Callback] = uNone,
                       secondaryTextLines: U[Int] = uNone,
                       leftIcon: U[ReactElement] = uNone,
                       rightIcon: U[ReactElement] = uNone,
                       rightToggle: U[ReactElement] = uNone,
                       leftCheckbox: U[ReactElement] = uNone) {

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiListItem](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.ListItem)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}