package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiCardActions(
  key:                  js.UndefOr[String]        = js.undefined,
  ref:                  js.UndefOr[String]        = js.undefined,
  /* If true, a click on this card component expands the card.*/
  actAsExpander:        js.UndefOr[Boolean]       = js.undefined,
  /* If true, this card component is expandable.*/
  expandable:           js.UndefOr[Boolean]       = js.undefined,
  /* If true, this card component will include a button to expand the card.*/
  showExpandableButton: js.UndefOr[Boolean]       = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:                js.UndefOr[CssProperties] = js.undefined){
  /**
   * @param children Can be used to render elements inside the Card Action.
   */
  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiCardActions](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.CardActions)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
