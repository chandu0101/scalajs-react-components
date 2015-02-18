package chandu0101.scalajs.react.components.materialui

import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.materialui.styles.MaterialUICss._
import chandu0101.scalajs.react.components.util.CommonUtils
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import org.scalajs.dom.html

import scala.scalajs.js



/**
 * Created by chandrasekharkode .
 *    circle: React.PropTypes.bool,
    innerClassName: React.PropTypes.string,
    rounded: React.PropTypes.bool,
    zDepth: React.PropTypes.oneOf([0,1,2,3,4,5])*
 */
object MuiPaper {


  val theInnerContainerRef = Ref[html.Element]("theInnerContainerRef")

  class Backend(t: BackendScope[Props, _]) {
    def getInnerContainer = theInnerContainerRef(t).get
  }


  val component = ReactComponentB[Props]("MuiPaper")
    .stateless
    .backend(new Backend(_))
    .render((P, C, S, B) => {
       val classes = CommonUtils.cssMap1M(mui_paper,
         P.clsNames,
        mui_z_depth.concat(P.zDepth.toString) -> true,
        mui_rounded -> P.rounded,
        mui_circle -> P.circle)
       val innerClasses = CommonUtils.cssMapM(P.innerClassNames,
        mui_paper_container -> true,
        mui_z_depth_bottom -> true)
         div(classSetM(classes), P.style!= null ?= P.style )(
          div(classSetM(innerClasses) ,ref := theInnerContainerRef ) (
           C
          )
         )
      })
    .build


  case class Props(style : TagMod, circle : Boolean ,clsNames : CssClassType ,rounded : Boolean ,ref :  js.UndefOr[String] ,zDepth : Int ,key : js.Any ,innerClassNames : CssClassType  )

  def apply(style : TagMod = null, circle : Boolean = false,clsNames : CssClassType = Map(),rounded : Boolean = true,ref :  js.UndefOr[String] = "",zDepth : Int = 1,key : js.Any = {},innerClassNames : CssClassType = Map()   )(children : ReactNode*) = component.set(key,ref)(Props(style,circle,clsNames,rounded,ref,zDepth,key,innerClassNames),children)



}
