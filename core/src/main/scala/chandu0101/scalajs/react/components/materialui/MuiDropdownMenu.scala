package chandu0101.scalajs.react.components.materialui


import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.materialui.styles.MaterialUICss._
import chandu0101.scalajs.react.components.materialui.svgicons.MuiDropDownArrow
import chandu0101.scalajs.react.components.mixins.ClickAwayable
import chandu0101.scalajs.react.components.util.CommonUtils
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._

import scala.scalajs.js



/**
 * Created by chandrasekharkode .
 * 
 *    autoWidth: React.PropTypes.bool,
    onChange: React.PropTypes.func,
    menuItems: React.PropTypes.array.isRequired* *
 */
object MuiDropdownMenu {



  case class State(open: Boolean = false, selectedIndex: Int)

  class Backend(t: BackendScope[Props, State]) extends ClickAwayable{

    def setWidth() = {
      val el = t.getDOMNode()
      val menuItemDom = theMenuRef(t).get.getDOMNode()
      el.style.width = menuItemDom.offsetWidth.toString.concat("px")
    }

    def onControlClick(e: ReactEventI) = {
      t.modState(s => State(!s.open, s.selectedIndex))
    }

    def onMenuItemClick(e: ReactEventI, index: Int ,route :String) = {
       println(s"selected index : $index")
      if (t.props.onChange != null && t.state.selectedIndex != index) t.props.onChange(e, index,route)
      t.modState(s => State(open = false, index))
    }

    override def onClickAway: Unit = t.modState(_.copy(open = false))

  }

  val theMenuRef = Ref.to(MuiMenu.component,"themenurefDropdown")

  val component = ReactComponentB[Props]("MuiDropdownMenu")
    .initialStateP(p => State( selectedIndex = p.selectedIndex))
    .backend(new Backend(_))
    .render((P, S, B) => {
      val classes = CommonUtils.cssMap1M(mui_drop_down_menu, P.clsNames , mui_open -> S.open)
      div(classSetM(classes))(
        div(cls := mui_menu_control, onClick ==> B.onControlClick)(
          MuiPaper(clsNames = Map(mui_menu_control_bg -> true), zDepth = 0)(),
          div(cls := mui_menu_label)(
            P.menuItems(S.selectedIndex).text
          ),
        MuiDropDownArrow(cls := "mui-menu-drop-down-icon" ,key := "dropdownicon"),
          div(cls := mui_menu_control_underline)
        ),
        MuiMenu(ref = theMenuRef, 
          autoWidth = P.autoWidth, 
          selectedIndex = S.selectedIndex, 
          menuItems = P.menuItems,
          hideable = true,
          visible = S.open, 
          onItemClick = B.onMenuItemClick )
      )
    })
    .configure(ClickAwayable.mixin)
    .componentDidMount(scope => {
      if (scope.props.autoWidth) scope.backend.setWidth
    })
    .componentWillReceiveProps((scope, nextProps) => {
     scope.modState(_.copy(selectedIndex = nextProps.selectedIndex))
    })
    .build

  case class Props(clsNames: CssClassType, autoWidth: Boolean, onChange: REventIIntStringUnit, menuItems: List[MuiMenu.Item], selectedIndex: Int)

  def apply(clsNames: CssClassType = Map(), autoWidth: Boolean = true, onChange: REventIIntStringUnit = null, menuItems: List[MuiMenu.Item], selectedIndex: Int = 0,key : js.Any = {},ref :  js.UndefOr[String] = "") = {
    component.set(key,ref)(Props(clsNames, autoWidth, onChange, menuItems, selectedIndex))
  }
}
