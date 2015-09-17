package demo
package components

import chandu0101.scalajs.react.components._
import demo.routes.AppRouter.Page
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.router2.RouterCtl
import japgolly.scalajs.react.vdom.prefix_<^._
import scala.scalajs.js

object ComponentGridItem {

  object Style {

    val item = Seq(^.margin := "30px",
      ^.maxWidth := "250px",
       cursorPointer,
      ^.boxShadow := "0 1px 3px rgba(85, 89, 88, 0.24)"
    )

    val itemTitle = Seq(^.backgroundColor := "#eeeeee",
      ^.color := "rgba(0, 0, 0, 0.87)",
      ^.fontSize := "18px",
      ^.fontWeight := "500",
      ^.letterSpacing := "0",
      ^.lineHeight := "54px",
      ^.margin := "0",
      ^.padding := "0",
      ^.textAlign := "center")

    val itemImage = Seq(^.maxHeight := "250px",
      ^.maxWidth := "250px",
      ^.minHeight := "100px",
      ^.minWidth := "120px")

    val itemHover = Seq(^.boxShadow := "0 10px 18px rgba(16, 208, 194, 0.24)")

  }

  case class State(itemHover: Boolean = false)

  class Backend(t: BackendScope[Props, State]) {

    def onMouseOver() = t.modState(_.copy(itemHover = true))

    def onMouseOut() = t.modState(_.copy(itemHover = false))

  }

  val component = ReactComponentB[Props]("ComponentGridElement")
    .initialState(State())
    .backend(new Backend(_))
    .render((P, S, B) => {
   <.div(Style.item, S.itemHover ?= Style.itemHover,P.ctrl setOnClick P.route,
     onMouseEnter --> B.onMouseOver, onMouseLeave --> B.onMouseOut)(
     <.h3(Style.itemTitle, ^.key := P.heading)(P.heading),
     <.img(^.src := P.img, Style.itemImage, ^.key := "alink")
    )
  })
    .build

  case class Props(heading: String, route: Page, img: String,ctrl: RouterCtl[Page])

  def apply(heading: String, route: Page, img: String,ctrl: RouterCtl[Page], ref: js.UndefOr[String] = "", key: js.Any = {}) = component.set(key, ref)(Props(heading, route, img,ctrl))
}
