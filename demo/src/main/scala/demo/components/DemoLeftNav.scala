package demo.components

import chandu0101.scalajs.react.components._
import japgolly.scalajs.react.{BackendScope, ReactComponentB}
import japgolly.scalajs.react.vdom.prefix_<^._
import scala.scalajs.js

object DemoLeftNav {

  case class Menu(text: String, route: String)

  trait Style {

    def leftNav: TagMod = Seq[TagMod](^.display := "flex", ^.flexDirection := "column")

    def menuItem: TagMod = Seq(
      ^.lineHeight := "48px",
      ^.padding := "0 25px",
      ^.color := "black",
//    ^.width := "190px",
      ^.textDecoration := "none"
    )

    def selectedMenuItem: TagMod = Seq(
      ^.color := "red",
      ^.fontWeight := 500
    )

    def menuItemHover: TagMod = Seq(
      ^.color := "#555555",
      ^.backgroundColor := "#ecf0f1"
    )

  }

  case class State(hoveredItem: String = "")

  class Backend(t: BackendScope[Props, State]) {

    def onMouseEnter_(item: String) = {
      t.modState(_.copy(hoveredItem = item))
    }

    def onMouseLeave_ = {
      t.modState(_.copy(hoveredItem = ""))
    }
    def render(P: Props, S: State) = {
      <.div(P.style.leftNav)(
        P.menu.map { item => {
          val selected = item.text == P.selectedItem
          val hover = S.hoveredItem == item.text
          <.a(^.key := item.text, P.style.menuItem, selected ?= P.style.selectedMenuItem,
            hover ?= P.style.menuItemHover)(
            ^.onMouseEnter --> onMouseEnter_(item.text),
              ^.onMouseOut --> onMouseLeave_)(^.href := item.route)(item.text)
        }
        }
      )
    }
  }

  val component = ReactComponentB[Props]("DemoLeftNav")
    .initialState(State())
    .renderBackend[Backend]
    .build

  case class Props(menu: List[Menu], selectedItem: String, style: Style)

  def apply(menu: List[Menu], selectedItem: String = "", style: Style = new Style {}, ref: js.UndefOr[String] = "", key: js.Any = {}) = component.set(key, ref)(Props(menu, selectedItem, style))

}
