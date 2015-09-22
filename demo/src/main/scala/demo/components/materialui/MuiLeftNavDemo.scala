package demo
package components
package materialui

import chandu0101.scalajs.react.components._
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react.{Callback, BackendScope, ReactComponentB, ReactEventH, Ref}
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js

object MuiLeftNavDemo {

  val code =
    """
      | lazy val menuItems = js.Array(
      |    MuiMenuItem(route = "get-started", text = "Get-started"),
      |    MuiMenuItem(`type` = MuiMenuItemType.SUBHEADER, text = " Resources"),
      |    MuiMenuItem(`type` = MuiMenuItemType.LINK,
      |      text = "Github",
      |      payload = "https://github.com/chandu0101/scalajs-react-components")
      |  )
      |  // hidebale left nav
      |    MuiLeftNav(ref = "leftnav",
      |            menuItems = menuItems,docked = false
      |          ),
      |
      |    MuiLeftNav(ref = "leftnavdocked",
      |            menuItems = menuItems,docked = S.isDocked
      |      ),
      |
    """.stripMargin

  lazy val menuItems = js.Array(
    MuiMenuItem(route = "get-started", text = "Get-started"),
    MuiMenuItem(`type` = MuiMenuItemType.SUBHEADER, text = " Resources"),
    MuiMenuItem(`type` = MuiMenuItemType.LINK,
      text = "Github",
      payload = "https://github.com/chandu0101/scalajs-react-components")
  )

  lazy val dockedLeftnavRef = Ref.toJS[MuiLeftNavM]("leftnavdocked")

  lazy val nondockedLeftnavRef = Ref.toJS[MuiLeftNavM]("leftnav")

  case class State(isDocked: Boolean = false)

  class Backend(t: BackendScope[_, State]) {
    val dockedLeftNavRefC    = callbackRef(dockedLeftnavRef, t)
    val nondockedLeftNavRefC = callbackRef(nondockedLeftnavRef, t)

    def handleDockedLeftNav(e: ReactEventH): Callback =
      dockedLeftNavRefC.map(_.toggle()) >> t.modState(s => s.copy(isDocked = !s.isDocked))

    def handleHidableLeftNav(e: ReactEventH): Callback =
      nondockedLeftNavRefC.map(_.toggle())

    def render(S: State) = {
      <.div(
        CodeExample(code, "MuiAppBar")(
          <.div(
            MuiLeftNav(ref = "leftnav",
              menuItems = menuItems,docked = false
            )(),
            MuiLeftNav(ref = "leftnavdocked",
              menuItems = menuItems,docked = S.isDocked
            )(),
            MuiRaisedButton(label = "Toggle Docked Left Nav" ,onTouchTap = handleDockedLeftNav _)(),
            <.br(),
            <.br(),
            MuiRaisedButton(label = "Show Hideable Left Nav" ,onTouchTap = handleHidableLeftNav _)()
          )
        )
      )
    }
  }

  val component = ReactComponentB[Unit]("MuiLeftNavDemo")
    .initialState(State())
    .renderBackend[Backend]
    .buildU

  def apply() = component()
}
