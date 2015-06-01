package chandu0101.scalajs.react.components.materialui


import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.materialui.styles.MaterialUICss._
import chandu0101.scalajs.react.components.util.CommonUtils
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js


/**
 * Created by chandrasekharkode .
 */
object MuiMenuItem {


  class Backend(t: BackendScope[Props, _]) {

    def onClick(e: ReactEventI) : Unit = {
      if (t.props.onClick != null) t.props.onClick(e, t.props.index, t.props.route)
    }

    def onToggleClick(e : ReactEventI,toggled:Boolean) : Unit = {
      if(t.props.onClick != null) t.props.onToggle(e,t.props.index,toggled)
    }

  }


  val component = ReactComponentB[Props]("MuiMenuItem")
    .stateless
    .backend(new Backend(_))
    .render((P, C, S, B) => {
      val classes = CommonUtils.cssMap1M( mui_menu_item,
        P.clsNames,
        mui_is_selected -> P.selected)
     <.div(^.classSetM(classes),
        ^.key := P.index,
        ^.onClick ==> B.onClick,
        P.iconClassName.nonEmpty ?= MuiFontIcon(className = s"mui-menu-item-icon ${P.iconClassName}") ,
        C,
        P.data.nonEmpty ?= <.span(^.cls := mui_menu_item_data)(P.data) ,
        P.attribute.nonEmpty ?= <.span(^.cls := mui_menu_item_attribute)(P.attribute) ,
        P.number.nonEmpty ?= <.span(^.cls := mui_menu_item_number)(P.number) ,
        P.toggle ?= MuiToggle(onToggle = B.onToggleClick),
        P.iconRightClassName.nonEmpty ?= MuiFontIcon(className = s"mui-menu-item-icon-right ${P.iconRightClassName}")
    )
    })
    .build



  case class Props( onToggle : REventIIntBooleanUnit ,iconClassName : String ,number : String ,onClick : REventIIntStringUnit ,toggle : Boolean ,data : String ,clsNames : CssClassType ,ref :  js.UndefOr[String] ,selected : Boolean ,key : js.Any ,iconRightClassName : String ,onTouchTap : REventIUnit ,route : String ,attribute : String ,index : Int  )

  def apply( onToggle : REventIIntBooleanUnit = null ,iconClassName : String = "" ,number : String = "" ,onClick : REventIIntStringUnit = null ,toggle : Boolean = false,data : String = "" ,clsNames : CssClassType = Map(),ref :  js.UndefOr[String] = "",selected : Boolean = false,key : js.Any = {},iconRightClassName : String = "" ,onTouchTap : REventIUnit = null ,route : String = "" ,attribute : String = "" ,index : Int  )(children : ReactNode*) =
    component.set(key,ref)(Props(onToggle,iconClassName,number,onClick,toggle,data,clsNames,ref,selected,key,iconRightClassName,onTouchTap,route,attribute,index),children)


}
