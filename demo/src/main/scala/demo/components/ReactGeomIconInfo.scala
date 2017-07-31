package demo.components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scalacss.Defaults._

object ReactGeomIconInfo {

  object Style extends StyleSheet.Inline {

    import dsl._

    val content = style(textAlign.center, fontSize(30.px), paddingTop(40.px))
  }

  val component = ReactComponentB[Unit]("ReactGeomIconInfo")
    .render(P => {
      InfoTemplate(componentFilePath = "icons/ReactGeomIcon.scala")(
        <.div(
          <.h3("React GeomIcon "),
          <.p("scalajs-react wrapper for ",
              RedLink("react geom icons", "https://github.com/jxnblk/react-geomicons")),
          <.div(
            <.h4("Supported Version :"),
            <.span("2.0.4")
          ),
          <.div(
            <.h4("How To Use :"),
            <.p("Follow the installation guide from :",
                RedLink("here", "https://github.com/jxnblk/react-geomicons#getting-started"))
          )
        )
      )

    })
    .build

  def apply() = component()
}
