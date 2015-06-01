package chandu0101.scalajs.react.components.materialui


import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.materialui.styles.MaterialUICss
import chandu0101.scalajs.react.components.util.CommonUtils
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js



/**
 * Created by chandrasekharkode .
 */
object MuiToolbar {

  case class Props(classNames: CssClassType)

  val component = ReactComponentB[Props]("toolbar")
    .render((P, C) => {
     <.div(^.classSetM(CommonUtils.cssMapM(P.classNames, MaterialUICss.mui_toolbar -> true)))(
        C
      )
    })
    .build

  def apply(classNames: CssClassType = Map(), ref: js.UndefOr[String] = "", key: js.Any = {})(children: ReactNode*) = {
    component.set(key, ref)(Props(classNames), children)
  }


}
