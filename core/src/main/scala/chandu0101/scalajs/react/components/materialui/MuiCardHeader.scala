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
    
case class MuiCardHeader(
  key:                  js.UndefOr[String]        = js.undefined,
  ref:                  js.UndefOr[String]        = js.undefined,
  /* If true, a click on this card component expands the card. */
  actAsExpander:        js.UndefOr[Boolean]       = js.undefined,
  /* This is the [Avatar](/#/components/avatar) element to be displayed on the Card Header.
     If `avatar` is an `Avatar` or other element, it will be rendered.
     If `avatar` is a string, it will be used as the image `src` for an `Avatar`. */
  avatar:               js.UndefOr[VdomNode]     = js.undefined,
  /* Can be used to pass a closeIcon if you don't like the default expandable close Icon. */
  closeIcon:            js.UndefOr[VdomNode]     = js.undefined,
  /* If true, this card component is expandable. */
  expandable:           js.UndefOr[Boolean]       = js.undefined,
  /* Can be used to pass a openIcon if you don't like the default expandable open Icon. */
  openIcon:             js.UndefOr[VdomNode]     = js.undefined,
  /* If true, this card component will include a button to expand the card. */
  showExpandableButton: js.UndefOr[Boolean]       = js.undefined,
  /* Override the inline-styles of the root element. */
  style:                js.UndefOr[CssProperties] = js.undefined,
  /* Can be used to render a subtitle in Card Header. */
  subtitle:             js.UndefOr[VdomNode]     = js.undefined,
  /* Override the subtitle color. */
  subtitleColor:        js.UndefOr[MuiColor]      = js.undefined,
  /* Override the inline-styles of the subtitle. */
  subtitleStyle:        js.UndefOr[CssProperties] = js.undefined,
  /* Override the inline-styles of the text. */
  textStyle:            js.UndefOr[CssProperties] = js.undefined,
  /* Can be used to render a title in Card Header. */
  title:                js.UndefOr[VdomNode]     = js.undefined,
  /* Override the title color. */
  titleColor:           js.UndefOr[MuiColor]      = js.undefined,
  /* Override the inline-styles of the title. */
  titleStyle:           js.UndefOr[CssProperties] = js.undefined){

  /**
    * @param children Can be used to render elements inside the Card Header.
   */
  def apply(children: VdomNode*) = {
    
    val props = JSMacro[MuiCardHeader](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Mui.CardHeader)
    component(props)(children: _*)
  }
}
