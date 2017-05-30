package demo
package pages

import chandu0101.scalajs.react.components._
import demo.components.{ComponentGridItem, LocalDemoButton}
import demo.routes.AppRouter
import demo.routes.AppRouter._
import japgolly.scalajs.react._
import japgolly.scalajs.react.component.Generic.toComponentCtor
import japgolly.scalajs.react.extra.router.RouterCtl
import japgolly.scalajs.react.vdom.html_<^._

object HomePage {
  import RCustomStyles._

  case class ComponentInfo(name: String, imagePath: String, route: Page, tags: Stream[String])

  object Style {

    val info = TagMod(
      MsFlexAlign := "center",
      MsFlexDirection := "column",
      WebkitAlignItems := "center",
      WebkitBoxAlign := "center",
      WebkitBoxDirection := "normal",
      WebkitBoxOrient := "vertical",
      WebkitFlexDirection := "column",
      ^.alignItems := "center",
      ^.backgroundColor := "#eeeeee",
      ^.display := "-ms-flexbox",
      ^.display := "-webkit-box",
      ^.display := "-webkit-flex",
      ^.display := "flex",
      ^.flexDirection := "column",
      ^.fontSize := "18px",
      ^.fontWeight := "500",
      ^.paddingBottom := "45px",
      ^.paddingTop := "85px"
    )

    val infoContent = TagMod(^.fontWeight := "500", ^.fontSize := "18px")

    val infoLink = TagMod(
      ^.color := "#ff4081",
      ^.padding := "0 5px",
      ^.textDecoration := "none"
    )

    val searchSection = TagMod(
      ^.display := "-ms-flexbox",
      ^.display := "-webkit-box",
      ^.display := "-webkit-flex",
      ^.display := "flex",
      ^.margin := "50px",
      ^.marginBottom := "15px"
    )

    val componentsGrid = TagMod(
      MsFlexWrap := "wrap",
      WebkitFlexWrap := "wrap",
      ^.display := "-ms-flexbox",
      ^.display := "-webkit-box",
      ^.display := "-webkit-flex",
      ^.display := "flex",
      ^.flexWrap := "wrap",
      ^.margin := "30px"
    )

  }

  case class State(filterText: String = "", results: Vector[ComponentInfo])

  class Backend(t: BackendScope[RouterCtl[Page], State]) {

    def onTextChange(text: String) = {
      val results = AppRouter.homePageMenu.filter(c => c.tags.exists(s => s.contains(text)))
      t.modState(_.copy(results = results, filterText = text))
    }
    def render(P: RouterCtl[Page], S: State) = {
      <.div(
        <.div(Style.info, ^.key := "info")(
          <.h3(Style.infoContent)(
            "Reusable ",
            <.a(^.href := "https://github.com/japgolly/scalajs-react",
                Style.infoLink,
                ^.target := "_blank")("scalajs-react"),
            " Components, want to Contribute ? "
          ),
          LocalDemoButton(
            name = "Welcome Mama",
            linkButton = true,
            href =
              "https://github.com/chandu0101/scalajs-react-components/tree/master/doc/CONTRIBUTE.md")
        ),
        <.div(Style.searchSection)(
          ReactSearchBox(onTextChange = onTextChange, style = ReactSearchBox.DefaultStyle),
          <.strong(^.alignSelf := "center", ^.paddingLeft := "30px")(
            s"Results: ${S.results.length}").unless(S.filterText.isEmpty)
        ),
        <.div(Style.componentsGrid)(
          S.results.map(c => ComponentGridItem(c.name, c.route, c.imagePath, P)).toTagMod
        )
      )
    }
  }

  val component = ScalaComponent
    .builder[RouterCtl[Page]]("homepage")
    .initialState(State("", AppRouter.homePageMenu))
    .renderBackend[Backend]
    .build

  def apply(ctrl: RouterCtl[Page]) = component(ctrl)

}
