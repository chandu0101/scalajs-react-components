package demo
package components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

import scalacss.ProdDefaults._

object InfoTemplate {

  case class Props(
      browsersTested: List[String],
      componentFilePath: String,
      scalacss: Boolean
  )

  case class Backend($ : BackendScope[Props, Unit]) {
    def render(P: Props, C: PropsChildren) = {
      <.div(^.cls := "info-template")(
        <.div(^.cls := "component-info")(C),
        (<.div(
          <.h4("Style :"),
          <.a(^.href := "#scalacss", "scalacss")
        )).when(P.scalacss),
        (<.div(^.marginTop := "10px")(
          <.h4("Tested Browsers List :"),
          <.ul(^.marginLeft := "50px")(P.browsersTested.map(s => <.li(s)).toTagMod)
        )).when(P.browsersTested.nonEmpty),
        <.div(^.marginTop := "10px")(
          ComponentCredits(
            filePath =
              s"core/src/main/scala/chandu0101/scalajs/react/components/${P.componentFilePath}")
        )
      )
    }
  }

  val component = ScalaComponent
    .builder[Props]("InfoTemplate")
    .renderBackendWithChildren[Backend]
    .build

  object Style extends StyleSheet.Inline {
    import dsl._
    val content = style(
      textAlign.center,
      fontSize(30.px),
      paddingTop(40.px)
    )
  }

  def apply(
      componentFilePath: String,
      scalacss: Boolean = false,
      browsersTested: List[String] = List()
  )(children: VdomNode*) =
    //    component.set(key, ref)(
    //      Props(browsersTested, componentFilePath, scalacss),
    //      children: _*
    //    )
    component(Props(browsersTested, componentFilePath, scalacss))(children: _*)

}
