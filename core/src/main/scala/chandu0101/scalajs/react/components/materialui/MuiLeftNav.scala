package chandu0101.scalajs.react.components.materialui


import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.materialui.styles.MaterialUICss._
import chandu0101.scalajs.react.components.mixins.WindowListeners
import chandu0101.scalajs.react.components.util.{CommonUtils, Events}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import org.scalajs.dom.ext.KeyCode
import org.scalajs.dom.{Event, KeyboardEvent}

import scala.scalajs.js
import scala.scalajs.js.Function1



/**
 * Created by chandrasekharkode .
 */
object MuiLeftNav {

  case class Props( menuItems : List[MuiMenu.Item],onChange : REventIIntStringUnit ,docked : Boolean ,header : ReactElement ,selectedIndex : Int ,classNames : CssClassType  )

  case class State(open : Boolean)

  class Backend( t: BackendScope[Props,State]) extends WindowListeners{

    def toggle() = t.modState(s => State(!s.open))

    def close() = t.modState(s => State(open = false))

    def open() = t.modState(s => State(open = true))

    def onMenuItemClick(e:ReactEventI , index : Int , route:String) = {
      e.preventDefault()
      if(t.props.docked) close
      if(t.props.onChange != null && t.props.selectedIndex != index) t.props.onChange(e,index,route)

    }

    def onOverlayTouchTap() = close

    lazy val onWindowKeyUp : js.Function1[Event,_] = (e:Event) => {
        if(e.asInstanceOf[KeyboardEvent].keyCode == KeyCode.escape && !t.props.docked && t.state.open) close
     }
    override def listeners: List[(String, Function1[Event, _])] = List(Events.KEYUP -> onWindowKeyUp)
  }

  val component = ReactComponentB[Props]("leftnav")
   .initialStateP( p => State(p.docked))
   .backend(new Backend(_))
   .render((P,S,B) => {
       val classes = CommonUtils.cssMapM(P.classNames, mui_left_nav -> true, mui_closed -> !S.open)
       div(classSetM(classes))(
        if(!P.docked) MuiOverlay( show = S.open , onTouchTap = B.onOverlayTouchTap _) else "",
        MuiPaper(clsNames = Map(mui_left_nav_menu -> true) ,zDepth = 2 )(
          P.header,
          MuiMenu( zDepth = 0, menuItems = P.menuItems ,selectedIndex = P.selectedIndex , onItemClick = B.onMenuItemClick ,key = "leftmenu")
        )
       )
     })
  .build

  def apply( menuItems : List[MuiMenu.Item],onChange : REventIIntStringUnit = null,docked : Boolean = true,header : ReactElement = null,selectedIndex : Int = 0,clsNames : CssClassType = Map() ,ref: js.UndefOr[String] = "", key: js.Any = {}) = {
    component.set(key,ref)(Props(menuItems,onChange,docked,header,selectedIndex,clsNames))
  }

}
