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
    
case class MuiCardExpandable(
  key:         js.UndefOr[String]        = js.undefined,
  ref:         js.UndefOr[String]        = js.undefined,
  closeIcon:   js.UndefOr[ReactNode]     = js.undefined,
  expanded:    js.UndefOr[Boolean]       = js.undefined,
  onExpanding: Callback,
  openIcon:    js.UndefOr[ReactNode]     = js.undefined,
  style:       js.UndefOr[CssProperties] = js.undefined){

  def apply() = {
    
    val props = JSMacro[MuiCardExpandable](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.CardExpandable)
    f(props).asInstanceOf[ReactComponentU_]
  }
}
        
