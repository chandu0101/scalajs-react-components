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
    
case class MuiToolbar(
  key:       js.UndefOr[String]        = js.undefined,
  ref:       js.UndefOr[String]        = js.undefined,
  /* The css class name of the root element. */
  className: js.UndefOr[String]        = js.undefined,
  /* Do not apply `desktopGutter` to the `Toolbar`. */
  noGutter:  js.UndefOr[Boolean]       = js.undefined,
  /* Override the inline-styles of the root element. */
  style:     js.UndefOr[CssProperties] = js.undefined){

  /**
    * @param children Can be a `ToolbarGroup` to render a group of related items.
   */
  def apply(children: ReactNode*) = {
    
    val props = JSMacro[MuiToolbar](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Toolbar)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
