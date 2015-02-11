package chandu0101.scalajs.react.components.materialui


import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.materialui.styles.MaterialUICss._
import chandu0101.scalajs.react.components.util.{CssEvents, DomUtil, KeyLine}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import org.scalajs.dom.Event

import scala.scalajs.js



/**
 * Created by chandrasekharkode on 12/4/14.
 *
 *   autoWidth: React.PropTypes.bool,
    onItemClick: React.PropTypes.func,
    onToggleClick: React.PropTypes.func,
    menuItems: React.PropTypes.array.isRequired,
    selectedIndex: React.PropTypes.number,
    hideable: React.PropTypes.bool,
    visible: React.PropTypes.bool,
    zDepth: React.PropTypes.number
 */
object MuiMenu {

  case class Item(items: List[Item] = List(), onToggle: REventIIntBooleanUnit = null, number: String = "", iconRight: String = "", onClick: REventIIntStringUnit = null, toggle: Boolean = false, icon: String = "", data: String = "", selected: Boolean = false, attribute: String = "", index: Int = 0, mtype: Types = null, route: String = "", text: String)

  sealed trait Types

  object Types {

    case object LINK extends Types

    case object SUBHEADER extends Types

    case object NESTED extends Types

  }


  case class State(nestedMenuShown: Boolean)

  class Backend(t: BackendScope[Props, State]) {

    def setKeyWidth(el: TopNode) = {
      val menuWidth = if (t.props.autoWidth) KeyLine.getIncrementalDim(el.offsetWidth).toString.concat("px")
      else "100%"
      //Update the menu width
      el.style.transition = "none"
      el.style.width = menuWidth
      DomUtil.withoutTransition(el,() => el.style.width = menuWidth)
    }

    def renderVisibility() = {
      val el = t.getDOMNode()
      val innerContainer = thePaperMenuRef(t).get.backend.getInnerContainer.getDOMNode()
      if (t.props.visible) {
        el.style.height = initialMenuHeight.toString.concat("px")
        CssEvents.onTransitionEnd(el,(e:Event) => if(t.props.visible) innerContainer.style.overflow = "visible" )
      } else {
        el.style.height = "0px"
        innerContainer.style.overflow = "hidden"
      }
    }

    def onNestedItemClick(e: ReactEventI, index: Int, route: String) = {
      if (t.props.onItemClick != null) t.props.onItemClick(e, index, route)
    }

    def onItemClick(e: ReactEventI, index: Int, route: String) = {
      if (t.props.onItemClick != null) t.props.onItemClick(e, index, route)
    }

    def onItemToggle(e:ReactEventI,index:Int,toggled:Boolean) = {
      if(t.props.onItemToggle != null)  t.props.onItemToggle(e,index,toggled)
    }
    var initialMenuHeight: Double = 0.0

  }

  val menuItem = ReactComponentB[(Item, Int, Int,Int, Backend)]("menuchildrens")
    .render(P => {
    val (item, selectedIndex, zDepth,index, b) = P
    item.mtype match {
      case Types.LINK => a(cls := mui_menu_item, href := item.route ,key := item.index)(item.text)
      case Types.SUBHEADER => div(cls := mui_subheader ,key := item.index)(item.text)
      case Types.NESTED => MuiNestedMenuItem(index = item.index, text = item.text, menuItems = item.items, zDepth = zDepth, onItemClick = b.onNestedItemClick ,key = item.index)
      case _ => MuiMenuItem(selected = selectedIndex == index,
        icon = item.icon,
        data = item.data,
        attribute = item.attribute,
        number = item.number,
        onClick = b.onItemClick,
        index = item.index,
        route = item.route,
        key = index,
        toggle = item.toggle,
        onToggle = b.onItemToggle
      )(item.text)
    }

  }).build

  val thePaperMenuRef = Ref.to(MuiPaper.component,"thePaperMenuRef")

  lazy val component = ReactComponentB[Props]("MuiMenu")
    .initialState(State(nestedMenuShown = false))
    .backend(new Backend(_))
    .render((P, S, B) => {
      MuiPaper(ref = thePaperMenuRef, clsNames = P.classNames.++(Map(mui_menu -> true, mui_menu_hideable -> P.hideable, mui_visible -> P.visible)), zDepth = P.zDepth)(
        P.menuItems.zipWithIndex.map { case (item,index) => menuItem.withKey(index)((item, P.selectedIndex, P.zDepth,index, B)) }: _* )
    })
    .componentDidMount(scope => {
      val el = scope.getDOMNode()
      scope.backend.setKeyWidth(el)
      scope.backend.initialMenuHeight = el.offsetHeight + KeyLine.Desktop.GUTTER_LESS
    scope.backend.renderVisibility
    })
    .componentDidUpdate((scope, p, _) => {
      if (scope.props.visible != p.visible) scope.backend.renderVisibility
    })
    .build

  val theMenuRef = Ref.to(component, "theMenuRef")

  case class Props(menuItems: List[MuiMenu.Item], visible: Boolean, zDepth: Int, autoWidth: Boolean, hideable: Boolean, onToggleClick: REventIAny, selectedIndex: Int, onItemClick: REventIIntStringUnit, classNames: CssClassType,onItemToggle : REventIIntBooleanUnit)

  def apply(menuItems: List[MuiMenu.Item], visible: Boolean = true, zDepth: Int = 1, autoWidth: Boolean = true, hideable: Boolean = false, onToggleClick: REventIAny = null, selectedIndex: Int = 100, onItemClick: REventIIntStringUnit = null, classNames: CssClassType = Map(),onItemToggle :REventIIntBooleanUnit = null , key : js.Any = {},ref :  js.UndefOr[String] = "") = {
    component.set(key,ref)(Props(menuItems, visible, zDepth, autoWidth, hideable, onToggleClick, selectedIndex, onItemClick, classNames,onItemToggle))
  }


}
