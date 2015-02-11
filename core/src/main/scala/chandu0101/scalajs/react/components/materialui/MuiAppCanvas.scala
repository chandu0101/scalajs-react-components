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
object MuiAppCanvas {

  val component = ReactComponentB[Props]("MuiAppCanvas")
    .render((P,C) => {
      div(classSetM(CommonUtils.cssMapM(P.clsNames,mui_app_canvas -> true, mui_predefined_layout_1 -> (P.predefinedLayout == 1) )))(C)
    })
    .build

  case class Props( clsNames : CssClassType ,key : js.Any ,ref :  js.UndefOr[String] ,predefinedLayout : Int  )

  def apply( clsNames : CssClassType = Map(),key : js.Any = {},ref :  js.UndefOr[String] = "",predefinedLayout : Int = 0 )(children : ReactNode*) = component.set(key,ref)(Props(clsNames,key,ref,predefinedLayout),children)

}
