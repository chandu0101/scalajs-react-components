package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiFocusRipple(
  key:        js.UndefOr[String]        = js.undefined,
  ref:        js.UndefOr[String]        = js.undefined,
  color:      js.UndefOr[MuiColor]      = js.undefined,
  innerStyle: js.UndefOr[CssProperties] = js.undefined,
  /* The material-ui theme applied to this component.*/
  @deprecated("Internal API")
  muiTheme:   MuiTheme,
  opacity:    js.UndefOr[Double]        = js.undefined,
  show:       js.UndefOr[Boolean]       = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:      js.UndefOr[CssProperties] = js.undefined){

  def apply() = {
    val props = JSMacro[MuiFocusRipple](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.FocusRipple)
    f(props).asInstanceOf[ReactComponentU_]
  }
}
        
