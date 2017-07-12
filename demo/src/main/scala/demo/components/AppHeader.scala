package demo
package components

import chandu0101.scalajs.react.components.RCustomStyles
import chandu0101.scalajs.react.components.RCustomStyles._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object AppHeader {

  object Style {

    val headerStyle = Seq(
      ^.background := "#F2706D",
      ^.fontSize := "1.5em",
      ^.padding := "0px",
      ^.margin := "0px",
      ^.position := "fixed",
      ^.width := "100%",
      ^.zIndex := "5"
    ).toTagMod

    val menuNav = Seq(
      MsFlexAlign := "center",
      WebkitAlignItems := "center",
      WebkitBoxAlign := "center",
      ^.alignItems := "center",
      ^.display := "-ms-flexbox",
      ^.display := "-webkit-box",
      ^.display := "-webkit-flex",
      ^.display := "flex",
      ^.height := "64px",
      ^.lineHeight := "64px",
      ^.margin := "0 3rem"
    ).toTagMod

    val logo = Seq(
      ^.color := "rgb(244, 233, 233)",
      ^.textDecoration := "none",
      ^.width := "150px"
    ).toTagMod

    val menuItem =
      Seq(^.padding := "20px", ^.color := "rgb(244, 233, 233)", ^.textDecoration := "none").toTagMod

    val menuItemHover = Seq(^.background := "#f1453e").toTagMod

  }

  case class State(menuHover: String = "")

  class Backend(t: BackendScope[_, State]) {

    def onMouseEnter(menu: String) = t.modState(_.copy(menuHover = menu))

    val onMouseLeave = t.modState(_.copy(menuHover = ""))

    def render(S: State) = {
      val github: String = "Github"
      <.header(Style.headerStyle)(
        <.nav(Style.menuNav)(
          <.a(Style.logo, ^.href := "#")("S J R C"),
          <.div(^.marginLeft := "auto")(
            <.a(
              ^.target := "_blank",
              Style.menuItemHover.when(S.menuHover == github),
              Style.menuItem,
              ^.href := "https://github.com/chandu0101/scalajs-react-components",
              ^.onMouseEnter --> onMouseEnter(github),
              ^.onMouseLeave --> onMouseLeave
            )(github)
          )
        )
      )
    }
  }

  val component = ScalaComponent
    .builder[Unit]("AppHeader")
    .initialState(State())
    .renderBackend[Backend]
    .build

  def apply() = component()

}
