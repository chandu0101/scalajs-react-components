package chandu0101.scalajs.react.components.materialui


import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.materialui.styles.MaterialUICss._
import chandu0101.scalajs.react.components.util.CommonUtils
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._

import scala.scalajs.js



/**
 * Created by chandrasekharkode .
 */
object MuiToolbarGroup {

  val component = ReactComponentB[Props]("MuiToolbarGroup")
    .render((P, C) => {
    val classes = CommonUtils.cssMapM(P.classNames, mui_toolbar_group -> true,
      mui_left -> (P.float == "left"),
      mui_right -> (P.float == "right"))
    div(classSetM(classes))(
      C
    )
  })
    .build

  def apply(classNames: CssClassType = Map(), float: String = "", ref: js.UndefOr[String] = "", key: js.Any = {})(children: ReactNode*) = {
    component.set(key, ref)(Props(classNames, float), children)
  }

  case class Props(classNames: CssClassType, float: String)

}
