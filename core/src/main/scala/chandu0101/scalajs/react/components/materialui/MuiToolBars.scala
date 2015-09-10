package chandu0101.scalajs.react.components
package materialui

import japgolly.scalajs.react._
import scala.scalajs.js

case class MuiToolbar(key: U[String] = uNone,
                      style: U[js.Any] = uNone,
                      ref: U[String] = uNone,
                      className: U[String] = uNone) {

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiToolbar](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Toolbar)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}

case class MuiToolbarSeparator(key: U[String] = uNone,
                               style: U[js.Any] = uNone,
                               ref: U[String] = uNone) {

  def apply() = {
    val props = JSMacro[MuiToolbarSeparator](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.ToolbarSeparator)
    f(props).asInstanceOf[ReactComponentU_]
  }

}

case class MuiToolbarTitle(key: U[String] = uNone,
                           style: U[js.Any] = uNone,
                           ref: U[String] = uNone,
                           text: U[String] = uNone) {

  def apply() = {
    val props = JSMacro[MuiToolbarTitle](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.ToolbarTitle)
    f(props).asInstanceOf[ReactComponentU_]
  }

}

case class MuiToolbarGroup(float: U[String] = uNone,
                           style: U[js.Any] = uNone,
                           ref: U[String] = uNone,
                           key: U[String] = uNone,
                           className: U[String] = uNone) {

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiToolbarGroup](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.ToolbarGroup)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}

