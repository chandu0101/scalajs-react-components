package demo
package components

import demo.routes.AppRouter._
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.router.RouterCtl
import japgolly.scalajs.react.vdom.html_<^._

object ComponentGridItem {

  object Style {

    val item = TagMod(
      ^.margin := "30px",
      ^.maxWidth := "250px",
      ^.cursor := "pointer",
      ^.boxShadow := "0 1px 3px rgba(85, 89, 88, 0.24)"
    )

    val itemTitle = TagMod(
      ^.backgroundColor := "#eeeeee",
      ^.color := "rgba(0, 0, 0, 0.87)",
      ^.fontSize := "18px",
      ^.fontWeight := "500",
      ^.letterSpacing := "0px",
      ^.lineHeight := "54px",
      ^.margin := "0px",
      ^.padding := "0px",
      ^.textAlign := "center"
    )

    val itemImage = TagMod(
      ^.maxHeight := "250 px",
      ^.maxWidth := "250 px",
      ^.minHeight := "100 px",
      ^.minWidth := "120 px"
    )

    val itemHover = TagMod(^.boxShadow := "0 10px 18px rgba(16, 208, 194, 0.24)")

  }

  case class State(itemHover: Boolean = false)

  class Backend(t: BackendScope[Props, State]) {

    val onMouseOver = t.modState(_.copy(itemHover = true))

    val onMouseOut = t.modState(_.copy(itemHover = false))

    def render(P: Props, S: State) =
      <.div(
        Style.item,
        Style.itemHover.when(S.itemHover),
        P.ctrl setOnClick P.route,
        ^.onMouseEnter --> onMouseOver,
        ^.onMouseLeave --> onMouseOut,
        <.h3(
          Style.itemTitle,
          ^.key := P.heading,
          P.heading
        ),
        <.img(
          ^.src := P.img,
          Style.itemImage,
          ^.key := "alink"
        )
      )
  }

  val component = ScalaComponent
    .builder[Props]("ComponentGridElement")
    .initialState(State())
    .renderBackend[Backend]
    .build

  case class Props(heading: String, route: Page, img: String, ctrl: RouterCtl[Page])

  def apply(heading: String, route: Page, img: String, ctrl: RouterCtl[Page]) = {
    component(Props(heading, route, img, ctrl))
    //    component.set(key, ref)(Props(heading, route, img, ctrl))
  }
}
