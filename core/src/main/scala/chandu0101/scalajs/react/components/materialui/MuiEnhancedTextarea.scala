package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiEnhancedTextarea(
  key:            js.UndefOr[String]                       = js.undefined,
  ref:            js.UndefOr[EnhancedTextareaM => Unit]    = js.undefined,
  defaultValue:   js.UndefOr[js.Any]                       = js.undefined,
  disabled:       js.UndefOr[Boolean]                      = js.undefined,
  onChange:       js.UndefOr[ReactEventTA => Callback]     = js.undefined,
  onHeightChange: js.UndefOr[(ReactEvent, Int)=> Callback] = js.undefined,
  rows:           js.UndefOr[Int]                          = js.undefined,
  rowsMax:        js.UndefOr[Int]                          = js.undefined,
  shadowStyle:    js.UndefOr[CssProperties]                = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:          js.UndefOr[CssProperties]                = js.undefined,
  textareaStyle:  js.UndefOr[CssProperties]                = js.undefined,
  value:          js.UndefOr[String]                       = js.undefined,
  valueLink:      js.UndefOr[js.Any]                       = js.undefined){

  def apply() = {
    val props = JSMacro[MuiEnhancedTextarea](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.EnhancedTextarea)
    f(props).asInstanceOf[ReactComponentU_]
  }
}
        


@js.native
class EnhancedTextareaM extends js.Object {
  def getInputNode(): js.Any = js.native

  def setValue(value: js.Any): js.Any = js.native

  def syncHeightWithShadow(newValue: js.Any, event: js.Any): js.Any = js.native
}
