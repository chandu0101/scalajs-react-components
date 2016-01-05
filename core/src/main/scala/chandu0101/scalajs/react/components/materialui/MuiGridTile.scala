package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiGridTile(
  key:             js.UndefOr[String]          = js.undefined,
  ref:             js.UndefOr[String]          = js.undefined,
  /* An IconButton element to be used as secondary action target
(primary action target is the tile itself).*/
  actionIcon:      js.UndefOr[ReactElement]    = js.undefined,
  /* Position of secondary action IconButton.*/
  actionPosition:  js.UndefOr[LeftRight]       = js.undefined,
  /* Width of the tile in number of grid cells.*/
  cols:            js.UndefOr[Int]             = js.undefined,
  /* Either a string used as tag name for the tile root element, or a ReactComponent.
This is useful when you have, for example, a custom implementation of
a navigation link (that knowsabout your routes) and you want to use it as primary tile action.
In case you pass a ReactComponent, please make sure that it passes all props,
accepts styles overrides and render it's children.*/
  rootClass:       js.UndefOr[String | js.Any] = js.undefined,
  /* Height of the tile in number of grid cells.*/
  rows:            js.UndefOr[Int]             = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:           js.UndefOr[CssProperties]   = js.undefined,
  /* String or element serving as subtitle (support text).*/
  subtitle:        js.UndefOr[ReactNode]       = js.undefined,
  /* Title to be displayed on tile.*/
  title:           js.UndefOr[ReactNode]       = js.undefined,
  /* Style used for title bar background.
Useful for setting custom gradients for example*/
  titleBackground: js.UndefOr[String]          = js.undefined,
  /* Position of the title bar (container of title, subtitle and action icon).*/
  titlePosition:   js.UndefOr[TopBottom]       = js.undefined){
  /**
   * @param children Theoretically you can pass any node as children, but the main use case is to pass an img,
in whichcase GridTile takes care of making the image "cover" available space
(similar to background-size: cover or to object-fit:cover).
   */
  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiGridTile](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.GridTile)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
