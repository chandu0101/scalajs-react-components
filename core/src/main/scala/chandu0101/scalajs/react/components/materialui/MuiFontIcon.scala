package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiFontIcon(
  key:          js.UndefOr[String]                       = js.undefined,
  ref:          js.UndefOr[String]                       = js.undefined,
  /* This is the fill color of the svg icon. If not specified, this component will default to muiTheme.palette.textColor.*/
  color:        js.UndefOr[MuiColor]                     = js.undefined,
  /* This is the icon color when the mouse hovers over the icon.*/
  hoverColor:   js.UndefOr[MuiColor]                     = js.undefined,
  onMouseEnter: js.UndefOr[ReactMouseEventH => Callback] = js.undefined,
  onMouseLeave: js.UndefOr[ReactMouseEventH => Callback] = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:        js.UndefOr[CssProperties]                = js.undefined){

  def apply() = {
    val props = JSMacro[MuiFontIcon](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.FontIcon)
    f(props).asInstanceOf[ReactComponentU_]
  }
}
        
