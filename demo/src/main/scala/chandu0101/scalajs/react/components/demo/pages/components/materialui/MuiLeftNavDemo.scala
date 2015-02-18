package chandu0101.scalajs.react.components.demo.pages.components.materialui

import chandu0101.scalajs.react.components.demo.pages.util.CodeExample
import chandu0101.scalajs.react.components.materialui.{MuiLeftNav, MuiMenu, MuiRaisedButton}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._

/**
 * Created by chandrasekharkode .
 */
object MuiLeftNavDemo {

  val code =
     """
       |val menuItems = List(
       |   MuiMenu.Item(text = "Material ui",route = "mui"),
       |   MuiMenu.Item(text = "React table",route = "rct"),
       |   MuiMenu.Item(tpe = MuiMenu.Types.SUBHEADER , text = "Resources"),
       |   MuiMenu.Item(tpe = MuiMenu.Types.LINK , text = "Github" ,route = "https://github.com/chandu0101/scalajs-react-components")
       |  )
       |
       |val theDockedLeftNavRef = Ref.to(MuiLeftNav.component,"theDockedLeftNavRef")
       |val theHideableLeftNavRef = Ref.to(MuiLeftNav.component,"theHidableLeftNavRef")
       |//Docked Left Nav
       |MuiLeftNav(ref = theDockedLeftNavRef , docked = S.docked , menuItems = menuItems),
       |//Hideable Left Nav
       |MuiLeftNav(ref = theHideableLeftNavRef , menuItems = menuItems ,docked = false)
       |
     """.stripMargin

  val menuItems = List(
   MuiMenu.Item(text = "Material ui",route = "mui"),
   MuiMenu.Item(text = "React table",route = "rct"),
   MuiMenu.Item(mtype = MuiMenu.Types.SUBHEADER , text = "Resources"),
   MuiMenu.Item(mtype = MuiMenu.Types.LINK , text = "Github" ,route = "https://github.com/chandu0101/scalajs-react-components")
  )

  case class State(docked : Boolean)
  class Backend(t:BackendScope[_,State]) {

    def onDockedLeftNavClick(e:ReactEventI) = {
      theDockedLeftNavRef(t).get.backend.toggle
      t.modState(s => State(!s.docked))
    }

    def onHideableLeftNavClick(e:ReactEventI) = {
      theHideableLeftNavRef(t).get.backend.toggle
    }
  }
  val theDockedLeftNavRef = Ref.to(MuiLeftNav.component,"theDockedLeftNavRef")
  val theHideableLeftNavRef = Ref.to(MuiLeftNav.component,"theHidableLeftNavRef")

  val component = ReactComponentB[Unit]("MuiLeftNavDemo")
    .initialState(State(docked = false))
    .backend(new Backend(_))
    .render((P,S,B) => {
      div(
       h3("Left Nav"),
       CodeExample(code)(
        div(
          MuiRaisedButton( label = "Toggle Docked Left Nav" , onTouchTap = B.onDockedLeftNavClick),
          br(),
          br(),
          MuiRaisedButton( label = "Show Hideable Left Nav" , onTouchTap = B.onHideableLeftNavClick),
          br(),
          br(),
          MuiLeftNav(ref = theDockedLeftNavRef , docked = S.docked , menuItems = menuItems),
          MuiLeftNav(ref = theHideableLeftNavRef , menuItems = menuItems ,docked = false)
        )
       )
      )
    }).buildU

    def apply() = component()

}
