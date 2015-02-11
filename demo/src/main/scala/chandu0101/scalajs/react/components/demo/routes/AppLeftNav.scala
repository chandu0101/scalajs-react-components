package chandu0101.scalajs.react.components.demo.routes

import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.all._


/**
 * Created by chandrasekharkode .
 */
object AppLeftNav {

//  case class State(selectedIndex: Long)
//
//  val menus = List(MuiMenu.Item(text = "MaterialUI", index = 1, route = "mui"))
//
//  class Backend(t: BackendScope[String, State]) {
//    def getSelectedIndex = menus.zipWithIndex.filter { case (menu, index) => menu.route == t.props}.head._2
//
//    def onHeaderClick = {
//      dom.window.location.hash = ""
//    }
//
//    def onLeftNavChange(e: ReactEventI, index: Long, payload: String) = {
//      dom.window.location.hash = payload
//      //      t.props.router.setIO(t.props.router.read(s"#$payload").getOrElse(null))
//    }
//
//  }

//  case class Props(router: Router, payload: String)

  val component = ReactComponentB[String]("appleftnav")
//    .initialState(State(0))
//    .backend(new Backend(_))
    .render(P => {
    div()
//    val header = div(cls := "logo", onClick --> B.onHeaderClick)("Components")
//    MuiLeftNav(docked = true, header = header, menuItems = menus, selectedIndex = B.getSelectedIndex, onChange = B.onLeftNavChange)
  }).build

  def apply(payload: String) = component(payload)
}
