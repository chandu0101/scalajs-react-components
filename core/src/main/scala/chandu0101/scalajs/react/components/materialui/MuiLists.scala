package chandu0101.scalajs.react.components
package materialui

import japgolly.scalajs.react._
import scala.scalajs.js


case class MuiListDivider(key: js.UndefOr[String] = js.undefined,
                          style: js.UndefOr[js.Any] = js.undefined,
                          ref: js.UndefOr[String] = js.undefined,
                          inset: js.UndefOr[Boolean] = js.undefined) {

  def apply() = {
    val props = JSMacro[MuiListDivider](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.ListDivider)
    f(props).asInstanceOf[ReactComponentU_]
  }

}

case class MuiListItem(secondaryText: js.UndefOr[ReactElement] = js.undefined,
                       style: js.UndefOr[js.Any] = js.undefined,
                       disableTouchTap: js.UndefOr[Boolean] = js.undefined,
                       insetChildren: js.UndefOr[Boolean] = js.undefined,
                       ref: js.UndefOr[String] = js.undefined,
                       rightAvatar: js.UndefOr[ReactElement] = js.undefined,
                       leftAvatar: js.UndefOr[ReactElement] = js.undefined,
                       key: js.UndefOr[String] = js.undefined,
                       onMouseOver: js.UndefOr[ReactEvent => Unit] = js.undefined,
                       onMouseOut: js.UndefOr[ReactEvent => Unit] = js.undefined,
                       secondaryTextLines: js.UndefOr[Int] = js.undefined,
                       leftIcon: js.UndefOr[ReactElement] = js.undefined,
                       rightIcon: js.UndefOr[ReactElement] = js.undefined,
                       rightToggle: js.UndefOr[ReactElement] = js.undefined,
                       leftCheckbox: js.UndefOr[ReactElement] = js.undefined) {

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiListItem](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.ListItem)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}

case class MuiList(subheaderStyle: js.UndefOr[js.Any] = js.undefined,
                   insetSubheader: js.UndefOr[Boolean] = js.undefined,
                   style: js.UndefOr[js.Any] = js.undefined,
                   ref: js.UndefOr[String] = js.undefined,
                   key: js.UndefOr[String] = js.undefined,
                   subheader: js.UndefOr[String] = js.undefined) {
  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiList](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.List)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
