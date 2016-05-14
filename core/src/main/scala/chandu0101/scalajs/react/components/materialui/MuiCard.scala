package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiCard(
  key:                  js.UndefOr[String]              = js.undefined,
  ref:                  js.UndefOr[String]              = js.undefined,
  /* If true, a click on this card component expands the card. Can be set on any child of the `Card` component.*/
  actAsExpander:        js.UndefOr[Boolean]             = js.undefined,
  /* Override the inline-styles of the container element.*/
  containerStyle:       js.UndefOr[CssProperties]       = js.undefined,
  /* If true, this card component is expandable. Can be set on any child of the `Card` component.*/
  expandable:           js.UndefOr[Boolean]             = js.undefined,
  /* Whether this card is expanded.
  If `true` or `false` the component is controlled.
  if `null` the component is uncontrolled.*/
  expanded:             js.UndefOr[Boolean]             = js.undefined,
  /* Whether this card is initially expanded.*/
  initiallyExpanded:    js.UndefOr[Boolean]             = js.undefined,
  /* Callback function fired when the `expandable` state of the card has changed.*/
  onExpandChange:       js.UndefOr[Boolean => Callback] = js.undefined,
  /* If true, this card component will include a button to expand the card. `CardTitle`,
  `CardHeader` and `CardActions` implement `showExpandableButton`. Any child component
  of `Card` can implements `showExpandableButton` or forwards the property to a child
  component supporting it.*/
  showExpandableButton: js.UndefOr[Boolean]             = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:                js.UndefOr[CssProperties]       = js.undefined){
  /**
   * @param children Can be used to render elements inside the Card.
   */
  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiCard](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Card)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
