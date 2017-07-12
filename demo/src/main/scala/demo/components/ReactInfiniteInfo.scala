package demo.components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

import scalacss.Defaults._

object ReactInfiniteInfo {

  object Style extends StyleSheet.Inline {

    import dsl._

    val content = style(textAlign.center, fontSize(30.px), paddingTop(40.px))
  }

  val component = ScalaComponent
    .builder[Unit]("ReactInfiniteInfo")
    .render(P => {
      InfoTemplate(componentFilePath = "listviews/ReactInfinite.scala")(
        <.div(
          <.h3("React Infinite "),
          <.p("scalajs-react wrapper for ",
              RedLink("react infinite", "https://github.com/seatgeek/react-infinite")),
          <.div(
            <.h4("Supported Version :"),
            <.span("0.7.1")
          ),
          <.div(
            <.h4("How To Use :"),
            <.p("Follow the installation guide from :",
                RedLink("here", "https://github.com/seatgeek/react-infinite#installation"))
          )
        )
      )

    })
    .build

  def apply() = component()
}
