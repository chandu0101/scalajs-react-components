
package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
  
case class MuiGridTile(
	key:             js.UndefOr[String]                      = js.undefined,
	ref:             js.UndefOr[String]                      = js.undefined,
	/*  An IconButton element to be used as secondary action target (primary action target is the tile itself).*/
	actionIcon:      js.UndefOr[ReactElement]                = js.undefined,
	/*  Position of secondary action IconButton. Defaults to "right".*/
	actionPosition:  js.UndefOr[MuiGridTileActionPosition]   = js.undefined,
	/* required: Theoretically you can pass any node as children, but the main use case is to pass an img, in whichcase GridTile takes care of making the image "cover" available space (similar to background-size: cover or to object-fit:cover)*/
	children:        ReactNode,
	/*  Width of the tile in number of grid cells. Defaults to 1.*/
	cols:            js.UndefOr[Int]                         = js.undefined,
	/*  Either a string used as tag name for the tile root element, or a ReactComponent. Defaults to "div".This is useful when you have, for example, a custom implementation of a navigation link (that knowsabout your routes) and you want to use it as primary tile action. In case you pass a ReactComponent, please make sure that it passes all props, accepts styles overrides and render it's children.*/
	rootClass:       js.UndefOr[String | js.Any]             = js.undefined,
	/*  Height of the tile in number of grid cells. Defaults to 1.*/
	rows:            js.UndefOr[Int]                         = js.undefined,
	/*  Override the inline-styles of the grid tile's root element.*/
	style:           js.UndefOr[CssProperties]               = js.undefined,
	/*  String or element serving as subtitle (support text).*/
	subtitle:        js.UndefOr[ReactNode]                   = js.undefined,
	/*  Title to be displayed on tile.*/
	title:           js.UndefOr[ReactNode]                   = js.undefined,
	/*  Style used for title bar background. Defaults to "rgba(0, 0, 0, 0.4)". Useful for setting custom gradients for example*/
	titleBackground: js.UndefOr[String]                      = js.undefined,
	/*  Position of the title bar (container of title, subtitle and action icon). Defaults to "bottom".*/
	titlePosition:   js.UndefOr[MuiGridTileTitlePosition]    = js.undefined)
{

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiGridTile](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.GridTile)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}


class MuiGridTileActionPosition(val value: String) extends AnyVal
object MuiGridTileActionPosition{
	val LEFT = new MuiGridTileActionPosition("left")
	val RIGHT = new MuiGridTileActionPosition("right")
	val values = List(LEFT, RIGHT)
}


class MuiGridTileTitlePosition(val value: String) extends AnyVal
object MuiGridTileTitlePosition{
	val TOP = new MuiGridTileTitlePosition("top")
	val BOTTOM = new MuiGridTileTitlePosition("bottom")
	val values = List(TOP, BOTTOM)
}
