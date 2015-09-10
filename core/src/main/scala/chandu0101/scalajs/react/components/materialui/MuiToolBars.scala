package chandu0101.scalajs.react.components
package materialui

import japgolly.scalajs.react._
import scala.scalajs.js

case class MuiToolbar(key: js.UndefOr[String] = js.undefined,
                      style: js.UndefOr[js.Any] = js.undefined,
                      ref: js.UndefOr[String] = js.undefined,
                      className: js.UndefOr[String] = js.undefined) {


  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiToolbar](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Toolbar)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}


case class MuiToolbarSeparator(key: js.UndefOr[String] = js.undefined,
                               style: js.UndefOr[js.Any] = js.undefined,
                               ref: js.UndefOr[String] = js.undefined) {

  def apply() = {
    val props = JSMacro[MuiToolbarSeparator](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.ToolbarSeparator)
    f(props).asInstanceOf[ReactComponentU_]
  }

}


case class MuiToolbarTitle(key: js.UndefOr[String] = js.undefined,
                           style: js.UndefOr[js.Any] = js.undefined,
                           ref: js.UndefOr[String] = js.undefined,
                           text: js.UndefOr[String] = js.undefined) {

  def apply() = {
    val props = JSMacro[MuiToolbarTitle](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.ToolbarTitle)
    f(props).asInstanceOf[ReactComponentU_]
  }

}

case class MuiToolbarGroup(float: js.UndefOr[String] = js.undefined,
                           style: js.UndefOr[js.Any] = js.undefined,
                           ref: js.UndefOr[String] = js.undefined,
                           key: js.UndefOr[String] = js.undefined,
                           className: js.UndefOr[String] = js.undefined) {

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiToolbarGroup](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.ToolbarGroup)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}

