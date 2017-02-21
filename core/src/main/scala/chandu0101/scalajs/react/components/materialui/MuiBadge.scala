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
    
case class MuiBadge(
  key:          js.UndefOr[String]        = js.undefined,
  ref:          js.UndefOr[String]        = js.undefined,
  /* This is the content rendered within the badge. */
  badgeContent: ReactNode,
  /* Override the inline-styles of the badge element. */
  badgeStyle:   js.UndefOr[CssProperties] = js.undefined,
  /* The css class name of the root element. */
  className:    js.UndefOr[String]        = js.undefined,
  /* If true, the badge will use the primary badge colors. */
  primary:      js.UndefOr[Boolean]       = js.undefined,
  /* If true, the badge will use the secondary badge colors. */
  secondary:    js.UndefOr[Boolean]       = js.undefined,
  /* Override the inline-styles of the root element. */
  style:        js.UndefOr[CssProperties] = js.undefined){

  /**
    * @param children The badge will be added relativelty to this node.
   */
  def apply(children: ReactNode*) = {
    
    val props = JSMacro[MuiBadge](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Badge)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
