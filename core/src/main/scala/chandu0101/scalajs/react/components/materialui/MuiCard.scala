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
    
case class MuiCard(
  key:                  js.UndefOr[String]              = js.undefined,
  ref:                  js.UndefOr[String]              = js.undefined,
  /* Override the inline-styles of the container element. */
  containerStyle:       js.UndefOr[CssProperties]       = js.undefined,
  /* If true, this card component is expandable. Can be set on any child of the `Card` component. */
  expandable:           js.UndefOr[Boolean]             = js.undefined,
  /* Whether this card is expanded.
     If `true` or `false` the component is controlled.
     if `null` the component is uncontrolled. */
  expanded:             js.UndefOr[Boolean]             = js.undefined,
  /* Whether this card is initially expanded. */
  initiallyExpanded:    js.UndefOr[Boolean]             = js.undefined,
  /* Callback function fired when the `expandable` state of the card has changed.
     @param {boolean} newExpandedState Represents the new `expanded` state of the card. */
  onExpandChange:       js.UndefOr[Boolean => Callback] = js.undefined,
  /* If true, this card component will include a button to expand the card. `CardTitle`,
     `CardHeader` and `CardActions` implement `showExpandableButton`. Any child component
     of `Card` can implements `showExpandableButton` or forwards the property to a child
     component supporting it. */
  showExpandableButton: js.UndefOr[Boolean]             = js.undefined,
  /* Override the inline-styles of the root element. */
  style:                js.UndefOr[CssProperties]       = js.undefined,
  /* Set to true to generate a circlular paper container.
     (Passed on to Paper) */
  circle:               js.UndefOr[Boolean]             = js.undefined,
  /* By default, the paper container will have a border radius.
     Set this to false to generate a container with sharp corners.
     (Passed on to Paper) */
  rounded:              js.UndefOr[Boolean]             = js.undefined,
  /* Set to false to disable CSS transitions for the paper element.
     (Passed on to Paper) */
  transitionEnabled:    js.UndefOr[Boolean]             = js.undefined,
  /* This number represents the zDepth of the paper shadow.
     (Passed on to Paper) */
  zDepth:               js.UndefOr[ZDepth]              = js.undefined){

  /**
    * @param children Can be used to render elements inside the Card.
   */
  def apply(children: VdomNode*) = {
    
    val props = JSMacro[MuiCard](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Mui.Card)
    component(props)(children: _*)
  }
}
