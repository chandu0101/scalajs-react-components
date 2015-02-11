
package chandu0101.scalajs.react.components.demo.pages

import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.demo.pages.components.demo.LocalDemoButton
import chandu0101.scalajs.react.components.demo.pages.util.ComponentGridItem
import chandu0101.scalajs.react.components.demo.routes.AppRouter.AppPage
import chandu0101.scalajs.react.components.demo.util.{ComponentInfo, Components}
import chandu0101.scalajs.react.components.searchboxes.ReactSearchBox
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._

import scala.scalajs.js.Dynamic.{global => g}


/**
 * Created by chandrasekharkode .
 */
object HomePage {


  object Style {

    val info = Seq( MsFlexAlign := "center" ,
      MsFlexDirection := "column" ,
      WebkitAlignItems := "center" ,
      WebkitBoxAlign := "center" ,
      WebkitBoxDirection := "normal" ,
      WebkitBoxOrient := "vertical" ,
      WebkitFlexDirection := "column" ,
      alignItems := "center" ,
      backgroundColor := "#eeeeee" ,
      display := "-ms-flexbox" ,
      display := "-webkit-box" ,
      display := "-webkit-flex" ,
      display := "flex" ,
      flexDirection := "column" ,
      fontSize := "18px" ,
      fontWeight := "500" ,
      paddingBottom := "45px" ,
      paddingTop := "85px")

    val infoContent = Seq(fontWeight := 500, fontSize := "18px")

    val infoLink = Seq(  color := "#ff4081" ,
      padding := "0 5px" ,
      textDecoration := "none")

    val searchSection = Seq( display := "-ms-flexbox" ,
      display := "-webkit-box" ,
      display := "-webkit-flex" ,
      display := "flex" ,
      margin := "50px" ,
      marginBottom := "15px")

    val componentsGrid = Seq( MsFlexWrap := "wrap" ,
      WebkitFlexWrap := "wrap" ,
      display := "-ms-flexbox" ,
      display := "-webkit-box" ,
      display := "-webkit-flex" ,
      display := "flex" ,
      flexWrap := "wrap" ,
      margin := "30px" )

  }

  case class State(filterText: String = "", results: List[ComponentInfo])

  class Backend(t: BackendScope[_, State]) {

    def onTextChange(text: String) = {
      val results = Components.all.filter(c => c.tags.exists(s => s.contains(text)))
      t.modState(_.copy(results = results, filterText = text))
    }
  }

  val component = ReactComponentB[Unit]("homepage")
    .initialState(State("", Components.all))
    .backend(new Backend(_))
    .render((P, S, B) => {
    div(
      div(Style.info,key := "info")(
        h3(Style.infoContent)("Reusable ", a(href := "https://github.com/japgolly/scalajs-react",Style.infoLink ,target := "_blank")("scalajs-react"), " Components , want to Contribute ? "),
        LocalDemoButton(name ="Welcome Mama",linkButton =  true,href  = AppPage.contribute.path.value)
      ),
      div(Style.searchSection)(
       ReactSearchBox(onTextChange = B.onTextChange),
        !S.filterText.isEmpty ?= strong(alignSelf := "center" ,paddingLeft := "30px")(s"Results : ${S.results.length}")
      ),
      div(Style.componentsGrid)(
          S.results.map(c => ComponentGridItem(c.name, c.url, c.imagePath))
      )
    )
  })
    .buildU


  def apply() = component()

}
