package chandu0101.scalajs.react.components
package materialui

import japgolly.scalajs.react._
import scala.scalajs.js

case class MuiRaisedButton(onBlur: U[ReactEventH => Unit] = uNone,
                           labelStyle: U[js.Any] = uNone,
                           onTouchStart: U[ReactEventH => Unit] = uNone,
                           rippleColor: U[String] = uNone,
                           style: U[js.Any] = uNone,
                           label: U[String] = uNone,
                           ref: U[String] = uNone,
                           secondary: U[Boolean] = uNone,
                           onMouseUp: U[ReactEventH => Unit] = uNone,
                           onTouchEnd: U[ReactEventH => Unit] = uNone,
                           key: U[String] = uNone,
                           onMouseOver: U[ReactEventH => Unit] = uNone,
                           linkButton: U[Boolean] = uNone,
                           onTouchTap: U[ReactEventH => Unit] = uNone,
                           className: U[String] = uNone,
                           onMouseOut: U[ReactEventH => Unit] = uNone,
                           hoverColor: U[String] = uNone,
                           onFocus: U[ReactEventH => Unit] = uNone,
                           disabled: U[Boolean] = uNone,
                           href: U[String] = uNone,
                           primary: U[Boolean] = uNone,
                           onMouseDown: U[ReactEventH => Unit] = uNone) {

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiRaisedButton](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.RaisedButton)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
