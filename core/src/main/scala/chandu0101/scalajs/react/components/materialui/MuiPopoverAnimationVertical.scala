package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.React
import japgolly.scalajs.react.vdom.VdomNode
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiPopoverAnimationVertical(
  key:          js.UndefOr[String]        = js.undefined,
  ref:          js.UndefOr[String]        = js.undefined,
  className:    js.UndefOr[String]        = js.undefined,
  open:         Boolean,
  /* Override the inline-styles of the root element. */
  style:        js.UndefOr[CssProperties] = js.undefined,
  targetOrigin: Origin,
  zDepth:       js.UndefOr[ZDepth]        = js.undefined){


  def apply(children: VdomNode*) = {
    
    val props = JSMacro[MuiPopoverAnimationVertical](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Mui.PopoverAnimationVertical)
    component(props)(children: _*)
  }
}
