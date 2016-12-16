package demo
package components
package semanticui

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._


object SuiInfo {


  val component = ReactComponentB[Unit]("SuiInfo")
    .render(P => {
      InfoTemplate(componentFilePath = "semanticui/package.scala")(
        <.div(
          <.h3("Semnatic-UI-React "),
          <.p("scalajs-react wrapper for ",
            RedLink("semantic-ui-react", "http://react.semantic-ui.com/introduction")
          ),
          <.div(
            <.h4("Supported Version :"),
            <.span("0.62.0")
          ),
          <.div(
            <.h4("How To Use :"),
            <.p("Follow the installation guide from :", RedLink("here", "http://react.semantic-ui.com/usage#javascript")
            )
          )
        )
      )

    }).build

  def apply() = component()
}
