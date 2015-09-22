package chandu0101.scalajs.react.components
package materialui

import japgolly.scalajs.react._
import scala.scalajs.js

case class MuiListDivider(key: U[String] = uNone,
                          style: U[js.Any] = uNone,
                          ref: U[String] = uNone,
                          inset: U[Boolean] = uNone) {

  def apply() = {
    val props = JSMacro[MuiListDivider](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.ListDivider)
    f(props).asInstanceOf[ReactComponentU_]
  }

}

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

case class MuiList(subheaderStyle: U[js.Any] = uNone,
                   insetSubheader: U[Boolean] = uNone,
                   style: U[js.Any] = uNone,
                   ref: U[String] = uNone,
                   key: U[String] = uNone,
                   subheader: U[String] = uNone) {
  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiList](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.List)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
