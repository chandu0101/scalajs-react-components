package chandu0101.scalajs.react.components.materialui


import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.materialui.styles.MaterialUICss._
import chandu0101.scalajs.react.components.mixins.ClickAwayable
import chandu0101.scalajs.react.components.util.CommonUtils
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._

import scala.scalajs.js



/**
 * Created by chandrasekharkode .
 */
object MuiDropDownIcon {

  case class Props(icon: String, classNames: CssClassType, onChange: REventIIntStringUnit, menuItems: List[MuiMenu.Item])

  case class State(open: Boolean)

  class Backend(t: BackendScope[Props, State]) extends ClickAwayable {
    def onControlClick(e: ReactEventI) = {
      e.preventDefault()
      t.modState(toggleState)
    }

    def onMenuItemClick(e: ReactEventI, index: Int ,route :String) = {
      e.preventDefault()
      if (t.props.onChange != null) t.props.onChange(e, index,route)
      t.modState(toggleState)
    }

    def toggleState = (s: State) => State(!s.open)

    override def onClickAway: Unit = t.modState(_.copy(open = false))

  }

  val component = ReactComponentB[Props]("radioButton")
    .initialState(State(open = false))
    .backend(new Backend(_))
    .render((P, S, B) => {
      div(classSetM(CommonUtils.cssMapM(P.classNames, mui_drop_down_icon -> true, mui_open -> S.open)))(
        div(cls := mui_menu_control, onClick ==> B.onControlClick)(
          MuiIcon(icon = P.icon)
        ),
        MuiMenu(menuItems = P.menuItems, hideable = true, visible = S.open, onItemClick = B.onMenuItemClick)
      )
    })
    .configure(ClickAwayable.mixin)
    .build

  def apply(icon: String = "", clsNames: CssClassType = Map(), onChange: REventIIntStringUnit = null, menuItems: List[MuiMenu.Item],key : js.Any = {},ref :  js.UndefOr[String] = "") = {
    component.set(key,ref)(Props(icon, clsNames, onChange, menuItems))
  }

}
