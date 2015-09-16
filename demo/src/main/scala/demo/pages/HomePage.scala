package demo
package pages

import chandu0101.scalajs.react.components._
import chandu0101.scalajs.react.components.searchboxes.ReactSearchBox
import demo.components.{ComponentGridItem, LocalDemoButton}
import demo.routes.AppRouter
import demo.routes.AppRouter.Page
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.router2.RouterCtl
import japgolly.scalajs.react.vdom.prefix_<^._

object HomePage {

  case class ComponentInfo(name: String, imagePath: String, route: Page, tags: Stream[String])

  object Style {

    val info = Seq(
      MsFlexAlign := "center" ,
      MsFlexDirection := "column" ,
      WebkitAlignItems := "center" ,
      WebkitBoxAlign := "center" ,
      WebkitBoxDirection := "normal" ,
      WebkitBoxOrient := "vertical" ,
      WebkitFlexDirection := "column" ,
      ^.alignItems := "center" ,
      ^.backgroundColor := "#eeeeee" ,
      ^.display := "-ms-flexbox" ,
      ^.display := "-webkit-box" ,
      ^.display := "-webkit-flex" ,
      ^.display := "flex" ,
      ^.flexDirection := "column" ,
      ^.fontSize := "18px" ,
      ^.fontWeight := "500" ,
      ^.paddingBottom := "45px" ,
      ^.paddingTop := "85px")

    val infoContent = Seq(^.fontWeight := 500, ^.fontSize := "18px")

    val infoLink = Seq(
      ^.color := "#ff4081" ,
      ^.padding := "0 5px" ,
      ^.textDecoration := "none")

    val searchSection = Seq(
      ^.display := "-ms-flexbox" ,
      ^.display := "-webkit-box" ,
      ^.display := "-webkit-flex" ,
      ^.display := "flex" ,
      ^.margin := "50px" ,
      ^.marginBottom := "15px")

    val componentsGrid = Seq(
      MsFlexWrap := "wrap" ,
      WebkitFlexWrap := "wrap" ,
      ^.display := "-ms-flexbox" ,
      ^.display := "-webkit-box" ,
      ^.display := "-webkit-flex" ,
      ^.display := "flex" ,
      ^.flexWrap := "wrap" ,
      ^.margin := "30px" )

  }

  case class State(filterText: String = "", results: Vector[ComponentInfo])

  class Backend(t: BackendScope[RouterCtl[Page], State]) {

    def onTextChange(text: String) = {
      val results = AppRouter.homePageMenu.filter(c => c.tags.exists(s => s.contains(text)))
      t.modState(_.copy(results = results, filterText = text))
    }
  }

  val component = ReactComponentB[RouterCtl[Page]]("homepage")
    .initialState(State("", AppRouter.homePageMenu))
    .backend(new Backend(_))
    .render((P, S, B) => {
    <.div(
      <.div(Style.info, ^.key := "info")(
        <.h3(Style.infoContent)("Reusable ", <.a(^.href := "https://github.com/japgolly/scalajs-react",Style.infoLink ,^.target := "_blank")("scalajs-react"), " Components, want to Contribute ? "),
        LocalDemoButton(name ="Welcome Mama",linkButton =  true,href  = "https://github.com/chandu0101/scalajs-react-components/tree/master/doc/CONTRIBUTE.md")
      ),
      <.div(Style.searchSection)(
       ReactSearchBox(onTextChange = B.onTextChange),
        !S.filterText.isEmpty ?= <.strong(^.alignSelf := "center" ,^.paddingLeft := "30px")(s"Results: ${S.results.length}")
      ),
      <.div(Style.componentsGrid)(
          S.results.map(c => ComponentGridItem(c.name, c.route, c.imagePath,P))
      )
    )
  })
    .build

  def apply(ctrl: RouterCtl[Page]) = component(ctrl)

}
