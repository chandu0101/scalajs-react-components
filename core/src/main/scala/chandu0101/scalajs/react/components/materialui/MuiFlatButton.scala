package chandu0101.scalajs.react.components
package materialui

import japgolly.scalajs.react._
import scala.scalajs.js

case class MuiFlatButton(onBlur: U[ReactEventH => Callback] = uNone,
                         labelStyle: U[js.Any] = uNone,
                         onTouchStart: U[ReactEventH => Callback] = uNone,
                         rippleColor: U[String] = uNone,
                         style: U[js.Any] = uNone,
                         label: U[String] = uNone,
                         ref: U[String] = uNone,
                         secondary: U[Boolean] = uNone,
                         onMouseUp: U[ReactEventH => Callback] = uNone,
                         onTouchEnd: U[ReactEventH => Callback] = uNone,
                         key: U[String] = uNone,
                         onMouseOver: U[ReactEventH => Callback] = uNone,
                         linkButton: U[Boolean] = uNone,
                         onTouchTap: U[ReactEventH => Callback] = uNone,
                         className: U[String] = uNone,
                         onMouseOut: U[ReactEventH => Callback] = uNone,
                         hoverColor: U[String] = uNone,
                         onFocus: U[ReactEventH => Callback] = uNone,
                         disabled: U[Boolean] = uNone,
                         href: U[String] = uNone,
                         primary: U[Boolean] = uNone,
                         onMouseDown: U[ReactEventH => Callback] = uNone) {

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiFlatButton](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.FlatButton)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}

