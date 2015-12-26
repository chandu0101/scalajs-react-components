package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiCircleRipple(
  key:     js.UndefOr[String]        = js.undefined,
  ref:     js.UndefOr[String]        = js.undefined,
  color:   js.UndefOr[MuiColor]      = js.undefined,
  opacity: js.UndefOr[Double]        = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:   js.UndefOr[CssProperties] = js.undefined){

  def apply() = {
    val props = JSMacro[MuiCircleRipple](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.CircleRipple)
    f(props).asInstanceOf[ReactComponentU_]
  }
}
        
