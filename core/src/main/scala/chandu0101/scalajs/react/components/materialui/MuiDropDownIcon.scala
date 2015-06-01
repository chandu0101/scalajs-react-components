package chandu0101.scalajs.react.components.materialui


import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.materialui.styles.MaterialUICss._
import chandu0101.scalajs.react.components.mixins.ClickAwayable
import chandu0101.scalajs.react.components.util.CommonUtils
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js



/**
 * Created by chandrasekharkode .
 */
object MuiDropDownIcon {


  case class State(open: Boolean)

  class Backend(t: BackendScope[Props, State]) extends ClickAwayable {
    def onControlClick(e: ReactEventI) = {
      t.modState(toggleState)
    }

    def onMenuItemClick(e: ReactEventI, index: Int ,route :String) = {
      if (t.props.onChange != null) t.props.onChange(e, index,route)
      t.modState(toggleState)
    }

    def toggleState = (s: State) => State(!s.open)

    override def onClickAway: Unit = t.modState(_.copy(open = false))

  }

  val component = ReactComponentB[Props]("MuiDropDownIcon")
    .initialState(State(open = false))
    .backend(new Backend(_))
    .render((P, C,S, B) => {
      val classes= CommonUtils.cssMap1M(mui_drop_down_icon,P.clsNames,mui_open -> S.open)
     <.div(^.classSetM(classes))(
       <.div(^.cls := mui_menu_control,
          ^.onClick ==> B.onControlClick,
          P.iconClassName.nonEmpty ?= MuiFontIcon(className = P.iconClassName,
          C)
        ),
        MuiMenu(menuItems = P.menuItems, hideable = true, visible = S.open, onItemClick = B.onMenuItemClick)
      )
    })
    .configure(ClickAwayable.mixin)
    .build

  case class Props(iconClassName: String, clsNames: CssClassType, onChange: REventIIntStringUnit, menuItems: List[MuiMenu.Item])

  // useful  when you want use svg icon instead of font-icon
  def withChildren(iconClassName: String = "", clsNames: CssClassType = Map(), onChange: REventIIntStringUnit = null, menuItems: List[MuiMenu.Item],key : js.Any = {},ref :  js.UndefOr[String] = "")(children : ReactNode*) = {
    component.set(key,ref)(Props(iconClassName, clsNames, onChange, menuItems),children)
  }
  
  def apply(iconClassName: String = "", clsNames: CssClassType = Map(), onChange: REventIIntStringUnit = null, menuItems: List[MuiMenu.Item],key : js.Any = {},ref :  js.UndefOr[String] = "") = {
    component.set(key,ref)(Props(iconClassName, clsNames, onChange, menuItems))
  }

}
