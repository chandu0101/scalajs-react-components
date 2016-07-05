package demo
package components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js
import scalacss.Defaults._

object InfoTemplate {

  case class Props(
    browsersTested: List[String],
    componentFilePath: String,
    scalacss: Boolean
  )

  case class Backend($: BackendScope[Props, _]){
    def render(P: Props, C: PropsChildren) = {
      <.div(^.cls := "info-template")(
        <.div(^.cls := "component-info")(C),
        P.scalacss ?= <.div(
         <.h4("Style :"),
         <.a(^.href := "#scalacss","scalacss")
        ) ,
        P.browsersTested.nonEmpty ?= <.div(^.marginTop := "10px")(
           <.h4("Tested Browsers List :"),
           <.ul(^.marginLeft := "50px")(P.browsersTested.map(s => <.li(s)))
         ),
        <.div(^.marginTop := "10px")(
           ComponentCredits(filePath = s"core/src/main/scala/chandu0101/scalajs/react/components/${P.componentFilePath}")
         )
       )
    }
  }

  val component = ReactComponentB[Props]("InfoTemplate")
    .renderBackend[Backend]
    .build

  object Style extends StyleSheet.Inline {
    import dsl._
    val content = style(
      textAlign.center,
      fontSize(30.px),
      paddingTop(40.px))
  }

  def apply(componentFilePath: String,
            scalacss:          Boolean            = false,
            browsersTested:    List[String]       = List(),
            ref:               js.UndefOr[String] = "",
            key:               js.Any             = {})
           (children:          ReactNode*)        =

    component.set(key, ref)(
      Props(browsersTested,componentFilePath,scalacss),
      children :_*
    )
}
