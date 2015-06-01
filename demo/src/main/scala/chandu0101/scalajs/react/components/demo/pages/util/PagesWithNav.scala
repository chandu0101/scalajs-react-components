package chandu0101.scalajs.react.components.demo.pages.util

import chandu0101.scalajs.react.components.demo.routes.AppRouter.AppPage
import chandu0101.scalajs.react.components.demo.util.Navigate
import chandu0101.scalajs.react.components.materialui.MuiMenu
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._



/**
 * Created by chandrasekharkode .
 */
object PagesWithNav {

  case class State(checked: Boolean)

  class Backend(t: BackendScope[Props, State]) {

    def getSelectedIndex = {
      t.props.menuItems.zipWithIndex.filter { case (menu, index) => menu.route == AppPage.currentRoute}.head._2
    }

    def onMenuItemClick(e: ReactEventI, index: Int, route: String) = {
      Navigate.to(route)
    }
  }

  val component = ReactComponentB[Props]("radioButton")
    .initialState(State(checked = false))
    .backend(new Backend(_))
    .render((P, S, B) => {
     <.div(^.cls := "mui-app-content-canvas page-with-nav")(
       <.div(^.cls := "page-with-nav-content")(
          P.content
        ),
       <.div(^.cls := "page-with-nav-secondary-nav")(
          MuiMenu(zDepth = 0, menuItems = P.menuItems, selectedIndex = B.getSelectedIndex, onItemClick = B.onMenuItemClick)
        )
      )
    })
    .build

  case class Props(menuItems: List[MuiMenu.Item],content : ReactElement)

  def apply(menuItems: List[MuiMenu.Item] ,content : ReactElement) = component(Props(menuItems,content))

}
