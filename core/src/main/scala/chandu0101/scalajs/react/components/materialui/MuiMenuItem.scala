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
object MuiMenuItem {


  class Backend(t: BackendScope[Props, _]) {

    def onClick(e: ReactEventI) = {
      if (t.props.onClick != null) t.props.onClick(e, t.props.index, t.props.route)
    }

    def onToggleClick(e : ReactEventI,toggled:Boolean) = {
      if(t.props.onClick != null) t.props.onToggle(e,t.props.index,toggled)
    }

  }


  val component = ReactComponentB[Props]("MuiMenuItem")
    .stateless
    .backend(new Backend(_))
    .render((P, C, S, B) => {
      div(classSetM(CommonUtils.cssMapM(P.classNames, mui_menu_item -> true, mui_is_selected -> P.selected)), key := P.index, onMouseDown ==> B.onClick)(
        P.icon.nonEmpty ?= MuiIcon(classNames = Map(mui_menu_item_icon -> true), icon = P.icon) ,
        C,
         P.data.nonEmpty ?= span(cls := mui_menu_item_data)(P.data) ,
        P.attribute.nonEmpty ?= span(cls := mui_menu_item_attribute)(P.attribute) ,
        P.number.nonEmpty ?= span(cls := mui_menu_item_number)(P.number) ,
        P.toggle ?= MuiToggle(onToggle = B.onToggleClick),
          P.iconRight.nonEmpty ?= MuiIcon(classNames = Map(mui_menu_item_icon_right -> true), icon = P.iconRight)

    )
    })
    .build

  case class Props(onToggle: REventIIntBooleanUnit, number: String, iconRight: String, onClick: REventIIntStringUnit, toggle: Boolean, icon: String, data: String, selected: Boolean, attribute: String, classNames: CssClassType, index: Int, route: String)

  def apply(onToggle: REventIIntBooleanUnit = null, number: String = "", iconRight: String = "", onClick: REventIIntStringUnit = null, toggle: Boolean = false, icon: String = "", data: String = "", selected: Boolean = false, attribute: String = "", classNames: CssClassType = Map(), index: Int, route: String = "",ref: js.UndefOr[String] = "", key: js.Any = {})(children: ReactNode*) = {
    component.set(key,ref)(Props(onToggle, number, iconRight, onClick, toggle, icon, data, selected, attribute, classNames, index, route), children)
  }

}
