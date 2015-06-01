package chandu0101.scalajs.react.components.materialui


import chandu0101.scalajs.react.components.all._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js



/**
 * Created by chandrasekharkode .
 */
object MuiInkBar {

  val component = ReactComponentB[Props]("MuiInkBar")
    .render((P) => {
   <.div(^.cls := "mui-ink-bar", ^.width := P.width, ^.height := P.height)("&nbsp")
  })
    .build

  case class Props(clsNames: CssClassType, height: Int, ref: js.UndefOr[String], key: js.Any, position: String, width: Int)

  def apply(clsNames: CssClassType = Map(), height: Int = 0, ref: js.UndefOr[String] = "", key: js.Any = {}, position: String = "", width: Int = 0) = component.set(key, ref)(Props(clsNames, height, ref, key, position, width))


}
