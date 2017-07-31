package demo
package components
package reactselect

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scalacss.Defaults._

object ReactSelectInfo {

  object Style extends StyleSheet.Inline {

    import dsl._

    val content = style(textAlign.center, fontSize(30.px), paddingTop(40.px))
  }

  val component = ReactComponentB[Unit]("ReactSelectInfo")
    .render(P => {
      InfoTemplate(componentFilePath = "reactselect/Select.scala")(
        <.div(
          <.h3("React Select "),
          <.p("scalajs-react wrapper for ",
              RedLink("react select", "https://github.com/JedWatson/react-select")),
          <.div(
            <.h4("Supported Version :"),
            <.span("1.0.0-beta")
          ),
          <.div(
            <.h4("How To Use :"),
            <.p("Follow the installation guide from :",
                RedLink("here", "https://github.com/JedWatson/react-select#installation"))
          )
        )
      )

    })
    .build

  def apply() = component()
}
