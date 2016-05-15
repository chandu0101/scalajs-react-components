package demo
package components
package materialui

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scalacss.Defaults._

object MuiInfo {

  object Style extends StyleSheet.Inline {

    import dsl._

    val content = style(textAlign.center,
      fontSize(30.px),
      paddingTop(40.px))
  }

  val component = ReactComponentB[Unit]("MuiInfo")
    .render(P => {
      InfoTemplate(componentFilePath = "materialui/package.scala")(
        <.div(
          <.h3("Material-ui "),
          <.p("scalajs-react wrapper for ",
            RedLink("material-ui", "http://material-ui.com/#/")
          ),
          <.div(
            <.h4("Supported Version :"),
            <.span("0.14.4")
          ),
          <.div(
            <.h4("How To Use :"),
            <.p("Follow the installation guide from :", RedLink("here", "https://github.com/callemall/material-ui#installation"),
              <.br(),
              <.br(),
              "Configure material-ui context in your top level component :", RedLink("example", "https://github.com/chandu0101/scalajs-react-components/blob/master/demo/src/main/scala/demo/pages/MuiPage.scala")
            )
          )
        )
      )

    }).build

  def apply() = component()
}
