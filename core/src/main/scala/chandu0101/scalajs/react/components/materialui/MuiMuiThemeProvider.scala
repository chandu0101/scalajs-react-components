package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.React
import japgolly.scalajs.react.vdom.html_<^._
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


  def apply(children: VdomElement*) = {
    
    val props = JSMacro[MuiMuiThemeProvider](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Mui.MuiThemeProvider)
    component(props)(children: _*)
  }
}


@js.native
class MuiMuiThemeProviderM extends js.Object {
  def getChildContext(): js.Dynamic = js.native
}
