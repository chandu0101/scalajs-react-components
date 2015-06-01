package chandu0101.scalajs.react.components.materialui.tabs


import chandu0101.scalajs.react.components.all._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js


/**
 * Created by chandrasekharkode on 2/7/15.
 */
object MuiTab {


    case class State(checked : Boolean)

      class Backend( t: BackendScope[Props,State]) {

        def handleTouchTap = if(t.props.handleTouchTap != null) t.props.handleTouchTap(t.props.route,t.props.tabIndex)

      }

      val component = ReactComponentB[Props]("MuiTab")
       .initialState(State(false))
       .backend(new Backend(_))
       .render((P,S,B) => {
           val classes = ^.classSet1("mui-tab-item" ,"mui-tab-is-active" -> P.selected )
          <.div(classes, ^.width := P.width, ^.onClick --> B.handleTouchTap)(P.label)
         })
      .build

  case class Props(width : Int,tabIndex : Int,label : String, route : String, handleTouchTap : StringIntUnit ,clsNames : CssClassType ,ref :  js.UndefOr[String] ,selected : Boolean ,key : js.Any  )

  def apply(width : Int = 0, tabIndex : Int, label : String, route : String, handleTouchTap : StringIntUnit = null,clsNames : CssClassType = Map(),ref :  js.UndefOr[String] = "",selected : Boolean = false,key : js.Any = {} )(children : ReactNode*) = component.set(key,ref)(Props(width,tabIndex,label,route,handleTouchTap,clsNames,ref,selected,key),children)

}
