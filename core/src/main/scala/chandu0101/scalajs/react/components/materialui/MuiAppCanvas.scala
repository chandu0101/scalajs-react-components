package chandu0101.scalajs.react.components.materialui


import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.materialui.styles.MaterialUICss._
import chandu0101.scalajs.react.components.util.CommonUtils
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js



/**
 * Created by chandrasekharkode .
 *  predefinedLayout: React.PropTypes.number
 */
object MuiAppCanvas {

  val component = ReactComponentB[Props]("MuiAppCanvas")
    .render((P,C) => {
      val classes = CommonUtils.cssMap1M(mui_app_canvas,P.clsNames,mui_predefined_layout_1 -> (P.predefinedLayout == 1))
     <.div(^.classSetM(classes))(
        C
      )
    })
    .build

  case class Props( clsNames : CssClassType ,key : js.Any ,ref :  js.UndefOr[String] ,predefinedLayout : Int  )

  def apply( clsNames : CssClassType = Map(),key : js.Any = {},ref :  js.UndefOr[String] = "",predefinedLayout : Int = 0 )(children : ReactNode*) = component.set(key,ref)(Props(clsNames,key,ref,predefinedLayout),children)

}
