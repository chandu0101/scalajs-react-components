package chandu0101.scalajs.react.components.materialui


import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.materialui.styles.MaterialUICss._
import chandu0101.scalajs.react.components.materialui.svgicons.MuiNavigationMenuIcon
import chandu0101.scalajs.react.components.util.CommonUtils
import chandu0101.scalajs.react.components.util.CommonUtils._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._

import scala.scalajs.js


/**
 * Created by chandrasekharkode .
 *
 * clsNames: React.PropTypes.css,
   key: React.PropTypes.key,
   ref: React.PropTypes.ref,
   onMenuIconButtonTouchTap: React.PropTypes.func,
    showMenuIconButton: React.PropTypes.bool,
    title : React.PropTypes.string,
    zDepth: React.PropTypes.number
 */
object MuiAppBar {

  class Backend(t: BackendScope[Props, _]) {
    def onMenuIconButtonTouchTap(e: ReactEventI) = {
      if (t.props.onMenuIconButtonTouchTap != null) t.props.onMenuIconButtonTouchTap(e)
    }
  }

  val component = ReactComponentB[Props]("MuiAppBar")
    .stateless
    .backend(new Backend(_))
    .render((P, C, S, B) => {
      MuiPaper(rounded = false, clsNames = cssMap1M(mui_app_bar,P.clsNames), zDepth = P.zDepth)(
        if (P.showMenuIconButton) MuiIconButton.withChildren(clsNames = Map(mui_app_bar_navigation_icon_button -> true), onTouchTap = B.onMenuIconButtonTouchTap ,key = "iconButton")(MuiNavigationMenuIcon()) else "",
        if (P.title.nonEmpty) h1(cls := mui_app_bar_title ,key := P.title,P.title) else "",
          C
      )
    })
    .build


  case class Props( clsNames : CssClassType ,onMenuIconButtonTouchTap : REventIUnit ,ref :  js.UndefOr[String] ,zDepth : Int ,key : js.Any ,showMenuIconButton : Boolean ,title : String  )

  def apply( clsNames : CssClassType = Map(),onMenuIconButtonTouchTap : REventIUnit = null ,ref :  js.UndefOr[String] = "",zDepth : Int = 0,key : js.Any = {},showMenuIconButton : Boolean = true,title : String = ""  ) =
    component.set(key,ref)(Props(clsNames,onMenuIconButtonTouchTap,ref,zDepth,key,showMenuIconButton,title))


}
