package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import org.scalajs.dom
import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiMuiThemeProvider(
  key:      js.UndefOr[String]                       = js.undefined,
  ref:      js.UndefOr[MuiMuiThemeProviderM => Unit] = js.undefined,
  muiTheme: js.UndefOr[MuiTheme]                     = js.undefined){


  def apply(children: ReactElement*) = {
    
    val props = JSMacro[MuiMuiThemeProvider](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.MuiThemeProvider)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}


@js.native
class MuiMuiThemeProviderM extends js.Object {
  def getChildContext(): js.Dynamic = js.native
}
