package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.React
import japgolly.scalajs.react.vdom.VdomNode

import scala.scalajs.js

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiCardTitle(
  key:                  js.UndefOr[String]        = js.undefined,
  ref:                  js.UndefOr[String]        = js.undefined,
  /* If true, a click on this card component expands the card. */
  actAsExpander:        js.UndefOr[Boolean]       = js.undefined,
  /* If true, this card component is expandable. */
  expandable:           js.UndefOr[Boolean]       = js.undefined,
  /* If true, this card component will include a button to expand the card. */
  showExpandableButton: js.UndefOr[Boolean]       = js.undefined,
  /* Override the inline-styles of the root element. */
  style:                js.UndefOr[CssProperties] = js.undefined,
  /* Can be used to render a subtitle in the Card Title. */
  subtitle:             js.UndefOr[VdomNode]     = js.undefined,
  /* Override the subtitle color. */
  subtitleColor:        js.UndefOr[MuiColor]      = js.undefined,
  /* Override the inline-styles of the subtitle. */
  subtitleStyle:        js.UndefOr[CssProperties] = js.undefined,
  /* Can be used to render a title in the Card Title. */
  title:                js.UndefOr[VdomNode]     = js.undefined,
  /* Override the title color. */
  titleColor:           js.UndefOr[MuiColor]      = js.undefined,
  /* Override the inline-styles of the title. */
  titleStyle:           js.UndefOr[CssProperties] = js.undefined){

  /**
    * @param children Can be used to render elements inside the Card Title.
   */
  def apply(children: VdomNode*) = {
    
    val props = JSMacro[MuiCardTitle](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Mui.CardTitle)
    component(props)(children: _*)
  }
}
