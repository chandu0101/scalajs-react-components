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
case class MuiCardMedia(key: js.UndefOr[String] = js.undefined,
                        ref: js.UndefOr[String] = js.undefined,
                        /* If true, a click on this card component expands the card. */
                        actAsExpander: js.UndefOr[Boolean] = js.undefined,
                        /* If true, this card component is expandable. */
                        expandable: js.UndefOr[Boolean] = js.undefined,
                        /* Override the inline-styles of the Card Media. */
                        mediaStyle: js.UndefOr[CssProperties] = js.undefined,
                        /* Can be used to render overlay element in Card Media. */
                        overlay: js.UndefOr[VdomNode] = js.undefined,
                        /* Override the inline-styles of the overlay container. */
                        overlayContainerStyle: js.UndefOr[CssProperties] = js.undefined,
                        /* Override the inline-styles of the overlay content. */
                        overlayContentStyle: js.UndefOr[CssProperties] = js.undefined,
                        /* Override the inline-styles of the overlay element. */
                        overlayStyle: js.UndefOr[CssProperties] = js.undefined,
                        /* Override the inline-styles of the root element. */
                        style: js.UndefOr[CssProperties] = js.undefined) {

  /**
    * @param children Can be used to render elements inside the Card Media.
    */
  def apply(children: VdomNode*) = {

    val props     = JSMacro[MuiCardMedia](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Mui.CardMedia)
    component(props)(children: _*)
  }
}
