package chandu0101.scalajs.react.components
package materialui
import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
/**
 * This file is generated - submit issues instead of PR against it
 */
case class MuiGridList(
  key:        js.UndefOr[String]          = js.undefined,
  ref:        js.UndefOr[String]          = js.undefined,
  /* Number of px for one cell height.
  You can set `'auto'` if you want to let the children determine the height.*/
  cellHeight: js.UndefOr[Int | js.Any] = js.undefined,
  /* Number of columns.*/
  cols:       js.UndefOr[Int]             = js.undefined,
  /* Number of px for the padding/spacing between items.*/
  padding:    js.UndefOr[Int]             = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:      js.UndefOr[CssProperties]   = js.undefined){
  /**
   * @param children Grid Tiles that will be in Grid List.
   */
  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiGridList](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.GridList)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
